# Simple CRUD application with Spring and MongoDb

## this is still a work in progress.

To run this application, make sure mongodb is installed.   
1. In the terminal start mongodb: (sudo) systemctl start mongod 
2. In Ide run `SpringBootApplicationWithMongoApplication.java` (sometimes it fails on the first run. Quick fix -> run again)  
3. In postman or web browser go to http://localhost:8080/wines to see a pre filled dataset.  
    a. See ```WineController.java``` for all end points.
    b. search by name:  `localhost:8080/names?name=On` will return Ontanon.
    c. to add a wine create a post request via: `http://localhost:8080/wines/new`  
        in the body paste this new wine:  
        ```
        {
                "year": 2011,  
                "price": 22,  
                "wineMaker": {  
                    "name": "Johnnie",  
                    "nationality": "American",  
                    "age": 28  
                },  
                "reviews": [  
                    {  
                        "user": "Dmtri",  
                        "rating": 6,  
                        "approved": true  
                    }  
                ],  
                "avReview": 6,  
                "name": "Screaming Eagle"  
            }  
        ```
4. Sometimes the test fail. Quick fix -> comment out all content in applications.properties.
