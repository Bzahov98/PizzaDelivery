package com.company.pizzadelivery.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID")
	protected Order order;

	@JoinTable(name = "PIZZADELIVERY_DISH_PRODUCT_LINK",
			joinColumns = @JoinColumn(name = "DISH_ID"),
			inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	@ManyToMany
	protected List<Product> dish_products;

	@Composition
	@OnDelete(DeletePolicy.CASCADE)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PIC_ID")
	protected FileDescriptor pic;

	public FileDescriptor getPic() { return pic; }

	public void setPic(FileDescriptor pic) { this.pic = pic; }

	public List<Product> getDish_products() { return dish_products; }

	public void setDish_products(List<Product> dish_products) { this.dish_products = dish_products; }

	public Order getOrder() { return order; }

	public void setOrder(Order order) { this.order = order; }

	public DishType getType() { return type == null ? null : DishType.fromId(type); }

	public void setType(DishType type) { this.type = type == null ? null : type.getId(); }

	public String getPrice() { return price; }

	public void setPrice(String price) { this.price = price; }

	public Date getTimeForCook() { return timeForCook; }

	public void setTimeForCook(Date timeForCook) { this.timeForCook = timeForCook; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }
}