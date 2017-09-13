# bank-app

1. Application requires:
- Java 1.8
- Gradle > 3.0
- Mysql > 5.5

2. Steps to run an application

- create a database using this small script or manualy:
  
  create database bank;
  
- Application uses default MySQL configuration:
  
  - port = 3306
  - username = root
  - password = root
  
  If these are different in your MySQL configuration, be sure to change
  them in appplication.properties file.
  
- run 'gradle bootRun' in a command line or using your IDE built-in gradle 
tasks. 

- application starts at 

  http://localhost:8000/customers

  