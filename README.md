# cab-book-service

#####
Url end points
* Add User - POST 
```localhost:8080/user ```
* Get Users
```localhost:8080/users```
* Get Cabs
```localhost:8080/cabs```
* Add Cab - POST
```localhost:8080/cab ```
* Find Nearby Cabs - POST
```localhost:8080/find_rides ```
* Choose Ride - POST
``` localhost:8080/choose_ride ```


##### 
Json Inputs for controller end points
* Add User
```javascript
   {
        "name": "demo name 1",
        "gender": "M",
        "age": 25
}
```

* Add Cab Driver
```javascript
{
    "name": "driver 3",
    "gender": "M",
    "age": 23,
    "carDetails": "Swift, KA-01-12345",
    "location": {
        "x": 18,
        "y": 20
    }
}
```

* Find Nearby Cabs
```javascript
{
    "name": "Rahul",
    "start":{
        "x":10,
        "y":0
    },
    "end":{
        "x":15,
        "y":3
    }
}
```

* Choose Ride 
```javascript
{
    "userName": "Rahul",
    "cabDriverName": "Driver1"
}
```



#####
Tech Used

[![My Skills](https://skills.thijs.gg/icons?i=java,spring,idea&theme=light)](https://skills.thijs.gg)
