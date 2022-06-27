package com.codegate.aula2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class UsuarioController {


        @Autowired
        UsuarioRepository usuarioRepository;

        @RequestMapping("/")
    public String listaUsuario(Model model){
            model.addAttribute("usuario", usuarioRepository.findAll());
            return "lista";
        }
    @GetMapping("/add")
    public String usuarioForm(Model model){
           model.addAttribute("usuario", new Usuario());
           return "usuarioForm";
    }

    @PostMapping("/process")
    public String processForm(@Valid Usuario usuario, BindingResult result){
            if (result.hasErrors()){
                return "usuarioForm";
            }
            usuarioRepository.save(usuario);
            return "redirect:/";
    }
}
