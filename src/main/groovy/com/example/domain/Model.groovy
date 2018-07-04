package com.example.domain

import grails.gorm.annotation.Entity
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.grails.datastore.gorm.GormEntity

@Entity
@EqualsAndHashCode(includes = ['name'])
@ToString(includes = ['name'], includeNames = true, includePackage = false)
class Model implements GormEntity<Model> {

    String name
    Integer year

    static constraints = {
        name nullable: false, blank: false
        year nullable: false
    }
}
