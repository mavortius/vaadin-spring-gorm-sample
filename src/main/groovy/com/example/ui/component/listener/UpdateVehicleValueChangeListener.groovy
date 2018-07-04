package com.example.ui.component.listener

import com.example.domain.Vehicle
import com.example.ui.component.VehicleEventType
import com.vaadin.data.HasValue
import groovy.transform.CompileStatic

@CompileStatic
class UpdateVehicleValueChangeListener extends AbstractVehicleListener implements HasValue.ValueChangeListener {

    UpdateVehicleValueChangeListener(VehicleEventType eventType, Vehicle vehicle) {
        super(eventType, vehicle)
    }

    @Override
    void valueChange(HasValue.ValueChangeEvent event) {
        updateVehicle(eventType, event.value)
    }
}
