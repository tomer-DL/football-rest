# football-rest

This project is a rest api for showing football fixtures and standings, using Spring.

In order to obtain the data I used an existing rapid api rest project.
The code in the class **football.input.reader.FixtureReader** is used to obtain and save the data to my database using JPA.
The database datasource is configured in the **application.properties** file.

After the data is set, the api allows for the following actions:

### Leagues (a specific season of a league):
/football/league/all - returns all available leagues 

### Team 
/football/teams/all - returns all teams
/football/teams/season/{seasonId} - returns all teams for a specific season
/football/team/{teamId} - returns a specific team

### fixtures
/football/fixture/season/{seasonId},{status} - All the fixtures of the season according to status.
    The status can be 0 - finished matches (default) , 2 - in progress.
/football/fixture/season/{seasonId}/team/{teamId} - All finished matches for the specified team for the specified season

### standings
/football/standing/season/{seasonId}/all - full standings for a season
/football/standing/season/{seasonId}/home - standings for home matches only
/football/standing/season/{seasonId}/away - standings for away matches only

More options will be added soon
