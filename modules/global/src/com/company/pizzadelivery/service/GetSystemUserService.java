package com.company.pizzadelivery.service;

import com.company.pizzadelivery.entity.Employer;

public interface GetSystemUserService {
	String NAME = "pizzadelivery_GetSystemUserService";
	Employer getEmployer(com.haulmont.cuba.security.entity.User user);
}