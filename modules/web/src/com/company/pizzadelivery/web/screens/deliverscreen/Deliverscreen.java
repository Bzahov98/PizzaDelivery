package com.company.pizzadelivery.web.screens.deliverscreen;

import com.company.pizzadelivery.entity.Employer;
import com.company.pizzadelivery.entity.Order;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Form;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.List;

@UiController("pizzadelivery_Deliverscreen")
@UiDescriptor("deliverScreen.xml")
@LoadDataBeforeShow
public class Deliverscreen extends Screen {
	private int ordersSize;
	private int newPosition = 0;
	private Order selectedOrder;

	@Inject
	private InstanceContainer<Order> orderDc;

	@Inject
	private InstanceLoader<Order> orderDL;

	@Inject
	private CollectionContainer<Order> orderCollDC;
	@Inject
	private CollectionLoader<Order> orderCollDL;

	@Inject
	private DataManager dataManager;


	@Inject
	private Notifications notifications;
	@Inject
	private Form form;
	@Inject
	private Table<Order> ordersTable;


	@Subscribe("next")
	private void onNextClick(Button.ClickEvent event) {
		newPosition++;
		changeOrder(null);
	}

	@Subscribe("previousOrder")
	private void onPreviousOrderClick(Button.ClickEvent event) {
		newPosition--;
		changeOrder(null);
	}

	@Subscribe
	private void onBeforeShow(BeforeShowEvent event) {
		changeOrder(null);
	}


	private void changeOrder(Order order) {
		List<Order> list = dataManager
				.load(Order.class)
				.query("select o\n" +
						"                        from pizzadelivery_Order o\n" +
						"                        where o.isSuccessful = false\n" +
						"                        order by o.createTime asc")
				.view("order-edit-view")
				.list();

		if (list == null || list.isEmpty()) {
			notifications.create().withCaption("No more Orders").show();
			newPosition = 0;
			ordersSize = 0;
			return;
		}
		ordersSize = list.size() - 1;
		if (order == null) {

			if ((ordersSize < newPosition) || (newPosition < 0)) {
				newPosition = 0;
			}
			order = list.get(newPosition);
		} else {
			int i = list.indexOf(order);
			if (i < 0) {
				newPosition = 0;
			}
		}
		orderDc.setItem(order);

		//commentDl.setParameter("OrderId", OrderDC.getItem().getId());
		orderDL.load();
		//deliverDL.load();
	}

	@Subscribe("ordersTable")
	private void onDeliversTableSelection(Table.SelectionEvent<Employer> event) {
		selectedOrder = ordersTable.getSingleSelected();
		if (selectedOrder != null) {
			changeOrder(selectedOrder);
		} else notifications.create().withCaption("Please select Employer").show();
	}

	@Subscribe("acceptBtn")
	private void onAcceptBtnClick(Button.ClickEvent event) {
		dataManager.commit(orderDc.getItem());
		newPosition++;
		notifications.create().withCaption("Order saved and sent to deliver").show();
		changeOrder(null);
		orderCollDL.load();
	}

	@Subscribe("denyBtn")
	private void onDenyBtnClick(Button.ClickEvent event) {
		notifications.create().withCaption("Order not changed").show();
		changeOrder(null);
		orderCollDL.load();
	}

}