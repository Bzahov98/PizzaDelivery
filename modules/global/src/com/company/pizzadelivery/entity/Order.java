package com.company.pizzadelivery.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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