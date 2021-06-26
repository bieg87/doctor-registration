package pl.wsb.student.doctorregistration.repository;

import org.springframework.data.repository.CrudRepository;
import pl.wsb.student.doctorregistration.model.Opinion;


public interface OpinionRepository extends CrudRepository<Opinion, Long> {

}