package ru.kamchatgtu.studium.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Объект класса {@code Theme} моделирует тему вопроса
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "theme")
public class Theme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_theme")
    private Integer idTheme;

    @Column(name = "theme_text")
    private String themeText;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theme")
    private Collection<Question> questions;

    public Theme() {}

    /**
     * Метод получения id темы вопросы
     * @return возвращает id темы вопроса
     */
    public Integer getIdTheme() {
        return idTheme;
    }

    /**
     * Метод установки id темы вопроса
     * @param idTheme id темы вопроса
     */
    public void setIdTheme(Integer idTheme) {
        this.idTheme = idTheme;
    }

    /**
     * Метод получения текста темы вопроса
     * @return возвращает текст темы вопроса
     */
    public String getThemeText() {
        return themeText;
    }

    /**
     * Метод установки текста темы вопроса
     * @param themeText тектс темы вопроса
     */
    public void setThemeText(String themeText) {
        this.themeText = themeText;
    }

    /**
     * Метод получения списка вопросов темы
     * @return возвращает коллекцию вопросов темы
     */
    public Collection<Question> getQuestions() {
        return questions;
    }

    /**
     * Метод установки списка вопросов темы
     * @param questions коллекция вопросов темы
     */
    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }
}
