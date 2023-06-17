CREATE TABLE IF NOT EXISTS `users`
(
    `id`       INT PRIMARY KEY AUTO_INCREMENT,
    `email`    VARCHAR(20) UNIQUE NOT NULL,
    `password` VARCHAR(20)        NOT NULL
);

CREATE TABLE IF NOT EXISTS `logs`
(
    `id`       INT PRIMARY KEY AUTO_INCREMENT,
    `user_id`  INT                NOT NULL,
    `log`      VARCHAR(20)        NOT NULL,
     CONSTRAINT `pk_logs_users`
            FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

INSERT INTO users (id, email, password) VALUES (1, 'user@user.com', 'user');
INSERT INTO users (id, email, password) VALUES (2, 'georgi@georgi.com', 'georgi');
INSERT INTO users (id, email, password) VALUES (3, 'stoyan@stoyan.com', 'stoyan');

INSERT INTO logs (id, user_id, log) VALUES (1, '1', '2020-10-01');
INSERT INTO logs (id, user_id, log) VALUES (2, '2', '2020-10-01');
INSERT INTO logs (id, user_id, log) VALUES (3, '3', '2020-10-01');
INSERT INTO logs (id, user_id, log) VALUES (4, '1', '2020-10-01');