package com.example.domain

import grails.gorm.annotation.Entity
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@Entity
@EqualsAndHashCode(includes = ['name'])
@ToString(includes = ['name'], includeNames = true, includePackage = false)
class Manufacturer implements GormEntity<Manufacturer> {

    String name

    static constraints = {
        name blank: false
    }
}
