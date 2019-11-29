package com.switchfully.order;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "customerPage", layout = MainLayout.class)
public class CustomerPage extends Composite<VerticalLayout> {

    public CustomerPage() {
        Span span = new Span("CUSTOMER PAGE");
        span.setHeight("600px");
        getContent().add(span);
    }

}
