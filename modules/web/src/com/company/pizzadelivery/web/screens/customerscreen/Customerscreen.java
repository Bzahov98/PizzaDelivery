package com.company.pizzadelivery.web.screens.customerscreen;

import com.company.pizzadelivery.entity.Dish;
import com.company.pizzadelivery.entity.DishType;
import com.company.pizzadelivery.entity.Order;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import org.apache.http.client.utils.DateUtils;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@UiController("pizzadelivery_Customerscreen")
@UiDescriptor("CustomerScreen.xml")
public class Customerscreen extends Screen {

	@Inject
	private CollectionContainer<Dish> dishesDC;
	@Inject
	private InstanceContainer<Order> orderDC;
	@Inject
	private CollectionLoader<Dish> dishesDL;
	@Inject
	private InstanceLoader<Order> orderDL;
	@Inject
	private Table<Dish> dishTable;
	@Inject
	private UiComponents uiComponents;
	@Inject
	private Notifications notifications;
	@Inject
	private DataManager dataManager;
	private Order order;



	@Subscribe
	private void onBeforeShow(BeforeShowEvent event) {
		createOrder();
	}

	private Order createOrder() {
		order = dataManager.create(Order.class);
		Calendar instance = Calendar.getInstance();
		order.setCreateTime(instance.getTime());
		order.setIsSuccessful(false);
		orderDC.setItem(order);
		orderDL.load();
		return order;
	}


	@Subscribe
	private void onInit(InitEvent event) {
		dishesDL.setParameter("DishType", DishType.PIZZA);
		dishesDL.load();

		dishTable.addGeneratedColumn("pic", dish -> {
			if (dish.getPic() != null) {
				Image pic = uiComponents.create(Image.class);
				pic.setAlignment(Component.Alignment.MIDDLE_CENTER);
				pic.setValueSource(new ContainerValueSource<>(dishTable.getInstanceContainer(dish), "pic"));
				return pic;
			}
			return null;
		});
		Set<Dish> selected = dishTable.getSelected();
		if (selected != null) {
			selected.forEach(dish -> {
				if (dish.getIsAdded() == null) {
					dish.setIsAdded(false);
				}
			});
		}else notify("No dishes");
	}

	@Subscribe("dishTable.addCart")
	private void onDishTableAddCart(Action.ActionPerformedEvent event) {
		if (dishTable == null){ notify("omg") ;return;}
		Dish selectedDish = dishTable.getSingleSelected();
		if (selectedDish == null) {
			notify("Please select dish");
		} else {
			if (!selectedDish.getIsAdded()) { // java.lang.NullPointerException: null
				selectedDish.setIsAdded(true);
				//notify("Added successfully " + selectedDish.getName());
				Order order = orderDC.getItem();
				List<Dish> allDIshes = getAllDishes(order);
				if (!allDIshes.contains(selectedDish)) {
					allDIshes.add(selectedDish);
					notify("Added successfully " + selectedDish.getName());
				}
			} else {
				notify("Already added");
			}
		}
	}

	@Subscribe("dishTable.removeCart")
	private void onDishTableRemoveCart(Action.ActionPerformedEvent event) {
		Dish singleSelected = dishTable.getSingleSelected();
		if (singleSelected == null) {
			notify("Please select dish");
		} else {
			if (singleSelected.getIsAdded()) {
				singleSelected.setIsAdded(false);
				Order order = orderDC.getItem();
				List<Dish> allDIshes = getAllDishes(order);
				allDIshes.remove(singleSelected);
				notify("Removed successfully " + singleSelected.getName());
			} else {
				notify("Not added");
			}
		}
	}

	private List<Dish> getAllDishes(Order order) {
		List<Dish> allDIshes = order.getAllDIshes();
		if (allDIshes == null) {
			allDIshes = new ArrayList<>();
		}
		return allDIshes;
	}

	private void notify(String s) {
		notifications.create()
				.withPosition(Notifications.Position.BOTTOM_RIGHT)
				.withCaption(s)
				.show();
	}

	@Subscribe("acceptBtn")
	private void onAcceptBtnClick(Button.ClickEvent event) {
		dataManager.commit(orderDC.getItem());
		notify("Order sent to clerk");
		createOrder();

	}

	@Subscribe("denyBtn")
	private void onDenyBtnClick(Button.ClickEvent event) {
		createOrder();
		notify("Order reset to clerk");
	}
	
	
	
	
}