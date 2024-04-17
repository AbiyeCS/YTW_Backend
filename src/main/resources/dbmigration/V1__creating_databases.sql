CREATE SCHEMA IF NOT EXISTS user_registration;

CREATE TABLE IF NOT EXISTS user_registration.user (
    id BIGINT NOT NULL,
    name VARCHAR(100),
    username VARCHAR(100),
    email VARCHAR(100),
    role VARCHAR(100),
    PRIMARY KEY (id)
    );

