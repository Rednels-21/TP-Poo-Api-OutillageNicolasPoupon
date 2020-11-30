package Tp2Poo.tp5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Tp2Poo.tp5.model.AddressRepository;

@Controller
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    //Renvoit les addresses de la base de données
    @GetMapping("/address")
    public String showAddress(Model model) {
        model.addAttribute("allAddress", addressRepository.findAll());
        return "address";
    }
}
