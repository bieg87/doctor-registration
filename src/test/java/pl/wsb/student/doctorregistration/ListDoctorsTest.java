package pl.wsb.student.doctorregistration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.wsb.student.doctorregistration.model.Doctor;
import pl.wsb.student.doctorregistration.repository.DoctorRepository;
import pl.wsb.student.doctorregistration.service.DoctorService;

import java.util.Arrays;
import java.util.stream.StreamSupport;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ListDoctorsTest {

    @Autowired
    private DoctorService service;

    @MockBean
    private DoctorRepository repository;

    @Test
    void listAll_whenFound_thenReturnResult() {

        Doctor doctor1 = new Doctor();
        doctor1.setId(1L);
        doctor1.setFirstName("Jakub");
        doctor1.setLastName("Kozłowski");
        doctor1.setSpecialisation("urolog");
        doctor1.setRoom(2);
        doctor1.setPrice(120);
        doctor1.setVisitDays("1,3,5");
        doctor1.setVisitHoursStart("14:00:00");
        doctor1.setVisitHoursStop("20:00:00");

        Doctor doctor2 = new Doctor();
        doctor2.setId(2L);
        doctor2.setFirstName("Michał");
        doctor2.setLastName("Mikołajczak");
        doctor2.setSpecialisation("choroby zakaźne");
        doctor2.setRoom(5);
        doctor2.setPrice(200);
        doctor2.setVisitDays("1,2,4");
        doctor2.setVisitHoursStart("11:00:00");
        doctor2.setVisitHoursStop("`8:00:00");

        doReturn(
                Arrays.asList(doctor1, doctor2)
        )
                .when(
                        repository
                )
                .findAll();

        Iterable<Doctor> doctors = service.listAll();

        Assertions.assertEquals(
                2,
                StreamSupport.stream(doctors.spliterator(), false).count()
        );
    }
}
