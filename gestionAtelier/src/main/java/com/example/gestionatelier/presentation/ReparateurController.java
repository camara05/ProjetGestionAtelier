package com.example.gestionatelier.presentation;

import com.example.dao.entities.Reparateur;
import com.example.dao.entities.Reparation;
import com.example.gestionatelier.metier.IGestionReparateur;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/reparateurs")
@AllArgsConstructor
public class ReparateurController {

	private final IGestionReparateur gestionReparateur;

	@GetMapping("/ajouter")
	public String afficherFormulaireAjout(Model model) {
		model.addAttribute("reparateur", new Reparateur());
		return "ajouter-reparateur"; // Le nom du fichier HTML sans l'extension
	}

	@PostMapping("/ajouter")
	public String ajouterReparateur(@ModelAttribute Reparateur reparateur, RedirectAttributes redirectAttributes) {
		try {
			gestionReparateur.ajouterReparateur(reparateur);
			redirectAttributes.addFlashAttribute("message", "Réparateur ajouté avec succès !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Erreur lors de l'ajout du réparateur.");
		}
		return "redirect:/reparateurs/ajouter";

	}

	// ➡️ Afficher la liste des réparateurs
	@GetMapping("/liste")
	public String afficherListeReparateurs(Model model) {
		List<Reparateur> reparateurs = gestionReparateur.listerReparateurs(0).getContent();
		model.addAttribute("reparateurs", reparateurs);
		return "liste-reparateurs";
	}

	// ➡️ Modifier un réparateur
	@GetMapping("/modifier/{id}")
	public String afficherFormulaireModification(@PathVariable Integer id, Model model) {
		Reparateur reparateur = gestionReparateur.rechercherReparateur(id);
		model.addAttribute("reparateur", reparateur);
		return "modifier-reparateur";
	}

	@PostMapping("/modifier")
	public String modifierReparateur(@ModelAttribute Reparateur reparateur, RedirectAttributes redirectAttributes) {
		try {
			gestionReparateur.modifierReparateur(reparateur);
			redirectAttributes.addFlashAttribute("message", "Réparateur modifié avec succès !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Erreur lors de la modification du réparateur.");
		}
		return "redirect:/reparateurs/liste";
	}

	// ➡️ Supprimer un réparateur
	@GetMapping("/supprimer/{id}")
	public String supprimerReparateur(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		try {
			gestionReparateur.supprimerReparateur(id);
			redirectAttributes.addFlashAttribute("message", "Réparateur supprimé avec succès !");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Erreur lors de la suppression du réparateur.");
		}
		return "redirect:/reparateurs/liste";
	}
}
