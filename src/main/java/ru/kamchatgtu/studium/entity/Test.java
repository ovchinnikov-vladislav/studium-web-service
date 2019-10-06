package ru.kamchatgtu.studium.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Объект класса {@code Test} моделирует тест
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "test")
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private Integer idTest;

    @Column(name = "test_name")
    private String testName;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_edit")
    private Date dateEdit;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timer")
    private Date timer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @ManyToMany(targetEntity = Question.class, cascade = CascadeType.MERGE)
    @JoinTable(name = "test_question",
            joinColumns = { @JoinColumn(name = "id_test", referencedColumnName = "id_test")},
            inverseJoinColumns = {@JoinColumn(name = "id_question", referencedColumnName = "id_question")})
    private Collection<Question> questions;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
    private Collection<ResultTest> resultTests;

    public Test() {

    }

    /**
     * Метод получения id теста
     * @return возвращает id теста
     */
    public Integer getIdTest() {
        return idTest;
    }

    /**
     * Метод установки id теста
     * @param idTest id теста
     */
    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    /**
     * Метод получения имени теста
     * @return возвращает имя теста
     */
    public String getTestName() {
        return testName;
    }

    /**
     * Метод установки имени теста
     * @param testName имя теста
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }

    /**
     * Метод получения даты редактирования теста
     * @return возвращает дату редактирования теста
     */
    public Date getDateEdit() {
        return dateEdit;
    }

    /**
     * Метод установки даты редактирования теста
     * @param dateEdit дата редактирования теста
     */
    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }

    /**
     * Метод получения времени прохождения теста
     * @return возвращает время прохождения теста
     */
    public Date getTimer() {
        return timer;
    }

    /**
     * Метод установки времени прохождения теста
     * @param timer время прохождения теста
     */
    public void setTimer(Date timer) {
        this.timer = timer;
    }

    /**
     * Метод получения пользователя, создавшего тест
     * @return возвращает пользователя, создавшего тест
     */
    public User getUser() {
        return user;
    }

    /**
     * Метод установки пользователя, создавшего тест
     * @param user пользователь, создавший тест
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Метод получения дисциплины, которой принадлежит тест
     * @return возвращает дисциплину, которой принадлежит тест
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Метод установки дисциплины, которой принадлежит тест
     * @param subject дисциплина, которой принадлежит тест
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * Метод получения результатов по тесту
     * @return возвращает результаты по тесту
     */
    public Collection<ResultTest> getResultTests() {
        return resultTests;
    }

    /**
     * Метод установки результатов по тесту
     * @param resultTests возвращает результаты по тесту
     */
    public void setResultTests(Collection<ResultTest> resultTests) {
        this.resultTests = resultTests;
    }

    /**
     * Метод получения вопросов теста
     * @return возвращает вопросы теста
     */
    public Collection<Question> getQuestions() {
        return questions;
    }

    /**
     * Метод установки вопросов теста
     * @param questions вопросы теста
     */
    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }
}
