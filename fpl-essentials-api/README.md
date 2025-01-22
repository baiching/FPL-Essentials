# This is the backend of the system
It is divided into to main sections:
1. Development Section
2. Testing section

## Development Section
It is broken down into layers

- [controller](#Controllers)
- [Service](#Service)
- [Repository](#Repository)
- [Model](#model)


# Controller
*EmailController* \
sendEmail: allows to send emails with attachments

To get data from official REST api, there are many requests:
```
1. https://fantasy.premierleague.com/api/bootstrap-static/  - returns Overall data
2. https://fantasy.premierleague.com/api/fixtures/          - returns Fixtures with kickoff time and score
3. https://fantasy.premierleague.com/api/element-summary/19/ - returns data for specific player for current and upcomming gameweek
```

