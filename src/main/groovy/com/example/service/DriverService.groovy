package com.example.service

import com.example.domain.Driver
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

@CompileStatic
@Service
@grails.gorm.services.Service(Driver)
interface DriverService {

    List<Driver> findAll()
}