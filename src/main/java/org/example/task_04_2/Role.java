package org.example.task_04_2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table()
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private List<User> users = new ArrayList<>();

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                " name='" + name + '\'' +
                '}';
    }

    public Role(String rolename) {
        this.name = rolename;
    }
}