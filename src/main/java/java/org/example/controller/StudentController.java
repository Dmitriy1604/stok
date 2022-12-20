package java.org.example.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
@GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id){
        Student student = studentService.findStudent(id);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
}
public Student createStudent(@RequestBody Student student){
        return studentService.addStudent(student);
}
    @GetMapping("{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Student student,@PathVariable Long id){
       Student foundStudent = studentService.editStudent(id,student);
       if(foundStudent == null){
           return ResponseEntity.status( HttpStatus.BAD_REQUEST).build();
       }
       return ResponseEntity.ok(foundStudent);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
