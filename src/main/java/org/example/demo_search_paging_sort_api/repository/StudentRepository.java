package org.example.demo_search_paging_sort_api.repository;

import org.example.demo_search_paging_sort_api.model.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student,Integer>, JpaRepository<Student,Integer> {
    @Query("select s from Student s where s.fullName like concat('%',:fullName,'%')")
    Page<Student> findStudentsByFullNameAndSorting(String fullName, Pageable pageable);
}
