package pl.wsb.student.doctorregistration.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "specialisation", nullable = false, length = 20)
    private String specialisation;

    @Column(name = "room", nullable = false)
    private Integer room;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "visit_days")
    private String visitDays;

    @Column(name = "visit_hour_start")
    private String visitHourStart;

    @Column(name = "visit_hour_stop")
    private String visitHourStop;

    public void setVisitDays(String visitDays) {
        this.visitDays = visitDays;
    }

    public void setVisitHoursStart(String visitHoursStart) {
        this.visitHourStart = visitHoursStart;
    }

    public void setVisitHoursStop(String visitHoursStop) {
        this.visitHourStop = visitHoursStop;
    }

    public String getVisitDays() {
        return visitDays;
    }

    public String getVisitHoursStart() {
        return visitHourStart;
    }

    public String getVisitHoursStop() {
        return visitHourStop;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public Integer getRoom() {
        return room;
    }

    public Integer getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
