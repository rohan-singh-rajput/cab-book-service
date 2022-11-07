# cab-book-service

#####


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
