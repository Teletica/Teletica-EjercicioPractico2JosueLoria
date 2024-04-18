/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2JosueLoria.demo.service.impl;


import EjercicioPractico2JosueLoria.demo.dao.ReservasDao;
import EjercicioPractico2JosueLoria.demo.domain.Reservas;
import EjercicioPractico2JosueLoria.demo.service.ReservasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservasServiceImpl implements ReservasService{

    @Autowired
    private ReservasDao reservasDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Reservas> getReservas(boolean activos) {
        var lista = reservasDao.findAll();
        return lista;
        
    }

    @Override
    public Reservas getReservas(Reservas reservas) {
        return reservasDao.findById(reservas.getIdReservas()).orElse(null);
    }

    @Override
    public void save(Reservas reservasl) {
        reservasDao.save(reservasl);
    }

    @Override
    public void delete(Reservas reservas) {
        reservasDao.delete(reservas);
    }
    
}
