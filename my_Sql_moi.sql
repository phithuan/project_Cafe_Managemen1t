CREATE DATABASE cafe2;

USE cafe2;

CREATE TABLE admin (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(200) DEFAULT NULL,
    password VARCHAR(100) DEFAULT NULL,
    s_ques VARCHAR(500) DEFAULT NULL,
    ans VARCHAR(200) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(200) DEFAULT NULL,
    price FLOAT DEFAULT NULL,
    image LONGBLOB,
    PRIMARY KEY (id)
);
/*Để thay đổi kiểu dữ liệu của cột image từ LONGBLOB thành BLOB, bạn có thể sử dụng câu lệnh ALTER TABLE. Dưới đây là cách bạn có thể thực hiện:*/
ALTER TABLE product
MODIFY COLUMN image LONGBLOB;
/*
DESCRIBE product;
*/


CREATE TABLE cart (
    cid INT DEFAULT NULL,
    pid INT DEFAULT NULL,
    pName VARCHAR(45) DEFAULT NULL,
    qty INT DEFAULT NULL,
    price FLOAT DEFAULT NULL,
    total FLOAT DEFAULT NULL
);

CREATE TABLE payment (
    pid INT NOT NULL AUTO_INCREMENT,
    cName VARCHAR(200) DEFAULT NULL,
    proid VARCHAR(100) DEFAULT NULL,
    pName VARCHAR(200) DEFAULT NULL,
    total FLOAT DEFAULT NULL,
    pdate DATE DEFAULT NULL,
    PRIMARY KEY (pid)
);


SELECT *
FROM product.admin


