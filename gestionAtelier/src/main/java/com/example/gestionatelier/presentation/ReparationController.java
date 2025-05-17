package com.example.gestionatelier.presentation;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dao.entities.Reparation;
import com.example.gestionatelier.metier.IGestionReparation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Controller
public class ReparationController {

	private IGestionReparation gestionReparation;

    @GetMapping(value = "/reparations/{numpage}")
    public String listerReparations(Model model, @PathVariable("numpage") @DefaultValue("0") int numpage) {
        Page<Reparation> listeReparations = gestionReparation.listerReparations(numpage);
        model.addAttribute("listeReparations", listeReparations);
        return "reparations";
    }

    @GetMapping(value = "/reparation/ajouter")
    public String afficherFormAjout(Model model) {
        // Ajoutez les listes d'appareils et de réparateurs
        model.addAttribute("appareils", gestionReparation.listerAppareils());
        model.addAttribute("reparateurs", gestionReparation.listerReparateurs());
        model.addAttribute("reparation", new Reparation());
        return "formAjoutReparation";
    }


    @PostMapping(value = "/reparation/ajouter")
    public String ajouterReparation(Model model, @Valid Reparation reparation, BindingResult br) {
        if (!br.hasErrors()) {
            gestionReparation.ajouterReparation(reparation);
            return "redirect:/reparations/0";
        } else
            return "formAjoutReparation";
    }

    @GetMapping(value = "/reparation/editer/{id}")
    public String afficherFormEdit(Model model, @PathVariable("id") int id) {
        Reparation reparation = gestionReparation.rechercherReparation(id);
        model.addAttribute("reparation", reparation);
        return "formEditReparation";
    }

    @PostMapping(value = "/reparation/editer")
    public String editerReparation(Model model, @Valid Reparation reparation, BindingResult br) {
        if (!br.hasErrors()) {
            gestionReparation.modifierReparation(reparation);
            return "redirect:/reparations/0";
        } else
            return "formEditReparation";
    }

    @GetMapping(value = "/reparation/supprimer/{id}")
    public String supprimerReparation(@PathVariable("id") int id) {
        gestionReparation.supprimerReparation(id);
        return "redirect:/reparations/0";
    }
}
