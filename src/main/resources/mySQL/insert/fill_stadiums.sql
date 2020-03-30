insert into stadiums (id, name, country_id)
  values (1, "Борисов-Арена", 1),
         (2, "Динамо Минск", 1),
         (3, "Стадион ФК \"Минск\"", 1)
         on duplicate key update name = values(name), country_id = values(country_id);