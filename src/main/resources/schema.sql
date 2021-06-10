DROP TABLE IF EXISTS games;

CREATE TABLE games (
                       id   BIGSERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       price NUMERIC NOT NULL,
                       category VARCHAR(255) NOT NULL
);