insert into countries (id, name, tag_name)
  values (1, "Беларусь", "BLR"),
         (2, "Украина", "UKR"),
         (3, "Сербия", "SRB"),
         (4, "Черногория", "MNE"),
         (5, "Босния и Герцеговина", "BIH"),
         (6, "Исландия", "ISL"),
         (7, "Камерун", "CAM"),
         (8, "Албания", "ALB"),
         (9, "Грузия", "GEO"),
         (10, "Узбекистан", "UZB")
         on duplicate key update name = values(name), tag_name = values(tag_name);