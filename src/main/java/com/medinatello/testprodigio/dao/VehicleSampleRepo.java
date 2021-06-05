package com.medinatello.testprodigio.dao;

import com.medinatello.testprodigio.entity.VehicleSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


}
