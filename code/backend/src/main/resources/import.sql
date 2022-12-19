INSERT INTO agelevel (agelevelname) VALUES
('Under 10'),
('Under 12'),
('Under 14'),
('Under 16'),
('Under 18'),
('Under 20'),
('Senior');

INSERT INTO field (location) VALUES
('Field 1'),
('Field 2'),
('Field 3'),
('Field 4');

INSERT INTO player (firstname, lastname, goals, position, fk_agelevelid) VALUES
('John', 'Doe', 10, 'Forward', 1),
('Jane', 'Doe', 5, 'Midfield', 2),
('Bob', 'Smith', 15, 'Defender', 3),
('Alice', 'Smith', 8, 'Goalkeeper', 4);

INSERT INTO trainer (firstname, lastname) VALUES
('Mike', 'Johnson'),
('Sue', 'Williams'),
('Chris', 'Brown');

INSERT INTO trainingsession (date, fk_agelevel, fk_field, fk_trainer) VALUES
('2022-01-01', 1, 1, 1),
('2022-01-02', 2, 2, 2),
('2022-01-03', 3, 3, 3),
('2022-01-04', 4, 4, 1);