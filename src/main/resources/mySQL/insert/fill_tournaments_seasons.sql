insert into tournaments_seasons (id, tournament_id, season_id)
  values (12020, 1, 2020),
         (12019, 1, 2019),
         (2201920, 2, 201920),
         (32020, 3, 2020),
         (4201920, 4, 201920),
         (5201920, 5, 201920),
         (6201920, 6, 201920)
         on duplicate key update tournament_id = values(tournament_id), season_id = values(season_id);