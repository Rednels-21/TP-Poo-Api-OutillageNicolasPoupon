package Tp2Poo.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class adresseController {
	
	//On dit juste bonjour à la persone ici, comme sur la page d'accueil
	@GetMapping("/adresse")
    public String adresse(@RequestParam(name="nameGET", required=false, defaultValue="Nicolas") String nameGET, Model model) {
        model.addAttribute("nomTemplate", nameGET);
        return "adresse";
    }
}
