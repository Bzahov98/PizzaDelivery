package com.company.pizzadelivery.web.screens.dish;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzadelivery.entity.Dish;

@UiController("pizzadelivery_Dish.browse")
@UiDescriptor("dish-browse.xml")
@LookupComponent("dishesTable")
@LoadDataBeforeShow
public class DishBrowse extends StandardLookup<Dish> {
}