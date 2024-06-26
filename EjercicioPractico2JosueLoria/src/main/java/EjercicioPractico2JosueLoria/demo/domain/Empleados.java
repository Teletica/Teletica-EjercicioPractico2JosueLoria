/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2JosueLoria.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;





@Data
@Entity​
@Table(name="empleados")
public class Empleados implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id​
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long idEmpleado;
    private String nombre;
    private String cargo;
    private int hotelId;

    //@ManyToOne​
    //@JoinColumn(name="id")
    //Hoteles hoteles;

    public Empleados() {        
    }

    public Empleados(String nombre, String cargo, int hotelId) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.hotelId = hotelId;
                
    }
}