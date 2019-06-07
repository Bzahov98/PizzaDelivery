package com.company.pizzadelivery.web.screens;

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

@UiController("pizzadelivery_Clerkscreennew")
@UiDescriptor("ClerkScreenNew.xml")
@LoadDataBeforeShow
public class Clerkscreennew extends Screen {
	private int ordersSize;
	private int newPosition = 0;
	private Employer selectedEmpl;

	@Inject
	private InstanceContainer<Order> orderDc;

	@Inject
	private InstanceLoader<Order> orderDL;

	@Inject
	private CollectionContainer<Employer> deliverDC;

	@Inject
	private CollectionLoader<Employer> deliverDL;
	@Inject
	private DataManager dataManager;
	@Inject
	private PickerField<Employer> deliveryEmployerField;
	@Inject
	private Table<Employer> deliversTable;
	@Inject
	private Notifications notifications;
	@Inject
	private Form form;


	@Subscribe("next")
	private void onNextClick(Button.ClickEvent event) {
		newPosition++;
		changeOrder();
	}

	@Subscribe("previousOrder")
	private void onPreviousOrderClick(Button.ClickEvent event) {
		newPosition--;
		changeOrder();
	}

	@Subscribe
	private void onBeforeShow(BeforeShowEvent event) {
		changeOrder();
	}

	private void changeOrder() {
		List<Order> list = dataManager
				.load(Order.class)
				.query("select o\n" +
						"                        from pizzadelivery_Order o\n" +
						"                        where o.isSuccessful = true\n" +
						"                        order by o.createTime asc")
				.view("order-edit-view")
				.list();

		if (list == null || list.isEmpty()) {
			notifications
					.create()
					.withCaption("No more Orders")
					.withPosition(Notifications.Position.BOTTOM_RIGHT)
					.show();
			newPosition = 0;
			ordersSize = 0;
			return;
		}
		ordersSize = list.size() - 1;
		if ((ordersSize < newPosition) || (newPosition < 0)) {
			newPosition = 0;
			notifications
					.create()
					.withCaption("Reset Orders")
					.withPosition(Notifications.Position.BOTTOM_RIGHT)
					.show();
		}

		orderDc.setItem(list.get(newPosition));

		//commentDl.setParameter("OrderId", OrderDC.getItem().getId());
		orderDL.load();
		//deliverDL.load();
	}

	@Subscribe("deliversTable")
	private void onDeliversTableSelection(Table.SelectionEvent<Employer> event) {
		selectedEmpl = deliversTable.getSingleSelected();
		if (selectedEmpl != null) {
			deliveryEmployerField.setValue(selectedEmpl);
		} else notifications.create()
				.withCaption("Please select Employer")
				.withPosition(Notifications.Position.BOTTOM_RIGHT)
				.show();
	}

	@Subscribe("deliversTable")
	private void onDeliversTableColumnCollapse(Table.ColumnCollapseEvent event) {

	}

	@Subscribe("acceptBtn")
	private void onAcceptBtnClick(Button.ClickEvent event) {
		dataManager.commit(orderDc.getItem());
		newPosition++;
		notifications
				.create()
				.withCaption("Order saved and sent to deliver")
				.withPosition(Notifications.Position.BOTTOM_RIGHT)
				.show();
		changeOrder();
		deliverDL.load();
	}

	@Subscribe("denyBtn")
	private void onDenyBtnClick(Button.ClickEvent event) {
		notifications.create()
				.withCaption("Order not changed")
				.withPosition(Notifications.Position.BOTTOM_RIGHT)
				.show();
		changeOrder();
		deliverDL.load();
	}

}