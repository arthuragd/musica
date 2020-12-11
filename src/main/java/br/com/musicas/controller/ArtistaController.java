package br.com.musicas.controller;

import br.com.musicas.domain.Artista;
import br.com.musicas.service.ArtistaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping("/listar")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("artistas", artistaService.recuperar());//entre" é só o nome da variavel
        return new ModelAndView("/artista/list", model);//elejá entende que é o list.html dos templates
    }    


    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("artista") Artista artista) {
        return "/artista/add";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("artista") Artista artista, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/artista/add";
        }

        artistaService.salvar(artista);
        attr.addFlashAttribute("mensagem", "Artista criada com sucesso.");
        return "redirect:/artistas/listar";
    }

    @GetMapping("/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
        Artista artista = artistaService.recuperarPorId(id);
        model.addAttribute("artista", artista);
        return new ModelAndView("/artista/add", model);
    }

    @PutMapping("/salvar")
    public String atualizar(@Valid @ModelAttribute("artista") Artista artista, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/artista/add";
        }

        artistaService.atualizar(artista);
        attr.addFlashAttribute("mensagem", "Artista atualizada com sucesso.");
        return "redirect:/artistas/listar";
    }

    @GetMapping("/{id}/remover")
    public String remover(@PathVariable("id") long id, RedirectAttributes attr) {
        artistaService.excluir(id);
        attr.addFlashAttribute("mensagem", "Artista excluída com sucesso.");
        return "redirect:/artistas/listar";
    }

}
