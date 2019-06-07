package com.company.pizzadelivery.web.screens.order;

import com.company.pizzadelivery.entity.DishType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizzadelivery.entity.Order;

import javax.inject.Inject;

@UiController("pizzadelivery_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {



		
}