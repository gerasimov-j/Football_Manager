drop table matches;
drop table players_teams;
drop table tournaments_seasons_teams;
drop table teams;
drop table managers;
drop table players;
drop table tournaments_seasons;
drop table tournaments;
drop table types_of_teams;
drop table seasons;
drop table countries;

create table countries (
  id int not null auto_increment,
  name varchar(50) not null,
  tag_name varchar(3) not null,
  primary key (id)
);

create table seasons (
  id int not null auto_increment,
  name varchar(20),
  start_year int,
  end_year int,
  primary key (id)
);

create table types_of_teams (
  id int not null auto_increment,
  name varchar(50) not null,
  primary key (id)
);

create table tournaments (
  id int not null auto_increment,
  name varchar(50) not null,
  type_of_teams_id int not null,
  primary key (id),
  foreign key (type_of_teams_id) references types_of_teams (id)
);

create table players (
  id int not null auto_increment,
  primary key (id),
  short_name varchar(50) not null,
  full_name varchar(100),
  country_id int not null,
  foreign key (country_id) references countries (id)
);

create table managers (
  id int not null auto_increment,
  primary key (id),
  short_name varchar(50) not null,
  full_name varchar(100),
  player_id int,
  country_id int not null,
  foreign key (player_id) references players (id) on delete set null,
  foreign key (country_id) references countries (id)
);

create table teams (
  id int not null auto_increment,
  primary key (id),
  name varchar(50) not null,
  tag_name varchar(3) not null,
  country_id int not null,
  type_of_teams_id int not null,
  manager_id int,
  foreign key (manager_id) references managers (id) on delete set null,
  foreign key (country_id) references countries (id),
  foreign key (type_of_teams_id) references types_of_teams (id)
);

create table tournaments_seasons (
  id int not null auto_increment,
  tournament_id int not null,
  season_id int not null,
  primary key (id),
  foreign key (tournament_id) references tournaments (id),
  foreign key (season_id) references seasons (id)
);

create table tournaments_seasons_teams (
  tournament_season_id int not null,
  team_id int not null,
  primary key (tournament_season_id, team_id),
  index tournament_season_id (tournament_season_id),
  index team_id (team_id),
  constraint fk_tournament_season_tst foreign key (tournament_season_id) references tournaments_seasons (id) on delete cascade,
  constraint fk_team_tst foreign key (team_id) references teams (id) on delete cascade
);

create table players_teams (
  player_id int not null,
  team_id int not null,
  primary key (player_id, team_id),
  index player_id (player_id),
  index team_id (team_id),
  constraint fk_player foreign key (player_id) references players (id) on delete cascade,
  constraint fk_team_player foreign key (team_id) references teams (id) on delete cascade
);

create table matches (
  id int not null auto_increment,
  primary key (id),
  home_team_id int not null,
  guest_team_id int not null,
  tournament_id int,
  home_team_goals int,
  guest_team_goals int,
  date_time date not null,
  foreign key (home_team_id) references teams (id),
  foreign key (guest_team_id) references teams (id),
  foreign key (tournament_id) references tournaments (id),
  constraint positiveGoals check (
    (home_team_goals is null or home_team_goals >= 0) and
    (guest_team_goals is null or guest_team_goals >= 0)
  )
);