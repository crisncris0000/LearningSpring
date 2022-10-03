CREATE SCHEMA airmanagement;
DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities(
	id INT NOT NULL,
	role VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS posts;
CREATE TABLE posts(
	id INT AUTO_INCREMENT,
	posts TEXT NOT NULL
);

DROP TABLE IF EXISTS users;
CREATE TABLE users(
	username VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	enabled TINYINT(1) NOT NULL,
    role INT,
    
    PRIMARY KEY(username),
    
	FOREIGN KEY (role) REFERENCES authorities(id)
);

DROP TABLE IF EXISTS book_flight;
CREATE TABLE book_flight(
    id INT NOT NULL AUTO_INCREMENT,
    departure VARCHAR(100) NOT NULL, 
    destination VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL,
    username VARCHAR(100) NOT NULL,
    
    FOREIGN KEY (username) REFERENCES users(username),
    PRIMARY KEY(id)
);