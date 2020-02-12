package ru.werdna.dao;

import ru.werdna.db.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsesDaoImpl implements UsersDao {
    //language=SQL
    private final String SQL_select_all = "SELECT * from fix_user";
    //language=SQL
    private final String SQL_select_by_id = "SELECT * from fix_user where id=?";
    private Connection connection;

    public UsesDaoImpl(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    @Override
    public List<User> findAllByFirstName(String firstName) {
        return null;
    }

    @Override
    public Optional<User> find(Integer id) {

        try {
            PreparedStatement statement = connection.prepareStatement(SQL_select_by_id);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                return Optional.of(new User(id, firstName, lastName));
            }            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_select_all);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                User user = new User(id, firstName, lastName);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
