create table articles(
 id bigint auto_increment,
 hours number(6,2),
 title varchar2(100)
);


insert into articles(hours, title) values (5.00, 'Introduction to mechanical ventilation');
insert into articles(hours, title) values (3.5, 'Introduction to coronavirus disease 2019 (COVID-19)');
insert into articles(hours, title) values (2.00, 'Clinical pointers: COVID-19 in primary care');
insert into articles(hours, title) values (1, 'Clinical pointers: remote consultations in primary care');
insert into articles(hours, title) values (1,  'Quick tips: introduction to asthma');
insert into articles(hours, title) values (10.25, 'Infection control - including basic personal protective equipment');
insert into articles(hours, title) values (7.50, 'Introduction to testing for COVID-19');
insert into articles(hours, title) values (2.00, 'Airways management: tracheal intubation');
insert into articles(hours, title) values (2.50, 'Quick tips: proning in critical care');
insert into articles(hours, title) values (3.0, 'Quick tips: introduction to asthma');