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

@UiController("pizzadelivery_Clerkscreen")
@UiDescriptor("ClerkScreen.xml")
@LoadDataBeforeShow
public class Clerkscreen extends Screen {
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
		List<Order> list = dataManager.load(Order.class).view("order-edit-view").list();

		ordersSize = list.size() - 1;
		if ( (ordersSize < newPosition) || (newPosition < 0)) {
			newPosition = 0;
		}
		
		orderDc.setItem(list.get(newPosition));

		//commentDl.setParameter("OrderId", OrderDC.getItem().getId());
		orderDL.load();
		//deliverDL.load();
	}

	@Subscribe("deliversTable")
	private void onDeliversTableSelection(Table.SelectionEvent<Employer> event) {
		selectedEmpl = deliversTable.getSingleSelected();
		if (selectedEmpl != null){
			deliveryEmployerField.setValue(selectedEmpl);
		}else notifications.create().withCaption("Please select Employer").show();
	}

	@Subscribe("deliversTable")
	private void onDeliversTableColumnCollapse(Table.ColumnCollapseEvent event) {

	}


	
	
	
}