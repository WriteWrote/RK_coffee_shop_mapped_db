truncate rk_coffee_shop.order cascade;
truncate rk_coffee_shop.orders_lines cascade;
truncate rk_coffee_shop.products cascade;
truncate rk_coffee_shop.users cascade;

-- delete from rk_coffee_shop.order;

insert into rk_coffee_shop.products(id, title, description)
values ('00000000-0000-0000-0000-000000000001', 'Product 1', 'Description 1'),
       ('00000000-0000-0000-0000-000000000002', 'Product 2', 'Description 2');

insert into rk_coffee_shop.users(id, login, password)
values ('00000000-0000-0000-0000-000000000001', 'login 1', 'password 1'),
       ('00000000-0000-0000-0000-000000000002', 'login 2', 'password 2');

insert into rk_coffee_shop.order(id, customer_id, customer_phone, customer_fio, address, status)
values ('00000000-0000-0000-0000-000000000001', null, '88005553535', 'Ivanov Ivan Ivanovich', 'Russia', 'CREATED'),
       ('00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000001', '88005553535', 'Ivanov Ivan Ivanovich', 'Russia', 'CREATED');

insert into rk_coffee_shop.orders_lines(id, order_id, product_id, quantity)
values ('00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', 1),
       ('00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000002', 2),
       ('00000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000001', 2);