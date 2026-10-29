package com.abes.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DoctorRepository {

    private final JdbcTemplate jdbcTemplate;

    public DoctorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getStudentName(int id) {
        String sql = "SELECT name FROM Doctors WHERE id = ?";

        String name = jdbcTemplate.queryForObject(
                sql,
                String.class,
                id
        );
        return name;
    }


    public List<Doctors> getAllDoctors() {

        String sql = "SELECT id, name, age FROM Doctors";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Doctors(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age")
                )
        );
    }


    public int addDoctor(int id, String name, int age) {

        String sql = "INSERT INTO Doctors (id, name, age) VALUES (?, ?, ?)";

        int rows = jdbcTemplate.update(sql, id, name, age);

        return rows;
    }


    public int updateDoctor(int id, String name, int age) {

        String sql = "UPDATE Doctors SET name = ?, age = ? WHERE id = ?";

        return jdbcTemplate.update(sql, name, age, id);
    }



    public int deleteDoctor(int id) {
        String sql = "DELETE FROM Doctors WHERE id = ?";

        return jdbcTemplate.update(sql, id);
    }
}
