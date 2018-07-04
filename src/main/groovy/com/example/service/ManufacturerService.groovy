package com.example.service

import com.example.domain.Manufacturer
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

@CompileStatic
@Service
@grails.gorm.services.Service(Manufacturer)
interface ManufacturerService {

    List<Manufacturer> findAll()
}
