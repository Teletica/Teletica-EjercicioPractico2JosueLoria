/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2JosueLoria.demo.controller;

import EjercicioPractico2JosueLoria.demo.domain.Hoteles;
import EjercicioPractico2JosueLoria.demo.service.HotelesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j//es una parte de loombok, es oara que la vista entienda lo que se va a procesar, es un protocolo 
@RequestMapping("/hoteles")
public class HotelesController {
    
    @Autowired 
    HotelesService hotelesService;

    
    @GetMapping("/listado")
    public String inicio(Model model) { // Obtiene una lista de categorías del servicio categoriaService y las agrega al modelo. Luego devuelve la vista listado.html que mostrará estas categorías.
        var hoteles = hotelesService.getHoteles(false);
        model.addAttribute("hoteles", hoteles);//el primero es el nombre que se le esta dando, es segundo es la variable 
        model.addAttribute("totalhotel", hoteles.size());//.size le dice el tamaño que trae esa lista
        return "/hoteles/listado";
    }
    
    @GetMapping("/nuevo")
    public String hotelesNuevo(Hoteles hoteles) {
        return "/hoteles/modifica";
    }

   
    
    @PostMapping("/guardar")
    public String categoriaGuardar(Hoteles hoteles){
           
        hotelesService.save(hoteles);
        return "redirect:/hoteles/listado";
    }

    @GetMapping("/eliminar/{idHoteles}")
    public String categoriaEliminar(Hoteles hoteles) {
        hotelesService.delete(hoteles);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idHoteles}")
    public String categoriaModificar(Hoteles hoteles, Model model) {
        hoteles = hotelesService.getHoteles(hoteles);
        model.addAttribute("hoteles", hoteles);
        return "/hoteles/modifica";
    }
    
}
