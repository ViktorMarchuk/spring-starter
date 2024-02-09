create table if not exists springdata.company
(
    id   serial primary key,
    name varchar(62) not null unique
);

create table if not exists springdata.company_locales
(
    company_id  int references springdata.company (id) on DELETE cascade ,
    lang        varchar(32),
    description varchar(32) not null,
    primary key (company_id, lang)
);

create table if not exists springdata.users
(
    id         bigserial primary key,
    username   varchar(64) not null unique,
    birth_date Date,
    firstname  varchar(64),
    lastname   varchar(64),
    role       varchar(32),
    company_id int references springdata.company (id) on DELETE cascade
);

create table if not exists springdata.payment
(
    id          bigserial primary key,
    amount      int    not null,
    receiver_id bigint not null references springdata.users (id) on DELETE cascade
);

create table if not exists springdata.chat
(
    id   bigserial primary key,
    name varchar(32)
);

create table if not exists springdata.users_chat
(
    id      bigserial primary key,
    user_id bigint not null references springdata.users (id) on DELETE cascade ,
    chat_id bigint not null references springdata.chat (id) on DELETE cascade ,
    unique (user_id, chat_id)
);
