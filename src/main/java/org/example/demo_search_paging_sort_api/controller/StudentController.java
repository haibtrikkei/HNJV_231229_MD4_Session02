package org.example.demo_search_paging_sort_api.controller;

import org.example.demo_search_paging_sort_api.model.entity.Student;
import org.example.demo_search_paging_sort_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/genList")
    public String genList(Model model){
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 55; i++) {
            Student s = new Student(0,"student "+i,true,new Date(),"address "+i,"class name "+i);
            list.add(s);
        }
        List<Student> studentList = studentService.saveAll(list);
        model.addAttribute("success","Save all student successfully!");
        return "index";
    }

    @GetMapping("/liststudent")
    public String listStudent(@RequestParam(defaultValue = "")String name,
                              @RequestParam(defaultValue = "1")Integer page,
                              @RequestParam(defaultValue = "8")Integer itemPage,
                              @RequestParam(defaultValue = "fullName")String sortBy,
                              @RequestParam(defaultValue = "DESC")String direction,
                              Model model){
        Page<Student> studentPaging = studentService.getStudentPaging(name, page - 1, itemPage, sortBy, direction);
        model.addAttribute("list",studentPaging.getContent());
        model.addAttribute("page",page);
        model.addAttribute("name",name);
        model.addAttribute("sortBy",sortBy);
        model.addAttribute("direction",direction);
        model.addAttribute("listPage",studentPaging.getTotalPages());
        return "listStudent";
    }
}
