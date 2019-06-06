package com.company.pizzadelivery.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum EmployerType implements EnumClass<String> {

	CLERK("clerk"),
    DELIVER("deliver");

	private String id;

	EmployerType(String value) {
		this.id = value;
	}

	public String getId() {
		return id;
	}

	@Nullable
	public static EmployerType fromId(String id) {
		for (EmployerType at : EmployerType.values()) {
			if (at.getId().equals(id)) {
				return at;
			}
		}
		return null;
	}
}