package vn.edu.iuh.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.entities.Candidate;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CandidateDao extends AsbtractDao<Candidate, Long> {

    public CandidateDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void add(Candidate candidate) {
        String sql = "insert into Candidate values(?,?,?,?,?)";
        jdbcTemplate.update(sql, candidate.getId(), candidate.getName(), candidate.getEmail(), candidate.getPhone(), candidate.getAddress());
    }

    @Override
    public void update(Candidate candidate) {
        String sql = "update Candidate c set name=?, email=?, phone=?, address=?";
        jdbcTemplate.update(sql,candidate.getName(), candidate.getEmail(), candidate.getPhone(), candidate.getAddress());
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Candidate getById(Long id) {
        String sql = "select * from Candidate where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Candidate.class),
                id);
    }

    @Override
    public List<Candidate> getAll() {
        return jdbcTemplate.queryForList("select * from Candidate", Candidate.class);
    }
}
