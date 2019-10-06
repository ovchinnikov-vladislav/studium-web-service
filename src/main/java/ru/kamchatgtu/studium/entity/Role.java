package ru.kamchatgtu.studium.entity;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Объект класса {@code Role} моделирует роль пользователя
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer idRole;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "access")
    private Byte access;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Collection<Group> groups;

    public Role() {}

    /**
     * Метод получения id роли пользователя
     * @return возвращает id роли пользователя
     */
    public Integer getIdRole() {
        return idRole;
    }

    /**
     * Метод установки id роли пользователя
     * @param idRole id роли пользователя
     */
    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    /**
     * Метод получения имени роли пользователя
     * @return возвращает имя роли пользователя
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Метод установки имени роли пользователя
     * @param roleName имя роли пользователя
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Метод получения уровня допуска роли пользователя
     * @return возвращает уровень допуска
     */
    public Byte getAccess() {
        return access;
    }

    /**
     * Метод установки уровня допуска
     * @param access уровень допуска
     */
    public void setAccess(Byte access) {
        this.access = access;
    }

    /**
     * Метод получения списка групп роли
     * @return возвращает коллекцию групп роли
     */
    public Collection<Group> getGroups() {
        return groups;
    }

    /**
     * Метод установки списка групп роли
     * @param groups коллекция групп роли
     */
    public void setGroups(Collection<Group> groups) {
        this.groups = groups;
    }
}
