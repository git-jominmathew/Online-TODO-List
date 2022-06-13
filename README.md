# Online-TODO-List
A simple online TODO list either supporting back-end or web interface that  can be used in all popular web browsers. The application storing necessary data in an in-memory database. Built with java 8+ and spring boot framework. For  The functionality below should be demonstrable through API testing (postman)

*local port : 9031
*H2 database console url:http://localhost:9031/h2

*To-Do Echo.postman_collection in projs\Online-TODO-List

*input json sample
{
"id": 1,
"task": "first task",
"done": false
}


Execution steps:

Navigate to project folder
Execute mvn clean install
Execute java -jar D:\projs\Online-TODO-List\project\todo\target\todo-0.0.1-SNAPSHOT.jar
Application should be up and running

import To-Do Echo.postman_collection to the postman

trigger get/save/update/delete functionalities

