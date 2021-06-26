package pl.wsb.student.doctorregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsb.student.doctorregistration.model.Opinion;
import pl.wsb.student.doctorregistration.model.Visit;
import pl.wsb.student.doctorregistration.service.DoctorService;
import pl.wsb.student.doctorregistration.service.OpinionService;

@Controller
public class OpinionController {

    @Autowired
    OpinionService opinionService;

    @Autowired
    DoctorService doctorService;

    @GetMapping("/opinions")
    public String listOpinion(Model model) {
        model.addAttribute(
                "listOpinions",
                opinionService.listAll()
        );
        return "opinion/opinion_list";
    }

    @RequestMapping("/opinions/add")
    public String create(Model model) {

        Opinion opinion = new Opinion();
        model.addAttribute("op", opinion);
        model.addAttribute("doctors", doctorService.listAll());

        return "opinion/opinion_add";
    }

    @PostMapping("opinions/save")
    public String saveOpinion(@ModelAttribute("opinion") Opinion opinion) {

        opinionService.save(opinion);

        return "redirect:/opinions";
    }
}
