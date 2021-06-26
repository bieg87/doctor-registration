package pl.wsb.student.doctorregistration.service;


import org.springframework.stereotype.Service;
import pl.wsb.student.doctorregistration.model.Opinion;
import pl.wsb.student.doctorregistration.repository.OpinionRepository;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class OpinionService {

    private final OpinionRepository opinionRepository;

    public OpinionService(OpinionRepository opinionRepository) {
        this.opinionRepository = opinionRepository;
    }

    public Iterable<Opinion> listAll() {
        return opinionRepository.findAll();
    }

    public void save(Opinion opinion) {
        opinionRepository.save(opinion);
    }

    public Opinion find(Long id) {
        return opinionRepository.findById(id).orElse(null);
    }
}
