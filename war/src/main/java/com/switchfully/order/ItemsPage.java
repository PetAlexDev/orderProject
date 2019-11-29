package com.switchfully.order;

import com.switchfully.order.domain.items.Item;
import com.switchfully.order.service.items.ItemService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.Collection;
import java.util.List;

@Route(value = "items", layout = MainLayout.class)
public class ItemsPage extends Composite<VerticalLayout> {

    private final ItemService itemService;
    private Grid<Item> grid = new Grid<>(Item.class, false);
    private final Binder<Item> binder = new Binder<>(Item.class);
    private ListDataProvider<Item> dataProvider;
    private TextField filter;

    public ItemsPage(ItemService itemService) {
        this.itemService = itemService;
        dataProvider = DataProvider.ofCollection(itemService.getAllItems());
        populateGrid(dataProvider);
        HorizontalLayout filtering = createFilterComponent();
        Button createItemButton = new Button("CREATE ITEM");
        createItemButton.setIcon(new Icon(VaadinIcon.PLUS));
        createItemButton.addClickListener(buttonClickEvent -> UI.getCurrent().navigate("items/CreateItem"));
        getContent().add(filtering, grid, createItemButton);
    }

    private void populateGrid(ListDataProvider<Item> dataProvider) {
        grid.setColumns("name", "description", "price", "amountOfStock");
        grid.setDataProvider(dataProvider);
    }

    private HorizontalLayout createFilterComponent() {
        filter = new TextField();
        filter.setPlaceholder("Filter Items by name...");
        filter.setValueChangeMode(ValueChangeMode.LAZY);
        filter.addValueChangeListener(e -> {
            dataProvider.setFilter(Item::getName, name -> name.toLowerCase().startsWith(e.getValue().toLowerCase()));
        });


        H2 title = new H2("Items");
        title.setWidth("400px");

        Icon removeIcon = new Icon(VaadinIcon.CLOSE);
        removeIcon.setColor("red");
        Button clearFilterTextBtn = new Button(removeIcon);
        clearFilterTextBtn.getElement().setProperty("title", "Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> {
            filter.clear();
            dataProvider.clearFilters();
        });

        HorizontalLayout filtering = new HorizontalLayout();
        filtering.setSizeFull();
        filtering.add(title, filter, clearFilterTextBtn);
        filtering.setAlignItems(FlexComponent.Alignment.CENTER);

        return filtering;

//        SelectedItemPage selectedItemPage = new SelectedItemPage(this , itemService);
//        grid.addSelectionListener(event -> {
//            if (event.getAllSelectedItems().isEmpty()) {
//                selectedItemPage.setVisible(false);
//            } else {
//                Item item = event.getAllSelectedItems().iterator().next();
//
//            }
//        });
    }
}
