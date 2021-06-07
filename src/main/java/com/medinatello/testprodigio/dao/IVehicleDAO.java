package com.medinatello.testprodigio.dao;

import com.medinatello.testprodigio.entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVehicleDAO extends CrudRepository<Vehicle, Long> {


    @Query("select u from vehicle u where u.countyName = ?1")
    List<Vehicle> findByCountry(String country);

}
