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

#데이터 입력
insert into Article values
(43,96,"magna at nunc commodo placerat praesent blandit nam nulla integer pede","2023-08-22 0:37","tkesterton0"),
(94,68,"odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit","2023-07-18 8:23","kohoolahan1"),
(52,92,"turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam sit amet diam in magna bibendum imperdiet","2023-05-27 21:44","dbohey2"),
(12,16,"dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien ut nunc vestibulum","2023-11-09 13:13","mstannah3"),
(96,24,"pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget elit sodales","2023-04-24 15:12","zdillistone4"),
(33,59,"a nibh in quis justo maecenas rhoncus aliquam lacus morbi quis","2023-10-15 23:30","dgillison5"),
(7,39,"iaculis congue vivamus metus arcu adipiscing molestie hendrerit at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis","2023-05-25 18:20","rsuddock6"),
(72,100,"ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit","2023-07-27 23:46","hantonsen7"),
(27,42,"ut at dolor quis odio consequat varius integer ac leo pellentesque","2023-04-24 19:31","hbladge8"),
(21,45,"nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula vehicula","2023-07-25 2:49","pyork9"),
(53,2,"interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus","2023-06-02 15:29","alossmana"),
(22,98,"luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat","2023-05-02 15:23","wferrarelloc"),
(88,49,"venenatis lacinia aenean sit amet justo morbi ut odio cras","2023-02-28 9:31","dspreadd"),
(62,24,"morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui vel nisl duis ac nibh fusce lacus purus","2023-07-24 12:24","arealf"),
(67,65,"odio porttitor id consequat in consequat ut nulla sed accumsan felis ut at dolor quis odio consequat varius","2023-02-08 20:22","bswinleyg"),
(34,86,"dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat non pretium quis lectus suspendisse potenti","2023-03-05 16:33","pfallowsi"),
(4,67,"nisi eu orci mauris lacinia sapien quis libero nullam sit amet","2023-07-29 18:53","prenhardj"),
(98,77,"tellus semper interdum mauris ullamcorper purus sit amet nulla quisque arcu libero","2023-01-17 12:17","tkesterton0"),
(60,94,"ut rhoncus aliquet pulvinar sed nisl nunc rhoncus dui vel sem sed","2023-05-17 10:38","kohoolahan1"),
(83,25,"turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut mauris eget massa","2023-01-13 1:05","dbohey2"),
(76,10,"at vulputate vitae nisl aenean lectus pellentesque eget nunc donec quis orci eget orci vehicula condimentum curabitur in libero","2023-05-17 0:15","mstannah3"),
(13,74,"nulla ac enim in tempor turpis nec euismod scelerisque quam","2023-04-08 22:38","zdillistone4"),
(23,51,"risus dapibus augue vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam","2023-04-26 11:19","dgillison5"),
(26,58,"nullam varius nulla facilisi cras non velit nec nisi vulputate","2023-01-18 9:50","rsuddock6"),
(51,67,"integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante ipsum primis in faucibus","2022-11-30 18:43","hantonsen7"),
(28,84,"vivamus in felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec","2022-11-23 23:57","hbladge8"),
(75,70,"convallis duis consequat dui nec nisi volutpat eleifend donec ut dolor morbi vel lectus in quam","2023-08-07 21:41","pyork9"),
(40,14,"nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum","2023-07-05 20:37","alossmana"),
(90,86,"urna ut tellus nulla ut erat id mauris vulputate elementum nullam varius nulla facilisi cras non","2023-03-21 13:12","wferrarelloc"),
(37,86,"suspendisse ornare consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce","2023-10-21 3:34","arealf"),
(100,57,"sollicitudin mi sit amet lobortis sapien sapien non mi integer ac neque duis bibendum","2023-03-07 8:44","ochettleh"),
(44,41,"aenean fermentum donec ut mauris eget massa tempor convallis nulla neque libero","2023-05-19 4:03","pfallowsi"),
(65,68,"at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis natoque penatibus et magnis","2023-02-09 0:25","prenhardj"),
(8,94,"justo maecenas rhoncus aliquam lacus morbi quis tortor id nulla ultrices aliquet maecenas leo odio condimentum id","2023-10-05 10:15","tkesterton0"),
(2,92,"ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus in sagittis dui","2023-01-16 22:01","kohoolahan1"),
(1,16,"odio odio elementum eu interdum eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat","2023-10-13 20:43","dbohey2"),
(79,49,"faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna","2023-05-12 19:17","zdillistone4"),
(78,84,"pellentesque viverra pede ac diam cras pellentesque volutpat dui maecenas","2023-02-22 10:54","dgillison5"),
(3,43,"mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing","2023-06-07 7:01","rsuddock6"),
(36,25,"ut erat id mauris vulputate elementum nullam varius nulla facilisi cras","2023-01-06 2:41","hbladge8"),
(61,68,"at turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum","2023-11-14 22:22","pyork9"),
(92,49,"posuere cubilia curae mauris viverra diam vitae quam suspendisse potenti nullam porttitor","2023-07-23 8:20","blerouxb"),
(32,69,"duis at velit eu est congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam","2023-05-13 2:51","dspreadd"),
(31,91,"blandit lacinia erat vestibulum sed magna at nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget","2023-08-21 10:49","mhallgalleye"),
(73,2,"nulla quisque arcu libero rutrum ac lobortis vel dapibus at","2023-01-17 1:59","arealf"),
(63,66,"sagittis dui vel nisl duis ac nibh fusce lacus purus aliquet at feugiat","2023-10-22 10:33","pfallowsi"),
(38,64,"in faucibus orci luctus et ultrices posuere cubilia curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit","2022-11-28 5:14","dbohey2"),
(82,28,"ligula in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper","2022-12-05 17:30","zdillistone4"),
(30,76,"lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem id ligula suspendisse","2023-05-15 4:17","dgillison5"),
(74,38,"neque sapien placerat ante nulla justo aliquam quis turpis eget elit","2023-03-20 16:30","rsuddock6"),
(99,36,"est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc","2023-09-21 14:51","hbladge8"),
(59,39,"eu tincidunt in leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus","2023-03-22 10:30","pyork9"),
(10,48,"nec condimentum neque sapien placerat ante nulla justo aliquam quis turpis eget","2023-04-21 7:01","alossmana"),
(87,59,"semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci nullam molestie nibh in","2022-12-08 0:29","wferrarelloc"),
(69,39,"rhoncus mauris enim leo rhoncus sed vestibulum sit amet cursus id turpis integer aliquet massa id lobortis","2023-05-09 16:24","dspreadd"),
(50,89,"ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit","2022-12-19 5:22","arealf"),
(58,77,"vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo aliquam","2023-07-14 8:42","bswinleyg"),
(66,1,"dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec condimentum neque sapien placerat ante nulla justo","2023-02-01 13:11","tkesterton0"),
(91,34,"vel accumsan tellus nisi eu orci mauris lacinia sapien quis libero nullam sit amet turpis elementum ligula","2023-04-01 11:01","zdillistone4"),
(55,42,"congue risus semper porta volutpat quam pede lobortis ligula sit amet eleifend pede libero quis orci","2023-03-26 11:18","dgillison5"),
(54,52,"consequat lectus in est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl nunc nisl","2023-05-23 21:11","pyork9"),
(16,94,"phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin","2023-05-27 18:03","blerouxb"),
(57,8,"sociis natoque penatibus et magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum sociis","2023-03-26 21:08","dspreadd"),
(47,15,"mauris eget massa tempor convallis nulla neque libero convallis eget eleifend luctus ultricies eu nibh quisque","2023-07-13 11:22","bswinleyg"),
(35,70,"congue elementum in hac habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo nec","2023-03-03 1:00","pfallowsi");


insert into Comment values
(2,"2023-04-04 16:59","est phasellus sit amet erat nulla tempus vivamus in felis eu","tkesterton0",43,1,1),
(68,"2023-01-20 23:41","integer ac leo pellentesque ultrices mattis odio donec vitae nisi nam ultrices","kohoolahan1",94,2,1),
(74,"2023-03-14 23:23","iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla ut erat id mauris vulputate elementum","dbohey2",52,3,1),
(53,"2023-04-18 23:45","proin at turpis a pede posuere nonummy integer non velit","mstannah3",12,4,1),
(37,"2023-07-23 5:21","sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque","zdillistone4",96,5,1),
(42,"2023-04-12 9:37","praesent lectus vestibulum quam sapien varius ut blandit non interdum in ante vestibulum ante ipsum primis in faucibus","dgillison5",33,1,1),
(3,"2023-04-25 21:24","maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat","rsuddock6",7,2,1),
(8,"2023-09-09 21:19","in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis consequat dui nec","hantonsen7",72,3,1),
(54,"2023-05-30 12:06","sed vel enim sit amet nunc viverra dapibus nulla suscipit","hbladge8",27,4,1),
(52,"2023-08-15 6:55","lacinia erat vestibulum sed magna at nunc commodo placerat praesent","pyork9",21,5,1),
(26,"2023-03-26 9:11","felis eu sapien cursus vestibulum proin eu mi nulla ac enim in tempor turpis nec euismod scelerisque","alossmana",53,1,1),
(81,"2023-07-04 14:52","magnis dis parturient montes nascetur ridiculus mus vivamus vestibulum sagittis sapien cum","blerouxb",12,2,1),
(92,"2023-05-26 2:07","turpis a pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante","wferrarelloc",22,3,1),
(96,"2023-10-22 12:09","interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing","dspreadd",88,4,1),
(44,"2023-02-14 16:30","pretium iaculis justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla","mhallgalleye",7,5,1),
(46,"2023-05-25 18:20","lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum nulla tellus","arealf",62,1,1),
(27,"2023-09-08 1:03","viverra diam vitae quam suspendisse potenti nullam porttitor lacus at turpis donec posuere metus vitae ipsum","bswinleyg",67,2,1),
(55,"2022-12-22 5:16","leo maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus in felis eu sapien cursus vestibulum proin eu","prenhardj",4,5,1),
(100,"2023-06-22 21:13","pellentesque volutpat dui maecenas tristique est et tempus semper est quam pharetra magna ac consequat metus sapien","kohoolahan1",60,2,1),
(80,"2023-03-09 10:16","id ornare imperdiet sapien urna pretium nisl ut volutpat sapien","dgillison5",23,1,2),
(83,"2023-10-07 2:20","lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt","rsuddock6",26,2,2),
(20,"2023-01-27 4:35","nunc commodo placerat praesent blandit nam nulla integer pede justo lacinia eget tincidunt eget tempus vel pede morbi porttitor lorem","hantonsen7",51,3,2),
(14,"2023-05-07 20:56","at turpis donec posuere metus vitae ipsum aliquam non mauris morbi non lectus aliquam","hbladge8",28,4,2),
(19,"2023-06-01 7:22","et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna","pyork9",75,5,2),
(79,"2023-06-08 2:36","vel augue vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae","alossmana",40,1,2),
(77,"2023-05-01 13:21","eros elementum pellentesque quisque porta volutpat erat quisque erat eros viverra eget","wferrarelloc",90,3,2),
(65,"2022-12-22 4:05","maecenas pulvinar lobortis est phasellus sit amet erat nulla tempus vivamus","dspreadd",83,4,2),
(17,"2023-10-27 11:35","ullamcorper augue a suscipit nulla elit ac nulla sed vel","mhallgalleye",88,5,2),
(31,"2023-09-28 12:02","tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque erat eros","arealf",37,1,2),
(60,"2023-02-03 21:11","justo in hac habitasse platea dictumst etiam faucibus cursus urna ut tellus nulla","bswinleyg",76,2,2),
(91,"2023-01-23 0:15","malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim","ochettleh",100,3,2),
(98,"2023-03-14 22:01","a odio in hac habitasse platea dictumst maecenas ut massa","mstannah3",96,4,2),
(4,"2023-02-09 12:13","id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed","zdillistone4",79,5,2),
(89,"2023-02-22 10:34","tellus in sagittis dui vel nisl duis ac nibh fusce","dgillison5",78,1,2),
(30,"2023-03-01 7:53","amet lobortis sapien sapien non mi integer ac neque duis bibendum morbi non quam nec dui luctus rutrum","rsuddock6",3,2,2),
(62,"2023-09-13 15:14","in magna bibendum imperdiet nullam orci pede venenatis non sodales sed tincidunt eu felis fusce posuere felis sed lacus morbi","hantonsen7",36,3,2),
(48,"2023-08-14 11:48","nunc rhoncus dui vel sem sed sagittis nam congue risus semper","hbladge8",36,4,2),
(12,"2023-06-25 22:28","curae donec pharetra magna vestibulum aliquet ultrices erat tortor sollicitudin mi sit amet lobortis sapien sapien non mi integer ac","pyork9",61,5,2),
(51,"2023-09-04 22:37","tortor risus dapibus augue vel accumsan tellus nisi eu orci","mhallgalleye",31,5,2),
(35,"2023-04-01 17:25","pede posuere nonummy integer non velit donec diam neque vestibulum eget vulputate ut ultrices vel augue vestibulum ante","arealf",73,1,2),
(56,"2023-02-10 11:10","mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem ipsum dolor sit","bswinleyg",13,2,2),
(13,"2023-08-08 4:51","feugiat et eros vestibulum ac est lacinia nisi venenatis tristique fusce congue diam id ornare imperdiet sapien urna pretium nisl","pfallowsi",63,4,2),
(7,"2022-11-30 11:40","massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio cras mi pede malesuada in imperdiet","prenhardj",32,5,2),
(71,"2023-06-04 15:32","lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat quisque","kohoolahan1",60,2,2),
(9,"2022-12-14 3:54","eros suspendisse accumsan tortor quis turpis sed ante vivamus tortor duis mattis egestas metus aenean fermentum donec ut","dbohey2",38,3,2),
(21,"2023-05-04 22:25","in lacus curabitur at ipsum ac tellus semper interdum mauris ullamcorper","mstannah3",67,4,2),
(11,"2023-08-16 12:17","id massa id nisl venenatis lacinia aenean sit amet justo morbi ut odio","zdillistone4",82,5,1),
(69,"2023-08-29 12:32","nulla ultrices aliquet maecenas leo odio condimentum id luctus nec molestie sed justo pellentesque viverra pede","dgillison5",30,1,1),
(82,"2023-09-25 9:44","luctus et ultrices posuere cubilia curae nulla dapibus dolor vel est donec odio justo sollicitudin ut suscipit a feugiat","pyork9",59,5,1),
(1,"2023-10-11 3:10","blandit ultrices enim lorem ipsum dolor sit amet consectetuer adipiscing elit proin","alossmana",10,1,1),
(70,"2023-10-18 5:57","nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget eros elementum pellentesque quisque porta volutpat erat","blerouxb",37,2,1),
(72,"2022-12-20 9:21","quisque arcu libero rutrum ac lobortis vel dapibus at diam nam","wferrarelloc",87,3,1),
(40,"2023-10-22 20:25","nisl duis bibendum felis sed interdum venenatis turpis enim blandit mi in","dspreadd",69,4,1),
(16,"2023-02-07 5:04","molestie nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu magna vulputate luctus cum sociis","arealf",50,1,1),
(78,"2023-04-28 20:15","eget tempus vel pede morbi porttitor lorem id ligula suspendisse ornare consequat lectus in est risus","ochettleh",3,3,1),
(57,"2023-02-10 17:37","nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt","prenhardj",52,5,1),
(6,"2022-12-29 8:40","eleifend luctus ultricies eu nibh quisque id justo sit amet sapien dignissim vestibulum","kohoolahan1",92,2,2),
(39,"2023-04-16 6:34","sem praesent id massa id nisl venenatis lacinia aenean sit","mstannah3",76,4,2),
(50,"2023-07-21 23:33","interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit at","rsuddock6",90,2,2),
(22,"2023-04-05 4:34","faucibus cursus urna ut tellus nulla ut erat id mauris","hantonsen7",79,3,2),
(32,"2023-07-24 3:02","nibh in lectus pellentesque at nulla suspendisse potenti cras in purus eu","hbladge8",59,4,2),
(75,"2023-05-28 0:39","congue risus semper porta volutpat quam pede lobortis ligula sit","alossmana",13,1,2),
(87,"2022-12-27 21:40","habitasse platea dictumst morbi vestibulum velit id pretium iaculis diam erat fermentum justo","mhallgalleye",98,5,1),
(73,"2023-11-08 3:17","rhoncus sed vestibulum sit amet cursus id turpis integer aliquet","ochettleh",52,3,1);

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


insert into Image values
(58,"http://dummyimage.com/228x100.png/5fa2dd/ffffff",43),
(88,"http://dummyimage.com/103x100.png/cc0000/ffffff",52),
(92,"http://dummyimage.com/114x100.png/cc0000/ffffff",12),
(47,"http://dummyimage.com/140x100.png/cc0000/ffffff",96),
(74,"http://dummyimage.com/209x100.png/ff4444/ffffff",33),
(54,"http://dummyimage.com/105x100.png/5fa2dd/ffffff",72),
(23,"http://dummyimage.com/138x100.png/5fa2dd/ffffff",27),
(44,"http://dummyimage.com/106x100.png/dddddd/000000",21),
(86,"http://dummyimage.com/106x100.png/dddddd/000000",53),
(65,"http://dummyimage.com/248x100.png/5fa2dd/ffffff",12),
(28,"http://dummyimage.com/101x100.png/5fa2dd/ffffff",88),
(10,"http://dummyimage.com/217x100.png/dddddd/000000",7),
(38,"http://dummyimage.com/238x100.png/5fa2dd/ffffff",62),
(97,"http://dummyimage.com/150x100.png/5fa2dd/ffffff",67),
(34,"http://dummyimage.com/236x100.png/5fa2dd/ffffff",51),
(12,"http://dummyimage.com/245x100.png/5fa2dd/ffffff",34),
(14,"http://dummyimage.com/218x100.png/5fa2dd/ffffff",4),
(72,"http://dummyimage.com/175x100.png/5fa2dd/ffffff",98),
(46,"http://dummyimage.com/250x100.png/dddddd/000000",60),
(17,"http://dummyimage.com/232x100.png/5fa2dd/ffffff",83),
(59,"http://dummyimage.com/204x100.png/ff4444/ffffff",76),
(43,"http://dummyimage.com/187x100.png/5fa2dd/ffffff",13),
(29,"http://dummyimage.com/155x100.png/ff4444/ffffff",23),
(60,"http://dummyimage.com/193x100.png/cc0000/ffffff",51),
(90,"http://dummyimage.com/129x100.png/cc0000/ffffff",75),
(96,"http://dummyimage.com/215x100.png/dddddd/000000",40),
(27,"http://dummyimage.com/177x100.png/dddddd/000000",90),
(98,"http://dummyimage.com/118x100.png/ff4444/ffffff",88),
(89,"http://dummyimage.com/143x100.png/ff4444/ffffff",37),
(61,"http://dummyimage.com/208x100.png/dddddd/000000",44),
(56,"http://dummyimage.com/146x100.png/dddddd/000000",65),
(1,"http://dummyimage.com/138x100.png/5fa2dd/ffffff",8),
(13,"http://dummyimage.com/145x100.png/5fa2dd/ffffff",2),
(99,"http://dummyimage.com/180x100.png/ff4444/ffffff",1),
(78,"http://dummyimage.com/227x100.png/cc0000/ffffff",3),
(9,"http://dummyimage.com/176x100.png/5fa2dd/ffffff",36),
(64,"http://dummyimage.com/128x100.png/ff4444/ffffff",36),
(26,"http://dummyimage.com/223x100.png/dddddd/000000",61),
(8,"http://dummyimage.com/151x100.png/ff4444/ffffff",21),
(31,"http://dummyimage.com/218x100.png/cc0000/ffffff",92),
(39,"http://dummyimage.com/133x100.png/5fa2dd/ffffff",72),
(87,"http://dummyimage.com/141x100.png/5fa2dd/ffffff",31),
(15,"http://dummyimage.com/113x100.png/ff4444/ffffff",13),
(53,"http://dummyimage.com/201x100.png/dddddd/000000",63),
(76,"http://dummyimage.com/109x100.png/ff4444/ffffff",32),
(68,"http://dummyimage.com/208x100.png/ff4444/ffffff",33),
(11,"http://dummyimage.com/118x100.png/cc0000/ffffff",60),
(48,"http://dummyimage.com/155x100.png/cc0000/ffffff",38),
(16,"http://dummyimage.com/161x100.png/cc0000/ffffff",67),
(73,"http://dummyimage.com/194x100.png/5fa2dd/ffffff",82),
(37,"http://dummyimage.com/198x100.png/dddddd/000000",74),
(32,"http://dummyimage.com/198x100.png/cc0000/ffffff",75),
(49,"http://dummyimage.com/129x100.png/cc0000/ffffff",10),
(36,"http://dummyimage.com/219x100.png/dddddd/000000",87),
(71,"http://dummyimage.com/189x100.png/5fa2dd/ffffff",69),
(30,"http://dummyimage.com/103x100.png/dddddd/000000",21),
(7,"http://dummyimage.com/162x100.png/cc0000/ffffff",82),
(83,"http://dummyimage.com/126x100.png/dddddd/000000",52),
(42,"http://dummyimage.com/176x100.png/cc0000/ffffff",92),
(80,"http://dummyimage.com/102x100.png/ff4444/ffffff",43),
(79,"http://dummyimage.com/249x100.png/cc0000/ffffff",91),
(91,"http://dummyimage.com/153x100.png/ff4444/ffffff",90),
(94,"http://dummyimage.com/129x100.png/cc0000/ffffff",79),
(75,"http://dummyimage.com/111x100.png/ff4444/ffffff",8),
(41,"http://dummyimage.com/241x100.png/ff4444/ffffff",52),
(2,"http://dummyimage.com/172x100.png/5fa2dd/ffffff",35);

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


#특정 사용자의 모든 게시물과 댓글 수 가져오기 :
SELECT a.article_id, a.context, COUNT(DISTINCT l.like_id) AS like_count, COUNT(DISTINCT c.comment_id) AS comment_count
FROM Article AS a
LEFT JOIN Likes AS l ON a.article_id = l.article_id
LEFT JOIN Comment AS c ON a.article_id = c.article_id
WHERE a.user_id = '[특정 사용자 ID]'
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




