CREATE TABLE IF NOT EXISTS `users`
(
    `id`                    INT PRIMARY KEY AUTO_INCREMENT,
    `email`                 VARCHAR(30) UNIQUE NOT NULL,
    `password`              VARCHAR(60)        NOT NULL,
    `personal_identity`     VARCHAR(128)        NOT NULL
);

CREATE TABLE IF NOT EXISTS `logs`
(
    `id`       VARCHAR(36)        PRIMARY KEY,
    `user_id`  INT                NOT NULL,
    `log_date` DATE               NOT NULL,
     CONSTRAINT `pk_logs_users`
            FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

INSERT INTO users (id, email, password, personal_identity) VALUES (1, 'petur@petur.com', '$2a$10$8C7RWgXFzla8YpDzazbL8urFwNstW367.tLlbiAqju.MA50fEWSDy', '1f7bf12277853b6c72a4e68f66e8c582c65570c0b62ff79b0846696997cf37246b1079bc8794f27516ed389232359831822e249e715bb5e8651fd6648ab26ef0');
INSERT INTO users (id, email, password, personal_identity) VALUES (2, 'georgi@georgi.com', '$2a$10$XmhbPfFcvhZOFxb1dQ0hb.U.sjeX3DlCrXN8a59YFTAG9MPaiuDTi', 'a0df099e81ec99fc63ada8715fc4ad8a071e98e4907a1ab4cb76359d32601f66e9b4e286f6837dc3c0f47b77647e94b7d56d660664a46951c541d7d4720c2ed2');
INSERT INTO users (id, email, password, personal_identity) VALUES (3, 'stoyan@stoyan.com', '$2a$10$oAiICuow8.1JFJa52eRtdO6egsDg9HUVHtJciYTSxxHn3zyaOvOQq', '557348e4d21af46b3895497ad6c6b05a04ad7b5e6a0492432ea4a56c6d7510d63c62dd3928d4291e33259158b1809e6c6ce26e54654393e7fb33d6d1352df8cb');
INSERT INTO users (id, email, password, personal_identity) VALUES (4, 'victoriya@victoriya.com', '$2a$10$uebMHPSE852zfwiZpbtkUev/ZfSj4M6qIDdhNHcqQbA5zC412qMDK', '7e15b4ca44311b7a7e5b2c176f693cd85f28cb4670d35abbfeed8cb3ce17ef18a353f534f4b47fa3b546ae79cfaa6141c7b771dc8431f567033128eaca558e81');
INSERT INTO users (id, email, password, personal_identity) VALUES (5, 'mariya@mariya.com', '$2a$10$DfTKhofFD.C7UkBDj9vMY.f2XYSlQQGz7uqZAIyJwJF2dG/HCd.mi', 'f7e9d7e4d7622aefe395172350261857f7efb20dd6368eb95a71ed8caf74ffd3bc9d16404b74908911595e6f7261cf5108e30ee08551c246cb520eb8b98a1d6a');
INSERT INTO users (id, email, password, personal_identity) VALUES (6, 'konstantin@konstantin.com', '$2a$10$4UWpEpQL8BvvfDk2cUX/6uGNGwrPU8IOb.YVRnbhg5srhEBhay/vu', '477c9125eddcf72ab3c33c8af5ac2e22971eca09e2a2d27daba3c925ce04210c8a04bf9f900e902c7c647683d9df0ac9c6367cb74261c63c8b55f625a4085ed4');

INSERT INTO logs (id, user_id, log_date) VALUES ('ad7d1a68-39b6-4450-b597-087b4f38f3f3', '1', '2023-06-10');
INSERT INTO logs (id, user_id, log_date) VALUES ('6082d7d4-514b-4e55-a941-4199f4851137', '1', '2023-05-18');
INSERT INTO logs (id, user_id, log_date) VALUES ('81876098-04a3-47dc-86ff-f3af83b9cabb', '2', '2023-06-17');
INSERT INTO logs (id, user_id, log_date) VALUES ('b74049a1-3237-40ee-8b06-ecee7fa8d6e1', '3', '2023-06-15');
INSERT INTO logs (id, user_id, log_date) VALUES ('ae79d719-4c44-4285-876c-1c2414e818dd', '4', '2023-05-11');
INSERT INTO logs (id, user_id, log_date) VALUES ('c75c64f6-5ce5-4337-ab23-bb4532f9930f', '4', '2023-05-15');
INSERT INTO logs (id, user_id, log_date) VALUES ('14b9d8dc-4686-4292-877e-b29d519b6ee4', '5', '2023-05-16');
INSERT INTO logs (id, user_id, log_date) VALUES ('f9ac265d-13f7-4e04-8e57-9b800bf11e80', '5', '2023-05-18');
INSERT INTO logs (id, user_id, log_date) VALUES ('85502551-98c8-43e3-bcb2-13b061aeb2bf', '6', '2023-05-18');
INSERT INTO logs (id, user_id, log_date) VALUES ('dffb0197-db8f-4712-95a8-699f3e7d0f86', '6', '2023-05-19');