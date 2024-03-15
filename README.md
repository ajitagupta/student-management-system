# Student Management System
This is a student CRUD API project with JDBC connection to a MySQL 8.0 database. You can open it directly in an IDE like Eclipse. You will also have to run `sql.sql` in a SQL client like MySQL Workbench to have a database set up. The connection is built from within the code. So, in all:
1) Download [Eclipse](https://www.eclipse.org/downloads/)
2) Download a SQL client like [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
3) Run sql.sql
4) Start using our menu-driven app

## Pattern: Tree-package-structure

The code follows common convention of organizing itself in different subpackages, each for a different layer: `dao, db, main, and pojo`, whereby `com.example` is the parent of them all.

## JDBC Database Connection


## Pattern: Singleton


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

