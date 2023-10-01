package vn.edu.iuh.daos;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

public abstract class AsbtractDao<T, ID> {
    private DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    public AsbtractDao(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public abstract void add(T t);
    public abstract void update(T t);
    public abstract void delete(ID id);
    public abstract T getById(ID id);
    public abstract List<T> getAll();
}
