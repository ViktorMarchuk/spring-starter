insert into springdata.company(name)
values ('Google'),
       ('Meta'),
       ('Amazon'),
       ('Basf');

insert into springdata.company_locales(company_id, lang, description)
values ((select id from springdata.company where name = 'Google'), 'en', 'Google description'),
       ((select id from springdata.company where name = 'Google'), 'ru', 'Google описание'),
       ((select id from springdata.company where name = 'Meta'), 'en', 'Meta description'),
       ((select id from springdata.company where name = 'Meta'), 'ru', 'Meta описание'),
       ((select id from springdata.company where name = 'Amazon'), 'en', 'Amazon description'),
       ((select id from springdata.company where name = 'Amazon'), 'ru', 'Amazon описание');

insert into springdata.users(username, birth_date, firstname, lastname, role, company_id)
values ('Ocean', '1990-01-10', 'Oleg', 'Petrov', 'ADMIN', (select id from springdata.company where name = 'Google')),
       ('Moon', '1996-05-20', 'Pedro', 'Horton', 'USER', (select id from springdata.company where name = 'Meta')),
       ('Sea', '2000-02-10', 'Lena', 'Marchuk', 'USER', (select id from springdata.company where name = 'Amazon')),
       ('Earth', '1991-04-11', 'Ostin', 'Power', 'ADMIN', (select id from springdata.company where name = 'Meta')),
       ('Volcano', '2013-06-12', 'Hawk', 'Nell', 'USER', (select id from springdata.company where name = 'Google')),
       ('River', '1993-09-20', 'Oleg', 'Petrov', 'ADMIN', (select id from springdata.company where name = 'Amazon'));


insert into springdata.payment(amount, receiver_id)
values (500, (select id from springdata.users where username = 'Ocean')),
       (700, (select id from springdata.users where username = 'Ocean')),
       (2500, (select id from springdata.users where username = 'Moon')),
       (1500, (select id from springdata.users where username = 'Earth')),
       (500, (select id from springdata.users where username = 'Ocean')),
       (4500, (select id from springdata.users where username = 'River')),
       (5400, (select id from springdata.users where username = 'Volcano')),
       (300, (select id from springdata.users where username = 'Sea')),
       (750, (select id from springdata.users where username = 'River'));

insert into springdata.chat(name)
values ('Minsk'),
       ('Java'),
       ('Database');

insert into springdata.users_chat(user_id, chat_id)
values
    ((select id from springdata.users where username = 'Ocean'), (select id from springdata.chat where name = 'Minsk')),
    ((select id from springdata.users where username = 'Moon'), (select id from springdata.chat where name = 'Minsk')),
    ((select id from springdata.users where username = 'River'), (select id from springdata.chat where name = 'Java')),
    ((select id from springdata.users where username = 'Volcano'), (select id from springdata.chat where name = 'Database')),
    ((select id from springdata.users where username = 'Sea'), (select id from springdata.chat where name = 'Minsk')),
    ((select id from springdata.users where username = 'Earth'), (select id from springdata.chat where name = 'Java')),
    ((select id from springdata.users where username = 'Moon'), (select id from springdata.chat where name = 'Database'));

