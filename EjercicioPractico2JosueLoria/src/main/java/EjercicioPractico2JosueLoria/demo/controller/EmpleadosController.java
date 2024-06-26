/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2JosueLoria.demo.controller;

import EjercicioPractico2JosueLoria.demo.domain.Empleados;
import EjercicioPractico2JosueLoria.demo.domain.Hoteles;
import EjercicioPractico2JosueLoria.demo.service.EmpleadosService;
import EjercicioPractico2JosueLoria.demo.service.HotelesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j//es una parte de loombok, es oara que la vista entienda lo que se va a procesar, es un protocolo 
@RequestMapping("/empleados")
public class EmpleadosController {
    
    @Autowired 
    EmpleadosService empleadosService;
    
    @GetMapping("/listado")
    public String inicio(Model model) { // Obtiene una lista de categorías del servicio categoriaService y las agrega al modelo. Luego devuelve la vista listado.html que mostrará estas categorías.
        var empleados = empleadosService.getEmpleados(false);
        model.addAttribute("empleados", empleados);//el primero es el nombre que se le esta dando, es segundo es la variable 
        model.addAttribute("totalempleados", empleados.size());//.size le dice el tamaño que trae esa lista
        return "/empleados/listado";
    }
    
    @GetMapping("/nuevo")
    public String hotelesNuevo(Empleados empleados) {
        return "/empleados/modifica";
    }

   
    
    @PostMapping("/guardar")
    public String empleadosGuardar(Empleados empleados){
           
        empleadosService.save(empleados);
        return "redirect:/hoteles/listado";
    }

    @GetMapping("/eliminar/{idHoteles}")
    public String categoriaEliminar(Empleados empleados) {
        empleadosService.delete(empleados);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idHoteles}")
    public String categoriaModificar(Empleados empleados, Model model) {
        empleados = empleadosService.getEmpleados(empleados);
        model.addAttribute("hoteles", empleados);
        return "/hoteles/modifica";
    }
    
    

    
}
