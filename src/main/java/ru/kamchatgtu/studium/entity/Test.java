package ru.kamchatgtu.studium.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private Integer idTest;

    @Column(name = "name_test")
    private String nameTest;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss a z")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_edit")
    private Date dateEdit;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss a z")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timer")
    private Date timer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
    private Set<ResultTest> resultTests;

    public Test() {

    }

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public String getNameTest() {
        return nameTest;
    }

    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }

    public Date getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }

    public Date getTimer() {
        return timer;
    }

    public void setTimer(Date timer) {
        this.timer = timer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<ResultTest> getResultTests() {
        return resultTests;
    }

    public void setResultTests(Set<ResultTest> resultTests) {
        this.resultTests = resultTests;
    }
}
