# YTW Project API Maven repo
This is the repository containing the Maven/Java Sping boot project that makes up my YTW project API.

---

### Connecting to the database
- You can connect to your mysql server by either by the command line or by mySQLWorkbench.
- To run the application locally you will have to create an application.yml to connect to the DB

### Using the terminal
Connect to your MySQL server from the command line using the following command containing your unique host, username and password credentials.

    $ mysql -h `host` -u `user` -p `password`

Create an empty database and use it. You then can import the given database.sql file found in the github repository by running:

    $ mysql source /path/to/database.sql;
    

### Using MySQLWorkbench
Launch MySQLWorkbench and click the "+" symbol in the "MySQLConnections" tab to add a new connection. Enter a name for the connection in the "Connection Name" field. 

Select "Standard (TCIP/IP)" as the "Connection Type".

Enter your `host` in the "Hostname" field.

Specify the "Username" as your `user` credential.

Enter your `password` by clicking the Store in Keychain button beside "Password".

Once connected to the database go to Data Import/Restore. Choose the option Import from Self-Contained File and select the database.sql file.


