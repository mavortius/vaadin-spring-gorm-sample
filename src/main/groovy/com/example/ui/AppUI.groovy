package com.example.ui

import com.vaadin.annotations.Theme
import com.vaadin.annotations.Title
import com.vaadin.annotations.Viewport
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewDisplay
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.spring.annotation.SpringViewDisplay
import com.vaadin.ui.Component
import com.vaadin.ui.Label
import com.vaadin.ui.Panel
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.themes.ValoTheme
import groovy.transform.CompileStatic

@CompileStatic
@SpringUI
@SpringViewDisplay
@Title("Vaadin Spring GORM")
@Theme(ValoTheme.THEME_NAME)
class AppUI extends UI implements ViewDisplay {

    private Panel viewDisplay

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout root = new VerticalLayout()
        content = root
        viewDisplay = new Panel()
        viewDisplay.setSizeFull()

        root.with {
            setSizeFull()
            addComponent(buildHeader())
            addComponent(viewDisplay)
            setExpandRatio(viewDisplay, 1.0f)
        }
    }

    @Override
    void showView(View view) {
        viewDisplay.content = view as Component
    }

    private static Label buildHeader() {
        new Label('Welcome to the Garage')
    }
}
