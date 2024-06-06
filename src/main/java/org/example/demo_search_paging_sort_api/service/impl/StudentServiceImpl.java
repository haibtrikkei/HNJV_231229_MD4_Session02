package org.example.demo_search_paging_sort_api.service.impl;

import org.example.demo_search_paging_sort_api.model.entity.Student;
import org.example.demo_search_paging_sort_api.repository.StudentRepository;
import org.example.demo_search_paging_sort_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer stuId) {
        return studentRepository.findById(stuId).orElseThrow(()->new NoSuchElementException("Khong ton tai sinh vien"));
    }

    @Override
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        studentRepository.findById(student.getStuId()).orElseThrow(()->new NoSuchElementException("Khong ton tai sinh vien"));
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Integer stuId) {
        studentRepository.deleteById(stuId);
    }

    @Override
    public Page<Student> getStudentPaging(String searchName, Integer page, Integer itemPage, String orderBy, String direction) {
        Pageable pageable = null;

        if(orderBy!=null && !orderBy.isEmpty()){
            // co sap xep
            Sort sort = null;
            switch (direction){
                case "ASC":
                    sort = Sort.by(orderBy).ascending();
                    break;
                case "DESC":
                    sort = Sort.by(orderBy).descending();
                    break;
            }
            pageable = PageRequest.of(page, itemPage,sort);
        }else{
            //khong sap xep
            pageable = PageRequest.of(page, itemPage);
        }

        //xu ly ve tim kiem
        if(searchName!=null && !searchName.isEmpty()){
            //co tim kiem
            return studentRepository.findStudentsByFullNameAndSorting(searchName,pageable);
        }else{
            //khong tim kiem
            return studentRepository.findAll(pageable);
        }
    }

    @Override
    public List<Student> saveAll(List<Student> list) {
        return studentRepository.saveAll(list);
    }

}
