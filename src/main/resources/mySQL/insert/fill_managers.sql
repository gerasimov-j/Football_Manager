insert into managers (id, short_name, country_id)
  values (1, "Альшевский", 1),
         (2, "Ковальчук", 1),
         (3, "Мархель", 1),
         (4, "Вернидуб", 2),
         (5, "Гуренко", 1)
         on duplicate key update short_name = values(short_name), country_id = values(country_id);