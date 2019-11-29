package com.switchfully.order;

import com.switchfully.order.service.items.ItemService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("itemDetail")
public class SelectedItemPage extends Composite<VerticalLayout> {
    private ItemService itemService;
    private ItemsPage itemsPage;

    public SelectedItemPage(ItemsPage itemsPage, ItemService itemService) {
        this.itemService = itemService;
        this.itemsPage = itemsPage;
    }

}
