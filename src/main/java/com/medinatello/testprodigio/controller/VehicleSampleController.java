package com.medinatello.testprodigio.controller;

import com.medinatello.testprodigio.dto.VehicleSampleDTO;
import com.medinatello.testprodigio.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(summary = "Lista de Vehiculos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontrado lista de vehiculos", content = {@Content(mediaType =  "application/json", schema  = @Schema(implementation = VehicleSampleDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Error procesando datos", content = @Content),
    })
    @GetMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<VehicleSampleDTO>> getAll(
            @Parameter(description = "Pais a filtrar", name = "county", required = false) @RequestParam(required = false) final Optional<String> country) {
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
            } else {
                logger.info(String.format("get vehicleSampre count %s", output.stream().count()));
            }
        }catch (Exception e){
            logger.error("Error in controlador", e);
            code = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(output, code);
    }

    @Operation(summary = "Datos de Vehiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontrado vehiculos", content = {@Content(mediaType =  "application/json", schema  = @Schema(implementation = VehicleSampleDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Error buscando vehiculos", content = @Content),
            @ApiResponse(responseCode = "400", description = "Parametro invalido", content = @Content),
            @ApiResponse(responseCode = "404", description = "Vehiculo no encontrado", content = @Content),
    })
    @GetMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<VehicleSampleDTO> getbyId(
            @Parameter(description = "ID del vehiculo", name = "id", required = true) @PathVariable("id") Long id) {

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

    @Operation(summary = "Crear Vehiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vehiculo creado", content = {@Content(mediaType =  "application/json", schema  = @Schema(implementation = VehicleSampleDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Error creando vehiculos", content = @Content),
            @ApiResponse(responseCode = "400", description = "Parametro invalido", content = @Content),
    })
    @PostMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<VehicleSampleDTO> create(
            @Parameter(description = "Datos del vehiculo", name = "vehicleSampleDTO", required = true) @Valid @RequestBody  VehicleSampleDTO vehicleSampleDTO) {

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

    @Operation(summary = "Actualizar Vehiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehiculo actualizado", content = {@Content(mediaType =  "application/json", schema  = @Schema(implementation = VehicleSampleDTO.class))}),
            @ApiResponse(responseCode = "500", description = "Error guardando vehiculos", content = @Content),
            @ApiResponse(responseCode = "400", description = "Parametro invalido", content = @Content),
    })
    @PutMapping(value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<VehicleSampleDTO> update(
            @Parameter(description = "Datos del vehiculo", name = "vehicleSampleDTO", required = true) @Valid @RequestBody  VehicleSampleDTO vehicleSampleDTO) {

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

    @Operation(summary = "Eliminar Vehiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehiculo eliminado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error eliminando vehiculos", content = @Content),
            @ApiResponse(responseCode = "400", description = "Parametro invalido", content = @Content),
    })
    @DeleteMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity delete(
            @Parameter(description = "ID del vehiculo", name = "id", required = true) @PathVariable("id") Long id) {
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