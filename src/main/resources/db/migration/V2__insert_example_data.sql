-- Insert example data into role table
INSERT INTO role (id, name)
VALUES (1, 'ADMIN'),
       (2, 'USER');

-- Insert example data into users table
INSERT INTO users (id, first_name, last_name, email, phone_number, password, is_enabled)
VALUES (1, 'John', 'Doe', 'john.doe@example.com', '123-456-7890',
        '$2a$10$kdr6mhgBrwW7Iak1dTg4AuLTC3mADllOCy/yhgaOxPtmCgADLILnq', true), -- password: "password"
       (2, 'Jane', 'Smith', 'jane.smith@example.com', '098-765-4321',
        '$2a$10$kdr6mhgBrwW7Iak1dTg4AuLTC3mADllOCy/yhgaOxPtmCgADLILnq', true);
-- password: "password"

-- Insert example data into user_role table
INSERT INTO user_role (role_id, user_id)
VALUES (1, 1), -- John Doe as ADMIN
       (2, 2);
-- Jane Smith as USER


-- Insert example data into location table
INSERT INTO location (code, city, state)
VALUES ('LOC001', 'New York', 'New York'),
       ('LOC002', 'Los Angeles', 'California'),
       ('LOC003', 'Chicago', 'Illinois');

-- Insert example data into hotel table
INSERT INTO hotel (id, name, code, phone_number, email, is_available, location_code)
VALUES
-- Hotels for Location 1
(1, 'Hotel A1', 'HOTEL001', '123-456-7890', 'contact@hotela1.com', true, 'LOC001'),
(2, 'Hotel A2', 'HOTEL002', '123-456-7891', 'contact@hotela2.com', true, 'LOC001'),
(3, 'Hotel A3', 'HOTEL003', '123-456-7892', 'contact@hotela3.com', true, 'LOC001'),
(4, 'Hotel A4', 'HOTEL004', '123-456-7893', 'contact@hotela4.com', true, 'LOC001'),
(5, 'Hotel A5', 'HOTEL005', '123-456-7894', 'contact@hotela5.com', true, 'LOC001'),
(6, 'Hotel A6', 'HOTEL006', '123-456-7895', 'contact@hotela6.com', true, 'LOC001'),
(7, 'Hotel A7', 'HOTEL007', '123-456-7896', 'contact@hotela7.com', true, 'LOC001'),
(8, 'Hotel A8', 'HOTEL008', '123-456-7897', 'contact@hotela8.com', true, 'LOC001'),
(9, 'Hotel A9', 'HOTEL009', '123-456-7898', 'contact@hotela9.com', true, 'LOC001'),
(10, 'Hotel A10', 'HOTEL010', '123-456-7899', 'contact@hotela10.com', true, 'LOC001'),

-- Hotels for Location 2
(11, 'Hotel B1', 'HOTEL011', '123-456-7900', 'contact@hotelb1.com', true, 'LOC002'),
(12, 'Hotel B2', 'HOTEL012', '123-456-7901', 'contact@hotelb2.com', true, 'LOC002'),
(13, 'Hotel B3', 'HOTEL013', '123-456-7902', 'contact@hotelb3.com', true, 'LOC002'),
(14, 'Hotel B4', 'HOTEL014', '123-456-7903', 'contact@hotelb4.com', true, 'LOC002'),
(15, 'Hotel B5', 'HOTEL015', '123-456-7904', 'contact@hotelb5.com', true, 'LOC002'),
(16, 'Hotel B6', 'HOTEL016', '123-456-7905', 'contact@hotelb6.com', true, 'LOC002'),
(17, 'Hotel B7', 'HOTEL017', '123-456-7906', 'contact@hotelb7.com', true, 'LOC002'),
(18, 'Hotel B8', 'HOTEL018', '123-456-7907', 'contact@hotelb8.com', true, 'LOC002'),
(19, 'Hotel B9', 'HOTEL019', '123-456-7908', 'contact@hotelb9.com', true, 'LOC002'),
(20, 'Hotel B10', 'HOTEL020', '123-456-7909', 'contact@hotelb10.com', true, 'LOC002'),

-- Hotels for Location 3
(21, 'Hotel C1', 'HOTEL021', '123-456-7910', 'contact@hotelc1.com', true, 'LOC003'),
(22, 'Hotel C2', 'HOTEL022', '123-456-7911', 'contact@hotelc2.com', true, 'LOC003'),
(23, 'Hotel C3', 'HOTEL023', '123-456-7912', 'contact@hotelc3.com', true, 'LOC003'),
(24, 'Hotel C4', 'HOTEL024', '123-456-7913', 'contact@hotelc4.com', true, 'LOC003'),
(25, 'Hotel C5', 'HOTEL025', '123-456-7914', 'contact@hotelc5.com', true, 'LOC003'),
(26, 'Hotel C6', 'HOTEL026', '123-456-7915', 'contact@hotelc6.com', true, 'LOC003'),
(27, 'Hotel C7', 'HOTEL027', '123-456-7916', 'contact@hotelc7.com', true, 'LOC003'),
(28, 'Hotel C8', 'HOTEL028', '123-456-7917', 'contact@hotelc8.com', true, 'LOC003'),
(29, 'Hotel C9', 'HOTEL029', '123-456-7918', 'contact@hotelc9.com', true, 'LOC003'),
(30, 'Hotel C10', 'HOTEL030', '123-456-7919', 'contact@hotelc10.com', true, 'LOC003');

-- Insert example data into room table
INSERT INTO room (id, capacity, room_number, type, price_per_night, currency, hotel_id)
VALUES
-- Rooms for Hotel 1
(1, 2, '101', 'Single', 100, 'USD', 1),
(2, 3, '102', 'Double', 150, 'USD', 1),
(3, 4, '103', 'Suite', 200, 'USD', 1),

-- Rooms for Hotel 2
(4, 2, '201', 'Single', 100, 'USD', 2),
(5, 3, '202', 'Double', 150, 'USD', 2),
(6, 4, '203', 'Suite', 200, 'USD', 2),

-- Rooms for Hotel 3
(7, 2, '301', 'Single', 100, 'USD', 3),
(8, 3, '302', 'Double', 150, 'USD', 3),
(9, 4, '303', 'Suite', 200, 'USD', 3),

-- Rooms for Hotel 4
(10, 2, '401', 'Single', 100, 'USD', 4),
(11, 3, '402', 'Double', 150, 'USD', 4),
(12, 4, '403', 'Suite', 200, 'USD', 4),

-- Rooms for Hotel 5
(13, 2, '501', 'Single', 100, 'USD', 5),
(14, 3, '502', 'Double', 150, 'USD', 5),
(15, 4, '503', 'Suite', 200, 'USD', 5),

-- Rooms for Hotel 6
(16, 2, '601', 'Single', 100, 'USD', 6),
(17, 3, '602', 'Double', 150, 'USD', 6),
(18, 4, '603', 'Suite', 200, 'USD', 6),

-- Rooms for Hotel 7
(19, 2, '701', 'Single', 100, 'USD', 7),
(20, 3, '702', 'Double', 150, 'USD', 7),
(21, 4, '703', 'Suite', 200, 'USD', 7),

-- Rooms for Hotel 8
(22, 2, '801', 'Single', 100, 'USD', 8),
(23, 3, '802', 'Double', 150, 'USD', 8),
(24, 4, '803', 'Suite', 200, 'USD', 8),

-- Rooms for Hotel 9
(25, 2, '901', 'Single', 100, 'USD', 9),
(26, 3, '902', 'Double', 150, 'USD', 9),
(27, 4, '903', 'Suite', 200, 'USD', 9),

-- Rooms for Hotel 10
(28, 2, '1001', 'Single', 100, 'USD', 10),
(29, 3, '1002', 'Double', 150, 'USD', 10),
(30, 4, '1003', 'Suite', 200, 'USD', 10);
