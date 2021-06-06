package com.medinatello.testprodigio.dao;

import com.medinatello.testprodigio.entity.VehicleSample;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVehicleSampleDAO extends CrudRepository<VehicleSample, Long> {


    @Query("select u from Vehiclesample u where u.countyName = ?1")
    List<VehicleSample> findByCountry(String country);

}
