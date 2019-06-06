package com.company.pizzadelivery.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzadelivery.entity.Customer;

@UiController("pizzadelivery_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
}