package com.example.zhansayauniversity.repository;

import com.example.zhansayauniversity.entity.ZhansayaProfessor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZhansayaProfessorRepository extends JpaRepository<ZhansayaProfessor, Long> {}