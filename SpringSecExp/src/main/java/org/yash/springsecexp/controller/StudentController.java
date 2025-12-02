package org.yash.springsecexp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yash.springsecexp.model.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student>  students = new ArrayList<>(List.of(new Student(1, "Alex", 20), new Student(2, "Bob", 30)));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

//    CSRF --> Cross-Site Request Forgery

    @GetMapping("/csrf-token")
    private CsrfToken getToken(HttpServletRequest request) {
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        return token;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

}
