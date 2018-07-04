package com.example.domain

import grails.gorm.annotation.Entity
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@Entity
@EqualsAndHashCode(includes = ['name'])
@ToString(includes = ['name'], includeNames = true, includePackage = false)
class Driver extends User implements GormEntity<Driver> {

    String name

    static hasMany = [vehicles: Vehicle]

    static constraints = {
        vehicles nullable: true
    }
}
