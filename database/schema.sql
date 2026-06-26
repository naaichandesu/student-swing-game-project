CREATE TABLE players (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    wins INTEGER DEFAULT 0,
    losses INTEGER DEFAULT 0,
    draws INTEGER DEFAULT 0,
    score INTEGER DEFAULT 0
);

INSERT INTO players(username,password)
VALUES
('naila','12345'),
('aeri','12345'),
('winter','12345'),
('ning','12345'),
('rina','12345');

SELECT * FROM players ORDER BY score DESC, wins DESC;
