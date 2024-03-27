package org.example.task_04_2;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Blog() {
    }

    public Blog(String name, User manager) {
        this.name = name;
        this.manager = manager;
    }

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "manager", unique = true)
    private User manager;

    @Override
    public String toString() {
        return "Blog{" +
                " name='" + name +
                '}';
    }
}