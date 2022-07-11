## Article Search Application

### Endpoints
| method  | url | action |
| ------------- | ------------- |------------- |
| GET  |  http://localhost:8090/api/search |Simple search by article content|
| GET  | http://localhost:8090/api/search/detailed  |Detailed search by article content|


### Build an executable JAR and run the application

If you use Maven, you can run the application by

`./mvnw spring-boot:run`

Alternatively, you can build the JAR file and then run the JAR file, as follows:

    .mvn clean package 
    java -jar target/article-service-1.0.0.jar

### Call the endpoints

Now, the application is up, please open a terminal window and run the commands below

* Simple search by an article content. Example : "tips"

`curl 'http://localhost:8090/api/search?title=tips'`

***result*** :
```[
  {
    "hours": 1,
    "title": "Quick tips: introduction to asthma"
  },
  {
    "hours": 2.5,
    "title": "Quick tips: proning in critical care"
  },
  {
    "hours": 3,
    "title": "Quick tips: introduction to asthma"
  }
]
```

*  Detailed search by an article content. Example :  "tips"

`curl 'http://localhost:8090/api/search/detailed?title=tips'`

***result*** :
```{
  "totalHours": 6.5,
  "articles": [
    {
      "hours": 1,
      "title": "Quick tips: introduction to asthma"
    },
    {
      "hours": 2.5,
      "title": "Quick tips: proning in critical care"
    },
    {
      "hours": 3,
      "title": "Quick tips: introduction to asthma"
    }
  ]
}
```
