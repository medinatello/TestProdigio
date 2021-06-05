package com.medinatello.testprodigio.controller;

import com.medinatello.testprodigio.dto.VehicleSampleDTO;
import com.medinatello.testprodigio.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vehiclesample")
@CrossOrigin(origins = "*")
public class VehicleSampleController {

    private Logger logger = LoggerFactory.getLogger(VehicleSampleController.class);


    @Autowired
    private VehicleService vehicleService;


    @GetMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<VehicleSampleDTO>> getAll() {
        logger.info("Services getAll");

        HttpStatus code = HttpStatus.OK;
        List<VehicleSampleDTO> output = new ArrayList<>();

        try{
            output = vehicleService.getVehicleSample();
            if(output == null) {
                code = HttpStatus.INTERNAL_SERVER_ERROR;
                logger.info("get pharmacy internal error");
            } else if(output.stream().count() == 0){
                code = HttpStatus.NOT_FOUND;
                logger.info("get pharmacy not found");
            } else {
                logger.info(MessageFormat.format("get vehicleSampre count {0}", output.stream().count()));
            }
        }catch (Exception e){
            logger.error("Error in controlador", e);
            code = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(output, code);
    }



}