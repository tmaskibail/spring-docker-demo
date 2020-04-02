CREATE TABLE customer
(id INTEGER AUTO_INCREMENT,
 title VARCHAR(20),
 first_name VARCHAR(120),
 last_name VARCHAR(120),
 email VARCHAR(255),
 phone_number VARCHAR(20),
 create_date TIMESTAMP,
 CONSTRAINT customer_pk PRIMARY KEY (id));