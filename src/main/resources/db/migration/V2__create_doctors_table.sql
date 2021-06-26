CREATE TABLE `doctors` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `price` int NOT NULL,
  `room` int NOT NULL,
  `specialisation` varchar(20) NOT NULL,
  `visit_days` varchar(255),
  `visit_hour_start` varchar(255),
  `visit_hour_stop` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO doctors(id, first_name, last_name, price, room, specialisation, visit_days, visit_hour_start, visit_hour_stop) VALUES
(1, 'Michał', 'Malinowski', 150, 5, 'internista','1,3,5', '14:00:00', '18:00:00');
INSERT INTO doctors(id, first_name, last_name, price, room, specialisation, visit_days, visit_hour_start, visit_hour_stop) VALUES
(2, 'Maciej', 'Czarny', 200, 7, 'chirurg','2,4', '16:00:00', '20:00:00');