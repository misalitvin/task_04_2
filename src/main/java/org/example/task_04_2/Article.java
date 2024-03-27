package org.example.task_04_2;
import jakarta.persistence.*;

@Entity
@Table()
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public Article() {
    }

    public Article(String title, User author, Blog blog) {
        this.title = title;
        this.author = author;
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                '}';
    }

    @ManyToOne
    private User author;
    @ManyToOne
    private Blog blog;
}
