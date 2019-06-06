package com.company.pizzadelivery.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzadelivery.entity.Product;

@UiController("pizzadelivery_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {
}