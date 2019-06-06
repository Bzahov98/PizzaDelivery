package com.company.pizzadelivery.web.screens.dish;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzadelivery.entity.Dish;

@UiController("pizzadelivery_Dish.edit")
@UiDescriptor("dish-edit.xml")
@EditedEntityContainer("dishDc")
@LoadDataBeforeShow
public class DishEdit extends StandardEditor<Dish> {
}