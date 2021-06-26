CREATE TABLE `visits` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_time` datetime(6) DEFAULT NULL,
  `fk_doctor_id` bigint DEFAULT NULL,
  `fk_user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi4kei02exnfiffrn5i376jqio` (`fk_doctor_id`),
  KEY `FKdiq39voivv0jv5aif6iptf80g` (`fk_user_id`),
  CONSTRAINT `FKdiq39voivv0jv5aif6iptf80g` FOREIGN KEY (`fk_user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKi4kei02exnfiffrn5i376jqio` FOREIGN KEY (`fk_doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;