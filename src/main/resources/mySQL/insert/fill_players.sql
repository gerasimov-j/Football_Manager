insert into players (short_name, country_id)
  values ("Стасевич", 1),
         ("Милевский", 2),
         ("Риос", 1)
         on duplicate key update short_name = values(short_name), country_id = values(country_id);