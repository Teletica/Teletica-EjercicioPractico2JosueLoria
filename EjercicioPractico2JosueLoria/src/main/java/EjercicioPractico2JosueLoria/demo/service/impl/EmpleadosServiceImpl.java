/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2JosueLoria.demo.service.impl;

import EjercicioPractico2JosueLoria.demo.dao.EmpleadosDao;
import EjercicioPractico2JosueLoria.demo.domain.Empleados;
import EjercicioPractico2JosueLoria.demo.service.EmpleadosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class EmpleadosServiceImpl implements EmpleadosService{
    
    @Autowired//se conecta durectamente con este de abajo
    private EmpleadosDao empleadosDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empleados> getEmpleados(boolean activos) {
        var lista = empleadosDao.findAll();
        return lista;
       
    }

    @Override
    @Transactional(readOnly = true)
    public Empleados getEmpleados(Empleados empleados) {
        return empleadosDao.findById(empleados.getId()).orElse(null);
       
    }

    @Override
    public void save(Empleados empleados) {
       empleadosDao.save(empleados);
    }

    @Override
    public void delete(Empleados empleados) {
        empleadosDao.delete(empleados);
    }

 

  
    
}
