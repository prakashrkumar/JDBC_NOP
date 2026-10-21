package prakash.service;

import org.springframework.stereotype.Service;
import prakash.model.Student;
import prakash.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
   StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public void createStudent(Student student){
        studentRepository.createStudent(student);

    }
    public List<Student>getAllStudents(){
        return studentRepository.getStudent();
    }
    public void updateStudent(Student student){
        studentRepository.updateStudent(student,student.id());
    }
    public Student getStudentById(Long id){
      return   studentRepository.getStudentById(id);

    }
    public void deleteStudent(Long id){
        studentRepository.deleteStudent(id);
    }




}
