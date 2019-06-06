package com.company.pizzadelivery.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Table(name = "PIZZADELIVERY_ORDER")
@Entity(name = "pizzadelivery_Order")
public class Order extends StandardEntity {
	private static final long serialVersionUID = -7904423074756413665L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME")
	protected Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ARRIVAL_TIME")
	protected Date arrivalTime;

	@Column(name = "TOTAL_PRICE")
	protected BigDecimal totalPrice;

	@Column(name = "DISCOUNT")
	protected Integer discount;

	@Column(name = "INSTRUCTIONS")
	protected String instructions;

	@Column(name = "ADRESS")
	protected String adress;

	@Column(name = "IS_SUCCESSFUL")
	protected Boolean isSuccessful;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	protected Customer customer;

	@OneToMany(mappedBy = "order")
	protected List<Dish> allDIshes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYER_ID")
	protected Employer employer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DELIVERY_EMPLOYER_ID")
	protected Employer deliveryEmployer;

	public Employer getDeliveryEmployer() { return deliveryEmployer; }

	public void setDeliveryEmployer(Employer deliveryEmployer) { this.deliveryEmployer = deliveryEmployer; }

	public Employer getEmployer() { return employer; }

	public void setEmployer(Employer employer) { this.employer = employer; }

	public List<Dish> getAllDIshes() { return allDIshes; }

	public void setAllDIshes(List<Dish> allDIshes) { this.allDIshes = allDIshes; }

	public Customer getCustomer() { return customer; }

	public void setCustomer(Customer customer) { this.customer = customer; }

	public Boolean getIsSuccessful() { return isSuccessful; }

	public void setIsSuccessful(Boolean isSuccessful) { this.isSuccessful = isSuccessful; }

	public String getAdress() { return adress; }

	public void setAdress(String adress) { this.adress = adress; }

	public String getInstructions() { return instructions; }

	public void setInstructions(String instructions) { this.instructions = instructions; }

	public Integer getDiscount() { return discount; }

	public void setDiscount(Integer discount) { this.discount = discount; }

	public BigDecimal getTotalPrice() { return totalPrice; }

	public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

	public Date getArrivalTime() { return arrivalTime; }

	public void setArrivalTime(Date arrivalTime) { this.arrivalTime = arrivalTime; }

	public Date getCreateTime() { return createTime; }

	public void setCreateTime(Date createTime) { this.createTime = createTime; }
}