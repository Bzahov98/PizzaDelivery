package com.company.pizzadelivery.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import java.util.List;

@NamePattern("%s %s|user,type")
@Table(name = "PIZZADELIVERY_EMPLOYER")
@Entity(name = "pizzadelivery_Employer")
public class Employer extends StandardEntity {
	private static final long serialVersionUID = -9177029933859178753L;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	protected User user;

	@Column(name = "TYPE_")
	protected String type;

	@OneToMany(mappedBy = "clerkEmployer")
	protected List<Order> allOrders;

	public List<Order> getAllOrders() { return allOrders; }

	public void setAllOrders(List<Order> allOrders) { this.allOrders = allOrders; }

	public EmployerType getType() { return type == null ? null : EmployerType.fromId(type); }

	public void setType(EmployerType type) { this.type = type == null ? null : type.getId(); }

	public User getUser() { return user; }

	public void setUser(User user) { this.user = user; }
}