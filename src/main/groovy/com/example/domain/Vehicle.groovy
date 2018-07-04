package com.example.domain

import grails.gorm.annotation.Entity
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@Entity
@EqualsAndHashCode(includes = ['name', 'manufacturer', 'model'])
@ToString(includes = ['name', 'manufacturer', 'model'], includeNames = true, includePackage = false)
class Vehicle implements GormEntity<Vehicle> {

    String name
    Manufacturer manufacturer
    Model model

    static belongsTo = [driver: Driver]

    static mapping = {
        driver fetch: 'join'
        model fetch: 'join'
        manufacturer fetch: 'join'
    }

    static constraints = {
        name nullable: false
    }
}
