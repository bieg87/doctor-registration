CREATE TABLE `opinions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `opinion` varchar(200) NOT NULL,
  `fk_doctor_id` bigint DEFAULT NULL,
  `fk_user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbw1gni8h9xwcm57ruxivsg37m` (`fk_doctor_id`),
  KEY `FKluvugnwfarscrsghkyqimdcmd` (`fk_user_id`),
  CONSTRAINT `FKbw1gni8h9xwcm57ruxivsg37m` FOREIGN KEY (`fk_doctor_id`) REFERENCES `doctors` (`id`),
  CONSTRAINT `FKluvugnwfarscrsghkyqimdcmd` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
