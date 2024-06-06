package org.example.demo_search_paging_sort_api.rest_controller;

import jakarta.websocket.server.PathParam;
import org.example.demo_search_paging_sort_api.model.dto.request.StudentRequest;
import org.example.demo_search_paging_sort_api.model.entity.Student;
import org.example.demo_search_paging_sort_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class RestStudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getListStudent(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/searchAndPaging")
    public ResponseEntity<List<Student>> getStudentWithSearchAndPage(@RequestBody StudentRequest studentRequest){
        List<Student> content = studentService.getStudentPaging(studentRequest.getName(), studentRequest.getPage() - 1, studentRequest.getItemPage(), studentRequest.getSortBy(), studentRequest.getDirection()).getContent();
        return new ResponseEntity<>(content,HttpStatus.OK);
    }

    @GetMapping("/{stuId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer stuId){
        return new ResponseEntity<>(studentService.getStudentById(stuId),HttpStatus.OK);
    }
    //...
}
