DROP DATABASE IF EXISTS `FAQ_project_24_11`;
CREATE DATABASE `FAQ_project_24_11`;
USE `FAQ_project_24_11`;

CREATE TABLE faq (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     question VARCHAR(255) NOT NULL,
                     answer TEXT NOT NULL,
                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_question (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               question TEXT NOT NULL,
                               answer TEXT,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);