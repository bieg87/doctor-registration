package pl.wsb.student.doctorregistration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.wsb.student.doctorregistration.model.Doctor;
import pl.wsb.student.doctorregistration.model.Opinion;
import pl.wsb.student.doctorregistration.model.User;
import pl.wsb.student.doctorregistration.repository.OpinionRepository;
import pl.wsb.student.doctorregistration.service.OpinionService;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class AddOpinionTest {

    @Autowired
    private
    OpinionService opinionService;

    @MockBean
    private OpinionRepository repository;

    @Test
    void find_whenFound_thenReturnResult() {

        Opinion opinion = new Opinion();
        opinion.setId(3L);
        opinion.setDoctor(new Doctor());
        opinion.setPatient(new User());
        opinion.setOpinionText("Lekarz OK");

        doReturn(Optional.of(opinion)).when(repository).findById(3L);

        Opinion result = opinionService.find(3L);

        Assertions.assertTrue((result != null) );
        Assertions.assertSame(result, opinion);
    }
}
