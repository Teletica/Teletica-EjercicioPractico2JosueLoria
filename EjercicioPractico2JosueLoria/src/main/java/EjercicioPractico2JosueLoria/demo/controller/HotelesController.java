/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2JosueLoria.demo.controller;

import EjercicioPractico2JosueLoria.demo.service.HotelesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j//es una parte de loombok, es oara que la vista entienda lo que se va a procesar, es un protocolo 
@RequestMapping("/hoteles")
public class HotelesController {
    
    @Autowired 
    HotelesService hotelesService;

    
    @GetMapping("/listado")
    public String inicio(Model model) { // Obtiene una lista de categorías del servicio categoriaService y las agrega al modelo. Luego devuelve la vista listado.html que mostrará estas categorías.
        var hotel = hotelesService.getHoteles();
        model.addAttribute("hotel", hotel);//el primero es el nombre que se le esta dando, es segundo es la variable 
        model.addAttribute("totalhotel", hotel.size());//.size le dice el tamaño que trae esa lista
        return "/hoteles/listado";
    }
    
}
