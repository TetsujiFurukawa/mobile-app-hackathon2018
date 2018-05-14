SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS spajam.t_wallet;
DROP TABLE IF EXISTS spajam.t_work;
DROP TABLE IF EXISTS spajam.m_user;
DROP TABLE IF EXISTS spajam.m_family;
DROP TABLE IF EXISTS spajam.m_work_item;
DROP TABLE IF EXISTS spajam.m_virtual_currency;




/* Create Tables */

CREATE TABLE spajam.m_family
(
	family_id int NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	PRIMARY KEY (family_id)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE spajam.m_user
(
	user_id int NOT NULL AUTO_INCREMENT,
	family_id int NOT NULL,
	name varchar(50) NOT NULL,
	-- 1：親、2：子
	division tinyint unsigned DEFAULT 2 NOT NULL COMMENT '1：親、2：子',
	hash_value varchar(256),
	PRIMARY KEY (user_id)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE spajam.m_virtual_currency
(
	currency_id varchar(10) NOT NULL,
	name varchar(50),
	hash_value varchar(256),
	trade_rate decimal(6,3),
	PRIMARY KEY (currency_id)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE spajam.m_work_item
(
	work_item_id int NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	currency_id varchar(10) NOT NULL,
	number decimal(9) NOT NULL,
	PRIMARY KEY (work_item_id)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE spajam.t_wallet
(
	user_id int NOT NULL,
	currency_id varchar(10) NOT NULL,
	number decimal(9) NOT NULL,
	PRIMARY KEY (user_id, currency_id)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;


CREATE TABLE spajam.t_work
(
	work_id int NOT NULL AUTO_INCREMENT,
	pay_date datetime NOT NULL,
	user_id int NOT NULL,
	work_item_id int NOT NULL,
	child_comment text NOT NULL,
	attached_image blob,
	parent_comment_id tinyint unsigned,
	approval tinyint unsigned,
	PRIMARY KEY (work_id)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8;



