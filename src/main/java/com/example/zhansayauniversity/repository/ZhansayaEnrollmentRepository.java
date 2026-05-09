package com.example.zhansayauniversity.repository;

import com.example.zhansayauniversity.entity.ZhansayaEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZhansayaEnrollmentRepository extends JpaRepository<ZhansayaEnrollment, Long> {}