package com.example.ui.view

import com.example.domain.Driver
import com.example.domain.Manufacturer
import com.example.domain.Model
import com.example.domain.Vehicle
import com.example.service.DriverService
import com.example.service.ManufacturerService
import com.example.service.ModelService
import com.example.service.VehicleService
import com.example.ui.component.ComponentFactory
import com.example.ui.component.VehicleEventType
import com.example.ui.component.listener.UpdateVehicleComboBoxSelectionListener
import com.example.ui.component.listener.UpdateVehicleValueChangeListener
import com.example.ui.component.provider.VehicleValueProvider
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.Button
import com.vaadin.ui.ComboBox
import com.vaadin.ui.Grid
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.Label
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.themes.ValoTheme
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired

import javax.annotation.PostConstruct

@CompileStatic
@SpringView(name = GarageView.VIEW_NAME)
class GarageView extends VerticalLayout implements View {
    public static final String VIEW_NAME = ""

    private static final String DEFAULT_WIDTH = '100%'

    @Autowired
    private DriverService driverService

    @Autowired
    private ManufacturerService manufacturerService

    @Autowired
    private ModelService modelService

    @Autowired
    private VehicleService vehicleService

    private Vehicle vehicle = new Vehicle()

    @PostConstruct
    void init() {
        final HorizontalLayout titleRow = new HorizontalLayout()
        titleRow.width = DEFAULT_WIDTH
        addComponent(titleRow)

        final Label title = new Label('Add a vehicle')
        titleRow.addComponent(title)
        titleRow.setExpandRatio(title, 1.0f)

        final HorizontalLayout inputRow = new HorizontalLayout()
        inputRow.width = DEFAULT_WIDTH
        addComponent(inputRow)

        final TextField vehicleName = ComponentFactory.createTextField('Enter a name...')
        final ComboBox<Manufacturer> vehicleManufacturer = ComponentFactory.createComboBox(manufacturerService.findAll(), 'Select a manufacturer')
        final ComboBox<Model> vehicleModel = ComponentFactory.createComboBox(modelService.findAll(), 'Select a model')
        final ComboBox<Driver> vehicleDriver = ComponentFactory.createComboBox(driverService.findAll(), 'Select a driver')
        final Button submitButton = ComponentFactory.createButton('Add to Garage', ValoTheme.BUTTON_FRIENDLY)

        vehicleName.addValueChangeListener(new UpdateVehicleValueChangeListener(VehicleEventType.NAME, vehicle))
        vehicleManufacturer.addSelectionListener(new UpdateVehicleComboBoxSelectionListener(VehicleEventType.MANUFACTURER, vehicle))
        vehicleModel.addSelectionListener(new UpdateVehicleComboBoxSelectionListener(VehicleEventType.MODEL, vehicle))
        vehicleDriver.addSelectionListener(new UpdateVehicleComboBoxSelectionListener(VehicleEventType.DRIVER, vehicle))

        submitButton.addClickListener { event -> submit() }

        [vehicleName, vehicleManufacturer, vehicleModel, vehicleDriver, submitButton].each {
            inputRow.addComponent it
        }

        final HorizontalLayout dataDisplayRow = new HorizontalLayout()
        dataDisplayRow.width = DEFAULT_WIDTH
        dataDisplayRow.addComponent(buildVehicleComponent())
        addComponent(dataDisplayRow)
    }

    @Override
    void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method()
    }

    private Grid buildVehicleComponent() {
        final List<Vehicle> vehicles = vehicleService.findAll()
        final Grid<Vehicle> grid = new Grid<>()

        grid.with {
            setSizeFull()
            items = vehicles
            addColumn(new VehicleValueProvider(VehicleValueProvider.ID)).caption = 'ID'
            addColumn(new VehicleValueProvider(VehicleValueProvider.NAME)).caption = 'Name'
            addColumn(new VehicleValueProvider(VehicleValueProvider.MANUFACTURER_NAME)).caption = 'Manufacturer'
            addColumn(new VehicleValueProvider(VehicleValueProvider.MODEL_NAME)).caption = 'Model'
            addColumn(new VehicleValueProvider(VehicleValueProvider.DRIVER_NAME)).caption = 'Driver'
        }
        grid
    }

    private submit() {
        vehicleService.save(vehicle)
        getUI().navigator.navigateTo VIEW_NAME
    }
}
