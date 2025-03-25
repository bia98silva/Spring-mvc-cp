package br.com.fiap.tds2ps.spring_mvc.controller;

import br.com.fiap.tds2ps.spring_mvc.dto.ConsultationDto;
import br.com.fiap.tds2ps.spring_mvc.dto.MedicalDto;
import br.com.fiap.tds2ps.spring_mvc.entities.Consultation;
import br.com.fiap.tds2ps.spring_mvc.entities.Patient;
import br.com.fiap.tds2ps.spring_mvc.service.ConsultationService;
import br.com.fiap.tds2ps.spring_mvc.service.PatientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/consultation")
public class ConsultationController {

    private final PatientService patientService;
    private final ConsultationService consultationService;

    public ConsultationController(
            PatientService patientService,
            ConsultationService consultationService) {
        this.patientService = patientService;
        this.consultationService = consultationService;
    }

    @PostMapping("/start")
    public ModelAndView start(Model model,
                              @RequestParam("cpf") String cpf,
                              @RequestParam("anamnese") String anamnese,
                              @RequestParam("prescription") String prescription,
                              HttpSession session) {

        Optional<Patient> patientOpt = patientService.findByCpf(cpf);

        if (patientOpt.isPresent()) {
            Patient existingPatient = patientOpt.get();
            String medicalCpf = (String) session.getAttribute("loggedUserCpf");
            Consultation consultation = consultationService.startConsultation(existingPatient.getCpf(), medicalCpf, anamnese, prescription);
            ConsultationDto consultationDto = new ConsultationDto(existingPatient.getCpf(), existingPatient.getNome());
            consultationDto.setHistoricoAtendimento(existingPatient.getHistoricoAtendimento());

            model.addAttribute("consultation", consultationDto);
            model.addAttribute("medicalDto", new MedicalDto());
            model.addAttribute("consultationId", consultation.getId());

            return new ModelAndView("redirect:/dashboard");
        }

        model.addAttribute("patient", new Patient());
        return new ModelAndView("add-patient");
    }

    @PostMapping("/save")
    public ModelAndView save(
            Model model,
            @ModelAttribute("medicalDto") MedicalDto medicalDto,
            @RequestParam("consultationId") Long consultationId) {

        Consultation finishedConsultation = consultationService.finishConsultation(consultationId, medicalDto);

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/list")
    public ModelAndView listConsultations(Model model) {
        model.addAttribute("consultations", consultationService.findAll());
        return new ModelAndView("consultation-list");
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Model model) {
        model.addAttribute("consultationDto", new ConsultationDto());
        return new ModelAndView("create");
    }
}
