package com.company.pizzadelivery.web.screens.employer;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzadelivery.entity.Employer;

@UiController("pizzadelivery_Employer.edit")
@UiDescriptor("employer-edit.xml")
@EditedEntityContainer("employerDc")
@LoadDataBeforeShow
public class EmployerEdit extends StandardEditor<Employer> {
}