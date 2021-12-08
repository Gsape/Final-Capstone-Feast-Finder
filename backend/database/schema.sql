--BEGIN TRANSACTION;
--
--DROP TABLE IF EXISTS users;
--DROP SEQUENCE IF EXISTS seq_user_id;
--
--CREATE SEQUENCE seq_user_id
--  INCREMENT BY 1
--  NO MAXVALUE
--  NO MINVALUE
--  CACHE 1;
--
--
--CREATE TABLE users (
--	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
--	username varchar(50) NOT NULL,
--	password_hash varchar(200) NOT NULL,
--	role varchar(50) NOT NULL,
--	CONSTRAINT PK_user PRIMARY KEY (user_id)
--);
--
--INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
--INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
--
--
--COMMIT TRANSACTION;

BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, restaurants, cuisine, user_restaurants, user_cuisine;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE restaurants (
        restaurant_id SERIAL,
        yelp_id VARCHAR (255),
        restaurant_name VARCHAR (255),
        is_shown BOOLEAN,

        PRIMARY KEY (restaurant_id)
);

CREATE TABLE cuisine (
        cuisine_id SERIAL,
        cuisine_type VARCHAR (255),

        PRIMARY KEY (cuisine_id)
);

CREATE TABLE user_restaurants (
        user_id SERIAL,
        restaurant_id SERIAL,

        PRIMARY KEY (user_id, restaurant_id),
        FOREIGN KEY (user_id) REFERENCES users (user_id),
        FOREIGN KEY (restaurant_id) REFERENCES restaurants (restaurant_id)
);

CREATE TABLE user_cuisine (
        user_id SERIAL,
        cuisine_id SERIAL,

        PRIMARY KEY (user_id, cuisine_id),
        FOREIGN KEY (user_id) REFERENCES users (user_id),
        FOREIGN KEY (cuisine_id) REFERENCES cuisine (cuisine_id)
);

ALTER TABLE users
ADD COLUMN radius NUMERIC;

ALTER TABLE users
ADD COLUMN zip_code NUMERIC;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
