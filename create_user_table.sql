/*
 * This is an SQL script used to create User table in the database server with the information
 * specified in src/main/resources/application.properties file.
 * 
 * If such database does not exist, either edit the datasource information to the one most
 * convenient for your access, or get MySQL and start a server with the given user, database, and table.
 * 
 * To make sure that auto-increment increments by 1 always, you can use this command on mysql shell:
 * SET @@auto_increment_increment=1;
 */
CREATE TABLE User(
   ID   INT NOT NULL AUTO_INCREMENT,
   NAME VARCHAR(64) NOT NULL,
   EMAIL VARCHAR(64) NOT NULL,
   PRIMARY KEY (ID)
);