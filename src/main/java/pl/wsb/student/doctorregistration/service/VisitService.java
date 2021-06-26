package pl.wsb.student.doctorregistration.service;

import org.springframework.stereotype.Service;
import pl.wsb.student.doctorregistration.model.Doctor;
import pl.wsb.student.doctorregistration.model.Visit;
import pl.wsb.student.doctorregistration.repository.VisitRepository;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@Transactional
public class VisitService {

    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public Iterable<Visit> listAll() {
        return visitRepository.findAll();
    }

    public Visit find(Long id) { return visitRepository.findById(id).orElse(null); }

    public Iterable<Visit> findByDoctor(Long doctor, LocalDateTime startDate, LocalDateTime stopDate) {
        return visitRepository.findByDoctor(doctor, startDate, stopDate);
    }

    public void save(Visit visit) {
        visitRepository.save(visit);
    }

    public Iterable<Visit> findByUser(Long id) {
        return visitRepository.findByUser(id);
    }

    public void patientNull(Long id){
        visitRepository.patientNull(id);
    }
}
