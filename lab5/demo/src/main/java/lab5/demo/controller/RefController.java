package lab5.demo.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import lab5.demo.Entity.Refugees;
import lab5.demo.repository.RefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RefController {
    @Autowired
    private RefService service;

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Refugees> listref = service.listAll();
        model.addAttribute("listref",listref);
        return "index";
    }
    @GetMapping("/new")
    public String AddElem(Model model){
        Refugees refugees = new Refugees();
        model.addAttribute("refugees", refugees);
        return "new";
    }
    @PostMapping("/new")
    public String saveRef(@ModelAttribute("refugees") Refugees refugees) {
        service.save(refugees);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public ModelAndView UpdateForm(@PathVariable(name = "id") Integer id){
        ModelAndView mav = new ModelAndView("edit");
        Refugees refugees = service.get(id);
        mav.addObject("refugees", refugees);

        return mav;
    }

    @GetMapping("/delete/{id}")
    public String DeleteRef(@PathVariable(name = "id") Integer id){
        service.delete(id);
        return "redirect:/";
    }
}
