package com.example.ui.component

import com.example.domain.Driver
import com.example.domain.Manufacturer
import com.example.domain.Model
import com.vaadin.ui.ItemCaptionGenerator
import groovy.transform.CompileStatic

@CompileStatic
class GarageItemCaptionGenerator implements ItemCaptionGenerator {

    @Override
    String apply(Object item) {
        switch (item) {
            case Manufacturer:
                return (item as Manufacturer).name
            case Driver:
                return (item as Driver).name
            case Model:
                return (item as Model).name
            default:
                return null
        }
    }
}
