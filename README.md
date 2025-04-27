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












