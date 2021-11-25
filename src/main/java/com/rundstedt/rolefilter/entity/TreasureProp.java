package com.rundstedt.rolefilter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreasureProp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String prop;
}
