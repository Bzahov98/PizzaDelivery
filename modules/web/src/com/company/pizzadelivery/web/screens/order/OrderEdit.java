package com.company.pizzadelivery.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzadelivery.entity.Order;

@UiController("pizzadelivery_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {
}