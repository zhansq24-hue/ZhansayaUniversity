package com.example.zhansayauniversity.repository;

import com.example.zhansayauniversity.entity.ZhansayaSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZhansayaScheduleRepository extends JpaRepository<ZhansayaSchedule, Long> {}