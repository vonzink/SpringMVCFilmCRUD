## Description

Our team of three worked together to build a web application that implements Create, Read, Update, Delete (CRUD) functionality using the DAO pattern in Spring Tools for Eclipse.
Our DAO implementation uses JDBC to persist and retrieve data from a local MySQL database and an Apache web server to present it to the user in a browser.

## Functionality

- Search film database with a film’s ID or by keyword.
- Create, Read, Update, Delete (CRUD) film information in a browser.

## Running the Program

- Import the project into Spring Tools for Eclipse.
- Run MySQL locally with the `sdvid` database (uses standard student credentials).
- **Run As > Run on Server** to present the web interface in a browser.

## Entities

- **FilmController**: Request handler methods
- **FilmDAO**: Defines database methods
- **FilmDaoJdbcImpl**: Implements DAO interface
- **Film**: Film object
- **Actor**: Actor object
## Lessons Learned

- **DAO pattern** provides a way to handle database operations.
- **Spring MVC** offers helpful web application functionality through annotations such as `@Controller`, `@Autowired`, `@RequestMapping`.
- **Transactions** in the JDBC Implementation help ensure correctness in DB operations (including commit on success or rollback in case of error).
- **Bootstrap** library provides user interface components that enhance the presentation of web pages.
- **JSTL** integrates with Expression Language (EL), allowing access to data stored in Java classes directly within JSP pages.
- **Java Server Pages (JSP)** along with the **Java Standard Tag Library (JSTL)** enable data processing, conditional execution, database access, and loops between the backend and frontend of a web application.

## Technologies Used

- JavaSE 21.0.6
- Spring MVC
- Java Database Connectivity (JDBC)
- MySQL
- Bootstrap
- HTML/CSS
- Spring Tools for Eclipse IDE
- Gradle

## Team (Alphabetical Order)

- Michael Francavilla [@ColoradoMF](https://github.com/ColoradoMF)
- Michel Okello Mukua
- Zachary Zink
9:06
See you about noon in the zoom room. :+1:
9:07
ChatGPT polished it up a bit:# SpringMVCFilmCRUD
![Java](https://img.shields.io/badge/Java-21.0.6-blue.svg)
![Spring MVC](https://img.shields.io/badge/Spring%20MVC-Framework-brightgreen.svg)
![MySQL](https://img.shields.io/badge/MySQL-Database-orange.svg)
![Gradle](https://img.shields.io/badge/Gradle-Build%20Tool-02303A.svg)
![Bootstrap](https://img.shields.io/badge/Bootstrap-Frontend-purple.svg)
---
## Description

Our team of three collaborated to build a web application implementing full Create, Read, Update, and Delete (CRUD) functionality using the DAO pattern in Spring Tools for Eclipse.
The DAO implementation uses JDBC to persist and retrieve data from a local MySQL database, and an Apache web server presents the application to users in a browser.
---
## Functionality

- Search the film database by film ID or keyword.
- Create, Read, Update, and Delete (CRUD) film information directly in a browser.
---
## Running the Program

1. Import the project into **Spring Tools for Eclipse**.
2. Run **MySQL** locally with the `sdvid` database (uses standard student credentials).
3. Use **Run As > Run on Server** to launch the web interface in a browser.
---
## Entities

- **FilmController** — Handles web requests.
- **FilmDAO** — Defines database access methods.
- **FilmDaoJdbcImpl** — Implements the DAO interface using JDBC.
- **Film** — Represents a film entity.
- **Actor** — Represents an actor entity.
---
## Lessons Learned

- **DAO Pattern** provides a clean structure for managing database operations.
- **Spring MVC** enables powerful web functionality through annotations like `@Controller`, `@Autowired`, and `@RequestMapping`.
- **Transactions** in JDBC ensure data correctness (commit on success, rollback on failure).
- **Bootstrap** enhances the user interface with pre-built, responsive components.
- **JSTL (JavaServer Pages Standard Tag Library)** integrates with **Expression Language (EL)** for simplified dynamic content handling within JSP pages.
- **Java Server Pages (JSP)** combined with **JSTL** allow efficient backend-to-frontend data processing, including conditional logic and looping.
---
## Technologies Used

- Java SE 21.0.6
- Spring MVC
- Java Database Connectivity (JDBC)
- MySQL
- Bootstrap
- HTML/CSS
- Spring Tools for Eclipse (IDE)
- Gradle
---
## Team (Alphabetical Order)

- [Michael Francavilla](https://github.com/ColoradoMF)
- Michel Okello Mukua
- Zachary Zink











