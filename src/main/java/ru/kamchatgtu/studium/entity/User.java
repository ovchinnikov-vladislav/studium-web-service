package ru.kamchatgtu.studium.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Collection;
import com.fasterxml.jackson.annotation.*;

/**
 * Объект класса {@code User} моделирует пользователя
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "`User`")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "fio_user")
    private String fio;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_reg")
    private Date dateReg;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_auth")
    private Date dateAuth;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private Byte status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_group")
    private Group group;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_direction")
    private Direction direction;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Answer> answers;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Question> questions;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<Test> tests;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<ResultTest> resultTests;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Collection<ResultQuestion> resultQuestions;

    @JsonIgnore
    @ManyToMany(targetEntity = Subject.class, cascade = CascadeType.MERGE, mappedBy = "users")
    private Collection<Subject> subjects;

    public User() {
    }

    /**
     * Метод получения id пользователя
     * @return возвращает id пользователя
     */
    public Integer getIdUser() {
        return idUser;
    }

    /**
     * Метод установки id пользователя
     * @param idUser id пользователя
     */
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    /**
     * Метод получения ФИО пользователя
     * @return возвращает ФИО пользователя
     */
    public String getFio() {
        return fio;
    }

    /**
     * Метод установки ФИО пользователя
     * @param fio ФИО пользователя
     */
    public void setFio(String fio) {
        this.fio = fio;
    }

    /**
     * Метод получения логина пользователя
     * @return возвращает логин пользователя
     */
    public String getLogin() {
        return login;
    }

    /**
     * Метод установки логина пользователя
     * @param login логин пользователя
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Метод получения пароля пользователя
     * @return возвращает пароль пользователя
     */
    public String getPassword() {
        return password;
    }

    /**
     * Метод установки пароля пользователя
     * @param password пароль пользователя
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Метод получения даты регистрации пользователя
     * @return возвращает дату регистрации пользователя
     */
    public Date getDateReg() {
        return dateReg;
    }

    /**
     * Метод установки даты регистрации пользователя
     * @param dateReg дата регистрации пользователя
     */
    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    /**
     * Метод получения даты авторизации пользователя
     * @return возвращает дату авторизации пользователя
     */
    public Date getDateAuth() {
        return dateAuth;
    }

    /**
     * Метод установки даты авторизации пользователя
     * @param dateAuth возвращает дату авторизации пользователя
     */
    public void setDateAuth(Date dateAuth) {
        this.dateAuth = dateAuth;
    }

    /**
     * Метод получения телефона пользователя
     * @return возвращает телефон пользователя
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Метод установки телефона пользователя
     * @param phone телефон пользователя
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Метод получения email пользователя
     * @return возвращает email пользователя
     */
    public String getEmail() {
        return email;
    }

    /**
     * Метод установки email пользователя
     * @param email E-mail пользователя
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Метод получения статуса аккаунта пользователя
     * @return возвращает статус аккаунта пользователя
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * Метод установки статуса аккаунта пользователя
     * @param status статус аккаунта пользователя
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * Метод получения роли пользователя
     * @return возвращает роль пользователя
     */
    public Role getRole() {
        return role;
    }

    /**
     * Метод установки роли пользователя
     * @param role роль пользователя
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Метод получения группы пользователя
     * @return возвращает группу пользователя
     */
    public Group getGroup() {
        return group;
    }

    /**
     * Метод установки группы пользователя
     * @param group группа пользователя
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * Метод получения направления подготовки пользователя
     * @return возвращает направление подготовки пользователя
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Метод установки направления подготовки пользователя
     * @param direction направление подготовки пользователя
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Метод получения ответов, созданных пользователем
     * @return возвращает коллекцию ответов, созданных пользователем
     */
    public Collection<Answer> getAnswers() {
        return answers;
    }

    /**
     * Метод установки ответов, созданных пользователем
     * @param answers коллекция ответов, созданных пользователем
     */
    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }

    /**
     * Метод получения вопросов, созданных пользователем
     * @return возвращает коллекцию вопросов, созданных пользователем
     */
    public Collection<Question> getQuestions() {
        return questions;
    }

    /**
     * Метод установки вопросов, созданных пользователем
     * @param questions коллекция вопросов, созданных пользователем
     */
    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }

    /**
     * Метод получения тестов, созданных пользователем
     * @return возвращает коллекцию тестов, созданных пользователем
     */
    public Collection<Test> getTests() {
        return tests;
    }

    /**
     * Метод установки тестов, созданных пользователем
     * @param tests коллекция тестов, созданных пользователем
     */
    public void setTests(Collection<Test> tests) {
        this.tests = tests;
    }

    /**
     * Метод получения результатов по тестам
     * @return возвращает коллекцию результатов по тестам
     */
    public Collection<ResultTest> getResultTests() {
        return resultTests;
    }

    /**
     * Метод установки результатов по тестам
     * @param resultTests коллекция результатов по тестам
     */
    public void setResultTests(Collection<ResultTest> resultTests) {
        this.resultTests = resultTests;
    }

    /**
     * Метод получения результатов по ответам конкретных вопросов
     * @return возвращает коллекцию результатов по ответам конкретных вопросов
     */
    public Collection<ResultQuestion> getResultQuestions() {
        return resultQuestions;
    }

    /**
     * Метод установки результатов по ответам конкретных вопросов
     * @param resultQuestions коллекция результатов по ответам конкретных вопросов
     */
    public void setResultQuestions(Collection<ResultQuestion> resultQuestions) {
        this.resultQuestions = resultQuestions;
    }

    /**
     * Метод получения дисциплин, принадлежащих преподавателям
     * @return возвращает коллекцию дисциплин
     */
    public Collection<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Метод установки дисциплин, принадлежащих преподавателям
     * @param subjects коллекция дисциплин
     */
    public void setSubjects(Collection<Subject> subjects) {
        this.subjects = subjects;
    }
}
