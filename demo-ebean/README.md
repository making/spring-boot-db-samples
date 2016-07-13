Get all pizza

``` console
curl localhost:8080
```

Add a pizza

``` console
curl -d '{"name" : "Spring Pizza", "price" : 1200, "toppings" : [{"id" : 3}, {"id" : 10}], "base" : {"id" : "2"}}' -H 'Content-Type: application/json' localhost:8080
```