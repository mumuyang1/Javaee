USE user_management

DROP  TABLE  users;
CREATE  TABLE  users (id INT (3) auto_increment NOT NULL PRIMARY KEY, name CHAR (10) NOT NULL, gender CHAR (4), mailbox CHAR (20) NOT NULL, age INT (3));
INSERT INTO users VALUES(NULL ,'薛倩','男','12893283@outlook.com','22');
INSERT INTO users VALUES(NULL ,'王欢','男','12893283@qq.com','22');