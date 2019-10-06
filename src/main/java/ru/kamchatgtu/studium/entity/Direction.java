package ru.kamchatgtu.studium.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Объект класса {@code Direction} моделирует направление подготовки
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "direction")
public class Direction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direction")
    private Integer idDirection;

    @Column(name = "direction_name")
    private String directionName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_faculty")
    private Faculty faculty;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direction")
    private Collection<Group> groups;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direction")
    private Collection<User> users;

    @JsonIgnore
    @ManyToMany(targetEntity = Subject.class, cascade = CascadeType.MERGE, mappedBy = "directions")
    private Collection<Subject> subjects;

    /**
     * Метод получения id направления подготовки
     * @return возращает id направления подготовки
     */
    public Integer getIdDirection() {
        return idDirection;
    }

    /**
     * Метод установки id направления подготовки
     * @param idDirection id направления подготовки
     */
    public void setIdDirection(Integer idDirection) {
        this.idDirection = idDirection;
    }

    /**
     * Метод получения имени направления подготовки
     * @return возращает имя направления подготовки
     */
    public String getDirectionName() {
        return directionName;
    }

    /**
     * Метод установки имени направления подготовки
     * @param directionName имя направления подготовки
     */
    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    /**
     * Метод получения факультета направления подготовки
     * @return возращает факультет направления подготовки
     */
    public Faculty getFaculty() {
        return faculty;
    }

    /**
     * Метод установки факультета направления подготовки
     * @param faculty факультет направления подготовки
     */
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    /**
     * Метод получения групп направления подготовки
     * @return возращает коллекцию групп направления подготовки
     */
    public Collection<Group> getGroups() {
        return groups;
    }

    /**
     * Метод установки групп направления подготовки
     * @param groups коллекция групп направления подготовки
     */
    public void setGroups(Collection<Group> groups) {
        this.groups = groups;
    }

    /**
     * Метод получения пользователей направления подготовки
     * @return возращает коллекцию пользователей направления подготовки
     */
    public Collection<User> getUsers() {
        return users;
    }

    /**
     * Метод установки пользователей направления подготовки
     * @param users коллекция пользователей направления подготовки
     */
    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    /**
     * Метод получения дисциплин направления подготовки
     * @return возвращает коллекцию дисциплин направления подготовки
     */
    public Collection<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Метод установки дисциплин направления подготовки
     * @param subjects коллекция дисциплин направления подготовки
     */
    public void setSubjects(Collection<Subject> subjects) {
        this.subjects = subjects;
    }
}
