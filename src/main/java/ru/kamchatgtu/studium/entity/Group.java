package ru.kamchatgtu.studium.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "`Group`")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    private Integer idGroup;

    @Column(name = "name_group")
    private String nameGroup;

    @Column(name = "direction")
    private String direction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_position")
    private Position position;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<User> users;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "group_subject",
            joinColumns = { @JoinColumn(name = "id_group")},
            inverseJoinColumns = {@JoinColumn(name = "id_subject")})
    private Set<Subject> subjects;

    public Group() {}

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
