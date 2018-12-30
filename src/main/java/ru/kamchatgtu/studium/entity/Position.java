package ru.kamchatgtu.studium.entity;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_position")
    private Integer idPosition;

    @Column(name = "position")
    private String position;

    @Column(name = "access")
    private Byte access;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
    private Set<User> users;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
    private Set<Group> groups;

    public Position() {}

    public Integer getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Byte getAccess() {
        return access;
    }

    public void setAccess(Byte access) {
        this.access = access;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
