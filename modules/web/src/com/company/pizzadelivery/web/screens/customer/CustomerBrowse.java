package com.company.pizzadelivery.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzadelivery.entity.Customer;

@UiController("pizzadelivery_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}