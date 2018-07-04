package com.example.ui.component.listener

import com.example.domain.Driver
import com.example.domain.Manufacturer
import com.example.domain.Model
import com.example.domain.Vehicle
import com.example.ui.component.VehicleEventType
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@Slf4j
@CompileStatic
class AbstractVehicleListener {
    protected VehicleEventType eventType
    protected Vehicle vehicle

    AbstractVehicleListener(VehicleEventType eventType, Vehicle vehicle) {
        this.eventType = eventType
        this.vehicle = vehicle
    }

    protected void updateVehicle(final VehicleEventType eventType, final eventValue) {
        switch (eventType) {
            case VehicleEventType.NAME:
                if (eventValue instanceof String) {
                    vehicle.name = eventValue as String
                }
                break
            case VehicleEventType.MANUFACTURER:
                if (eventValue instanceof Optional<Manufacturer>) {
                    vehicle.manufacturer = (eventValue as Optional<Manufacturer>).get()
                }
                break
            case VehicleEventType.MODEL:
                if (eventValue instanceof Optional<Model>) {
                    vehicle.model = (eventValue as Optional<Model>).get()
                }
                break
            case VehicleEventType.DRIVER:
                if (eventValue instanceof Optional<Driver>) {
                    vehicle.driver = (eventValue as Optional<Driver>).get()
                }
                break
            default:
                log.error 'updateVehicle invoked with wrong eventType: {}', eventType
        }
    }
}
