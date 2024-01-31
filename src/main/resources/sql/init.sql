insert into springdata.company(name)
values ('Google',
        'Meta',
        'Amazon',
        'Ozon');

insert into springdata.company_locales(company_id, lang, description)
values ((select company_id from springdata.company where name = 'Google'), 'en', 'Google description'),
       ((select company_id from springdata.company where name = 'Google'), 'ru', 'Google описание'),
       ((select company_id from springdata.company where name = 'Meta'), 'en', 'Meta description'),
       ((select company_id from springdata.company where name = 'Meta'), 'ru', 'Meta описание'),
       ((select company_id from springdata.company where name = 'Amazon'), 'en', 'Google description'),
       ((select company_id from springdata.company where name = 'Amzon'), 'ru', 'Google описание');

insert into springdata.users(username, birth_date, firstname, lastname, role, company_id)
values ('Ocean', '1990-01-10', 'Oleg', 'Petrov', 'ADMIN',
        (select company_id from springdata.company where company_id = 1),
        'Ocean', '1990-01-10', 'Pedro', 'Horton', 'USER',
        (select company_id from springdata.company where company_id = 2),
        'Ocean', '1990-01-10', 'Oleg', 'Petrov', 'ADMIN',
        (select company_id from springdata.company where company_id = 1),
        'Ocean', '1990-01-10', 'Oleg', 'Petrov', 'ADMIN',
        (select company_id from springdata.company where company_id = 1),
        'Ocean', '1990-01-10', 'Oleg', 'Petrov', 'ADMIN',
        (select company_id from springdata.company where company_id = 1),
        'Ocean', '1990-01-10', 'Oleg', 'Petrov', 'ADMIN',
        (select company_id from springdata.company where company_id = 1));