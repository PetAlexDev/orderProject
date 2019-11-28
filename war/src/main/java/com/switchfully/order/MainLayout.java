package com.switchfully.order;

import com.switchfully.order.domain.items.Item;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;

import java.util.Objects;

public class MainLayout extends Composite<Div> implements RouterLayout {

    //Component to delegate content through.
    private Div content = new Div();

    private final HorizontalLayout headerDiv = new HorizontalLayout(
            new Image("img/header.png", "image of the order app"),
            new RouterLink("HomePage", HomePage.class),
            new RouterLink("Items", ItemsPage.class),
            new RouterLink("Customer", CustomerPage.class),
            new RouterLink("Basket", BasketPage.class));


    private final HorizontalLayout footerDiv = new HorizontalLayout(
            new Image("img/footer.png", "image of the footer")
    );

    private final VerticalLayout layout = new VerticalLayout(
            headerDiv,
            content,
            footerDiv
    );

    public MainLayout() {
        headerDiv.setAlignItems(FlexComponent.Alignment.CENTER);   ///not working, i would like to have the image centered
        content.setHeight("450px");
        getContent().add(layout);
    }

    @Override
    public void showRouterLayoutContent(HasElement hasElement) {
        Objects.requireNonNull(hasElement);
        Objects.requireNonNull(hasElement.getElement());
        content.removeAll();
        content.getElement().appendChild(hasElement.getElement());
    }
}
