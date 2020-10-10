package com.demo.SpringbootCassandra;

import com.demo.SpringbootCassandra.models.Student;
import com.demo.SpringbootCassandra.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    public void createEntityTest(){
        Student student=new Student();
        student.setFirstName("John");
        student.setLastName("Last");
        student.setId(461243);

        studentRepository.save(student);
        assertNotNull(studentRepository.findById(student.getId()));
        Student fetchedStudent = studentRepository.findById(student.getId()).get();
        assertEquals(student.getId(),fetchedStudent.getId());
    }
}
