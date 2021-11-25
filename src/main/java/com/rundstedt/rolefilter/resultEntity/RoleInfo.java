package com.rundstedt.rolefilter.resultEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleInfo {
    String id;
    String name;
    String gender;
    String grade;
    String school;
    String neigongyanxiu;
    String price;
    ServerResult server;
    String status;
}
