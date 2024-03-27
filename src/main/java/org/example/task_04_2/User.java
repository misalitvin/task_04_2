package org.example.task_04_2;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;

    public User() {
    }

    public User(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                " mail='" + mail + '\'' +
                '}';
    }

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();

    @OneToOne(mappedBy = "manager",cascade = CascadeType.ALL, orphanRemoval = true)
    private Blog managedBlog;
}
