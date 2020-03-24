insert into seasons (id, name, start_year, end_year)
  values (201819, "2018/19", 2018, 2019),
         (2019, "2019", 2019, 2020),
         (201920, "2019/20", 2019, 2019),
         (2020, "2020", 2020, 2020)
         on duplicate key update name = values(name), start_year = values(start_year), end_year = values(end_year);