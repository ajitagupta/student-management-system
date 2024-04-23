# Student Management System
This is a student CRUD API project with JDBC connection to a MySQL 8.0 database. To get started, execute the following:

1) Download [Eclipse](https://www.eclipse.org/downloads/)
2) Download a SQL client like [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
3) Run sql.sql to set up a database
4) Start using our menu-driven app

## Pattern: Tree-package-structure

Packages should be cohesive collections of classes. That would minimize coupling between classes that should not be coupled because they pertain to different features. In the package-by-layer approach, packages have high cohesion and a low degree of coupling between packages. 

Our code follows common convention of organizing itself in different subpackages, each for a different child-layer: `dao, db, main, and pojo`, whereby `com.example` is the parent of them all. Hence, the name tree structure.

![Tree-package-structure](https://i.ibb.co/7p9N5Lc/tree-package-structure.png "Tree-package-structure")


## Database Connection with JDBC

JDBC (Java Database Connectivity) is the Java API that manages connecting to a database, issuing queries and commands, and handling result sets obtained from the database.

The steps for connecting to a database with JDBC are as follows:

1. Install or locate the database you want to access.
2. Include the JDBC library.
3. Ensure the JDBC driver you need is on your classpath.
4. Use the JDBC library to obtain a connection to the database.
5. Use the connection to issue SQL commands.
6. Close the connection when you are finished.


As a developer, you can use JDBC to interact with a database from within a Java program. JDBC acts as a bridge from your code to the database. JDBC is the common API that your application code interacts with. Beneath that is the JDBC-compliant driver for the database you are using as shown in the figure below:

![JDBC](https://i.ibb.co/pZPSnYD/what-is-jdbc-fig2-100927560-large.webp "JDBC")

Source: InfoWorld

While JDBC is sufficient for simpler applications, most developers will eventually look to the Jakarta Persistence API (formerly the Java Persistence API) to develop a more formal data access layer.

## Pattern: Singleton

There are many objects we only need one of: thread pools, caches, dialog boxes, objects that handle preferences and registry settings, objects used for logging, and objects that act as device drivers to devices like printers and graphics cards. In fact, for many of these types of objects, if we were to instantiate more than one we'd run into all sorts of problems like incorrect program behavior, overuse of resources, or inconsistent results.

<blockquote>
The Singleton Pattern ensures a class has only one instance, and provides a global point of access to it. Whenever you need an instance, just query the class and it will hand you back the single instance.
</blockquote>

[*Head First Design Patterns*](https://www.oreilly.com/library/view/head-first-design/9781492077992/)

In short, a Singleton is a one-of-a-kind object for which only one instance is required. Following this best practice we put all our database code into one class. The so-called resulting *Singleton* class `CP.java` is as follows:

```
public class CP {

	static Connection conn;
	
	public static Connection createc() throws SQLException {
		
		//load driver class
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/studentdata";
			
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		return conn;
		
		
	}
	
}
```

Here, we execute an SQL query using `PreparedStatement` and SQL-argument-placeholders. Since this action has to be repeated at many occasions (CRUD) it makes sense to place the code inside a Singleton.

## Pattern: Data Access Object (DAO)

The DAO is responsible for interfacing with the database. It implements methods for saving/retrieving/deleting entities.

## Pattern: POJO Class

To enable mapping between Java code and database we create a Plain Old Object Class (POJO). For each table there is a corresponding POJO class. This is the convention.

For our case we just need one Student POJO since we have only one table `students` in our database. It contains a default and a parameterized constructor, getter / setter methods, and a toString method.

## Screenshots

### (C)reate

#### Eclipse Console
![Create function](https://i.ibb.co/thHQK8B/Add.png "Create function")

#### MySQL Workbench
![New record inside MySQL database](https://i.ibb.co/L1jm3Gg/database.png "New record inside MySQL database")

### (R)ead

#### Eclipse Console
![Read function](https://i.ibb.co/7VW6Zmj/Display.png "Read function")


### (U)pdate

#### Eclipse Console
![Update function](https://i.ibb.co/PrT6xzK/Update.png "Update function")

#### MySQL Workbench
![Updated record inside MySQL database](https://i.ibb.co/gmhBBC8/database-updated.png "Updated record inside MySQL database")


### (D)elete

#### Eclipse Console
![Delete function](https://i.ibb.co/CJVqmq1/Delete.png "Delete function")

#### MySQL Workbench
![Empty MySQL database](https://i.ibb.co/BjB9jY0/database-entrydeleted.png "Empty MySQL database")

