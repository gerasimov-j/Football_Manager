insert into players_teams (player_id, team_id)
  values (1, 1),
         (2, 2),
         (3, 5)
         on duplicate key update player_id = values(player_id), team_id = values(team_id);