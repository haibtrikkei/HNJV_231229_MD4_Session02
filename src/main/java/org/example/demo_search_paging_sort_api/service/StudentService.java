package org.example.demo_search_paging_sort_api.service;

import org.example.demo_search_paging_sort_api.model.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Integer stuId);
    Student insertStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Integer stuId);
    Page<Student> getStudentPaging(String searchName, Integer page, Integer itemPage, String orderBy, String direction);
    List<Student> saveAll(List<Student> list);

}
