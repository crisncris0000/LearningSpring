INSERT INTO authorities
VALUES
(0, "ROLE_USER"),
(1, "ROLE_ADMIN");

INSERT INTO USERS(username, password, enabled, role)
VALUES
("User", "$2a$04$aGx6AqOqLWrWGoUIC4rQg.NOwnkEXFTYL620A5ScBSf.2T2KbR3ZG", 1, 0),
("Admin", "$2a$04$JBPHZVxGBGe2c5lUlFhwzuY7dB/axl13vxX5.yXupCctyb19pcWGq", 1, 1)
