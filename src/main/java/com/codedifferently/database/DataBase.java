package com.codedifferently.database;

import com.codedifferently.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Logger;

public class DataBase {
    private static final Logger logger = Logger.getGlobal();
    private Connection connection;

    private void getConnection() throws DataBaseConnectionException {
        try{
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/addressbook?createDatabaseIfNotExist=true&useSSL=false", "developer01", "pass");
            connection.setAutoCommit(false);
            logger.info("Successful Connection");

        }catch (Exception e) {
            logger.warning(e.getMessage());
            throw new DataBaseConnectionException();
        }
    }

    public DataBase() throws DataBaseConnectionException {
        getConnection();
    }

    //INSERT INTO PERSON (id, first_name, last_name, email, age) VALUES ('IDTBD', 'Tariq', 'Hook', tariq.hook@gmail.com, 42)

    public void insertNewPerson(Person person) throws DataBaseConnectionException{
        try{
            String insertCommand = "INSERT INTO PERSON VALUES ( '%s', '%s', '%s', '%s', %d)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format(insertCommand, person.getId(), person.getFirstName(), person.getLastName(), person.getEmail(), person.getAge()));
            connection.commit();

        }catch (Exception e) {
            logger.warning(e.getMessage());
            throw new DataBaseConnectionException();
        }
    }
}
