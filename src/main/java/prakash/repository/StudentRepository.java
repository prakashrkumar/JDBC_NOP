package prakash.repository;

import prakash.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    String url="jdbc:mysql://localhost:3306/student_db";
    String username="root";
    String password="Prakashr@0234";

    public void createStudent(Student student)  {
        String sql= """
                        INSERT INTO  STUDENT(name,email,age)
                        values(?,?,?)
                        """;
        try( Connection  connection=DriverManager.getConnection(url,username,password);
             PreparedStatement  preparedStatement=connection.prepareStatement(sql)){


     preparedStatement.setString(1,student.name());
     preparedStatement.setString(2,student.email());
     preparedStatement.setInt(3,student.age());

     int rowAffected =preparedStatement.executeUpdate();
     if(rowAffected==1 ){
         System.out.println("create Student Successfully");
     }
     else {
         System.out.println("create Student faield");
     }




        } catch (SQLException e) {
            System.out.println("Db connection failed");
            e.printStackTrace();
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
        try( Connection connection=DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);){
            preparedStatement.setString(1,student.name());
            preparedStatement.setString(2,student.email());
            preparedStatement.setInt(3,student.age());
            preparedStatement.setLong(4,id);

    int rowAffected=preparedStatement.executeUpdate();


            if(rowAffected==1){
                System.out.println("upade student successfully");
            }else{
                System.out.println("creation faield");

            }




        } catch (SQLException e) {
            System.out.println("Db connection failed");
            e.printStackTrace();
        }

    }

    public void deleteStudent(Long id){
        String sql= """
        DELETE from  student where id=?
""";
        try(  Connection connection=DriverManager.getConnection(url,username,password);
              PreparedStatement preparedStatement=connection.prepareStatement(sql);){

            preparedStatement.setLong(1,id);


            int rowAffected=   preparedStatement.executeUpdate();
            if(rowAffected==1){
                System.out.println("Deleted student successfully");
            }else{
                System.out.println("Deleted faield");

            }

        } catch (SQLException e) {
            System.out.println("Db connection failed");
            e.printStackTrace();
        }
    }

    public void getStudentById(Long id){
        String sql= """
    SELECT  id,name,email,age FROM  student
    where id=?
""";
        try(  Connection connection=DriverManager.getConnection(url,username,password);
              PreparedStatement preparedStatement =connection.prepareStatement(sql);){
            preparedStatement.setLong(1,id);


          try( ResultSet resultSet =   preparedStatement.executeQuery();){
              if(  resultSet.next()) {
                  Student student=mapRow(resultSet);
                  System.out.println(student);

              }


          }

        } catch (SQLException e) {
            System.out.println("Db connection failed");
            e.printStackTrace();
        }


    }

    public void getStudent(){
        String sql= """
    SELECT  id,name,email,age FROM  student
""";
        try(  Connection connection=DriverManager.getConnection(url,username,password);
              PreparedStatement preparedStatement =connection.prepareStatement(sql);){
            try( ResultSet resultSet =   preparedStatement.executeQuery();){
                List<Student>studentList=new ArrayList<>();
                while(  resultSet.next()) {
                    Student student=mapRow(resultSet);
                    studentList.add(student);
                    System.out.println(student);

                }


            }

        } catch (SQLException e) {
            System.out.println("Db connection failed");
            e.printStackTrace();
        }


    }
public  void completeCURD(){
    String sql="SELECT id,name,email,age FROM student WHERE id=1";
    try (Connection connection=DriverManager.getConnection(url,username,password);
         Statement statement=connection.createStatement();
         ResultSet resultSet=statement.executeQuery(sql)) {
        if(resultSet.next()){
            System.out.println(mapRow(resultSet));
        }
    } catch (SQLException e) {
        System.out.println("Db connection failed");
        e.printStackTrace();
    }

}


private  Student mapRow(ResultSet resultSet) throws SQLException{
    Student student=new Student();
    student.setId(resultSet.getLong("id"));
    student.setName(resultSet.getString("name"));
    student.setEmail(resultSet.getString("email"));
    student.setAge(resultSet.getInt("age"));
    return student;
}



}
