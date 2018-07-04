package com.example.service

import com.example.domain.Model
import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

@CompileStatic
@Service
@grails.gorm.services.Service(Model)
interface ModelService {

    List<Model> findAll()
}