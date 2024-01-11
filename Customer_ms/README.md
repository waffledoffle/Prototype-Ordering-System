### Demonstrating Use Cases for Customer

Creating a Customer
```shell
curl -X POST -H "Content-Type: application/json" -d "{\"companyName\": \"CSCI318\", \"address\": \"Joes house\", \"country\": \"Australia\", \"contact\": {\"name\": \"Joe\", \"phone\": 123456789, \"email\": \"joe@gmail.com\", \"position\": \"Student\"}}" http://localhost:8080/customers
```

Get all customers
```shell
curl http://localhost:8080/customers 
```

Get a customer by id
```shell
curl http://localhost:8080/customers/1
```

Updating a customer by id
```shell
curl -X PUT -H "Content-Type: application/json" -d "{\"companyName\": \"Cool Inc\", \"address\": \"Julies house\", \"country\": \"Russia\", \"contact\": {\"name\": \"Julie Mama\", \"phone\": 234567689, \"email\": \"julie@gmail.com\", \"position\": \"Mother\"}}" http://localhost:8080/customers/1
```

Update a customers company name
```shell
curl -X PUT -H "Content-Type: application/json" -d "Cool fellas" http://localhost:8080/customers/1/company
```

Update a customers address
```shell
curl -X PUT -H "Content-Type: application/json" -d "Cool house" http://localhost:8080/customers/1/address
```

Update a customers country
```shell
curl -X PUT -H "Content-Type: application/json" -d "Argentina" http://localhost:8080/customers/1/country
```

Update a customers contact information
```shell
curl -X PUT -H "Content-Type: application/json" -d "{\"name\": \"Coolie Mcool\", \"phone\": 111111111, \"email\": \"cool@gmail.com\", \"position\": \"Cool Kid\"}" http://localhost:8080/customers/1/contact
```

Delete a customer by id
```shell
curl -X DELETE http://localhost:8080/customers/1
```

Add an order to a customers list of orders
```shell
curl -X PUT -H "Content-Type: application/json" -d "4L" http://localhost:8080/customers/1/add
```

Get all customers orders
```shell
curl http://localhost:8080/customers/1/orders
```

remove an order from a customers list of orders
```shell
curl -X PUT -H "Content-Type: application/json" -d "1L" http://localhost:8080/customers/1/orderRemove
```