insert into types_of_teams (id, name)
  values (1, "Клуб"),
         (2, "Сборная")
         on duplicate key update name = values(name);