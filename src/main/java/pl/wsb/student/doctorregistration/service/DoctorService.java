package pl.wsb.student.doctorregistration.service;

import org.springframework.stereotype.Service;
import pl.wsb.student.doctorregistration.model.Doctor;
import pl.wsb.student.doctorregistration.repository.DoctorRepository;
import javax.transaction.Transactional;

@Service
@Transactional
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Iterable<Doctor> listAll() {
        return doctorRepository.findAll();
    }
}
