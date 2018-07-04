package com.example.ui.component

import com.vaadin.ui.Button
import com.vaadin.ui.ComboBox
import com.vaadin.ui.TextField
import groovy.transform.CompileStatic

@CompileStatic
class ComponentFactory {

    static <T> ComboBox<T> createComboBox(List<T> items, String placeholder) {
        final ComboBox<T> comboBox = new ComboBox<>()

        comboBox.with {
            emptySelectionAllowed = false
            setPlaceholder(placeholder)
            itemCaptionGenerator = new GarageItemCaptionGenerator()
            setItems(items)
        }
        comboBox
    }

    static TextField createTextField(String placeholder) {
        final TextField field = new TextField()
        field.placeholder = placeholder
        field
    }

    static Button createButton(String caption, String styleName = '') {
        final Button button = new Button(caption)
        button.styleName = styleName
        button
    }
}
