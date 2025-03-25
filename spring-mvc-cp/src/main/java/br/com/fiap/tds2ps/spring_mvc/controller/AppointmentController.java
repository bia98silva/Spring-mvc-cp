package br.com.fiap.tds2ps.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.ArrayList;

@Controller
public class AppointmentController {

    @GetMapping("/appointments")
    public ModelAndView listAppointments(Model model) {
        List<String> appointments = new ArrayList<>();
        appointments.add("Consulta - 10/04/2025 - 14h00");
        appointments.add("Consulta - 12/04/2025 - 09h30");

        model.addAttribute("appointments", appointments);
        return new ModelAndView("list-appointments");
    }
}