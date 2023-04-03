CREATE TABLE IF NOT EXISTS historyTraffic (
                      id SERIAL PRIMARY KEY,
                      localDateTime DATE NOT NULL,
                      averageTime REAL NOT NULL ,
                      congestionType TEXT NOT NULL,
                      countCars integer
);
