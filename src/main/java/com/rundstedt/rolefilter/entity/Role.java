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
public class Role {
    @Id
    private String id;

    private String name;
    private String gender;
    private String grade;
    private String school;
    private String neigongyanxiu;
    private String price;
    private String serverName;
    private String serverId;
    private String status;

    @OneToMany
    @JoinColumn(name = "role_id")
    private List<Skin> skinList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "role_id")
    private List<Threeskills> threeskillsList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "role_id")
    private List<Treasure> treasureList = new ArrayList<>();
}