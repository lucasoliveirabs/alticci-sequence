Hello! This project is part of 'Alticci sequence' challenge. To check it out:  
- install [docker runtime engine](https://docs.docker.com/engine/install/) according to your OS 
- run `docker run -d --name alticci-sequence-client -p 8099:80 lucasoliveirabs/alticci-sequence-client`
- run `docker run -d --name alticci-sequence-api -p 8080:8080 lucasoliveirabs/alticci-sequence-api`
- go to [localhost](http://localhost:8099/) and test the solution
- [local API documentation](http://localhost:8080/swagger-ui/index.html)