package com.example.zhansayauniversity.repository;

import com.example.zhansayauniversity.entity.ZhansayaCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZhansayaCourseRepository extends JpaRepository<ZhansayaCourse, Long> {
}