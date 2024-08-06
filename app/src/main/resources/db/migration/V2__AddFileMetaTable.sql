create table rk_coffee_shop.file_metadata
(
    id             uuid primary key default gen_random_uuid(),
    filepath       varchar(500) not null,
    file_extension varchar(10)  not null
);