package prakash;


import prakash.model.Student;
import prakash.repository.StudentRepository;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) throws SQLException {
        System.out.println("JBC start ho raha hai");
      StudentRepository studentRepository=new StudentRepository();
    // studentRepository.createStudent(new Student("Ramesh","rk847409@gmail.com",25));
      //studentRepository.updateStudent(new Student("sohan","sohan@gamil.com",24),4L);

     // studentRepository.deleteStudent(4L);

      //studentRepository.getStudentById(1L);
      studentRepository.getStudent();

        // jdbc:mysql://localhost:3306/

    }
}
