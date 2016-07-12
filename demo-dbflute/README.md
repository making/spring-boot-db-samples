Get all pizza

``` console
curl localhost:8080
```

Add a pizza

``` console
curl -d '{"name" : "Spring Pizza", "price" : 1200, "toppings" : [{"id" : 3}, {"id" : 10}], "base" : {"id" : "2"}}' -H 'Content-Type: application/json' localhost:8080
```

How to generate classes by DBFlute  

1. download DBFlute Engine  
```
mvn dbflute:download
```
2. create DBFlute Client  
```
mvn dbflute:create-client
```
(DBFlute Client and DBFlute Engine are git-ignored in this project for repository size so needed here)  
3. copy SQLs in data.sql and schems.sql to replace-schema.sql for ReplaceSchema  
```
cat src/main/resources/schema.sql >> dbflute_pizzadb/playsql/replace-schema.sql
cat src/main/resources/data.sql >> dbflute_pizzadb/playsql/replace-schema.sql
```
4. sh manage.sh (at dbflute_pizzadb) and execute ReplaceSchema to create a DB  
```
demo-dbflute
 |-dbflute_pizzadb
 |-mydbflute
 |  |-dbflute-1.1.1
 |  |-h2database
 |     |-pizzadb.mv.db // *created here
```
5. sh manage.sh (at dbflute_pizzadb) and execute Regenerate to generate classes and documents
```  
demo-dbflute
 |-src/main/java
 |  |-com.example
 |  |  |-dbflute // *generated here
 |  |  |  |-allcommon
 |  |  |  |-bsbhv
 |  |  |  |-...
 |  |  |-DemoDBFluteApplication
 |  |  |-PizzaController
 |  |  |-PizzaRepository
 |  |-...
 |
 |-dbflute_pizzadb
 |  |-dfprop
 |  |-output
 |  |  |-doc
 |  |  |  |-schema-pizzadb.html // *generated here
 |
 |-...
```

How to collaborate with DBFlute classes in Spring Framework

1. import the auto-generated DBFluteBeansJavaConfig class at the application class
```
@SpringBootApplication
@Import(DBFluteBeansJavaConfig.class) // *here
public class DemoDBFluteApplication {
```
2. add a logging level setting for 'org.dbflute' to the application.properties to show SQL logs as DEBUG
```
logging.level.org.dbflute=DEBUG
```
