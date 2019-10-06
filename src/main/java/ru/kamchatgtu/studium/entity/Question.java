package ru.kamchatgtu.studium.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Объект класс {@code Question} моделирует вопрос
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "question")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Integer idQuestion;

    @Column(name = "question_text")
    private String questionText;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_edit")
    private Date dateEdit;

    @Column(name = "question_type")
    private Byte questionType;

    @Column(name = "dir_image")
    private String dirImage;

    @Column(name = "dir_audio")
    private String dirAudio;

    @Column(name = "dir_video")
    private String dirVideo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_theme")
    private Theme theme;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Collection<Answer> answers;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Collection<ResultQuestion> resultQuestions;

    @JsonIgnore
    @ManyToMany(targetEntity = Test.class, cascade = CascadeType.MERGE, mappedBy = "questions")
    private Collection<Test> tests;

    public Question() {}

    /**
     * Метод получения id вопроса
     * @return возвращает id вопроса
     */
    public Integer getIdQuestion() {
        return idQuestion;
    }

    /**
     * Метод установки id вопроса
     * @param idQuestion id вопроса
     */
    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    /**
     * Метод получения текста вопроса
     * @return возращает текст вопроса
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Метод установки текста вопроса
     * @param questionText текст вопроса
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    /**
     * Метод получения темы вопроса
     * @return возращает тему вопроса
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * Метод установки темы вопроса
     * @param theme тема вопроса
     */
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    /**
     * Метод получения даты редактирования
     * @return возращает дату редактирования
     */
    public Date getDateEdit() {
        return dateEdit;
    }

    /**
     * Метод установки даты редактирования
     * @param dateEdit дата редактирования
     */
    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }

    /**
     * Метод получения типа вопроса
     * @return возвращает тип вопроса
     */
    public Byte getQuestionType() {
        return questionType;
    }

    /**
     * Метод установки типа вопроса
     * @param questionType тип вопроса
     */
    public void setQuestionType(Byte questionType) {
        this.questionType = questionType;
    }

    /**
     * Метод получения адреса изображения вопроса
     * @return возвращает адрес изображение вопроса
     */
    public String getDirImage() {
        return dirImage;
    }

    /**
     * Метод установки адреса изображения вопроса
     * @param dirImage адрес изображения вопроса
     */
    public void setDirImage(String dirImage) {
        this.dirImage = dirImage;
    }

    /**
     * Метод получения адреса аудио вопроса
     * @return возращает адрсес аудио вопроса
     */
    public String getDirAudio() {
        return dirAudio;
    }

    /**
     * Метод установки адреса аудио вопроса
     * @param dirAudio адрес аудио вопроса
     */
    public void setDirAudio(String dirAudio) {
        this.dirAudio = dirAudio;
    }

    /**
     * Метод получения адреса видео вопроса
     * @return возращает адрес видео вопроса
     */
    public String getDirVideo() {
        return dirVideo;
    }

    /**
     * Метод установки адреса видео вопроса
     * @param dirVideo адрес видео вопроса
     */
    public void setDirVideo(String dirVideo) {
        this.dirVideo = dirVideo;
    }

    /**
     * Метод получения пользователя, создавшего вопрос
     * @return возращает пользователя, создавшего вопрос
     */
    public User getUser() {
        return user;
    }

    /**
     * Метод установки пользователя, создавшего вопрос
     * @param user пользователя, создавший вопрос
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Метод получения ответов на данный вопрос
     * @return возращает коллекцию ответов на данный вопрос
     */
    public Collection<Answer> getAnswers() {
        return answers;
    }

    /**
     * Метод установки ответов на данный вопрос
     * @param answers коллекция ответов на данный вопрос
     */
    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }

    /**
     * Метод получения результов по ответам на данный вопрос
     * @return возращает коллекцию результатов по ответам на данный вопрос
     */
    public Collection<ResultQuestion> getResultQuestions() {
        return resultQuestions;
    }

    /**
     * Метод установки результов по ответам на данный вопрос
     * @param resultQuestions коллекция результов по ответам на данный вопрос
     */
    public void setResultQuestions(Collection<ResultQuestion> resultQuestions) {
        this.resultQuestions = resultQuestions;
    }

    /**
     * Метод получения тестов, в которых содержится данный вопрос
     * @return возращает коллекцию тестов, в которых содержится данный вопрос
     */
    public Collection<Test> getTests() {
        return tests;
    }

    /**
     * Метод установки тестов, в которых содержится данный вопрос
     * @param tests коллекция тестов, в которых содержится данный вопрос
     */
    public void setTests(Collection<Test> tests) {
        this.tests = tests;
    }
}
