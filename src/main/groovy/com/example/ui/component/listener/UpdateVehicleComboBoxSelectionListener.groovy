package com.example.ui.component.listener

import com.example.domain.Vehicle
import com.example.ui.component.VehicleEventType
import com.vaadin.event.selection.SingleSelectionEvent
import com.vaadin.event.selection.SingleSelectionListener
import groovy.transform.CompileStatic

@CompileStatic
class UpdateVehicleComboBoxSelectionListener extends AbstractVehicleListener implements SingleSelectionListener {

    UpdateVehicleComboBoxSelectionListener(VehicleEventType eventType, Vehicle vehicle) {
        super(eventType, vehicle)
    }

    @Override
    void selectionChange(SingleSelectionEvent event) {
        updateVehicle(eventType, event.firstSelectedItem)
    }
}
