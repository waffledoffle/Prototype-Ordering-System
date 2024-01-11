### Demonstrating Use Cases

Creating an order
```shell
curl -X POST -H "Content-Type: application/json" -d "{\"supplier\": \"Nvidia\", \"productName\": \"Laptop\", \"quantity\": 2, \"customerId\": 1}" http://localhost:8081/orders
```

Getting all orders
```shell
curl -X GET http://localhost:8081/orders
```

Getting an order by id
```shell
curl -X GET http://localhost:8081/orders/1
```

Updating an order by id
```shell
curl -X PUT -H "Content-Type: application/json" -d "{\"supplier\": \"AMD\", \"quantity\": 15, \"customerId\": 2}" http://localhost:8081/orders/1
```

Delete an order by id
```shell
curl -X DELETE http://localhost:8081/orders/1
```

Update an orders status to shipped 
```shell
curl -X PUT http://localhost:8081/orders/1/shipped
```

Allows a customer to update the status of an order to received
```shell
curl -X PUT http://localhost:8081/orders/1/received
```