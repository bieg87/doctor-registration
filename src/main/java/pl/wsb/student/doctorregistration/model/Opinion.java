package pl.wsb.student.doctorregistration.model;

import javax.persistence.*;

@Entity
@Table(name = "opinions")
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="FK_UserId")
    private User patient;

    @ManyToOne
    @JoinColumn(name ="FK_DoctorId")
    private Doctor doctor;

    @Column(name="opinion", nullable = false, length = 200)
    private String opinionText;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setOpinionText(String opinion) {
        this.opinionText = opinion;
    }

    public Long getId() {
        return id;
    }

    public User getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getOpinionText() {
        return opinionText;
    }
}
