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
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name="reservas")
public class Reservas {

    public Reservas(String cliente_nombre, int num_huespedes, String numero_cedula, Date fecha_ingreso, Date fecha_salida) {
        this.cliente_nombre = cliente_nombre;
        this.num_huespedes = num_huespedes;
        this.numero_cedula = numero_cedula;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
    }
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    
    private Long idReservas;

    private String cliente_nombre;
    private int num_huespedes;
    private String numero_cedula;
    private Date fecha_ingreso;
    private Date fecha_salida;
   
}
