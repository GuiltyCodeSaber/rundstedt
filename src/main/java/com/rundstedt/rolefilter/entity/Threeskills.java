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
public class Threeskills {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String wuxue;
    private String skill;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    private String dataInfo;
}
