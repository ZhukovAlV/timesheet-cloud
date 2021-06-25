TRUNCATE TABLE USER;

/*
CREATE TABLE USER (
	ID 		        INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    PERSONALNUMBER 	INTEGER,
    FIRSTNAME 		VARCHAR(32),
    LASTNAME 		VARCHAR(32),
    MIDLENAME 		VARCHAR(32),
    LOGIN 	        VARCHAR(16),
    POSITION_E 		VARCHAR(64),
    POSITION_R 		VARCHAR(64),
    ACCESSLEVEL 	VARCHAR(16)
);
*/

INSERT INTO USER ("PERSONALNUMBER", "FIRSTNAME", "LASTNAME", "MIDLENAME", "LOGIN", "POSITION_E", "POSITION_R", "ACCESSLEVEL")  VALUES
(1001, 'Монтгомери', 'Бернс', 'Шикльгрубер', 'burnscm', 'boss', 'Начальник', 'manager'),
(1002, 'Вейлон', 'Смиттерс', 'Джуниор', 'waylonjs', 'manager', 'Менеджер', 'manager'),
(2001, 'Гомер', 'Симпсон', 'Абрахам', 'homersa', 'security', 'Безопасник', 'admin'),
(2002, 'Мардж', 'Симпсон', 'Бувье', 'margesb', 'accounter', 'Бухгалтер', 'user'),
(3001, 'Карл', 'Карлсон', 'Карлтон', 'carlcc', 'engineer', 'Инженер', 'user'),
(3002, 'Ленни', 'Леонард', 'Ленфорд', 'lennyll', 'engineer', 'Инженер', 'user');