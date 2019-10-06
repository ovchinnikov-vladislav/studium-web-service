package ru.kamchatgtu.studium.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Объект класса {@code Subject} моделирует дисциплину
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "`Subject`")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Integer idSubject;

    @Column(name = "subject_name")
    private String subjectName;

    @ManyToMany(targetEntity = Direction.class, cascade = CascadeType.MERGE)
    @JoinTable(name = "direction_subject",
            joinColumns = { @JoinColumn(name = "id_subject", referencedColumnName = "id_subject")},
            inverseJoinColumns = {@JoinColumn(name = "id_direction", referencedColumnName = "id_direction")})
    private Collection<Direction> directions;

    @ManyToMany(targetEntity = User.class, cascade = CascadeType.MERGE)
    @JoinTable(name = "subject_user",
            joinColumns = { @JoinColumn(name = "id_subject", referencedColumnName = "id_subject")},
            inverseJoinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id_user")})
    private Collection<User> users;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private Collection<Test> tests;

    public Subject() {}

    /**
     * Метод получения id дисциплины
     * @return возвращает id дисциплины
     */
    public Integer getIdSubject() {
        return idSubject;
    }

    /**
     * Метод установки id дисциплины
     * @param idSubject id дисциплины
     */
    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    /**
     * Метод получения имени дисциплины
     * @return возвращает имя дисциплины
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Метод установки имени дисциплины
     * @param subjectName имя дисциплины
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * Метод получения списка направлений подготовки дисциплины
     * @return возвращает коллекцию направлений подготовки
     */
    public Collection<Direction> getDirections() {
        return directions;
    }

    /**
     * Метод установки направлений подготовки дисциплины
     * @param directions коллекция направлений подготовки дисциплины
     */
    public void setDirections(Collection<Direction> directions) {
        this.directions = directions;
    }

    /**
     * Метод получения тестов дисциплины
     * @return возвращает коллекцию тестов дисциплины
     */
    public Collection<Test> getTests() {
        return tests;
    }

    /**
     * Метод установки тестов дисциплины
     * @param tests тесты дисциплины
     */
    public void setTests(Collection<Test> tests) {
        this.tests = tests;
    }

    /**
     * Метод получения пользователей, принадлежащих дисциплинам
     * @return список пользователей
     */
    public Collection<User> getUsers() {
        return users;
    }

    /**
     * Метод установки пользователей, принадлежащих дисциплинам
     * @param users список дисциплин
     */
    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return idSubject.equals(subject.idSubject) && subjectName.equals(subject.subjectName);
    }
}
