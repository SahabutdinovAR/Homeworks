-- select setval('account_id_seq', 12, true);

-- удаление таблицы, если она существует
drop table if exists driver_car;
drop table if exists car;
drop table if exists account;
-- создание таблицы
create table account
(
    -- первичный ключ - семантика - уникальная запись (как правило числовая, как правило по принципу автоинкремента)
    -- обозначает столбец
    --  который однозначно идентифицирует строку
    id         serial primary key,
    first_name char(20),
    last_name  char(20),
    -- проверки, которые мы накладываем на колонку age
    age        integer not null default 1 check (age >= 1 and age <= 120)
);

-- добавление данных
insert into account(first_name, last_name, age)
values ('Марсель', 'Сидиков', 27);
insert into account(first_name, last_name, age)
values ('Виктор', 'Евлампьев', 24);
insert into account(first_name, last_name, age)
values ('Айрат', 'Мухутдинов', 22);
insert into account(first_name, last_name, age)
values ('Максим', 'Поздеев', 21);
insert into account(first_name, last_name, age)
values ('Аделя', 'Сабирзянова', 20);
insert into account(first_name, last_name, age)
values ('Алия', 'Мухутдинова', 21);
insert into account(first_name, last_name, age)
values ('Даниил', 'Вдовинов', 21);
insert into account(first_name, last_name, age)
values ('Марсель', 'Сидиков', 27);
insert into account(first_name, last_name, age)
values ('Ангелина', 'Еланская', 21);
insert into account(first_name, last_name, age)
values ('Разиль', 'Миниахметов', 22);
insert into account(first_name, last_name, age)
values ('Тимур', 'Хафизьянов', 22);
-- удаление данных по условию
delete
from account
where id = 8;

-- добавление столбца с таблицу
alter table account
    add email char(30) unique;

-- обновление данных по условию
update account
set email = 'sidikov.marsel@gmail.com'
where id = 1;

-- между машиной и владельцами связь один-ко-многим/многие-к-одному
create table car
(
    id       serial primary key,
    color    char(20),
    model    char(20),
    owner_id integer,
    -- внешний ключ, ссылается на id-шник из таблицы account
    foreign key (owner_id) references account (id)
);

insert into car(color, model, owner_id)
values ('Black', 'BMW', 1);
insert into car(color, model)
values ('Blue', 'Granta');
insert into car(color, model, owner_id)
values ('Yellow', 'KIA OPTIMA', 1);
insert into car(color, model, owner_id)
values ('Красный', 'Lada Largus', 2);
insert into car(color, model, owner_id)
values ('Серый', 'Renault', 3);
insert into car(color, model, owner_id)
values ('Голубой', 'Bugatti', 4);
insert into car(color, model, owner_id)
values ('Синяя', 'LADA', 5);
insert into car(color, model, owner_id)
values ('Белая', 'Solaris', 6);
-- insert into car(color, model, owner_id)
-- values ('Голубая', 'AUDI', 13);

-- каждый пользователь может водить несколько машин, также и у машин может быть несколько водителей
-- многие ко многим

create table driver_car
(
    driver_id integer,
    car_id    integer,
    foreign key (driver_id) references account (id),
    foreign key (car_id) references car (id)
);

insert into driver_car(driver_id, car_id)
values (2, 2);
insert into driver_car(driver_id, car_id)
values (1, 3);
insert into driver_car(driver_id, car_id)
values (5, 4);
insert into driver_car(driver_id, car_id)
values (4, 6);
insert into driver_car(driver_id, car_id)
values (1, 6);
insert into driver_car(driver_id, car_id)
values (5, 6);
insert into driver_car(driver_id, car_id)
values (4, 5);

-- получить все колонки всех записей таблицы account
select *
from account;

-- получить имена всех пользователей, у которых есть email
select first_name
from account
where email notnull;

-- получение имен и возрастов пользователей, которые старше 23-х лет упорядочить по убыванию возраста
select first_name, age
from account
where age > 23
order by age desc;

-- получить имена всех владельцев у которых есть хотя бы одна машина
select a.first_name as name
from account a
where a.id in (
-- получаем id всех владельцев из таблицы car
    select distinct c.owner_id
    from car c
    where owner_id notnull
);

-- получить имена владельцев машин, у которых более 1-го водителя

-- 1. получение id машин и количество их водителей
-- 2. получить id машин, у которых более 1-го водителя
-- 3. получить id всех владельцев, у машин которых более 1-го водителя
-- 4. получить имя владельца, у машины которого более 1-го водителя
select first_name as name
from account a
where a.id in (
    select owner_id
    from car c
    where c.id in (
        select cd.car_id
        from (select car_id, count(driver_id) as drivers_count from driver_car group by car_id) cd
        where cd.drivers_count > 1));
---

--- все владельцы и все их машины (есть владельцы без машин, а некоторые владельцы повторяются столько раз, сколько у них машин)
select *
from account a
         left join car c on a.id = c.owner_id;

-- все машины и их владельцы (есть машины без владельцев, владельцев без машин нет)
select *
from account a
         right join car c on a.id = c.owner_id;

-- все машины и все владельцы, которые есть друг у друга (нет машин без владельцев, нет владельцев без машин)
select *
from account a
         inner join car c on a.id = c.owner_id;

select *
from account
         full join car c on account.id = c.owner_id;

alter table account alter column first_name type varchar(20) using first_name::varchar(20);
alter table account alter column last_name type varchar(20) using last_name::varchar(20);