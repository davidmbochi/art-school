package com.company.schoolart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "art_groups")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "group_name",unique = true)
    private String groupName;

    @OneToMany(fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    List<Student> students = new ArrayList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }
}
