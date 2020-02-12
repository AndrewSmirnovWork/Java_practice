package ru.werdna.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@WebServlet("/addUsers")

public class UsersServlet extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));

            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");

            Class.forName(driverClassName);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        try {/*
            Statement statement = connection.createStatement();
            String sqlInsert = "INSERT INTO fix_user(first_name, last_name)"
                    + "VALUES('"+ firstName + "','" + lastName + "');";
            statement.execute(sqlInsert);*/
            PreparedStatement preparedStatement = connection.prepareStatement("insert  into "+
                    "fix_user(firstName, lastName) VALUES (?, ?)");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/addUser.jsp").forward(req, resp);
    }
}
