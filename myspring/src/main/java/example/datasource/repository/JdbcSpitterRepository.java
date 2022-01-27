package example.datasource.repository;

import example.datasource.entity.Spitter;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class JdbcSpitterRepository implements SpitterRepository {

    private JdbcOperations jdbcOperations;

    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private NamedParameterJdbcOperations namedParameterJdbcOperations;

    public JdbcSpitterRepository(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public Spitter findOne(long id) {
        String sql = "select id, username, password from spitter where id = ?";

        Spitter spitter = jdbcOperations.queryForObject(sql, new SpitterRowMapper(), id);

        // 使用lambda表达式
        spitter = jdbcOperations.queryForObject(
                sql,
                (rs, rownum) -> new Spitter(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password")),
                id);

        // 方法引用
        spitter = jdbcOperations.queryForObject(sql, this::mapSpitter, id);

        return spitter;
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {

        @Override
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("password"));
        }

    }

    private Spitter mapSpitter(ResultSet rs, int rowNum) throws SQLException {
        return new Spitter(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"));
    }

    @Override
    public void addSpitter(Spitter spitter) {
        String sql = "insert into spitter " +
                "  (id, username, password)" +
                "values " +
                "  (:id, :username, :password)";

        Map<String, Object> paramMap = new HashMap<String, Object>(4);
        paramMap.put("id", spitter.getId());
        paramMap.put("username", spitter.getUsername());
        paramMap.put("password", spitter.getPassword());
        namedParameterJdbcOperations.update(sql, paramMap);
    }

}
