insert into teams (id, name, tag_name, country_id, type_of_teams_id, manager_id)
  values (1, "БАТЭ", "BAT", 1, 1, 1),
         (2, "Динамо-Брест", "DBR", 1, 1, 2),
         (3, "Беларусь", "BLR", 1, 2, 3),
         (4, "Шахтёр Солигорск", "SHS", 1, 1, 4),
         (5, "Динамо-Минск", "DMN", 1, 1, 5),
         (6, "Грузия", "GEO", 9, 2, null)
         on duplicate key update name = values(name), tag_name = values(tag_name),
         country_id = values(country_id), type_of_teams_id = values(type_of_teams_id);