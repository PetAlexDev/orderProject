package com.switchfully.order;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.jboss.jandex.Main;

@Route(value = "index/Basket", layout = MainLayout.class)
public class BasketPage extends Composite<VerticalLayout> {

    public BasketPage() {

        Span basket_page = new Span("BASKET PAGE");
        basket_page.setHeight("600px");
        getContent().add(basket_page);

    }
}
