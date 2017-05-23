-- Erstelle eine Adresse für den Parkplatz
INSERT INTO adresse (adress_id, land, bundesland, plz, strasse, haus_nummer, haus_nummer_zusatz) VALUES (1, 'Deutschland', 'NRW', '44147', 'Otto-Hahn-Straße', 16, null);

-- Erstelle einen Parkplatz
INSERT INTO PARKPLATZ (parkplatz_id,stellplatz_name,adresse_adress_id) VALUES  (1, 'Mitarbeiterparkplatz',1);

-- Create Öffnungszeiten
INSERT INTO OEFFNUNGSZEITEN (oeffnungszeiten_id, day, start_time, end_time) VALUES (1, 0, '07:00', '19:00');
INSERT INTO OEFFNUNGSZEITEN (oeffnungszeiten_id, day, start_time, end_time) VALUES (2, 1, '07:00', '19:00');
INSERT INTO OEFFNUNGSZEITEN (oeffnungszeiten_id, day, start_time, end_time) VALUES (3, 2, '07:00', '19:00');
INSERT INTO OEFFNUNGSZEITEN (oeffnungszeiten_id, day, start_time, end_time) VALUES (4, 3, '07:00', '19:00');
INSERT INTO OEFFNUNGSZEITEN (oeffnungszeiten_id, day, start_time, end_time) VALUES (5, 4, '07:00', '19:00');
INSERT INTO OEFFNUNGSZEITEN (oeffnungszeiten_id, day, start_time, end_time) VALUES (6, 5, '07:00', '19:00');
INSERT INTO OEFFNUNGSZEITEN (oeffnungszeiten_id, day, start_time, end_time) VALUES (7, 6, '07:00', '19:00');

-- Map Öffnungszeiten <-> Parkplatz
INSERT INTO PARKPLATZ_OEFFNUNGSZEITEN VALUES (1, 1);
INSERT INTO PARKPLATZ_OEFFNUNGSZEITEN VALUES (1, 2);
INSERT INTO PARKPLATZ_OEFFNUNGSZEITEN VALUES (1, 3);
INSERT INTO PARKPLATZ_OEFFNUNGSZEITEN VALUES (1, 4);
INSERT INTO PARKPLATZ_OEFFNUNGSZEITEN VALUES (1, 5);
INSERT INTO PARKPLATZ_OEFFNUNGSZEITEN VALUES (1, 6);
INSERT INTO PARKPLATZ_OEFFNUNGSZEITEN VALUES (1, 7);

