package com.company.pizzadelivery.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum DishType implements EnumClass<Integer> {

	PIZZA(1),
    SALAD(2),
    PASTA(3),
    DESERT(4);

	private Integer id;

	DishType(Integer value) {
		this.id = value;
	}

	public Integer getId() {
		return id;
	}

	@Nullable
	public static DishType fromId(Integer id) {
		for (DishType at : DishType.values()) {
			if (at.getId().equals(id)) {
				return at;
			}
		}
		return null;
	}
}