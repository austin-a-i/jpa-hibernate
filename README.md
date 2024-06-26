# Spring JPA-Hibernate
This project is a sample implementation of the Spring Data JPA and Hibernate ORM framework showcasing different Spring eco-system together to implement a REST web service.

Project description
Spring Boot
Spring MVC
Spring Data JPA
Spring Data REST
Hibernate

-------------------------------------------------------------------------------

Spring Data JPA
The Spring Data repository mechanism is used to reduce the effort to implement persistence for the domain objects to the declaration of an interface per aggregate root. See ArtistRepository and AudienceRepository for example. Beyond that, using the repository abstract enables the Spring Data REST module to do its work.

Spring Data REST
We're using Spring Data REST to expose the AudienceRepository as REST resource without additional effort.


REST APIs
------------------------------

/artists

      Retrieve Artists details
      GET 
      http://localhost:8080/artists/
      http://localhost:8080/artists/{id}
      
      Create/Update Artist details
      POST
      http://localhost:8080/artists/
        JSON BODY : 
      {
        "Artist" : "",
        "place_of_origin" : ""
      }
      
      DELETE
      http://localhost:8080/artists/{id}

/songs

      Retrieve Song details
      GET 
      http://localhost:8080/songs/
      http://localhost:8080/songs/{id}
      http://localhost:8080/songs/artist/id/{artistId}
      http://localhost:8080/songs/artist/{artistName}


      Create/Update Song details
      POST
      http://localhost:8080/songs/
                JSON BODY : 
              {
                "songname" : "",
                "artist" : ""
              }

      PUT
      http://localhost:8080/songs/{id}
               JSON BODY : 
              {
                "songname" : "",
                "artist" : ""
              }
