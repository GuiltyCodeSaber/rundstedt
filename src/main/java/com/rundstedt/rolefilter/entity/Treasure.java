package com.rundstedt.rolefilter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treasure {
    @Id
    private int id;

    private String wuxue;
    private boolean is750;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    private String dataInfo;

    @OneToMany
    @JoinColumn(name = "treasure_id")
    private List<TreasureProp> treasurePropList = new ArrayList<>();
}
