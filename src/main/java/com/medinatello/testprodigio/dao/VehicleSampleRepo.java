package com.medinatello.testprodigio.dao;

import com.medinatello.testprodigio.entity.VehicleSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleSampleRepo {

    @Autowired
    private IVehicleSampleDAO vehicleSample;

    private Logger logger = LoggerFactory.getLogger(VehicleSampleRepo.class);

    public List<VehicleSample> getAll() {
        List<VehicleSample>  output = new ArrayList<>();
        try{
            var dao = vehicleSample.findAll();
            dao.forEach(output::add);
        }catch (Exception e){
            output = null;
            logger.error("Fallando con Base de datos", e);
        }

        return  output;
    }

    public List<VehicleSample> getAll(String country) {
        List<VehicleSample>  output = new ArrayList<>();
        try{
            var dao = vehicleSample.findByCountry(country);
            dao.forEach(output::add);
        }catch (Exception e){
            output = null;
            logger.error("Fallando con Base de datos", e);
        }

        return  output;
    }

    public VehicleSample getById(Long id) {
        var output = new VehicleSample();
        try{
            var dao = vehicleSample.findById(id);
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

    public VehicleSample update(VehicleSample value){
        VehicleSample output = null;
        Boolean isNew = value.getId() == null || value.getId() == 0;
        try{
            output = vehicleSample.save(value);
        }catch (Exception e){
            logger.error(String.format("Error %s tabla vehicleSample", isNew?"creando":"actualizando"), e);
        }
        return output;
    }

    public Boolean delete(VehicleSample value){

        Boolean output;
        try{
            vehicleSample.delete(value);
            output = true;
        }catch (Exception e){
            output = false;
            logger.error("Fallando eliminando registro " + value, e);
        }
        return  output;
    }


}
