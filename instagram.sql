drop database instagram;

create database instagram;
use instagram;

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

select * from user;
create table Article(
	article_id int auto_increment,
    like_num int,
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
    comment_grp int,
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
    img_url text,
    primary key(user_id),
    foreign key(user_id) references User(user_id)on delete cascade
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

create table Reply(
	comment_id int,
    reply_id int,
    primary key(comment_id, reply_id),
    foreign key(comment_id) references Comment(comment_id) on delete cascade,
    foreign key(reply_id) references Comment(comment_id) on delete cascade
);
