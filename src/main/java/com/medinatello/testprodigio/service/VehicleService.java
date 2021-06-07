package com.medinatello.testprodigio.service;

import com.medinatello.testprodigio.dao.VehicleRepo;
import com.medinatello.testprodigio.dto.VehicleDTO;
import com.medinatello.testprodigio.entity.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private Logger logger = LoggerFactory.getLogger(VehicleService.class);

    @Autowired
    private VehicleRepo vehicleRepo;

    public List<VehicleDTO> getAllVehicleSamples(String country){
        List<Vehicle> vehicle = null;
        if(country == null || country == ""){
            vehicle =  vehicleRepo.getAll();
        }else{
            vehicle =  vehicleRepo.getAll(country);
        }
        if (vehicle == null){
            return null;
        }
        List<VehicleDTO> vehicleDTO = new ArrayList<>();
        vehicle.forEach(v -> vehicleDTO.add( entityDto(v)) );

        return vehicleDTO;
    }

    public VehicleDTO getVehicleSamples(Long id){
        var vehicleSample =  vehicleRepo.getById(id);
        if (vehicleSample == null){
            return null;
        }
        var output = entityDto(vehicleSample);

        return   output;
    }

    public VehicleDTO create(VehicleDTO value){
        VehicleDTO output = null;
        try{

            var entity = vehicleRepo.update(DtoEntity(value));
            if(entity == null){
                return null;
            }
            output = entityDto(entity);

        }catch (Exception e){
            logger.error("Error tranformando datos en la creación", e);
            output = null;
        }

        return output;
    }

    public VehicleDTO update(VehicleDTO value){
        VehicleDTO output = null;
        try{

            var entity = vehicleRepo.update(DtoEntity(value));
            if(entity == null){
                return null;
            }
            output = entityDto(entity);

        }catch (Exception e){
            logger.error("Error tranformando datos en la actualizando", e);
            output = null;
        }

        return output;
    }


    public Optional<Boolean> delete(Long id){
        Optional<Boolean>  output = null;
        try{

            var entity = vehicleRepo.getById(id);
            if(entity == null){
                return Optional.empty();
            }
            var result = vehicleRepo.delete(entity);
            if(result == null){
                return Optional.of(false);
            }
            output = Optional.of(true);

        }catch (Exception e){
            logger.error("Error tranformando datos en la actualizando", e);
            output = Optional.empty();
        }

        return output;
    }


    private VehicleDTO entityDto (@org.jetbrains.annotations.NotNull Vehicle value){
        var output = new VehicleDTO();
        output.setId(value.getId());
        output.setCountryId(value.getCountyFips());
        output.setCountry(value.getCountyName());
        output.setState(value.getStateName());
        output.setDate(value.getDate());
        output.setVmt(value.getCountyVmt());
        output.setBaselineJanVmt(value.getBaselineJanVmt());
        output.setPercentJan(value.getPercentChangeFromJan());
        output.setMean7CountyVmt(value.getMean7CountyVmt());
        output.setMean7PercentChangeFromJan(value.getMean7PercentChangeFromJan());
        output.setDateAtLow(value.getDateAtLow());
        output.setMean7CountyVmtAtLow(value.getMean7CountyVmtAtLow());
        output.setPercentChangeFromLow(value.getPercentChangeFromLow());

        return output;
    }

    private Vehicle DtoEntity (VehicleDTO value){

        var output = new Vehicle();

        output.setId(value.getId());
        output.setCountyFips(value.getCountryId());
        output.setCountyName(value.getCountry());
        output.setStateName(value.getState());
        output.setDate(value.getDate());
        output.setCountyVmt(value.getVmt());
        output.setBaselineJanVmt(value.getBaselineJanVmt());
        output.setPercentChangeFromJan(value.getPercentJan());
        output.setMean7CountyVmt(value.getMean7CountyVmt());
        output.setMean7PercentChangeFromJan(value.getMean7PercentChangeFromJan());
        output.setDateAtLow(value.getDateAtLow());
        output.setMean7CountyVmtAtLow(value.getMean7CountyVmtAtLow());
        output.setPercentChangeFromLow(value.getPercentChangeFromLow());

        return output;
    }

}
