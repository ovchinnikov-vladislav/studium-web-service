package ru.kamchatgtu.studium.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Объект класса {@code Faculty} моделирует факультет
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faculty")
    private Integer idFaculty;

    @Column(name = "faculty_name")
    private String facultyName;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "faculty")
    private Collection<Direction> directions;

    /**
     * Метод получения id факультета
     * @return возращает id факультета
     */
    public Integer getIdFaculty() {
        return idFaculty;
    }

    /**
     * Метод установки id факультета
     * @param idFaculty id факультета
     */
    public void setIdFaculty(Integer idFaculty) {
        this.idFaculty = idFaculty;
    }

    /**
     * Метод получения имени факультета
     * @return возращает имя факультета
     */
    public String getFacultyName() {
        return facultyName;
    }

    /**
     * Метод установки имени факультета
     * @param facultyName имя факультета
     */
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    /**
     * Метод получения направлений подготовки факультета
     * @return возращает коллекцию направлений подготовки
     */
    public Collection<Direction> getDirections() {
        return directions;
    }

    /**
     * Метод установки направлений подготовки факультета
     * @param directions коллекция направлений подготовки факультета
     */
    public void setDirections(Collection<Direction> directions) {
        this.directions = directions;
    }
}
