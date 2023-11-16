--liquibase formatted sql
--changeset wierzbicki:1
--comment: comment_1

CREATE TABLE IF NOT EXISTS students (
    id VARCHAR(128), dob VARCHAR(40) NOT NULL
    , email VARCHAR(255) NOT NULL
    , namee VARCHAR(255) NOT NULL
    , PRIMARY KEY (id)
);
