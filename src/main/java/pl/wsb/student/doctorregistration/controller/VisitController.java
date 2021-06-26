package pl.wsb.student.doctorregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.student.doctorregistration.model.Visit;
import pl.wsb.student.doctorregistration.service.VisitService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
public class VisitController {

    @Autowired
    VisitService visitService;

    @RequestMapping(path="/visit", method = { RequestMethod.POST, RequestMethod.GET })
    public String selectVisit(@RequestParam(value="doctorid") Long doctorid, String date, Model model) {
       model.addAttribute(
               "doctorId",
               doctorid
        );

       if(date != null) {
           date = date + " 00:00:00";

           System.out.println(date);
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
           LocalDateTime startDate = LocalDateTime.parse(date, formatter);

           System.out.println(startDate);
           LocalDateTime stopDate = startDate.plusDays(1);
           System.out.println(doctorid);

           model.addAttribute(
                   "listVisits",
                   visitService.findByDoctor(doctorid, startDate, stopDate)
           );
       }
        return "visit/visit_select";
    }

    @RequestMapping("visit/edit/{id}")
    public ModelAndView editVisit(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("visit/visit_edit");
        modelAndView.addObject("visit", visitService.find(id));
        return modelAndView;
    }

    @PostMapping("visit/save")
    public String saveVisit(@ModelAttribute("visit") Visit visit) {
        visitService.save(visit);
        return "redirect:/visit/user/" + visit.getPatient().getId();
    }

    @GetMapping("visit/user/{id}")
    public String listUsersVisit(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute(
                "listVisits",
                visitService.findByUser(id)
        );
        return "visit/visit_user";
    }

    @RequestMapping("visit/delete/{id}")
    public String deleteVisit(@PathVariable(name = "id") Long id) {
        visitService.patientNull(id);
        return "redirect:/start";
    }
}
