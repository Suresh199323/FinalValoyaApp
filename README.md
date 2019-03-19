# JWT-Zuul-Docker-Boot-Angular7-Ribbon

this project is made using angular7, spring boot frameworks.

config server is used for centralized configuration  for microservices

here have used jwt authentication and authorization.

zuul is used for centralized routing ,every request will hit zuul api gateway, i have configured authorizaton in zuul and authentication 
in login microservice.

every request which is containing /auth like localhost:2222/auth/ will go to login service.

cros has been set in RequsestFilter for angular application.
