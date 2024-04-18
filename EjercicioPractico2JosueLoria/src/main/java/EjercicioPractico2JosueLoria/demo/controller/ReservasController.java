/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2JosueLoria.demo.controller;

import EjercicioPractico2JosueLoria.demo.domain.Hoteles;
import EjercicioPractico2JosueLoria.demo.domain.Reservas;
import EjercicioPractico2JosueLoria.demo.service.HotelesService;
import EjercicioPractico2JosueLoria.demo.service.ReservasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j//es una parte de loombok, es oara que la vista entienda lo que se va a procesar, es un protocolo 
@RequestMapping("/reservas")
public class ReservasController {
    
    @Autowired 
    ReservasService reservasService;
    
     @GetMapping("/listado")
    public String inicio(Model model) { // Obtiene una lista de categorías del servicio categoriaService y las agrega al modelo. Luego devuelve la vista listado.html que mostrará estas categorías.
        var reservas = reservasService.getReservas(false);
        model.addAttribute("reservas", reservas);//el primero es el nombre que se le esta dando, es segundo es la variable 
        model.addAttribute("totalreservas", reservas.size());//.size le dice el tamaño que trae esa lista
        return "/reservas/listado";
    }
    
    @GetMapping("/nuevo")
    public String hotelesNuevo(Reservas reservas) {
        return "/reservas/modifica";
    }

   
    
    @PostMapping("/guardar")
    public String categoriaGuardar(Reservas reservas){
           
        reservasService.save(reservas);
        return "redirect:/reservas/listado";
    }

    @GetMapping("/eliminar/{idHoteles}")
    public String categoriaEliminar(Reservas reservas) {
        reservasService.delete(reservas);
        return "redirect:/reservas/listado";
    }

    @GetMapping("/modificar/{idHoteles}")
    public String categoriaModificar(Reservas reservas, Model model) {
        reservas = reservasService.getReservas(reservas);
        model.addAttribute("reservas", reservas);
        return "/reservas/modifica";
    }
    
}
