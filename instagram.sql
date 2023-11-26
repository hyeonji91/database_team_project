-- Active: 1700998124646@@127.0.0.1@3306
CREATE DATABASE instagram;

use instagram;

set foreign_key_checks=0;

create table User(
    user_id varchar(20),
    name varchar(20),
    password varchar(20),
    birth varchar(10),
    gender varchar(10),
    phone_number varchar(20),
    address varchar(512),
    primary key(user_id)
);

create table Article(
    article_id int auto_increment,
    context varchar(512),
    created_at datetime(6),
    user_id varchar(20),
    primary key(article_id),
    foreign key(user_id) references User(user_id) on delete cascade
);

create table Comment(
    comment_id int auto_increment,
    created_at datetime(6),
    context varchar(512),
    user_id varchar(20),
    article_id int,
    group_num int,
    hierarchy int,
    primary key(comment_id),
    foreign key(user_id) references User(user_id) on delete cascade, 
    foreign key(article_id) references Article(article_id) on delete cascade
);

create table Profile(
    nickname varchar(20),
    follower int,
    following int,
    info varchar(512),
    user_id varchar(20),
	profile_img text,
    primary key(user_id),
    foreign key(user_id) references User(user_id)on delete cascade
);

create table Reply(
    comment_id int,
    reply_id int,
    primary key(comment_id, reply_id),
    foreign key(comment_id) references Comment(comment_id),
    foreign key(reply_id) references Comment(comment_id)
);

create table Image(
    image_id int ,
    URL text,
    article_id int default null,
    primary key(Image_id),
    foreign key(article_id) references Article(article_id) on delete cascade
);

create table Follow(
    following_id varchar(20),
    follower_id varchar(20),
    primary key(following_id, follower_id),
    foreign key(following_id) references User(user_id) on delete cascade,
    foreign key(follower_id) references User(user_id) on delete cascade
);

create table Likes (
    like_id int auto_increment,
    user_id varchar(20),
    article_id int,
    primary key(like_id),
    foreign key(user_id) references User(user_id),
    foreign key(article_id) references Article(article_id) on delete cascade
);

#특정 사용자의 모든 게시물과 댓글 수 가져오기 :
SELECT a.article_id, a.context, COUNT(DISTINCT l.like_id) AS like_count, COUNT(DISTINCT c.comment_id) AS comment_count
FROM Article AS a
LEFT JOIN Likes AS l ON a.article_id = l.article_id
LEFT JOIN Comment AS c ON a.article_id = c.article_id
WHERE a.user_id = '[특정 사용자 ID]'
GROUP BY a.article_id;

# 특정 게시물에 대한 모든 댓글 및 댓글에 대한 답글 가져오기:
SELECT c.comment_id, c.context, r.reply_id
FROM Comment AS c
LEFT JOIN Reply AS r ON c.comment_id = r.comment_id
WHERE c.article_id = '[특정 게시물 ID]';

#특정 사용자의 팔로워 수:
SELECT COUNT(DISTINCT follower_id) AS follower_count
FROM Follow
WHERE following_id = '[특정 사용자 ID]';

#특정 사용자가 팔로우하는 사람의 수:
SELECT COUNT(DISTINCT following_id) AS following_count
FROM Follow
WHERE follower_id = '[특정 사용자 ID]';

#프로필에서 특정 게시글에 대한 정보를 가져오기
SELECT p.nickname, a.article_id, a.context, COUNT(l.like_id) AS like_count, a.created_at
FROM Profile AS p
JOIN User AS u ON p.user_id = u.user_id
JOIN Article AS a ON u.user_id = a.user_id
LEFT JOIN Likes AS l ON a.article_id = l.article_id
WHERE u.user_id = '[특정 사용자 ID]' AND a.article_id = '[특정 게시글 ID]'
GROUP BY a.article_id;

#프로필에서 게시글의 이미지를 선택하여 해당 게시글로 이동하는 기능 (오류 발생)
SELECT a.article_id, i.URL AS image_url, a.context, COUNT(l.like_id) AS like_count, a.created_at
FROM Profile AS p
JOIN Article AS a ON p.user_id = a.user_id
LEFT JOIN Image AS i ON a.article_id = i.article_id
LEFT JOIN Likes AS l ON a.article_id = l.article_id
WHERE p.nickname = '[특정 사용자 닉네임]'
GROUP BY a.article_id; 

SELECT 
    a.article_id, 
    MIN(i.URL) AS image_url,  -- 집계 함수를 사용하여 하나의 URL 값을 선택
    a.context, 
    COUNT(l.like_id) AS like_count, 
    a.created_at
FROM 
    Profile AS p
JOIN 
    Article AS a ON p.user_id = a.user_id
LEFT JOIN 
    Image AS i ON a.article_id = i.article_id
LEFT JOIN 
    Likes AS l ON a.article_id = l.article_id
WHERE 
    p.nickname = '[특정 사용자 닉네임]'
GROUP BY 
    a.article_id;

#좋아요 추가
INSERT INTO Likes (user_id, article_id) VALUES ('[사용자 ID]', '[게시물 ID]');

#좋아요 취소
DELETE FROM Likes WHERE user_id = '[사용자 ID]' AND article_id = '[게시물 ID]';

#팔로우 추가
INSERT INTO Follow (follower_id, following_id) VALUES ('[팔로우하는 사용자 ID]', '[팔로우될 사용자 ID]');

#팔로우 취소
DELETE FROM Follow WHERE follower_id = '[팔로우 취소하는 사용자 ID]' AND following_id = '[팔로우 취소될 사용자 ID]';

#게시물 추가
INSERT INTO Article (context, created_at, user_id) VALUES ('[게시물 내용]', NOW(), '[사용자 ID]');

#게시물 삭제
DELETE FROM Article WHERE article_id = '[게시물 ID]' AND user_id = '[사용자 ID]';


#게시물의 총 좋아요 수 조회 #이건 게시글 조회에 같이 들어가있어서 필요없을듯
SELECT COUNT(*) AS like_count FROM Likes WHERE article_id = [게시물 ID];


#사용자 프로필 업데이트
UPDATE Profile
SET nickname = '[새 닉네임]', info = '[새 정보]', img_url = '[새 이미지 URL]'
WHERE user_id = '[사용자 ID]';

#팔로잉, 팔로워 업데이트
CREATE TRIGGER update_follower_count
AFTER INSERT ON Follow
FOR EACH ROW
BEGIN
   UPDATE Profile
   SET follower = follower + 1
   WHERE user_id = NEW.following_id;
END;

CREATE TRIGGER update_following_count
AFTER INSERT ON Follow
FOR EACH ROW
BEGIN
   UPDATE Profile
   SET following = following + 1
   WHERE user_id = NEW.follower_id;
END; 

#팔로우를 취소하는 사용자(follower)의 following 수 감소 트리거:
CREATE TRIGGER decrease_following_count
AFTER DELETE ON Follow
FOR EACH ROW
BEGIN
   UPDATE Profile
   SET following = following - 1
   WHERE user_id = OLD.follower_id AND following > 0;
END;

#팔로우가 취소된 사용자(following)의 follower 수 감소 트리거:
CREATE TRIGGER decrease_follower_count
AFTER DELETE ON Follow
FOR EACH ROW
BEGIN
   UPDATE Profile
   SET follower = follower - 1
   WHERE user_id = OLD.following_id AND follower > 0;
END;

#'tkesterton0' 사용자가 작성한 모든 게시물에 대한 정보 제시
SELECT a.article_id, a.context, COUNT(DISTINCT l.like_id) AS like_count, 
COUNT(DISTINCT c.comment_id) AS comment_count
FROM Article AS a
LEFT JOIN Likes AS l ON a.article_id = l.article_id
LEFT JOIN Comment AS c ON a.article_id = c.article_id
WHERE a.user_id = 'tkesterton0'
GROUP BY a.article_id;




# ID가 43인 특정 게시물에 대한 모든 댓글과 해당 댓글에 대한 답글(대댓글) 정보
SELECT c.comment_id, c.context, r.reply_id
FROM Comment AS c
LEFT JOIN Reply AS r ON c.comment_id = r.comment_id
WHERE c.article_id = 43;