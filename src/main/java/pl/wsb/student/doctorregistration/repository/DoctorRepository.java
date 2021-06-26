package pl.wsb.student.doctorregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.student.doctorregistration.model.Doctor;

import java.util.Optional;


public interface DoctorRepository extends JpaRepository<Doctor, Long> { }