package com.medinatello.testprodigio.service;

import com.medinatello.testprodigio.dao.VehicleSampleRepo;
import com.medinatello.testprodigio.dto.VehicleSampleDTO;
import com.medinatello.testprodigio.entity.VehicleSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    private Logger logger = LoggerFactory.getLogger(VehicleService.class);

    @Autowired
    private VehicleSampleRepo vehicleSampleRepo;

    public List<VehicleSampleDTO> getVehicleSample(){
        var vehicleSample =  vehicleSampleRepo.getAll();
        if (vehicleSample == null){
            return null;
        }
        List<VehicleSampleDTO> vehicleSampleDTO = new ArrayList<>();
        vehicleSample.forEach(v -> vehicleSampleDTO.add( entityDto(v)) );

        return   vehicleSampleDTO;
    }






    private VehicleSampleDTO entityDto (@org.jetbrains.annotations.NotNull VehicleSample value){
        var output = new VehicleSampleDTO();
        output.setId(value.getId());
        output.setFips(value.getCountyFips());
        output.setCountry(value.getCountyName());
        output.setState(value.getStateName());
        output.setDate(value.getDate());
        output.setVmt(value.getCountyVmt());
        output.setBaselineJanVmt(value.getBaselineJanVmt());
        output.setPercentChangeFromJan(value.getPercentChangeFromJan());
        output.setMean7CountyVmt(value.getMean7CountyVmt());
        output.setMean7PercentChangeFromJan(value.getMean7PercentChangeFromJan());
        output.setDateAtLow(value.getDateAtLow());
        output.setMean7CountyVmtAtLow(value.getMean7CountyVmtAtLow());
        output.setPercentChangeFromLow(value.getPercentChangeFromLow());

        return output;
    }

    private VehicleSample DtoEntity (VehicleSampleDTO value){

        var output = new VehicleSample();

        output.setId(value.getId());
        output.setCountyFips(value.getFips());
        output.setCountyName(value.getCountry());
        output.setStateName(value.getState());
        output.setDate(value.getDate());
        output.setCountyVmt(value.getVmt());
        output.setBaselineJanVmt(value.getBaselineJanVmt());
        output.setPercentChangeFromJan(value.getPercentChangeFromJan());
        output.setMean7CountyVmt(value.getMean7CountyVmt());
        output.setMean7PercentChangeFromJan(value.getMean7PercentChangeFromJan());
        output.setDateAtLow(value.getDateAtLow());
        output.setMean7CountyVmtAtLow(value.getMean7CountyVmtAtLow());
        output.setPercentChangeFromLow(value.getPercentChangeFromLow());

        return output;
    }

}
