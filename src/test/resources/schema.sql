CREATE TABLE `fixture` (
  `id` int(11) NOT NULL,
  `event_date` date DEFAULT NULL,
  `goals_away_team` int(11) NOT NULL,
  `goals_home_team` int(11) NOT NULL,
  `round` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `venue` varchar(255) DEFAULT NULL,
  `away_team_id` int(11) DEFAULT NULL,
  `home_team_id` int(11) DEFAULT NULL,
  `league_id` int(11) DEFAULT NULL
); 

CREATE TABLE `league` (
  `id` int(11) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `season_end` date DEFAULT NULL,
  `season_start` date DEFAULT NULL,
  `season_year` int(11) NOT NULL
);

CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `team_name` varchar(255) DEFAULT NULL
); 
