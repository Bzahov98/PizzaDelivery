-- begin PIZZADELIVERY_CUSTOMER
create table PIZZADELIVERY_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36) not null,
    PHONE varchar(10),
    ADRESS varchar(255),
    ORDERS_COUNT integer,
    --
    primary key (ID)
)^
-- end PIZZADELIVERY_CUSTOMER
-- begin PIZZADELIVERY_ORDER
create table PIZZADELIVERY_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CREATE_TIME timestamp,
    ARRIVAL_TIME timestamp,
    TOTAL_PRICE decimal(19, 2),
    DISCOUNT integer,
    INSTRUCTIONS varchar(255),
    ADRESS varchar(255),
    IS_SUCCESSFUL boolean,
    CUSTOMER_ID varchar(36),
    CLERK_EMPLOYER_ID varchar(36),
    DELIVERY_EMPLOYER_ID varchar(36),
    --
    primary key (ID)
)^
-- end PIZZADELIVERY_ORDER
-- begin PIZZADELIVERY_EMPLOYER
create table PIZZADELIVERY_EMPLOYER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID varchar(36),
    TYPE_ varchar(50),
    IS_AVAILABLE boolean,
    --
    primary key (ID)
)^
-- end PIZZADELIVERY_EMPLOYER
-- begin PIZZADELIVERY_DISH
create table PIZZADELIVERY_DISH (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    TIME_FOR_COOK time,
    PRICE varchar(255),
    TYPE_ integer,
    ORDER_ID varchar(36),
    PIC_ID varchar(36),
    --
    primary key (ID)
)^
-- end PIZZADELIVERY_DISH
-- begin PIZZADELIVERY_PRODUCT
create table PIZZADELIVERY_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    AMOUNT decimal(19, 2),
    --
    primary key (ID)
)^
-- end PIZZADELIVERY_PRODUCT
-- begin PIZZADELIVERY_DISH_PRODUCT_LINK
create table PIZZADELIVERY_DISH_PRODUCT_LINK (
    PRODUCT_ID varchar(36) not null,
    DISH_ID varchar(36) not null,
    primary key (PRODUCT_ID, DISH_ID)
)^
-- end PIZZADELIVERY_DISH_PRODUCT_LINK
