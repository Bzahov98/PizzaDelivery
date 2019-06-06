package com.company.pizzadelivery.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "PIZZADELIVERY_PRODUCT")
@Entity(name = "pizzadelivery_Product")
public class Product extends StandardEntity {
	private static final long serialVersionUID = 8230270750879524656L;

	@Column(name = "NAME")
	protected String name;

	@Column(name = "AMOUNT")
	protected BigDecimal amount;

	public BigDecimal getAmount() { return amount; }

	public void setAmount(BigDecimal amount) { this.amount = amount; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }
}