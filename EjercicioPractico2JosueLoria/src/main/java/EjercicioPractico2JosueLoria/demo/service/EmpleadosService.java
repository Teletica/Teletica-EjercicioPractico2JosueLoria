/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EjercicioPractico2JosueLoria.demo.service;

import EjercicioPractico2JosueLoria.demo.domain.Empleados;
import java.util.List;


public interface EmpleadosService {
    
    public List<Empleados> getHoteles();
   
   // Se obtiene un Categoria, a partir del id de un categoria
    public Empleados getHotel(Empleados empleados);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Empleados empleados);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Empleados empleados);
    
}
