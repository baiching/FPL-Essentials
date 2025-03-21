# This is the backend of the system
It is divided into to main sections:
1. [Development Section](#Development-Section)
2. [Testing section](#Testing-section)

## Development Section
It is broken down into layers
- [packages](#Packages)
- [controller](#Controllers)
- [Service](#Service)
- [Repository](#Repository)
- [Model](#model)

## Packages
**For src/main/java**
- `com.baiching.fpl_essentials.controller` : It contains the controllers
- `com.baiching.fpl_essentials.service` : It contains the services
- `com.baiching.fpl_essentials.repositor`y : It contains the repositories that is used to query through DB
- `com.baiching.fpl_essentials.model` : It contains the entities for DB
- `com.baiching.fpl_essentials.appconfig` : Mostly for scheduling classes
- `com.baiching.fpl_essentials.security` : It contains a small implementation of Spring Security
- `com.baiching.fpl_essentials.service` : Different Services that are used in the project or business logic

## controllers

*EmailController* \
sendEmail: allows to send emails with attachments

To get data from official REST api, there are many requests:
```
1. https://fantasy.premierleague.com/api/bootstrap-static/  - returns Overall data
2. https://fantasy.premierleague.com/api/fixtures/          - returns Fixtures with kickoff time and score
3. https://fantasy.premierleague.com/api/element-summary/19/ - returns data for specific player for current and upcomming gameweek
```

# Service

**FplDataServiceImpl**\
It implements *FplDataService* interface. The purpose of this service is to get data from API and save in the database.

Here, *getGameweekData()* method fetches the data from the FPL official API and returns in List<Gameweek> format.

*FplDataServiceTest* class tests if the the data is returned in the intended format or if it's empty

