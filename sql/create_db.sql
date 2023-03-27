CREATE DATABASE traffic;

CREATE TABLE historyTraffic (
                      id SERIAL PRIMARY KEY,
                      localDateTime DATA NOT NULL,
                      averageTime DOUBLE NOT NULL ,
                      congestionType TEXT NOT NULL
);
