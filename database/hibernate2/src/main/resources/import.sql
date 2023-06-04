insert into employee_type VALUES (1, 'Developer');
insert into employee_type VALUES (2, 'Tester');

insert into city VALUES (1, 'Vilnius'), (2, 'Kaunas');

insert into employee (name, surname, employee_type_id, current_city_id) VALUES ('Petras', 'Petraitis', 1, 1), ('Ona', 'Onute', 1, 2), ('Zita', 'Zinute', 2, 2);


insert into employee_city (cities_id , employees_id) VALUES (1, 1), (1, 2), (2, 1), (2, 3);
