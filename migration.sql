USE adlister_db;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ad_category;

CREATE TABLE users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email    VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    image TEXT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

ALTER TABLE ads
    ADD price DOUBLE NOT NULL
        AFTER image;

CREATE TABLE categories
(
    id   int(11)        unsigned not null auto_increment,
    name varchar(255)   not null,
    primary key (id)
);

INSERT INTO categories (name) VALUE ('Electronic');
INSERT INTO categories (name) VALUES ('Card Deck');
INSERT INTO categories (name) VALUES ('Boardgame');
INSERT INTO categories (name) VALUES ('Miniatures');
INSERT INTO categories (name) VALUES ('Role-Playing');

CREATE TABLE ad_category
(
    ad_id       int(10) unsigned NOT NULL,
    category_id int(10) unsigned NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);