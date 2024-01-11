### Demonstrating Use Cases for product

Creating a Product
```shell
curl -X POST -H "Content-Type: application/json" -d "{\"productCategory\": \"Electronics\", \"name\": \"Laptop\", \"price\": 999.99, \"quantity\": 10, \"stock\": \"In stock\", \"details\": {\"description\": \"This is a laptop\", \"comment\": \"Just released!\"}}" http://localhost:8082/products
```

Get all products
```shell
curl http://localhost:8082/products
```

Get a product by name
```shell
curl http://localhost:8082/products/Laptop
```

Updating a product by name
```shell
curl -X PUT -H "Content-Type: application/json" -d "{\"productCategory\": \"Furniture\", \"price\": 120.50, \"quantity\": 2, \"details\": {\"description\": \"This is a leather couch\", \"comment\": \"Made with the finest snakeskin\"}}" http://localhost:8082/products/Laptop
```

Update a products category
```shell
curl -X PUT -H "Content-Type: application/json" -d "\"Electronics\"" http://localhost:8082/products/Laptop/category
```

Update a products price
```shell
curl -X PUT -H "Content-Type: application/json" -d 299.99 http://localhost:8082/products/Laptop/price
```

Update a products quantity
```shell
curl -X PUT -H "Content-Type: application/json" -d 2 http://localhost:8082/products/Laptop/quantity
```

Update a products details
```shell
curl -X PUT -H "Content-Type: application/json" -d "{\"description\": \"This is a monitor\", \"comment\": \"240Hz!!\"}" http://localhost:8082/products/Laptop/details
```

Delete a product by name
```shell
curl -X DELETE http://localhost:8082/products/Laptop
```

Check a product exists and has enough quantity
```shell
curl -X PUT -H "Content-Type: application/json" -d 2 http://localhost:8082/products/Laptop/check
```

Search for Products that start with a given string
```shell
curl http://localhost:8082/products/searchBy/La"
```
