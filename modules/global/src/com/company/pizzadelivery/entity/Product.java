package com.company.pizzadelivery.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NamePattern("%s %s|name,amount")
@Table(name = "PIZZADELIVERY_PRODUCT")
@Entity(name = "pizzadelivery_Product")
public class Product extends StandardEntity {
	private static final long serialVersionUID = 8230270750879524656L;

	@Column(name = "NAME")
	protected String name;

	@Column(name = "AMOUNT")
	protected BigDecimal amount;

	@JoinTable(name = "PIZZADELIVERY_DISH_PRODUCT_LINK",
			joinColumns = @JoinColumn(name = "PRODUCT_ID"),
			inverseJoinColumns = @JoinColumn(name = "DISH_ID"))
	@ManyToMany
	protected List<Dish> dishes;

	public List<Dish> getDishes() { return dishes; }

	public void setDishes(List<Dish> dishes) { this.dishes = dishes; }

	public BigDecimal getAmount() { return amount; }

	public void setAmount(BigDecimal amount) { this.amount = amount; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }
}