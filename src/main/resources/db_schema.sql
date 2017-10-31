DROP SCHEMA IF EXISTS inform_system;

CREATE SCHEMA inform_system;

SET SCHEMA inform_system;

CREATE TABLE periodicals (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  descriprion VARCHAR(255) NULL,
  id_publisher INT NOT NULL,
  id_genre INT NOT NULL,
  price VARCHAR(45) NOT NULL,
  imgpath VARCHAR(255),
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
  id INT NOT NULL,
  id_user	INT NOT NULL,
  id_periodical INT NOT NULL,
  status VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));