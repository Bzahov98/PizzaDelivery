package com.company.pizzadelivery.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzadelivery.entity.Product;

@UiController("pizzadelivery_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
}