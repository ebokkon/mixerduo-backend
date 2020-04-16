Java Spring boot backend for mixerduo project

Project Description

Do you fancy a cocktail, but do not fancy going out to bars? 
Or is it someone's birthday and you want to do something special for them?
Or maybe you are looking for a new hobby to take on?

Look no further! This web application is made for you: you can browse cocktails' database and learn how to make them in the comfort of your home.

Project Technologies and resources

Data resource is provided by the https://www.thecocktaildb.com/ API.

This project backend is built in Java Spring Boot framework with microservices architecture. The discovery service is provided by Eureka and the application has an API entry point, the apigateway, which is integrated with Spring Security. 
The application uses Postgresql relational database and the ORM is managed with Hibernate.

Application endpoints:

/auth/sign_up - register user
/auth/sign_in - check login credentails
/cocktails - provides a list of all the cocktails of the database
/cocktails/id - provides a description of the cocktail with the 'id'
/get-cart - provides user their shoppingcart
/add - adds item to cart for specific user
/increase - increases quantity in cart of a user
/decrease - decreases quantity in cart of a user
/remove - removes item from cart of a user
/users - only with admin role, provides a list of all the users and their available shoppingcarts
   
Implemented functionalites:

-browse cocktails
-search cocktail
-get descrpition of a cocktail
-register user
-login user
-login admin role user
-course listing
-add courses to shoppingcart
-edit shoppingcart
-proceed to checkout

Unfinished functionality:
-payment for purchasing courses   
   
   