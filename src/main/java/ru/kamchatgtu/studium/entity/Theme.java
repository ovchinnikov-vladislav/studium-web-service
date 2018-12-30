package ru.kamchatgtu.studium.entity;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "theme")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_theme")
    private Integer idTheme;

    @Column(name = "text_theme")
    private String theme;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theme")
    private Set<Question> questions;

    public Theme() {}

    public Integer getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Integer idTheme) {
        this.idTheme = idTheme;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
