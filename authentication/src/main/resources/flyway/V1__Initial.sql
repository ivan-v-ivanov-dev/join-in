CREATE TABLE IF NOT EXISTS `users`
(
    `id`                    INT PRIMARY KEY AUTO_INCREMENT,
    `email`                 VARCHAR(30) UNIQUE NOT NULL,
    `password`              VARCHAR(60)        NOT NULL,
    `personal_identity`     VARCHAR(64) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS `logs`
(
    `id`       VARCHAR(36)        PRIMARY KEY,
    `user_id`  INT                NOT NULL,
    `log_date` DATE               NOT NULL,
     CONSTRAINT `pk_logs_users`
            FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

INSERT INTO users (id, email, password, personal_identity) VALUES (1, 'petur@petur.com', '$2a$10$8C7RWgXFzla8YpDzazbL8urFwNstW367.tLlbiAqju.MA50fEWSDy', '1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032');
INSERT INTO users (id, email, password, personal_identity) VALUES (2, 'georgi@georgi.com', '$2a$10$XmhbPfFcvhZOFxb1dQ0hb.U.sjeX3DlCrXN8a59YFTAG9MPaiuDTi', '771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551');
INSERT INTO users (id, email, password, personal_identity) VALUES (3, 'stoyan@stoyan.com', '$2a$10$oAiICuow8.1JFJa52eRtdO6egsDg9HUVHtJciYTSxxHn3zyaOvOQq', '788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627');
INSERT INTO users (id, email, password, personal_identity) VALUES (4, 'victoriya@victoriya.com', '$2a$10$uebMHPSE852zfwiZpbtkUev/ZfSj4M6qIDdhNHcqQbA5zC412qMDK', 'd52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8');
INSERT INTO users (id, email, password, personal_identity) VALUES (5, 'mariya@mariya.com', '$2a$10$DfTKhofFD.C7UkBDj9vMY.f2XYSlQQGz7uqZAIyJwJF2dG/HCd.mi', '8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f');
INSERT INTO users (id, email, password, personal_identity) VALUES (6, 'konstantin@konstantin.com', '$2a$10$4UWpEpQL8BvvfDk2cUX/6uGNGwrPU8IOb.YVRnbhg5srhEBhay/vu', 'c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85');

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