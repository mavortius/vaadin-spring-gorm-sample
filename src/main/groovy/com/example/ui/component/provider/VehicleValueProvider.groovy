package com.example.ui.component.provider

import com.example.domain.Vehicle
import com.vaadin.data.ValueProvider
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@Slf4j
@CompileStatic
class VehicleValueProvider implements ValueProvider {
    static final String ID = 'id'
    static final String NAME = 'name'
    static final String MODEL_NAME = 'model.name'
    static final String MANUFACTURER_NAME = 'manufacturer.name'
    static final String DRIVER_NAME = 'driver.name'

    String propertyName

    VehicleValueProvider(String propertyName) {
        this.propertyName = propertyName
    }

    @Override
    Object apply(Object o) {
        switch (propertyName) {
            case ID:
                if (o instanceof Vehicle) {
                    return (o as Vehicle).id
                }
                break
            case NAME:
                if (o instanceof Vehicle) {
                    return (o as Vehicle).name
                }
                break
            case MODEL_NAME:
                if (o instanceof Vehicle) {
                    return (o as Vehicle).model.name
                }
                break
            case MANUFACTURER_NAME:
                if (o instanceof Vehicle) {
                    return (o as Vehicle).manufacturer.name
                }
                break
            case DRIVER_NAME:
                if (o instanceof Vehicle) {
                    return (o as Vehicle).driver.name
                }
                break
        }

        null
    }
}