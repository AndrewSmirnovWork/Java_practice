package ru.werdna.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.werdna.db.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersDaoiJdbcImpl implements UsersDao {
    private JdbcTemplate jdbcTemplate;
    //language=SQL
    private final String SQL_select_all = "SELECT * from fix_user";

    public UsersDaoiJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<User> findAllByFirstName(String firstName) {
        return null;
    }

    @Override
    public Optional<User> find(Integer id) {
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
    private RowMapper<User> userRowMapper = (resultSet, i) -> {
        new User(resultSet.getInt("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"));
        return null;
    };

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_select_all, userRowMapper);
    }
}
