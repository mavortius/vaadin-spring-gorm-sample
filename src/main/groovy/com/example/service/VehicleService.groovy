package com.example.service

import com.example.domain.Vehicle
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

@CompileStatic
@grails.gorm.services.Service(Vehicle)
@Service
interface VehicleService {

    List<Vehicle> findAll()

    Vehicle save(Vehicle vehicle)
}