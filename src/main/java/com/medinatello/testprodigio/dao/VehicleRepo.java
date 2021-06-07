package com.medinatello.testprodigio.dao;

import com.medinatello.testprodigio.entity.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleRepo {

    @Autowired
    private IVehicleDAO vehicleDao;

    private Logger logger = LoggerFactory.getLogger(VehicleRepo.class);

    public List<Vehicle> getAll() {
        List<Vehicle>  output = new ArrayList<>();
        try{
            var dao = vehicleDao.findAll();
            dao.forEach(output::add);
        }catch (Exception e){
            output = null;
            logger.error("Fallando con Base de datos", e);
        }

        return  output;
    }

    public List<Vehicle> getAll(String country) {
        List<Vehicle>  output = new ArrayList<>();
        try{
            var dao = vehicleDao.findByCountry(country);
            dao.forEach(output::add);
        }catch (Exception e){
            output = null;
            logger.error("Fallando con Base de datos", e);
        }

        return  output;
    }

    public Vehicle getById(Long id) {
        var output = new Vehicle();
        try{
            var dao = vehicleDao.findById(id);
            if(!dao.isPresent()){
                return null;
            }
            output = dao.get();
        }catch (Exception e){
            output = null;
            logger.error("Fallando con Base de datos", e);
        }

        return  output;
    }

    public Vehicle update(Vehicle value){
        Vehicle output = null;
        Boolean isNew = value.getId() == null || value.getId() == 0;
        try{
            output = vehicleDao.save(value);
        }catch (Exception e){
            logger.error(String.format("Error %s tabla vehicleSample", isNew?"creando":"actualizando"), e);
        }
        return output;
    }

    public Boolean delete(Vehicle value){

        Boolean output;
        try{
            vehicleDao.delete(value);
            output = true;
        }catch (Exception e){
            output = false;
            logger.error("Fallando eliminando registro " + value, e);
        }
        return  output;
    }


}
