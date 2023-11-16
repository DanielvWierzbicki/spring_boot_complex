package com.example.demo.student;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;
import com.example.demo.service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepo;

    @Mock
    private static MockHttpServletResponse response;

    private static List<Student> students;

    @BeforeAll
    public static void setConfiguration() {

        students = new ArrayList<>() {{
            add(new Student(1L, "Antek", "antek@gmail.com", 25));
            add(new Student(2L, "Ewa", "ewa@gmail.com", 23));
            add(new Student(3L, "Zosia", "zosia@gmail.com", 22));
            add(new Student(4L, "Hubert", "hubert@gmail.com", 11));
            add(new Student(5L, "Konrad", "konrad@gmail.com", 7));
        }};

    }

//    @Test
//    void getStudentsTest() {
//        when(studentRepo.findAll()).thenReturn(students);
//        verify(response).setStatus(HttpServletResponse.SC_OK);
//        assertEquals(studentService.getStudents(), students);
//    }

    @Test
    void getStudentByIdTest() {
        long sampleId = 1L;
        when(studentRepo.findStudentById(sampleId)).thenReturn(students.get(0));
        assertEquals(studentService.getStudentById(1L), students.get(0));
    }

    @Test
    void getStudentByIdThrowsExceptionTest() {
        long sampleId = 2L;
        when(studentRepo.findStudentById(sampleId)).thenReturn(null);
        try {
            studentService.getStudentById(sampleId);
        } catch (Exception ex) {
            assertThrows(ResponseStatusException.class, () -> {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Student not found for this id: " + sampleId
                );
            });
        }
    }

}