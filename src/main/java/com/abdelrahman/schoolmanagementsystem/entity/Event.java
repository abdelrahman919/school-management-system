package com.abdelrahman.schoolmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "eventIdGen")
    @SequenceGenerator(name = "eventIdGen",allocationSize = 1)
    private Long eventId;


    private List<Object> participants;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate eventDate;











}
