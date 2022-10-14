DROP TABLE IF EXISTS subscribe;
DROP TABLE IF EXISTS bookcategory;
DROP TABLE IF EXISTS userinterest;
DROP TABLE IF EXISTS bookmark;
DROP TABLE IF EXISTS highlight;
DROP TABLE IF EXISTS pay;
DROP TABLE IF EXISTS liking;
DROP TABLE IF EXISTS note;
DROP TABLE IF EXISTS subcomment;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS readinghistory;
DROP TABLE IF EXISTS today_inf;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
CREATE TABLE category
(
	category_id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	category_name VARCHAR(20) NOT NULL 
);
CREATE TABLE user
    ( 
	account_id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
	pass VARCHAR(20) NOT NULL,
	points INTEGER NOT NULL,
	account_name VARCHAR(20) NOT NULL,
	vip INT NOT NULL,
	sex boolean,
	email VARCHAR(20),
	is_delete INT,
	created_user VARCHAR(20),
	created_time DATETIME,
	modified_user VARCHAR(20),
	modified_time DATETIME
    );
CREATE TABLE subscribe
(
	subscriber_id INTEGER NOT NULL, 
	subscribe_id INTEGER NOT NULL,
	PRIMARY KEY (`subscriber_id`,`subscribe_id`),
	CONSTRAINT fk_sub_1 FOREIGN KEY (subscriber_id) REFERENCES user(account_id),
	CONSTRAINT fk_sub_2 FOREIGN KEY (subscribe_id) REFERENCES user(account_id)
);
CREATE TABLE book
(
	book_id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY, 
	book_name VARCHAR(20) NOT NULL,
	authors VARCHAR(20) NOT NULL,
	price INTEGER NOT NULL,
	years INTEGER NOT NULL,
	category_id INTEGER NOT NULL,
	likes INTEGER NOT NULL,
	CONSTRAINT fk_bc_1 FOREIGN KEY (category_id) REFERENCES category(category_id)
);

CREATE TABLE bookmark
(
	user_id INTEGER NOT NULL, 
	book_id INTEGER NOT NULL, 
	location INTEGER NOT NULL,
	PRIMARY KEY (`user_id`,`book_id`,location),
	CONSTRAINT fk_bm_1 FOREIGN KEY (book_id) REFERENCES book(book_id),
	CONSTRAINT fk_bm_2 FOREIGN KEY (user_id) REFERENCES user(account_id)
);
CREATE TABLE pay
(
	user_id INTEGER NOT NULL, 
	book_id INTEGER NOT NULL, 
	share boolean NOT NULL,
	PRIMARY KEY (`user_id`,`book_id`),
	CONSTRAINT fk_pay_1 FOREIGN KEY (book_id) REFERENCES book(book_id),
	CONSTRAINT fk_pay_2 FOREIGN KEY (user_id) REFERENCES user(account_id)
);
CREATE TABLE highlight
(
	user_id INTEGER NOT NULL, 
	book_id INTEGER NOT NULL, 
	location INTEGER NOT NULL,
	length INTEGER NOT NULL,
	PRIMARY KEY (`user_id`,`book_id`,location,length),
	CONSTRAINT fk_highlight_1 FOREIGN KEY (book_id) REFERENCES book(book_id),
	CONSTRAINT fk_highlight_2 FOREIGN KEY (user_id) REFERENCES user(account_id)
);
CREATE TABLE liking
(
	user_id INTEGER NOT NULL, 
	book_id INTEGER NOT NULL, 
	PRIMARY KEY (`user_id`,`book_id`),
	CONSTRAINT fk_like_1 FOREIGN KEY (book_id) REFERENCES book(book_id),
	CONSTRAINT fk_like_2 FOREIGN KEY (user_id) REFERENCES user(account_id)
);
CREATE TABLE comment
(
	user_id INTEGER NOT NULL , 
	book_id INTEGER NOT NULL, 
	com_id INTEGER NOT NULL,
	time DATETIME NOT NULL,
	content text NOT NULL,	
	PRIMARY KEY (`user_id`,`book_id`,com_id),
	CONSTRAINT fk_com_1 FOREIGN KEY (book_id) REFERENCES book(book_id),
	CONSTRAINT fk_com_2 FOREIGN KEY (user_id) REFERENCES user(account_id)
);
CREATE TABLE note
(
	user_id INTEGER NOT NULL, 
	book_id INTEGER NOT NULL, 
	location INTEGER NOT NULL,
	note text NOT NULL,
	PRIMARY KEY (`user_id`,`book_id`,`location`),
	CONSTRAINT fk_note_1 FOREIGN KEY (book_id) REFERENCES book(book_id),
	CONSTRAINT fk_note_2 FOREIGN KEY (user_id) REFERENCES user(account_id)
);
CREATE TABLE readinghistory
(
	user_id INTEGER NOT NULL, 
	book_id INTEGER NOT NULL, 
	history_id INTEGER NOT NULL,
	last_read_time DATETIME NOT NULL,
	last_read_location INTEGER NOT NULL,
	PRIMARY KEY (`user_id`,`book_id`,history_id),
	CONSTRAINT fk_his_1 FOREIGN KEY (book_id) REFERENCES book(book_id),
	CONSTRAINT fk_his_2 FOREIGN KEY (user_id) REFERENCES user(account_id)
);
CREATE TABLE today_inf
(
	user_id INTEGER NOT NULL PRIMARY KEY, 
	notenum INTEGER NOT NULL,
	online_time INTEGER NOT NULL,
	CONSTRAINT fk_today FOREIGN KEY (user_id) REFERENCES user(account_id)
);


INSERT INTO category VALUES(1, 'category1');
INSERT INTO category VALUES(2, 'category2');
INSERT INTO category VALUES(3, 'category3');
INSERT INTO category VALUES(4, 'category4');
INSERT INTO book VALUES(1,'book1','AUTHOR1',10,1,3);
INSERT INTO book VALUES(2,'book3','AUTHOR3',20,1,4);
INSERT INTO book VALUES(3,'book1','AUTHOR1',10,1,3);
INSERT INTO book VALUES(4,'book1','AUTHOR1',10,1,2);
INSERT INTO book VALUES(5,'book1','AUTHOR1',10,1,1);
INSERT INTO book VALUES(6,'book1','AUTHOR1',10,1,6);
INSERT INTO book VALUES(7,'book1','AUTHOR1',10,1,8);
INSERT INTO book VALUES(8,'book2','AUTHOR2',10,2,5);
INSERT INTO book VALUES(9,'book4','AUTHOR3',20,2,3);
INSERT INTO user VALUES (1,'123456',10,'kevin1',1,1,'1@google.com',0,'kevin1','2022-08-01 12:00:00','kevin1','2022-08-01 12:00:00');
INSERT INTO user VALUES (2,'123456',10,'kevin2',1,1,'2@google.com',0,'kevin2','2022-08-01 12:00:00','kevin2','2022-08-01 12:00:00');
INSERT INTO user VALUES (3,'123456',10,'kevin3',1,0,'3@google.com',0,'kevin3','2022-08-01 12:00:00','kevin3','2022-08-01 12:00:00');
INSERT INTO subscribe VALUES (1,2);
INSERT INTO subscribe VALUES (1,3);
INSERT INTO pay VALUES (1,1,1);
INSERT INTO today_inf VALUES (1,3,40);
INSERT INTO readinghistory VALUES (1,1,1,'2022-08-01 12:00:00',40);
INSERT INTO readinghistory VALUES (1,2,1,'2022-08-03 12:00:00',40);