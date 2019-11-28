package com.switchfully.order;

import com.switchfully.order.service.items.ItemService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "index", layout = MainLayout.class)
public class HomePage extends VerticalLayout {
    private ItemService itemService;


    @Autowired
    public HomePage(){

        Span welcome = new Span("Welcome message");
        welcome.setText("Welcome to Order Application");
        add(welcome);

    }
}
