DROP TABLE IF EXISTS customer_order;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300),
    last_name varchar(300) DEFAULT 'unknown customer',
    email varchar(300),
    customer_type varchar(300) NOT NULL DEFAULT 'REGULAR',
    PRIMARY KEY (id)
);

CREATE TABLE customer_order (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    customer_id int(11) NOT NULL,
    item_name varchar(300) NOT NULL DEFAULT '',
    price DECIMAL(100,2) NOT NULL DEFAULT '',
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);