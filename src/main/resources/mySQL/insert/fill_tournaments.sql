insert into tournaments (id, name, type_of_teams_id)
  values (1, "Высшая лига", 1),
         (2, "Кубок Беларуси", 1),
         (3, "Суперкубок Беларуси", 1),
         (4, "Лига Чемпионов", 1),
         (5, "Лига Европы", 1),
         (6, "Лига Наций", 2)
         on duplicate key update name = values(name), type_of_teams_id = values(type_of_teams_id);