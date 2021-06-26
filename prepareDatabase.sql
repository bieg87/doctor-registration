INSERT INTO doctors(id, first_name, last_name, price, room, specialisation, visit_days, visit_hour_start, visit_hour_stop) VALUES
(1, 'Michał', 'Malinowski', 150, 5, 'internista','1,3,5', '14:00:00', '18:00:00');
INSERT INTO doctors(id, first_name, last_name, price, room, specialisation, visit_days, visit_hour_start, visit_hour_stop) VALUES
(2, 'Maciej', 'Czarny', 200, 7, 'chirurg','2,4', '16:00:00', '20:00:00');


DELIMITER $$

CREATE PROCEDURE InsertVisits(doctor INT)
BEGIN
	SELECT visit_days, visit_hour_start, visit_hour_stop INTO @days, @start_visit, @stop_visit FROM doctors WHERE id=doctor;
	SELECT CONCAT(DATE_ADD(DATE_FORMAT(NOW(), '%Y-%m-%d'), INTERVAL 1 day), ' ', @start_visit) INTO @start_visit_date;
	SELECT  CONCAT(DATE_ADD(DATE_FORMAT(NOW(), '%Y-%m-%d'), INTERVAL 1 day), ' ', @stop_visit) INTO @stop_visit_date;
	SELECT @start_visit_date INTO @hour_iter;

 	 insert_loop: WHILE @hour_iter < @stop_visit_date DO
 		IF FIND_IN_SET(WEEKDAY(@start_visit_date), @days) THEN
			INSERT INTO visits(fk_doctor_id, fk_user_id, date_time) VALUES (doctor, NULL, @hour_iter);
			SELECT DATE_ADD(@hour_iter, INTERVAL 30 minute) INTO @hour_iter;
		ELSE
			LEAVE insert_loop;
		END IF;
	END WHILE;
END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE createVisits() BEGIN
  DECLARE done BOOLEAN DEFAULT FALSE;
  DECLARE _id BIGINT UNSIGNED;
  DECLARE cur CURSOR FOR SELECT id FROM doctors;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done := TRUE;

  OPEN cur;

  doctors_loop: LOOP
    FETCH cur INTO _id;
    IF done THEN
      LEAVE doctors_loop;
    END IF;
    CALL InsertVisits(_id);
  END LOOP doctors_loop;

  CLOSE cur;
END$$

DELIMITER ;

CALL createVisits();

CREATE EVENT visits
ON SCHEDULE EVERY 1 DAY
STARTS '2021-06-19 14:47:00'
DO
	CALL createVisits()