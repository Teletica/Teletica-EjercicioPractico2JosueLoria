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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author franv
 */
@Service
public class HotelesServiceImpl implements HotelesService{
    
    @Autowired
    private HotelesDao hotelesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Hoteles> getHoteles(boolean activos) {
        var lista = hotelesDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Hoteles getHoteles(Hoteles hoteles) {
        return hotelesDao.findById(hoteles.getIdHoteles()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Hoteles hoteles) {
       hotelesDao.save(hoteles);
    }

    @Override
    @Transactional
    public void delete(Hoteles hoteles) {
       hotelesDao.delete(hoteles);
    }
    
}
