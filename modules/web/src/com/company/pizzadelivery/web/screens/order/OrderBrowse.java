package com.company.pizzadelivery.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzadelivery.entity.Order;

@UiController("pizzadelivery_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}