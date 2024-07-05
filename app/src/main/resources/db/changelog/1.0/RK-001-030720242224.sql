create schema rk_coffee_shop;

create table rk_coffee_shop.users
(
    uuid     uuid primary key default gen_random_uuid(),
    login    varchar(25) not null,
    password varchar(50) not null
);

create table rk_coffee_shop.products
(
    uuid        uuid primary key default gen_random_uuid(),
    title       varchar(50) not null,
    description varchar(100)
);

create table rk_coffee_shop.order
(
    uuid         uuid primary key default gen_random_uuid(),
    customer_id  uuid references rk_coffee_shop.users (uuid),
    customer_tel varchar(8)   not null,
    customer_fio varchar(150) not null,
    address      varchar(150) not null,
    status       varchar(25)  not null
);

create table rk_coffee_shop.orders_lines
(
    uuid       uuid primary key default gen_random_uuid(),
    product_id uuid references rk_coffee_shop.products (uuid) not null,
    order_id   uuid references rk_coffee_shop.order (uuid)    not null,
    quantity   int                                            not null
);