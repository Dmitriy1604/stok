package java.org.example.service;

import org.example.model.Faculty;

public interface FacultyService {
    Faculty addFaculty(Faculty student);

    Faculty findFaculty(long id);

    Faculty editFaculty(long id, Faculty student);

    void deleteFaculty(long id);
}
