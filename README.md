# Blog API

API Rest to manage data of Blog WebApplication persisted in MS Sql server database.

## Changelog

### 0.1-SNAPSHOT - 2020/08/14

**Added**
- Author Controller with endpoints: listAll (GET) and getAuthorById(GET)
- MS SQL server Database conenction
- commons-library implementation

## Environment

Required environment variables to correct excecution:

```
API_PORT=mainport
API_HOST=hostname
API_NAME=blog-api
MANAGEMENT_PORT=secondaryport
SQL_URL=jdbc:sqlserver://localhost\
databaseName=database;
SQL_USR=user
SQL_PWD=password
```