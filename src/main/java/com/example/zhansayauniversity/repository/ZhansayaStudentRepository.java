package com.example.zhansayauniversity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZhansayaStudentRepository extends JpaRepository<ZhansayaStudent, Long> {
}