insert into user(first_name, last_name, pesel) values
                                                   ('Jan', 'Kowalski', '90101222457'),
                                                   ('Maciej', 'Zalewski', '87112242456'),
                                                   ('Aneta', 'Korczyńska', '76061536749'),
                                                   ('Wojciech', 'Sokolik', '82010877245');



insert into category(name, description) values
                                            ('Laptopy', 'Przenośne komputery osobiste'),
                                            ('Telefony', 'Drobny sprzęt komputerowy'),
                                            ('Pojazdy', 'Samochody i skutery');

insert into asset(name, description, serial_number, category_id) values
                                                                     ('Asus MateBook D', '15 calowy laptop, i5, 8GB DDR3, kolor czarny', 'ASMBD198723', 1),
                                                                     ('Apple MacBook Pro 2015', '13 calowy laptop, i5, 16GB DDR3, SSD256GB, kolor srebrny', 'MBP15X0925336', 1),
                                                                     ('Dell Inspirion 3576', '13 calowy laptop, i7, 8GB DDR4, SSD 512GB, kolor czarny', 'DI3576XO526716', 3),
                                                                     ('Lenovo Thinkpad X1 Carbon', '14 calowy laptop, i5, 8GB DDR4, SSD 128GB, kolor czarny', 'LTX1C8KA78220', 1),
                                                                     ('Samsung Note 8', 'Kompletny zestaw: telefon, słuchawki, rysik, ładowarka', 'SN882017AX896B', 2),
                                                                     ('Xiaomi Mi Mix 2', 'Telefon z ładowarką', 'XMM2S78A6652J', 2),
                                                                     ('Apple iPhone X', 'Telefon z zestawem słuchawkowym lightning i ładowarką', 'APLX17287GHX21', 2),
                                                                     ('Apple iPhone 8', 'Telefon z zestawem słuchawkowym lightning i ładowarką', 'APL8185652HGT7', 2),
                                                                     ('Opel Insignia GSi', 'Samochód osobowy, 6 biegowa automatyczna skrzynia biegów, benzynowy silnik 2.0', 'XHG78K64', 3),
                                                                     ('Ford Focus', 'Samochód osobowy, 5 biegowa manualna skrzynia biegów, silnik diesel 1.6', 'M24HP88GYJ', 3);


insert into assignment(start, end, asset_id, user_id) values
                                                          ('2017-10-08 15:00:00', '2018-10-08 15:00:00', 1, 2),
                                                          ('2024-10-09 12:00:00', null, 5, 2),
                                                          ('2024-10-10 16:00:00', null, 9, 2);


