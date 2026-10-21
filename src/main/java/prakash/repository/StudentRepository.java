package prakash.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import prakash.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;
    private StudentRowMapper studentRowMapper=new StudentRowMapper();
   // private RowMapper<Student> rowMapper=new BeanPropertyRowMapper<>(Student.class);

    public StudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public void createStudent(Student student )  {
        String sql= """
                        INSERT INTO  STUDENT(name,email,age)
                        values(?,?,?)
                        """;
        int rowAffected=jdbcTemplate.update(sql,
                student.getName(), student.getEmail(), student.getAge()
        );
                        if(rowAffected==1){
                            System.out.println("create Student successfully");
                        }
                        else{
                            System.out.println("Create Student failed");
                        }

    }

    public void updateStudent(Student student,Long id){
        String sql="""
                UPDATE student
                set name=?,
                email=?,
                age=?
                where id=?
                """;
        int rowAffected =jdbcTemplate.update(sql,
                student.getName(),
                student.getEmail(),
                student.getAge(),
                id

                );
        if(rowAffected==1){
            System.out.println("Update operation successfully");
        }
        else {
            System.out.println("updation failed");
        }


    }

    public void deleteStudent(Long id){
        String sql= """
        DELETE from  student where id=?
""";
        int rowAffected=jdbcTemplate.update(sql,
id
                );
        if(rowAffected==1){
            System.out.println("Delete operation successfully");
        }
        else {
            System.out.println("Deleted failed");
        }

    }

    public Student  getStudentById(Long id){
        String sql= """
    SELECT  id,name,email,age FROM  student
    where id=?
""";
    return jdbcTemplate.queryForObject(sql,
            studentRowMapper,
            id

            );


    }

    public List<Student> getStudent(){

          String sql= """
    SELECT  id,name,email,age FROM  student
""";
          List<Student>students=jdbcTemplate.query(sql,studentRowMapper) ;
          return students;


    }





    






}
