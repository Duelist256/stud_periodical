DROP SCHEMA IF EXISTS inform_system;

CREATE SCHEMA inform_system;

SET SCHEMA inform_system;

CREATE TABLE periodicals (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  description VARCHAR(255) NULL,
  publisher VARCHAR(255) NOT NULL,
  genre VARCHAR(255) NOT NULL,
  price DECIMAL (10, 2) NOT NULL,
  img_path VARCHAR(255),
  PRIMARY KEY (`id`));

CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  salt VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  isAdmin BOOLEAN NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE (`login`));

CREATE TABLE orders (
  id INT NOT NULL AUTO_INCREMENT,
  id_user	INT NOT NULL,
  date_order TIMESTAMP NOT NULL,
  status VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE orderPeriodical (
  id_order INT NOT NULL,
  id_periodical INT NOT NULL
);

