package com.example.zhansayauniversity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "zhansaya_schedules")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ZhansayaSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private String classroom;
}