package prakash.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prakash.model.Student;
import prakash.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    StudentService studentService;
    public  StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping
    public ResponseEntity<String>createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("Done");
    }
    @GetMapping
    public ResponseEntity<List<Student>>getAllStudents(){
        List<Student>students=studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student>getStudentById(@PathVariable("id") Long id){
        Student student=studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String>updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        student.setId(id);
        studentService.updateStudent(student);
        return ResponseEntity.ok("Done");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteStudent(@PathVariable("id") Long id){
       studentService.deleteStudent(id);
       return ResponseEntity.ok("Done");
    }




}
