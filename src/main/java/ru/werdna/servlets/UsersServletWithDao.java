package ru.werdna.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.werdna.dao.UsersDao;
import ru.werdna.dao.UsesDaoImpl;
import ru.werdna.db.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

@WebServlet("/users")
public class UsersServletWithDao extends HttpServlet {
    private UsersDao usersDao;

    @Override
    public void init() throws ServletException {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        Properties properties = new Properties();

        try {

            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");

            dataSource.setUsername(dbUser);
            dataSource.setPassword(dbPassword);
            dataSource.setUrl(dbUrl);
            dataSource.setDriverClassName(driverClassName);

            usersDao = new UsesDaoImpl(dataSource);

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usersDao.findAll();
        req.setAttribute("usersFromServer", users);
        req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
    }
}
