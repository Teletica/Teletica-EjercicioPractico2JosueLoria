/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EjercicioPractico2JosueLoria.demo.service;

import EjercicioPractico2JosueLoria.demo.domain.Hoteles;
import java.util.List;

public interface HotelesService {
        // Se obtiene un listado de categorias en un List
    public List<Hoteles> getHoteles();
   
   // Se obtiene un Categoria, a partir del id de un categoria
    public Hoteles getHotel(Hoteles hotel);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Hoteles hotel);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Hoteles hotel);
    
}
