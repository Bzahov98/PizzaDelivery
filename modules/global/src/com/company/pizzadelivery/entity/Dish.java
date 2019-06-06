package com.company.pizzadelivery.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.Date;

@NamePattern("%s %s %s|name,price,type")
@Table(name = "PIZZADELIVERY_DISH")
@Entity(name = "pizzadelivery_Dish")
public class Dish extends StandardEntity {
	private static final long serialVersionUID = 620727889429503557L;

	@Column(name = "NAME")
	protected String name;

	@Temporal(TemporalType.TIME)
	@Column(name = "TIME_FOR_COOK")
	protected Date timeForCook;

	@Column(name = "PRICE")
	protected String price;

	@Column(name = "TYPE_")
	protected Integer type;

	public DishType getType() { return type == null ? null : DishType.fromId(type); }

	public void setType(DishType type) { this.type = type == null ? null : type.getId(); }

	public String getPrice() { return price; }

	public void setPrice(String price) { this.price = price; }

	public Date getTimeForCook() { return timeForCook; }

	public void setTimeForCook(Date timeForCook) { this.timeForCook = timeForCook; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }
}