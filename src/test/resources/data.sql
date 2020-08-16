DROP TABLE IF EXISTS matches;

CREATE TABLE matches (
  matchId INT AUTO_INCREMENT  PRIMARY KEY,
  startDate TIMESTAMP NOT NULL,
  playerA VARCHAR(250) NOT NULL,
  playerB VARCHAR(250) NOT NULL
  );

INSERT INTO matches (startDate, playerA, playerB) VALUES
  ({ts '2020-08-14 18:30:00.00'}, 'Doe', 'Smith'),
  ({ts '2020-08-15 22:30:00.00'}, 'Brown', 'Smith'),
  ({ts '2020-08-25 18:30:00.00'}, 'Black', 'Hen'),
  ({ts '2012-08-26 20:30:00.00'}, 'Gates', 'Ulf');

DROP TABLE IF EXISTS licenses;

CREATE TABLE licenses (
  customerId INT NOT NULL,
  matchId INT NOT NULL,
  PRIMARY KEY(customerId, matchId)
  );

INSERT INTO licenses (customerId, matchId) VALUES
  (10, 1),
  (10, 2),
  (10, 3),
  (20, 4);
