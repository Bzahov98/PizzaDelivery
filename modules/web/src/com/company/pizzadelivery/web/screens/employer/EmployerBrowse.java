package com.company.pizzadelivery.web.screens.employer;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzadelivery.entity.Employer;

@UiController("pizzadelivery_Employer.browse")
@UiDescriptor("employer-browse.xml")
@LookupComponent("employersTable")
@LoadDataBeforeShow
public class EmployerBrowse extends StandardLookup<Employer> {
}