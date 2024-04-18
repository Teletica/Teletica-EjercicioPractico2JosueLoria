/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2JosueLoria.demo.service.impl;

import EjercicioPractico2JosueLoria.demo.dao.HotelesDao;
import EjercicioPractico2JosueLoria.demo.domain.Hoteles;
import EjercicioPractico2JosueLoria.demo.service.HotelesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HotelesServiceImpl implements HotelesService{
    
    @Autowired//se conecta durectamente con este de abajo
    private HotelesDao hotelesDao;


    @Override
    public List<Hoteles> getHoteles() {
        
        var lista = hotelesDao.findAll();
        
        return lista;
       
    }

    @Override
    public Hoteles getHotel(Hoteles hotel) {
        
        return hotelesDao.findById(hotel.getId()).orElse(null);
        
    }

    @Override
    public void save(Hoteles hotel) {
        
        hotelesDao.save(hotel);
        
    }

    @Override
    public void delete(Hoteles hotel) {
        hotelesDao.delete(hotel);
       
    }
    
    
  
    
}