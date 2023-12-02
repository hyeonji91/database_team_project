drop database instagram;

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
    like_num integer,
    context varchar(512),
    created_at datetime(6),
    user_id varchar(20),
    primary key(article_id),
    foreign key(user_id) references User(user_id) on delete cascade
);

create table Comment(
    comment_id int auto_increment,
    context varchar(512),
    group_num int,
    hierarchy int,
    user_id varchar(20),
    article_id int,
    created_at datetime(6),
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


create table Image(
    image_id int auto_increment,
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



#데이터 입력
INSERT INTO article(like_num,context,created_at,user_id) VALUES (96,'magna at nunc commodo placerat praesent blandit nam nulla integer pede','2023-08-22 0:37','tkesterton0');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (68,'odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit','2023-07-18 8:23','kohoolahan1');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (92,'turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet','2023-05-27 21:44','dbohey2');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (16,'dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum','2023-11-09 13:13','mstannah3');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (24,'pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales','2023-04-24 15:12','zdillistone4');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (59,'a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis','2023-10-15 23:30','dgillison5');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (39,'iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis','2023-05-25 18:20','rsuddock6');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (100,'ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit','2023-07-27 23:46','hantonsen7');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (42,'ut at dolor quis odio consequat varius integer ac leo pellentesque','2023-04-24 19:31','hbladge8');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (45,'nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula','2023-07-25 2:49','pyork9');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (2,'interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus','2023-06-02 15:29','alossmana');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (86,'velit nec nisi vulputate nonummy maecenas tincidunt lacus at velit','2023-09-24 3:18','blerouxb');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (98,'luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat','2023-05-02 15:23','wferrarelloc');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (49,'venenatis lacinia aenean sit amet justo morbi ut odio cras','2023-02-28 9:31','dspreadd');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (27,'quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis','2022-12-07 17:09','mhallgalleye');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (24,'morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus','2023-07-24 12:24','arealf');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (65,'odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius','2023-02-08 20:22','bswinleyg');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (93,'sapien dignissim vestibulum vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae nulla dapibus dolor','2023-01-13 14:53','ochettleh');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (86,'dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti','2023-03-05 16:33','pfallowsi');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (67,'nisi eu orci mauris lacinia sapien quis libero nullam sit amet','2023-07-29 18:53','prenhardj');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (77,'tellus semper interdum mauris ullamcorper purus sit amet nulla quisque arcu libero','2023-01-17 12:17','tkesterton0');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (94,'ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed','2023-05-17 10:38','kohoolahan1');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (25,'turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa','2023-01-13 1:05','dbohey2');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (10,'at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero','2023-05-17 0:15','mstannah3');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (74,'nulla ac enim in tempor turpis nec euismod scelerisque quam','2023-04-08 22:38','zdillistone4');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (51,'risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam','2023-04-26 11:19','dgillison5');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (58,'nullam varius nulla facilisi cras non velit nec nisi vulputate','2023-01-18 9:50','rsuddock6');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (67,'integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus','2022-11-30 18:43','hantonsen7');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (84,'vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec','2022-11-23 23:57','hbladge8');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (70,'convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam','2023-08-07 21:41','pyork9');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (14,'nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum','2023-07-05 20:37','alossmana');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (94,'ut at dolor quis odio consequat varius integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices','2023-07-26 14:53','blerouxb');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (86,'urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non','2023-03-21 13:12','wferrarelloc');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (58,'orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum','2023-06-11 19:16','dspreadd');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (28,'nullam sit amet turpis elementum ligula vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas rhoncus aliquam','2023-11-08 1:25','mhallgalleye');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (86,'suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce','2023-10-21 3:34','arealf');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (100,'pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet','2023-07-09 15:13','bswinleyg');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (57,'sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum','2023-03-07 8:44','ochettleh');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (41,'aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero','2023-05-19 4:03','pfallowsi');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (68,'at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis','2023-02-09 0:25','prenhardj');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (94,'justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id','2023-10-05 10:15','tkesterton0');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (92,'ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui','2023-01-16 22:01','kohoolahan1');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (16,'odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat','2023-10-13 20:43','dbohey2');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (78,'sem fusce consequat nulla nisl nunc nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in porttitor pede','2023-03-29 1:57','mstannah3');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (49,'faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna','2023-05-12 19:17','zdillistone4');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (84,'pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas','2023-02-22 10:54','dgillison5');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (43,'mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing','2023-06-07 7:01','rsuddock6');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (26,'integer pede justo lacinia eget tincidunt eget tempus vel pede morbi','2023-04-06 4:09','hantonsen7');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (25,'ut erat id mauris vulputate elementum nullam varius nulla facilisi cras','2023-01-06 2:41','hbladge8');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (68,'at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum','2023-11-14 22:22','pyork9');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (13,'nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum','2023-01-20 19:36','alossmana');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (49,'posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor','2023-07-23 8:20','blerouxb');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (35,'augue luctus tincidunt nulla mollis molestie lorem quisque ut erat curabitur gravida nisi at','2023-09-20 17:46','wferrarelloc');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (69,'duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam','2023-05-13 2:51','dspreadd');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (91,'blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget','2023-08-21 10:49','mhallgalleye');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (2,'nulla quisque arcu libero rutrum ac lobortis vel dapibus at','2023-01-17 1:59','arealf');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (38,'sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc','2023-02-12 12:27','bswinleyg');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (70,'neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus orci luctus','2023-07-19 17:15','ochettleh');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (66,'sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat','2023-10-22 10:33','pfallowsi');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (27,'lorem ipsum dolor sit amet consectetuer adipiscing elit proin risus praesent','2023-01-10 18:29','prenhardj');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (33,'sit amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec','2023-09-10 20:56','tkesterton0');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (5,'semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum ante ipsum','2023-05-26 11:43','kohoolahan1');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (64,'in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit','2022-11-28 5:14','dbohey2');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (99,'et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend','2023-02-22 12:01','mstannah3');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (28,'ligula in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper','2022-12-05 17:30','zdillistone4');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (76,'lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse','2023-05-15 4:17','dgillison5');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (38,'neque sapien placerat ante nulla justo aliquam quis turpis eget elit','2023-03-20 16:30','rsuddock6');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (69,'molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas tristique est et tempus','2023-02-11 3:39','hantonsen7');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (36,'est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc','2023-09-21 14:51','hbladge8');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (39,'eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus','2023-03-22 10:30','pyork9');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (48,'nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget','2023-04-21 7:01','alossmana');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (19,'aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero convallis eget eleifend','2023-04-26 19:09','blerouxb');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (59,'semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in','2022-12-08 0:29','wferrarelloc');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (39,'rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis','2023-05-09 16:24','dspreadd');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (51,'placerat ante nulla justo aliquam quis turpis eget elit sodales scelerisque mauris sit','2023-09-01 10:08','mhallgalleye');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (89,'ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit','2022-12-19 5:22','arealf');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (77,'vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam','2023-07-14 8:42','bswinleyg');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (79,'eget tincidunt eget tempus vel pede morbi porttitor lorem id','2023-11-08 22:37','ochettleh');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (4,'et ultrices posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam','2022-12-09 19:31','pfallowsi');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (60,'sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed sagittis','2023-09-28 15:24','prenhardj');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (1,'dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo','2023-02-01 13:11','tkesterton0');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (32,'tellus semper interdum mauris ullamcorper purus sit amet nulla quisque','2023-02-19 21:12','kohoolahan1');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (80,'a suscipit nulla elit ac nulla sed vel enim sit amet nunc viverra dapibus nulla suscipit ligula in','2023-07-07 5:31','dbohey2');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (25,'massa donec dapibus duis at velit eu est congue elementum','2023-08-10 14:44','mstannah3');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (34,'vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula','2023-04-01 11:01','zdillistone4');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (42,'congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci','2023-03-26 11:18','dgillison5');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (82,'felis fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui','2023-05-20 4:18','rsuddock6');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (15,'libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in leo maecenas','2023-10-24 20:03','hantonsen7');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (74,'aenean auctor gravida sem praesent id massa id nisl venenatis lacinia','2023-06-11 10:20','hbladge8');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (52,'consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl','2023-05-23 21:11','pyork9');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (89,'libero ut massa volutpat convallis morbi odio odio elementum eu interdum eu tincidunt in','2023-10-05 0:41','alossmana');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (94,'phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin','2023-05-27 18:03','blerouxb');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (15,'duis faucibus accumsan odio curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus','2023-09-14 22:27','wferrarelloc');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (8,'sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis','2023-03-26 21:08','dspreadd');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (80,'enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien','2023-10-08 19:55','mhallgalleye');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (33,'morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo','2023-03-03 5:35','arealf');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (15,'mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque','2023-07-13 11:22','bswinleyg');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (43,'ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam justo','2022-11-25 11:09','ochettleh');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (70,'congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec','2023-03-03 1:00','pfallowsi');
INSERT INTO article(like_num,context,created_at,user_id) VALUES (8,'leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices libero non mattis pulvinar nulla pede','2023-06-04 3:59','prenhardj');



INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin',1,1,'alossmana',10,'2023-04-04 16:59');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('est phasellus sit amet erat nulla tempus vivamus in felis eu',1,1,'tkesterton0',43,'2023-01-20 23:41');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat',2,1,'rsuddock6',7,'2023-03-14 23:23');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed',5,2,'zdillistone4',79,'2023-04-18 23:45');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum',2,2,'kohoolahan1',92,'2023-07-23 5:21');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet',5,2,'prenhardj',32,'2023-04-12 9:37');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec',3,1,'hantonsen7',72,'2023-04-25 21:24');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut',3,2,'dbohey2',38,'2023-09-09 21:19');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio',5,1,'zdillistone4',82,'2023-05-30 12:06');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac',5,2,'pyork9',61,'2023-08-15 6:55');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl',4,2,'pfallowsi',63,'2023-03-26 9:11');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam',4,2,'hbladge8',28,'2023-07-04 14:52');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis',1,1,'arealf',50,'2023-05-26 2:07');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('ullamcorper augue a suscipit nulla elit ac nulla sed vel',5,2,'mhallgalleye',88,'2023-10-22 12:09');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna',5,2,'pyork9',75,'2023-02-14 16:30');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem',3,2,'hantonsen7',51,'2023-05-25 18:20');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper',4,2,'mstannah3',67,'2023-09-08 1:03');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('faucibus cursus urna ut tellus nulla ut erat id mauris',3,2,'hantonsen7',79,'2023-04-03 3:12');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque',1,1,'alossmana',53,'2023-08-30 17:40');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum',2,1,'bswinleyg',67,'2022-12-22 5:16');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum',2,2,'rsuddock6',3,'2023-09-19 3:07');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros',1,2,'arealf',37,'2023-06-22 21:13');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu',4,2,'hbladge8',59,'2023-04-14 20:01');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante',1,2,'arealf',73,'2023-10-27 23:32');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque',5,1,'zdillistone4',96,'2023-11-02 16:41');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('sem praesent id massa id nisl venenatis lacinia aenean sit',4,2,'mstannah3',76,'2023-03-09 10:16');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in',4,1,'dspreadd',69,'2023-10-07 2:20');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('praesent lectus vestibulum quam sapien varius ut blandit non interdum in ante vestibulum ante ipsum primis in faucibus',1,1,'dgillison5',33,'2023-01-27 4:35');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla',5,1,'mhallgalleye',7,'2023-05-07 20:56');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus',1,1,'arealf',62,'2023-06-01 7:22');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('nunc rhoncus dui vel sem sed sagittis nam congue risus semper',4,2,'hbladge8',36,'2023-06-08 2:36');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at',2,2,'rsuddock6',90,'2022-12-10 23:09');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('tortor risus dapibus augue vel accumsan tellus nisi eu orci',5,2,'mhallgalleye',31,'2023-05-01 13:21');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('lacinia erat vestibulum sed magna at nunc commodo placerat praesent',5,1,'pyork9',21,'2022-12-22 4:05');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('proin at turpis a pede posuere nonummy integer non velit',4,1,'mstannah3',12,'2023-10-27 11:35');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('sed vel enim sit amet nunc viverra dapibus nulla suscipit',4,1,'hbladge8',27,'2023-09-28 12:02');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu',5,1,'prenhardj',4,'2023-02-03 21:11');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit',2,2,'bswinleyg',13,'2023-01-23 0:15');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt',5,1,'prenhardj',52,'2023-07-26 1:49');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla',2,2,'bswinleyg',76,'2023-03-13 2:54');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi',3,2,'hantonsen7',36,'2023-02-19 12:27');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus',4,2,'dspreadd',83,'2022-11-20 1:57');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices',2,1,'kohoolahan1',94,'2023-06-02 18:29');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede',1,1,'dgillison5',30,'2023-03-14 22:01');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat',2,1,'blerouxb',37,'2023-02-09 12:13');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque',2,2,'kohoolahan1',60,'2023-02-22 10:34');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('quisque arcu libero rutrum ac lobortis vel dapibus at diam nam',3,1,'wferrarelloc',87,'2023-03-01 7:53');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('rhoncus sed vestibulum sit amet cursus id turpis integer aliquet',3,1,'ochettleh',52,'2023-09-13 15:14');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum',3,1,'dbohey2',52,'2023-08-14 11:48');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('congue risus semper porta volutpat quam pede lobortis ligula sit',1,2,'alossmana',13,'2023-06-25 22:28');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget',3,2,'wferrarelloc',90,'2023-08-13 5:15');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus',3,1,'ochettleh',3,'2023-05-20 13:50');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae',1,2,'alossmana',40,'2023-08-11 17:43');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('id ornare imperdiet sapien urna pretium nisl ut volutpat sapien',1,2,'dgillison5',23,'2022-11-24 16:59');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum',2,1,'blerouxb',12,'2023-09-04 22:37');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat',5,1,'pyork9',59,'2023-04-01 17:25');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt',2,2,'rsuddock6',26,'2023-02-10 11:10');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo',5,1,'mhallgalleye',98,'2022-12-30 10:10');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('tellus in sagittis dui vel nisl duis ac nibh fusce',1,2,'dgillison5',78,'2023-08-08 4:51');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim',3,2,'ochettleh',100,'2022-11-30 11:40');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante',3,1,'wferrarelloc',22,'2022-12-11 18:44');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing',4,1,'dspreadd',88,'2023-06-04 15:32');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('a odio in hac habitasse platea dictumst maecenas ut massa',4,2,'mstannah3',96,'2022-12-14 3:54');
INSERT INTO comment(context,group_num,hierarchy,user_id,article_id,created_at) VALUES ('pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien',2,1,'kohoolahan1',60,'2023-05-04 22:25');



insert into Follow values
("tkesterton0","pfallowsi"),
("tkesterton0","kohoolahan1"),
("kohoolahan1","prenhardj"),
("dbohey2","tkesterton0"),
("mstannah3","kohoolahan1"),
("zdillistone4","dbohey2"),
("dgillison5","mstannah3"),
("rsuddock6","zdillistone4"),
("hantonsen7","dgillison5"),
("hbladge8","rsuddock6"),
("pyork9","hantonsen7"),
("alossmana","hbladge8"),
("blerouxb","pyork9"),
("wferrarelloc","alossmana"),
("dspreadd","blerouxb"),
("mhallgalleye","wferrarelloc"),
("arealf","dspreadd"),
("bswinleyg","mhallgalleye"),
("ochettleh","arealf"),
("pfallowsi","bswinleyg"),
("prenhardj","ochettleh");



INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/228x100.png/5fa2dd/ffffff',43);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/126x100.png/5fa2dd/ffffff',94);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/103x100.png/cc0000/ffffff',52);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/114x100.png/cc0000/ffffff',12);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/140x100.png/cc0000/ffffff',96);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/209x100.png/ff4444/ffffff',33);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/246x100.png/ff4444/ffffff',7);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/105x100.png/5fa2dd/ffffff',72);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/138x100.png/5fa2dd/ffffff',27);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/106x100.png/dddddd/000000',21);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/106x100.png/dddddd/000000',53);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/248x100.png/5fa2dd/ffffff',12);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/109x100.png/5fa2dd/ffffff',22);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/101x100.png/5fa2dd/ffffff',88);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/217x100.png/dddddd/000000',7);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/238x100.png/5fa2dd/ffffff',62);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/150x100.png/5fa2dd/ffffff',67);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/236x100.png/5fa2dd/ffffff',51);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/245x100.png/5fa2dd/ffffff',34);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/218x100.png/5fa2dd/ffffff',4);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/175x100.png/5fa2dd/ffffff',98);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/250x100.png/dddddd/000000',60);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/232x100.png/5fa2dd/ffffff',83);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/204x100.png/ff4444/ffffff',76);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/187x100.png/5fa2dd/ffffff',13);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/155x100.png/ff4444/ffffff',23);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/175x100.png/ff4444/ffffff',26);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/193x100.png/cc0000/ffffff',51);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/133x100.png/cc0000/ffffff',28);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/129x100.png/cc0000/ffffff',75);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/215x100.png/dddddd/000000',40);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/137x100.png/cc0000/ffffff',23);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/177x100.png/dddddd/000000',90);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/190x100.png/cc0000/ffffff',83);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/118x100.png/ff4444/ffffff',88);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/143x100.png/ff4444/ffffff',37);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/144x100.png/5fa2dd/ffffff',76);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/119x100.png/5fa2dd/ffffff',100);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/208x100.png/dddddd/000000',44);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/146x100.png/dddddd/000000',65);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/138x100.png/5fa2dd/ffffff',8);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/145x100.png/5fa2dd/ffffff',2);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/180x100.png/ff4444/ffffff',1);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/124x100.png/dddddd/000000',96);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/111x100.png/cc0000/ffffff',79);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/165x100.png/dddddd/000000',78);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/227x100.png/cc0000/ffffff',3);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/176x100.png/5fa2dd/ffffff',36);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/128x100.png/ff4444/ffffff',36);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/223x100.png/dddddd/000000',61);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/151x100.png/ff4444/ffffff',21);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/218x100.png/cc0000/ffffff',92);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/133x100.png/5fa2dd/ffffff',72);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/233x100.png/ff4444/ffffff',32);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/141x100.png/5fa2dd/ffffff',31);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/249x100.png/5fa2dd/ffffff',73);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/216x100.png/dddddd/000000',13);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/113x100.png/ff4444/ffffff',13);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/201x100.png/dddddd/000000',63);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/109x100.png/ff4444/ffffff',32);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/208x100.png/ff4444/ffffff',33);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/118x100.png/cc0000/ffffff',60);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/155x100.png/cc0000/ffffff',38);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/161x100.png/cc0000/ffffff',67);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/194x100.png/5fa2dd/ffffff',82);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/101x100.png/cc0000/ffffff',30);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/198x100.png/dddddd/000000',74);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/198x100.png/cc0000/ffffff',75);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/108x100.png/dddddd/000000',99);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/232x100.png/5fa2dd/ffffff',59);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/129x100.png/cc0000/ffffff',10);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/227x100.png/cc0000/ffffff',37);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/219x100.png/dddddd/000000',87);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/189x100.png/5fa2dd/ffffff',69);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/103x100.png/dddddd/000000',21);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/178x100.png/dddddd/000000',50);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/184x100.png/5fa2dd/ffffff',58);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/131x100.png/cc0000/ffffff',3);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/162x100.png/cc0000/ffffff',82);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/126x100.png/dddddd/000000',52);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/163x100.png/cc0000/ffffff',66);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/176x100.png/cc0000/ffffff',92);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/102x100.png/ff4444/ffffff',43);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/152x100.png/dddddd/000000',76);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/249x100.png/cc0000/ffffff',91);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/165x100.png/5fa2dd/ffffff',55);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/153x100.png/ff4444/ffffff',90);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/129x100.png/cc0000/ffffff',79);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/247x100.png/cc0000/ffffff',59);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/135x100.png/ff4444/ffffff',54);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/171x100.png/dddddd/000000',13);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/171x100.png/ff4444/ffffff',16);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/175x100.png/dddddd/000000',3);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/140x100.png/ff4444/ffffff',57);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/179x100.png/ff4444/ffffff',98);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/111x100.png/ff4444/ffffff',8);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/248x100.png/cc0000/ffffff',47);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/241x100.png/ff4444/ffffff',52);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/172x100.png/5fa2dd/ffffff',35);
INSERT INTO image(URL,article_id) VALUES ('http://dummyimage.com/139x100.png/cc0000/ffffff',30);



insert into Profile values
("pfranzewitch0",85,67,"ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae","tkesterton0","http://dummyimage.com/228x100.png/5fa2dd/ffffff"),
("dguppey1",83,30,"mollis molestie lorem quisque ut erat curabitur gravida nisi at nibh in hac","kohoolahan1","http://dummyimage.com/126x100.png/5fa2dd/ffffff"),
("rblackborn2",91,6,"dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non","dbohey2","http://dummyimage.com/103x100.png/cc0000/ffffff"),
("ceshmade3",23,24,"pretium iaculis justo in hac habitasse platea dictumst etiam faucibus","mstannah3","http://dummyimage.com/114x100.png/cc0000/ffffff"),
("gdebenedictis4",88,97,"vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus","zdillistone4","http://dummyimage.com/140x100.png/cc0000/ffffff"),
("jghelardoni5",22,10,"morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede","dgillison5","http://dummyimage.com/209x100.png/ff4444/ffffff"),
("ltackley6",52,17,"vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum","rsuddock6","http://dummyimage.com/246x100.png/ff4444/ffffff"),
("cdilger7",19,20,"tincidunt ante vel ipsum praesent blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla","hantonsen7","http://dummyimage.com/105x100.png/5fa2dd/ffffff"),
("llivingston8",33,74,"justo in blandit ultrices enim lorem ipsum dolor sit amet consectetuer","hbladge8","http://dummyimage.com/138x100.png/5fa2dd/ffffff"),
("amaldin9",77,1,"amet eleifend pede libero quis orci nullam molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in","pyork9","http://dummyimage.com/106x100.png/dddddd/000000"),
("acarsea",61,26,"curabitur convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor","alossmana","http://dummyimage.com/106x100.png/dddddd/000000"),
("ccianellib",82,55,"sed interdum venenatis turpis enim blandit mi in porttitor pede justo eu massa donec dapibus duis at velit eu est","blerouxb","http://dummyimage.com/248x100.png/5fa2dd/ffffff"),
("bcovellc",55,13,"at dolor quis odio consequat varius integer ac leo pellentesque ultrices","wferrarelloc","http://dummyimage.com/109x100.png/5fa2dd/ffffff"),
("dlefeaverd",98,33,"bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui","dspreadd","http://dummyimage.com/101x100.png/5fa2dd/ffffff"),
("cscallye",66,71,"mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac nulla sed vel enim","mhallgalleye","http://dummyimage.com/217x100.png/dddddd/000000"),
("bgrigolonf",47,72,"ultrices libero non mattis pulvinar nulla pede ullamcorper augue a suscipit nulla elit ac","arealf","http://dummyimage.com/238x100.png/5fa2dd/ffffff"),
("ehendrickxg",25,51,"consectetuer adipiscing elit proin risus praesent lectus vestibulum quam sapien varius ut blandit","bswinleyg","http://dummyimage.com/150x100.png/5fa2dd/ffffff"),
("rdecheletteh",34,86,"posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in","ochettleh","http://dummyimage.com/236x100.png/5fa2dd/ffffff"),
("ewootoni",55,19,"in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla","pfallowsi","http://dummyimage.com/245x100.png/5fa2dd/ffffff"),
("zprantlj",40,98,"tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien","prenhardj","http://dummyimage.com/218x100.png/5fa2dd/ffffff");


insert into User values
("tkesterton0","Tim","zY7YY.>v","2022-11-16","Male","796-821-5424","2662 Arkansas Place"),
("kohoolahan1","Kakalina","tX4.q<\*@E_O","2023-05-03","Female","362-402-9049","37754 Huxley Avenue"),
("dbohey2","Doloritas","pD2$9aBN~aLet","2023-05-26","Female","134-197-7794","7 Bultman Point"),
("mstannah3","Melisenda","wK0|8u\DFc&#<2M7","2023-04-26","Female","650-249-6257","84477 Fairview Trail"),
("zdillistone4","Zackariah","pB8!T)a9)EpRo","2023-09-20","Male","355-271-3751","94 Bonner Street"),
("dgillison5","Danna","pM6&Tvkde","2022-12-09","Non-binary","962-583-5466","796 Longview Trail"),
("rsuddock6","Ros","rE2(WnVp","2023-08-14","Female","562-409-1520","771 Mallard Circle"),
("hantonsen7","Horace","tA6*Q6Rx7X4e","2022-12-12","Male","395-357-0957","985 Coleman Road"),
("hbladge8","Hazlett","nQ2H|jT`Sdc|8+q","2023-05-22","Male","700-838-2386","24165 Gale Parkway"),
("pyork9","Paddy","dC2>3jIyq}po","2023-09-27","Male","813-313-9746","6 Granby Parkway"),
("alossmana","Ashla","uV3(B}YE3o3k","2023-01-19","Female","135-537-9104","6 Clarendon Crossing"),
("blerouxb","Boris","dO5%\y%EzYMC","2023-04-16","Male","377-174-0576","00 Petterle Terrace"),
("wferrarelloc","Weidar","tG8%@Vt_O_$lP","2023-04-02","Male","826-868-2031","0 Novick Drive"),
("dspreadd","Dunstan","aJ2!!_8#)*WsQ2","2023-04-17","Male","239-127-8632","55445 Schlimgen Place"),
("mhallgalleye","Maribelle","jV7(25j7QQO","2023-10-30","Female","781-443-8203","99 Sycamore Place"),
("arealf","Antony","jP5*}&9jzCyl}","2023-10-22","Male","817-901-8971","972 Duke Circle"),
("bswinleyg","Bree","nJ1/o_e{6&'_E1KD","2023-10-16","Female","222-975-7309","7 Commercial Street"),
("ochettleh","Odie","bO4@'OY1","2023-09-09","Male","241-860-6489","20 Manitowish Court"),
("pfallowsi","Philipa","hX0/wkWqAg?(S","2023-11-07","Female","242-585-0927","02 Summer Ridge Park"),
("prenhardj","Perice","jT1@{+ZG","2023-04-14","Male","403-154-6834","47 Onsgard Trail");


INSERT INTO likes(user_id,article_id) VALUES ('tkesterton0',9);
INSERT INTO likes(user_id,article_id) VALUES ('kohoolahan1',10);
INSERT INTO likes(user_id,article_id) VALUES ('dbohey2',9);
INSERT INTO likes(user_id,article_id) VALUES ('mstannah3',6);
INSERT INTO likes(user_id,article_id) VALUES ('zdillistone4',7);
INSERT INTO likes(user_id,article_id) VALUES ('dgillison5',9);
INSERT INTO likes(user_id,article_id) VALUES ('rsuddock6',1);
INSERT INTO likes(user_id,article_id) VALUES ('hantonsen7',1);
INSERT INTO likes(user_id,article_id) VALUES ('hbladge8',10);
INSERT INTO likes(user_id,article_id) VALUES ('pyork9',8);
INSERT INTO likes(user_id,article_id) VALUES ('alossmana',4);
INSERT INTO likes(user_id,article_id) VALUES ('blerouxb',6);
INSERT INTO likes(user_id,article_id) VALUES ('wferrarelloc',6);
INSERT INTO likes(user_id,article_id) VALUES ('dspreadd',8);
INSERT INTO likes(user_id,article_id) VALUES ('mhallgalleye',8);
INSERT INTO likes(user_id,article_id) VALUES ('arealf',8);
INSERT INTO likes(user_id,article_id) VALUES ('bswinleyg',3);
INSERT INTO likes(user_id,article_id) VALUES ('ochettleh',7);
INSERT INTO likes(user_id,article_id) VALUES ('pfallowsi',9);
INSERT INTO likes(user_id,article_id) VALUES ('prenhardj',4);
INSERT INTO likes(user_id,article_id) VALUES ('tkesterton0',9);
INSERT INTO likes(user_id,article_id) VALUES ('kohoolahan1',10);
INSERT INTO likes(user_id,article_id) VALUES ('dbohey2',5);
INSERT INTO likes(user_id,article_id) VALUES ('mstannah3',4);
INSERT INTO likes(user_id,article_id) VALUES ('zdillistone4',2);
INSERT INTO likes(user_id,article_id) VALUES ('dgillison5',1);
INSERT INTO likes(user_id,article_id) VALUES ('rsuddock6',10);
INSERT INTO likes(user_id,article_id) VALUES ('hantonsen7',5);
INSERT INTO likes(user_id,article_id) VALUES ('hbladge8',5);
INSERT INTO likes(user_id,article_id) VALUES ('pyork9',9);
INSERT INTO likes(user_id,article_id) VALUES ('alossmana',7);
INSERT INTO likes(user_id,article_id) VALUES ('blerouxb',1);
INSERT INTO likes(user_id,article_id) VALUES ('wferrarelloc',3);
INSERT INTO likes(user_id,article_id) VALUES ('dspreadd',1);
INSERT INTO likes(user_id,article_id) VALUES ('mhallgalleye',2);
INSERT INTO likes(user_id,article_id) VALUES ('arealf',1);
INSERT INTO likes(user_id,article_id) VALUES ('bswinleyg',9);
INSERT INTO likes(user_id,article_id) VALUES ('ochettleh',9);
INSERT INTO likes(user_id,article_id) VALUES ('pfallowsi',6);
INSERT INTO likes(user_id,article_id) VALUES ('prenhardj',4);
INSERT INTO likes(user_id,article_id) VALUES ('tkesterton0',1);
INSERT INTO likes(user_id,article_id) VALUES ('kohoolahan1',8);
INSERT INTO likes(user_id,article_id) VALUES ('dbohey2',6);
INSERT INTO likes(user_id,article_id) VALUES ('mstannah3',1);
INSERT INTO likes(user_id,article_id) VALUES ('zdillistone4',1);
INSERT INTO likes(user_id,article_id) VALUES ('dgillison5',9);
INSERT INTO likes(user_id,article_id) VALUES ('rsuddock6',6);
INSERT INTO likes(user_id,article_id) VALUES ('hantonsen7',6);
INSERT INTO likes(user_id,article_id) VALUES ('hbladge8',9);
INSERT INTO likes(user_id,article_id) VALUES ('pyork9',5);
INSERT INTO likes(user_id,article_id) VALUES ('alossmana',10);
INSERT INTO likes(user_id,article_id) VALUES ('blerouxb',10);
INSERT INTO likes(user_id,article_id) VALUES ('wferrarelloc',5);
INSERT INTO likes(user_id,article_id) VALUES ('dspreadd',6);
INSERT INTO likes(user_id,article_id) VALUES ('mhallgalleye',6);
INSERT INTO likes(user_id,article_id) VALUES ('arealf',8);
INSERT INTO likes(user_id,article_id) VALUES ('bswinleyg',2);
INSERT INTO likes(user_id,article_id) VALUES ('ochettleh',5);
INSERT INTO likes(user_id,article_id) VALUES ('pfallowsi',9);
INSERT INTO likes(user_id,article_id) VALUES ('prenhardj',8);
INSERT INTO likes(user_id,article_id) VALUES ('tkesterton0',1);
INSERT INTO likes(user_id,article_id) VALUES ('kohoolahan1',9);
INSERT INTO likes(user_id,article_id) VALUES ('dbohey2',9);
INSERT INTO likes(user_id,article_id) VALUES ('mstannah3',2);
INSERT INTO likes(user_id,article_id) VALUES ('zdillistone4',10);
INSERT INTO likes(user_id,article_id) VALUES ('dgillison5',1);
INSERT INTO likes(user_id,article_id) VALUES ('rsuddock6',5);
INSERT INTO likes(user_id,article_id) VALUES ('hantonsen7',10);
INSERT INTO likes(user_id,article_id) VALUES ('hbladge8',3);
INSERT INTO likes(user_id,article_id) VALUES ('pyork9',6);
INSERT INTO likes(user_id,article_id) VALUES ('alossmana',10);
INSERT INTO likes(user_id,article_id) VALUES ('blerouxb',7);
INSERT INTO likes(user_id,article_id) VALUES ('wferrarelloc',1);
INSERT INTO likes(user_id,article_id) VALUES ('dspreadd',10);
INSERT INTO likes(user_id,article_id) VALUES ('mhallgalleye',5);
INSERT INTO likes(user_id,article_id) VALUES ('arealf',6);
INSERT INTO likes(user_id,article_id) VALUES ('bswinleyg',9);
INSERT INTO likes(user_id,article_id) VALUES ('ochettleh',7);
INSERT INTO likes(user_id,article_id) VALUES ('pfallowsi',10);
INSERT INTO likes(user_id,article_id) VALUES ('prenhardj',10);
INSERT INTO likes(user_id,article_id) VALUES ('tkesterton0',1);
INSERT INTO likes(user_id,article_id) VALUES ('kohoolahan1',3);
INSERT INTO likes(user_id,article_id) VALUES ('dbohey2',3);
INSERT INTO likes(user_id,article_id) VALUES ('mstannah3',4);
INSERT INTO likes(user_id,article_id) VALUES ('zdillistone4',8);
INSERT INTO likes(user_id,article_id) VALUES ('dgillison5',9);
INSERT INTO likes(user_id,article_id) VALUES ('rsuddock6',2);
INSERT INTO likes(user_id,article_id) VALUES ('hantonsen7',6);
INSERT INTO likes(user_id,article_id) VALUES ('hbladge8',10);
INSERT INTO likes(user_id,article_id) VALUES ('pyork9',7);
INSERT INTO likes(user_id,article_id) VALUES ('alossmana',8);
INSERT INTO likes(user_id,article_id) VALUES ('blerouxb',2);
INSERT INTO likes(user_id,article_id) VALUES ('wferrarelloc',1);
INSERT INTO likes(user_id,article_id) VALUES ('dspreadd',5);
INSERT INTO likes(user_id,article_id) VALUES ('mhallgalleye',1);
INSERT INTO likes(user_id,article_id) VALUES ('arealf',10);
INSERT INTO likes(user_id,article_id) VALUES ('bswinleyg',8);
INSERT INTO likes(user_id,article_id) VALUES ('ochettleh',8);
INSERT INTO likes(user_id,article_id) VALUES ('pfallowsi',7);
INSERT INTO likes(user_id,article_id) VALUES ('prenhardj',2);


#'tkesterton0' 사용자의 모든 게시물과 댓글 수 가져오기 :
SELECT a.article_id, a.context, COUNT(DISTINCT l.like_id) AS like_count, COUNT(DISTINCT c.comment_id) AS comment_count
FROM Article AS a
LEFT JOIN Likes AS l ON a.article_id = l.article_id
LEFT JOIN Comment AS c ON a.article_id = c.article_id
WHERE a.user_id = 'tkesterton0'
GROUP BY a.article_id;

# 특정 게시물에 대한 모든 댓글 및 댓글에 대한 답글 가져오기: (수정완)
SELECT 
    c1.comment_id AS parent_comment_id,
    c1.context AS parent_comment,
    c2.comment_id AS reply_comment_id,
    c2.context AS reply_comment
FROM 
    Comment AS c1
LEFT JOIN 
    Comment AS c2 ON c1.comment_id = c2.group_num AND c2.hierarchy = 2
WHERE 
    c1.article_id = '[특정 게시물 ID]' AND c1.hierarchy = 1;



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


#프로필에서 게시글의 이미지를 선택하여 해당 게시글로 이동하는 기능 (article_id, like_num, context, user_id, created_at, 댓글 개수, 이미지)
select a.article_id, a.like_num, a.context, a.user_id, a.created_at, comment_count, imgUrlList
from article as a left join 
(select article_id, count(comment_id) as comment_count from comment group by (article_id)) as c 
on a.article_id = c.article_id
left join (select article_id, group_concat(url) as imgUrlList from image as i group by (i.article_id)) as img
on a.article_id = img.article_id 
where a.article_id = 3;
    
    
#'tkesterton0'가 팔로잉하는 사용자의 게시물 (article_id, like_num, context, created_at, user_id, comment_count )
select a.article_id, a.like_num, a.context, a.created_at, a.user_id, comment_count, imgUrlList
from article as a left join 
(select user_id, count(comment_id) as comment_count from comment group by(user_id))as c
on a.user_id = c.user_id
left join (select article_id, group_concat(url) as imgUrlList from image as i group by (i.article_id)) as img
on a.article_id = img.article_id 
 where a.user_id in (select following_id from follow where follower_id = 'tkesterton0');



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
SELECT COUNT(*) AS like_count FROM Likes WHERE article_id = '[게시물 ID]';


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





