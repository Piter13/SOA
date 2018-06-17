INSERT INTO users(username, password, role) VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'Admin');
INSERT INTO users(username, password, role) VALUES ('user', 'cdb59355f3ba293977fc0945fb85f11822d412c45c7520c7121bd2234f6c1f48', 'User');

INSERT INTO category(Category_ID, name) VALUES (1, 'zamek');

INSERT INTO castle(Castle_height, category, User_ID) VALUES (99, 1, 1);
INSERT INTO castle(Castle_height, category, User_ID) VALUES (123, 1, 2);
INSERT INTO castle(Castle_height, category, User_ID) VALUES (175, 1, 2);

INSERT INTO mag(Mag_name, Mag_mana, Mag_element, Mag_power, castle) VALUES ('Ricky', 99, 'Fire', 'Crush', 1);
INSERT INTO mag(Mag_name, Mag_mana, Mag_element, Mag_power, castle) VALUES ('Ticky', 14, 'Fire', 'Crush', 2);
INSERT INTO mag(Mag_name, Mag_mana, Mag_element, Mag_power, castle) VALUES ('Narcoticky', 25, 'Fire', 'Crush', 1);
INSERT INTO mag(Mag_name, Mag_mana, Mag_element, Mag_power, castle) VALUES ('Eus', 73, 'Fire', 'Crush', 2);
INSERT INTO mag(Mag_name, Mag_mana, Mag_element, Mag_power, castle) VALUES ('Deus', 23, 'Fire', 'Crush', 1);