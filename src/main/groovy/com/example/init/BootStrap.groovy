package com.example.init

import com.example.domain.Driver
import com.example.domain.Manufacturer
import com.example.domain.Model
import com.example.domain.Vehicle
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

@Slf4j
@Component
@CompileStatic
class BootStrap {

    @Transactional
    void init() {
        log.info 'Generating data...'

        final driver1 = new Driver(name: 'Susan', username: 'susan', password: 'password1').save()
        final driver2 = new Driver(name: 'Pedro', username: 'pedro', password: 'password2').save()

        final nissan = new Manufacturer(name: 'Nissan').save()
        final ford = new Manufacturer(name: 'Ford').save()

        final titan = new Model(name: 'Titan', year: 2004).save()
        final leaf = new Model(name: 'Leaf', year: 2010).save()
        final windstar = new Model(name: 'Windstar', year: 2012).save()

        new Vehicle(name: 'Pickup', driver: driver1, manufacturer: nissan, model: titan).save()
        new Vehicle(name: 'Economy', driver: driver2, manufacturer: nissan, model: leaf).save()
        new Vehicle(name: 'Minivan', driver: driver2, manufacturer: ford, model: windstar).save()

        log.info 'Finished.'
    }
}
