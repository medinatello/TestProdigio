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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/vehiclesample")
@CrossOrigin(origins = "*")
public class VehicleSampleController {

    private Logger logger = LoggerFactory.getLogger(VehicleSampleController.class);


    @Autowired
    private VehicleService vehicleService;


    /**
     *
     * @param country opcionar para filtrar por pais
     * @return Lista de Vehiculos
     */
    @GetMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<VehicleSampleDTO>> getAll(@RequestParam(required = false) final Optional<String> country) {
        logger.info("Services getAll");
        String _country = null;
        if(country.isPresent()){
            _country = country.get();
            logger.info(String.format("Service getAll by country %s", country));
        }

        HttpStatus code = HttpStatus.OK;
        List<VehicleSampleDTO> output = new ArrayList<>();

        try{
            output = vehicleService.getAllVehicleSamples(_country);
            if(output == null) {
                code = HttpStatus.INTERNAL_SERVER_ERROR;
                logger.info("get Vehicle internal error");
            } else if(output.stream().count() == 0){
                code = HttpStatus.NOT_FOUND;
                logger.info("get vehicle not found");
            } else {
                logger.info(String.format("get vehicleSampre count %s", output.stream().count()));
            }
        }catch (Exception e){
            logger.error("Error in controlador", e);
            code = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(output, code);
    }

    @GetMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<VehicleSampleDTO> getbyId(@PathVariable("id") Long id) {
        logger.info(String.format( "Services getby Id %s",  id));
        if(id == null || id == 0){
            logger.info("Parametro erroneo");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        HttpStatus code;
        VehicleSampleDTO output = null;

        try{
            output = vehicleService.getVehicleSamples(id);
            if(output == null) {
                code = HttpStatus.INTERNAL_SERVER_ERROR;
                logger.info("get vehicle internal error");
            }else{
                code = HttpStatus.OK;
            }
        }catch (Exception e){
            logger.error("Error in controlador", e);
            code = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(output, code);
    }

    @PostMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<VehicleSampleDTO> create(
            @Valid @RequestBody  VehicleSampleDTO vehicleSampleDTO) {

        logger.info(String.format( "Services Create  %s",  vehicleSampleDTO));
        if(vehicleSampleDTO == null){
            logger.info("Parametro erroneo");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        HttpStatus code;
        VehicleSampleDTO output = null;

        try{
            output = vehicleService.create(vehicleSampleDTO);
            if(output == null) {
                code = HttpStatus.INTERNAL_SERVER_ERROR;
                logger.info("create vehicle internal error");
            }else{
                code = HttpStatus.CREATED;
            }
        }catch (Exception e){
            logger.error("Error in controlador", e);
            code = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(output, code);
    }


    @PutMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<VehicleSampleDTO> update(
            @Valid @RequestBody  VehicleSampleDTO vehicleSampleDTO) {

        logger.info(String.format( "Services Update  %s",  vehicleSampleDTO));
        if(vehicleSampleDTO == null){
            logger.info("Parametro erroneo");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        HttpStatus code;
        VehicleSampleDTO output = null;

        try{
            output = vehicleService.update(vehicleSampleDTO);
            if(output == null) {
                code = HttpStatus.INTERNAL_SERVER_ERROR;
                logger.info("create vehicle internal error");
            }else{
                code = HttpStatus.OK;
            }
        }catch (Exception e){
            logger.error("Error in controlador", e);
            code = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(output, code);
    }


    @DeleteMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity delete(@PathVariable("id") Long id) {
        logger.info(String.format( "Services getby Id %s",  id));
        if(id == null || id == 0){
            logger.info("Parametro erroneo");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        HttpStatus code;
        Optional<Boolean> output = null;

        try{
            output = vehicleService.delete(id);
            if(!output.isPresent()) {
                code = HttpStatus.INTERNAL_SERVER_ERROR;
                logger.info("delete vehicle not found");
            }if(!output.get()) {
                code = HttpStatus.INTERNAL_SERVER_ERROR;
                logger.info("delete vehicle error");
            }else{
                code = HttpStatus.OK;
            }
        }catch (Exception e){
            logger.error("Error in controlador", e);
            code = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(code);
    }

}