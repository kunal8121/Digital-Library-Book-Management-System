-----------------------------------------Digital Library Book Management System------------------------------------

------------Project Overview------------

The Digital Library Book Management System is a RESTful API built using Spring Boot and MySQL. It allows librarian to manage books by providing functionalities to add, update, search, and delete books.

Features

1.View all books
2.Add a new book
3.Search for a book by ID or title
4.Update book details
5.Delete a book

-------Technologies Used--------

1.Java (Spring Boot)
2.MySQL (Database)
3.Spring Data JPA (ORM)
4.Maven (Build tool)
5.Railway (Deployment)

------Setup Instructions-------

Prerequisites

1.Install Java 17+
2.Install Maven
3.Install MySQL


------Steps to Run Locally-------

1.Clone the repository
         -->  git clone <repository-url>
         -->  cd Digital-Library-Book-Management-System

2.Configure MySQL Database

  * Create a database named digital_library
  * Update application.properties with your MySQL credentials:
        --> spring.datasource.url=jdbc:mysql://localhost:3306/digital_library
        --> spring.datasource.username=root
        --> spring.datasource.password=yourpassword

3.Build and Run the Application

   --> mvn clean install
   --> mvn spring-boot:run


-------API Endpoints-----

GET  -  /digital-library/getAllBooks                     //  Retrieve all books

POST  -  /digital-library/addBook                       //   Add a new book

GET   -  /digital-library/searchBookById/{bookId}       //    Retrieve a book by ID

GET   -  /digital-library/searchBookByTitle/{title}     //    Retrieve a book by title

PUT   -  /digital-library/updateBookById/{bookId}       //    Update a book by ID

DELETE -  /digital-library/deleteBookById/{bookId}      //    Delete a book by ID


----------Deployment------------

This application is deployed on Railway.app. You can access it at :    digital-library-book-management-production-9c31.up.railway.app


------------To use the API, append the required endpoint to the above URL. For example:

-->  To retrieve all books: https://digital-library-book-management-production-9c31.up.railway.app/digital-library/getAllBooks

-->  To search for a book by ID: https://digital-library-book-management-production-9c31.up.railway.app/digital-library/searchBookById/{bookId}

--------------Challenges Faced------------

--> Handling Exceptions: Initially, error handling was not structured well. We added proper exception handling to provide meaningful error messages.

--> Database Connection Issues: Faced multiple challenges with MySQL connectivity, such as incorrect credentials and database schema mismatches, which required careful debugging and configuration updates.

--> Deployment Issues: Encountered errors while deploying on Railway.app, particularly with environment variable misconfiguration and ensuring the application starts correctly in a cloud environment.

--> Endpoint Testing: Ensuring API endpoints function correctly in different environments required rigorous testing using tools like Postman and integration testing in Spring Boot.

--> Performance Optimization: Initially, database queries were slow, so indexing and query optimization techniques were applied to improve retrieval speed.


------------Future Improvements---------------

--> Implement Swagger API Documentation for better developer experience.

--> Add User Authentication (JWT-based security) to restrict unauthorized access.

--> Use PostgreSQL instead of MySQL for better scalability and cloud compatibility.

--> Create a Frontend UI using React or Angular to provide an intuitive interface for users.

--> Implement Caching Mechanisms like Redis to improve response times for frequently accessed data.
