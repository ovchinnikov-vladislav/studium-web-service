package ru.kamchatgtu.studium.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "result_test")
public class ResultTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_result")
    private Integer idResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_test")
    private Test test;

    @Column(name = "date_begin")
    private Date dateBegin;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "mark")
    private Byte mark;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resultTest")
    private Set<ResultQuestion> resultQuestions;

    public ResultTest() {}

    public Integer getIdResult() {
        return idResult;
    }


    public void setIdResult(Integer idResult) {
        this.idResult = idResult;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Byte getMark() {
        return mark;
    }

    public void setMark(Byte mark) {
        this.mark = mark;
    }

    public Set<ResultQuestion> getResultQuestions() {
        return resultQuestions;
    }

    public void setResultQuestions(Set<ResultQuestion> resultQuestions) {
        this.resultQuestions = resultQuestions;
    }
}
