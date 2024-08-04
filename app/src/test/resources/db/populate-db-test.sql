truncate rk_coffee_shop.order cascade;
truncate rk_coffee_shop.orders_lines cascade;
truncate rk_coffee_shop.products cascade;
truncate rk_coffee_shop.users cascade;

insert into rk_coffee_shop.products(id, title, description)
values ('00000000-0000-0000-0000-000000000001', 'Product', 'Description'),
       ('00000000-0000-0000-0000-000000000002', 'Product', 'Description');

insert into rk_coffee_shop.users(id, login, password)
values ('00000000-0000-0000-0000-000000000001', 'userlogin', 'Pa$$w0rd!'),
       ('00000000-0000-0000-0000-000000000002', 'userlogin', 'Pa$$w0rd!');

insert into rk_coffee_shop.order(id, customer_id, customer_phone, customer_fio, address, status)
values ('00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', '88005553535', 'Ivanov Ivan Ivanovich', 'Russia', 'CREATED'),
       ('00000000-0000-0000-0000-000000000002', null, '88005553535', 'Ivanov Ivan Ivanovich', 'Russia', 'CREATED');

insert into rk_coffee_shop.orders_lines(id, order_id, product_id, quantity)
values ('00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', 1),
       ('00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000002', 2),
       ('00000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000001', 2);