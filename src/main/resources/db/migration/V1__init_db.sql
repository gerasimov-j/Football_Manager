create table countries (
	id bigint not null auto_increment,
	flag_file_name varchar(255),
	name varchar(50) not null, tag_name varchar(3) not null,
	user_id bigint,
	primary key (id)
);

create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );

create table managers (
	id bigint not null auto_increment,
	full_name varchar(100), short_name varchar(50) not null,
	country_id bigint, player_id bigint,
	primary key (id)
);

create table matches (
	id bigint not null auto_increment,
	home_team_id bigint,
	primary key (id)
);

create table players (
	id bigint not null auto_increment,
	full_name varchar(100),
	short_name varchar(50) not null,
	country_id bigint,
	primary key (id)
);

create table seasons (
	id bigint not null auto_increment,
	end_year integer,
	name varchar(20),
	start_year integer,
	primary key (id)
);
create table stadiums (
	id bigint not null auto_increment,
	name varchar(50) not null,
	country_id bigint,
	primary key (id)
);

create table teams (
	id bigint not null auto_increment,
	name varchar(50) not null,
	tag_name varchar(3) not null,
	country_id bigint, manager_id bigint,
	type_of_teams_id bigint,
	primary key (id)
);

create table tournaments (
	id bigint not null auto_increment,
	name varchar(50) not null,
	type_of_teams_id bigint,
	primary key (id)
);

create table tournaments_seasons (
	id bigint not null auto_increment,
	season_id bigint not null,
	tournament_id bigint not null,
	primary key (id)
);

create table tournaments_seasons_teams (
	tournament_season_id bigint not null,
	team_id bigint not null,
	primary key (tournament_season_id, team_id)
);

create table type_of_teams (
	id bigint not null auto_increment,
	name varchar(50),
	primary key (id)
);

create table user_role (
	user_id bigint not null,
	roles varchar(255)
);

create table usr (
	id bigint not null,
	activation_code varchar(255),
	active bit not null,
	email varchar(255),
	password varchar(255),
	username varchar(255),
	primary key (id)
);

alter table managers add constraint manager_player_unique unique (player_id);
alter table countries add constraint country_user_fk foreign key (user_id) references usr (id);
alter table managers add constraint manager_country_fk foreign key (country_id) references countries (id);
alter table managers add constraint manager_player_fk foreign key (player_id) references players (id);
alter table matches add constraint match_home_team_fk foreign key (home_team_id) references teams (id);
alter table players add constraint player_country_fk foreign key (country_id) references countries (id);
alter table stadiums add constraint stadium_country_fk foreign key (country_id) references countries (id);
alter table teams add constraint team_country_fk foreign key (country_id) references countries (id);
alter table teams add constraint team_manager_fk foreign key (manager_id) references managers (id);
alter table teams add constraint team_type_of_teams_fk foreign key (type_of_teams_id) references type_of_teams (id);
alter table tournaments add constraint tournament_type_of_temas_fk foreign key (type_of_teams_id) references type_of_teams (id);
alter table tournaments_seasons add constraint tournaments_season_season_fk foreign key (season_id) references seasons (id);
alter table tournaments_seasons add constraint tournaments_season_tournament_fk foreign key (tournament_id) references tournaments (id);
alter table tournaments_seasons_teams add constraint tournaments_seasons_team_team_fk foreign key (team_id) references teams (id);
alter table tournaments_seasons_teams add constraint tournaments_seasons_team_tournaments_season_fk_fk foreign key (tournament_season_id) references tournaments_seasons (id);
alter table user_role add constraint user_role_user_fk foreign key (user_id) references usr (id);