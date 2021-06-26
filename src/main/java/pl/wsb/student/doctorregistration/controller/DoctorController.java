package pl.wsb.student.doctorregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wsb.student.doctorregistration.service.DoctorService;

@Controller
public class DoctorController {

     @Autowired
     DoctorService doctorService;

    @GetMapping("/doctorselect")
    public String viewDoctors(Model model) {
        model.addAttribute(
                "listDoctors",
                doctorService.listAll()
        );
        return "doctor/doctor_select";
    }
}