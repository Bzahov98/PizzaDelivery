-- begin PIZZADELIVERY_CUSTOMER
alter table PIZZADELIVERY_CUSTOMER add constraint FK_PIZZADELIVERY_CUSTOMER_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_PIZZADELIVERY_CUSTOMER_ON_USER on PIZZADELIVERY_CUSTOMER (USER_ID)^
-- end PIZZADELIVERY_CUSTOMER
-- begin PIZZADELIVERY_ORDER
alter table PIZZADELIVERY_ORDER add constraint FK_PIZZADELIVERY_ORDER_ON_CUSTOMER foreign key (CUSTOMER_ID) references PIZZADELIVERY_CUSTOMER(ID)^
alter table PIZZADELIVERY_ORDER add constraint FK_PIZZADELIVERY_ORDER_ON_CLERK_EMPLOYER foreign key (CLERK_EMPLOYER_ID) references PIZZADELIVERY_EMPLOYER(ID)^
alter table PIZZADELIVERY_ORDER add constraint FK_PIZZADELIVERY_ORDER_ON_DELIVERY_EMPLOYER foreign key (DELIVERY_EMPLOYER_ID) references PIZZADELIVERY_EMPLOYER(ID)^
create index IDX_PIZZADELIVERY_ORDER_ON_CUSTOMER on PIZZADELIVERY_ORDER (CUSTOMER_ID)^
create index IDX_PIZZADELIVERY_ORDER_ON_CLERK_EMPLOYER on PIZZADELIVERY_ORDER (CLERK_EMPLOYER_ID)^
create index IDX_PIZZADELIVERY_ORDER_ON_DELIVERY_EMPLOYER on PIZZADELIVERY_ORDER (DELIVERY_EMPLOYER_ID)^
-- end PIZZADELIVERY_ORDER
-- begin PIZZADELIVERY_EMPLOYER
alter table PIZZADELIVERY_EMPLOYER add constraint FK_PIZZADELIVERY_EMPLOYER_ON_USER foreign key (USER_ID) references SEC_USER(ID)^
create index IDX_PIZZADELIVERY_EMPLOYER_ON_USER on PIZZADELIVERY_EMPLOYER (USER_ID)^
-- end PIZZADELIVERY_EMPLOYER
-- begin PIZZADELIVERY_DISH
alter table PIZZADELIVERY_DISH add constraint FK_PIZZADELIVERY_DISH_ON_ORDER foreign key (ORDER_ID) references PIZZADELIVERY_ORDER(ID)^
create index IDX_PIZZADELIVERY_DISH_ON_ORDER on PIZZADELIVERY_DISH (ORDER_ID)^
-- end PIZZADELIVERY_DISH
-- begin PIZZADELIVERY_DISH_PRODUCT_LINK
alter table PIZZADELIVERY_DISH_PRODUCT_LINK add constraint FK_DISPRO_ON_PRODUCT foreign key (PRODUCT_ID) references PIZZADELIVERY_PRODUCT(ID)^
alter table PIZZADELIVERY_DISH_PRODUCT_LINK add constraint FK_DISPRO_ON_DISH foreign key (DISH_ID) references PIZZADELIVERY_DISH(ID)^
-- end PIZZADELIVERY_DISH_PRODUCT_LINK
