/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EjercicioPractico2JosueLoria.demo.dao;

import EjercicioPractico2JosueLoria.demo.domain.Hoteles;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelesDao extends JpaRepository <Hoteles,Long>{
    
}
