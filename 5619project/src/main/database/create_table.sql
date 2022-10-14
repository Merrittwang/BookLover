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


INSERT INTO category VALUES(1, 'Science');
INSERT INTO category VALUES(2, 'Love');
INSERT INTO category VALUES(3, 'Detective');
INSERT INTO category VALUES(4, 'Drama');
INSERT INTO category VALUES(5, 'Magic');
INSERT INTO book VALUES(1,'Harry Potter 1','JK Rowling',10,4,3);
INSERT INTO book VALUES(2,'Hamlet','Shakespeare',20,5,4);
INSERT INTO book VALUES(3,'Assam Witch','Arthur Miller',10,5,3);
INSERT INTO book VALUES(4,'Death of a Salesman','Arthur Miller',10,5,2);
INSERT INTO book VALUES(5,'Macbeth','Shakespeare',10,5,1);
INSERT INTO book VALUES(6,'Beijingers','Yu Cao',10,5,6);
INSERT INTO book VALUES(7,'Harry Potter 2','JK Rowling',10,4,8);
INSERT INTO book VALUES(8,'Twilight','Stephenie Meyer',10,4,5);
INSERT INTO book VALUES(9,'The Lord of the Rings','J. R. R. Tolkien',20,4,3);
INSERT INTO book VALUES(10,'The Chronicles of Narnia 1','C.S Lewis',10,4,1);
INSERT INTO book VALUES(11,'The Chronicles of Narnia 2','C.S Lewis',10,4,6);
INSERT INTO book VALUES(12,'The Chronicles of Narnia 3','C.S Lewis',10,4,8);
INSERT INTO book VALUES(13,'Titans sea demon','Kurt Vonnegut',10,1,5);
INSERT INTO book VALUES(14,'Internet killing','Daniel Suarez',20,1,3);
INSERT INTO book VALUES(15,'Tiresome','Cixin Liu',10,1,8);
INSERT INTO book VALUES(16,'I robot','Frank Herbert',10,1,5);
INSERT INTO book VALUES(17,'Ring World','Larry Nivel',20,1,3);
INSERT INTO book VALUES(18,'Halloween Party','Agatha Christie',10,3,8);
INSERT INTO book VALUES(19,'The Body in the Library','Agatha Christie',10,3,5);
INSERT INTO book VALUES(20,'Rogue Male','Geoffrey Household',20,3,8);
INSERT INTO book VALUES(21,'The False Inspector Dew','Peter Lovesey',20,3,23);
INSERT INTO book VALUES(22,'Barbara Vine','A Dark-Adapted Eye',20,3,24);
INSERT INTO book VALUES(23,'The Postman Always Rings Twice','James M. Cain',20,3,32);
INSERT INTO book VALUES(24,'The Thorn Birds ','Colleen McCullough',20,2,31);
INSERT INTO book VALUES(25,'The English Patient','Michael Ondaatje',20,2,23);
INSERT INTO book VALUES(26,'Jane Eyre','Charlotte Brontë',20,2,13);
INSERT INTO book VALUES(27,'Wuthering Heights','Emily Brontë',20,2,22);
INSERT INTO book VALUES(28,'Paper Heart','Aileen Arrington',20,2,10);
INSERT INTO book VALUES(29,'Me Before You','Jojo Moyes',20,2,11);

INSERT INTO user VALUES (1,'123456',10,'kevin',1,1,'yuechen@google.com',0,'kevin','2022-08-01 12:00:00','kevin','2022-08-01 12:00:00');
INSERT INTO user VALUES (2,'123456',10,'Yuzhe',1,1,'yuzhe1997@google.com',0,'Yuzhe','2022-08-01 12:00:00','Yuzhe','2022-08-01 12:00:00');
INSERT INTO user VALUES (3,'123456',10,'Haonan',1,0,'haonan@google.com',0,'Haonan','2022-08-01 12:00:00','Haonan','2022-08-01 12:00:00');
INSERT INTO subscribe VALUES (1,2);
INSERT INTO subscribe VALUES (1,3);
INSERT INTO pay VALUES (1,1,1);
INSERT INTO today_inf VALUES (1,3,40);
INSERT INTO readinghistory VALUES (1,1,1,'2022-08-01 12:00:00',40);
INSERT INTO readinghistory VALUES (1,2,1,'2022-08-03 12:00:00',40);