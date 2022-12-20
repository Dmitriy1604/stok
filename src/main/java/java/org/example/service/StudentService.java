package java.org.example.service;

import org.example.model.Student;

public interface StudentService {
    Student addStudent(Student student);

    Student findStudent(long id);

    Student editStudent(long id,Student student);

    void deleteStudent(long id);
}
