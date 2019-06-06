package com.company.pizzadelivery.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "PIZZADELIVERY_CUSTOMER")
@Entity(name = "pizzadelivery_Customer")
public class Customer extends StandardEntity {
	private static final long serialVersionUID = 918989428628627751L;

	@NotNull
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID")
	protected User user;

	@Column(name = "PHONE", length = 10)
	protected String phone;

	@Column(name = "ADRESS")
	protected String adress;

	@Column(name = "ORDERS_COUNT")
	protected Integer ordersCount;

	public Integer getOrdersCount() { return ordersCount; }

	public void setOrdersCount(Integer ordersCount) { this.ordersCount = ordersCount; }

	public String getAdress() { return adress; }

	public void setAdress(String adress) { this.adress = adress; }

	public String getPhone() { return phone; }

	public void setPhone(String phone) { this.phone = phone; }

	public User getUser() { return user; }

	public void setUser(User user) { this.user = user; }
}