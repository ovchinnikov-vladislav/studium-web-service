package ru.kamchatgtu.studium.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Объект класса {@code Group} моделирует группу пользователя
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "`Group`")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    private Integer idGroup;

    @Column(name = "group_name")
    private String groupName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_direction")
    private Direction direction;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Collection<User> users;

    public Group() {}

    /**
     * Метод получения id группы
     * @return возращает id группы
     */
    public Integer getIdGroup() {
        return idGroup;
    }

    /**
     * Метод установки id группы
     * @param idGroup id группы
     */
    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    /**
     * Метод получения имени группы
     * @return возвращает имя группы
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Метод установки имени группы
     * @param groupName имя группы
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Метод получения направления подготовки группы
     * @return возращает направление подготовки
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Метод установки направления подготовки группы
     * @param direction направление подготовки группы
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Метод получения роли группы
     * @return возращает роль группы
     */
    public Role getRole() {
        return role;
    }

    /**
     * Метод установки роли группы
     * @param role роль группы
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Метод получения пользователей группы
     * @return возращает множество пользователей группы
     */
    public Collection<User> getUsers() {
        return users;
    }

    /**
     * Метод установки пользователей группы
     * @param users множество пользователей группы
     */
    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
