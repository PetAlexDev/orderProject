package com.switchfully.order;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route(value = "items/CreateItem", layout = MainLayout.class)
public class CreateItem extends Composite<VerticalLayout> {

    public CreateItem() {
        H2 titleOfPage = new H2("Create a new Item:");
        TextField name = new TextField("Name");
        name.setWidth("500px");
        name.setPlaceholder("Name of the item to add...");
        name.setRequired(true);

        TextArea description = new TextArea("Description");
        description.setPlaceholder("Description of the Item in max 255 characters...");
        description.setWidth("500px");
        description.setHeight("150px");
        description.setMaxLength(255);
        description.setRequired(true);

        HorizontalLayout priceAndAmount = new HorizontalLayout();
        TextField price = new TextField("Price");
        price.setRequired(true);
        TextField stockAmount = new TextField("Amount of Stock");
        stockAmount.setRequired(true);
        priceAndAmount.add(new Icon(VaadinIcon.EURO), price, stockAmount);

        Button addButton = new Button("Add new Item");
        Button cancemButton = new Button("Cancel");
        Icon icon = new Icon(VaadinIcon.PLUS);
        icon.setColor("green");
        addButton.setIcon(icon);
        HorizontalLayout buttons = new HorizontalLayout(addButton, cancemButton);
        getContent().add(titleOfPage, name, description, priceAndAmount, buttons);
        getContent().setAlignItems(FlexComponent.Alignment.CENTER);
    }
}
