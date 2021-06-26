package pl.wsb.student.doctorregistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wsb.student.doctorregistration.model.Doctor;
import pl.wsb.student.doctorregistration.model.Visit;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query("SELECT v FROM Visit v WHERE  v.doctor.id = ?1 AND v.dateTime > ?2 AND v.dateTime < ?3")
    public Iterable<Visit> findByDoctor(Long doctor, LocalDateTime startDate, LocalDateTime stopDate);

    @Query("SELECT v FROM Visit v WHERE  v.patient.id =?1")
    public Iterable<Visit> findByUser(Long id);

    @Modifying
    @Query("UPDATE Visit v SET v.patient=null WHERE v.id = ?1")
    public void patientNull(Long id);
}
