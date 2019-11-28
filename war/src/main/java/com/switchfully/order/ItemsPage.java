package com.switchfully.order;

import com.switchfully.order.domain.items.Item;
import com.switchfully.order.service.items.ItemService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "item", layout = MainLayout.class)
public class ItemsPage extends Composite<VerticalLayout> {

    private ItemService itemService;
    private Grid<Item> grid = new Grid<>(Item.class, false);

    @Autowired
    public ItemsPage(ItemService itemService) {
        this.itemService= itemService;
        List<Item> itemsList = itemService.getAllItems();
        grid.setItems(itemsList);

        getContent().add(grid);
    }
}
