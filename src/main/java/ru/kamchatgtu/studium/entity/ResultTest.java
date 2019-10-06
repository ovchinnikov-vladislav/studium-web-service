package ru.kamchatgtu.studium.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Объект класса {@code ResultTest} моделирует результат по тесту
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "result_test")
public class ResultTest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_result")
    private Integer idResult;

    @Column(name = "date_begin")
    private Date dateBegin;

    @Column(name = "date_end")
    private Date dateEnd;

    @Column(name = "mark")
    private Float mark;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_test")
    private Test test;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resultTest")
    private Collection<ResultQuestion> resultQuestions;

    public ResultTest() {}

    /**
     * Метод получения id результата по тесту
     * @return возращает id результата по тесту
     */
    public Integer getIdResult() {
        return idResult;
    }

    /**
     * Метод установки id результата по тесту
     * @param idResult id результата по тесту
     */
    public void setIdResult(Integer idResult) {
        this.idResult = idResult;
    }

    /**
     * Метод получени пользователя
     * @return возращает пользователя
     */
    public User getUser() {
        return user;
    }

    /**
     * Метод установки пользователя
     * @param user пользователь
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Метод получения теста
     * @return возращает тест
     */
    public Test getTest() {
        return test;
    }

    /**
     * Метод установки теста
     * @param test тест
     */
    public void setTest(Test test) {
        this.test = test;
    }

    /**
     * Метод получения даты начала прохождения теста
     * @return возращает дату начала прохождения теста
     */
    public Date getDateBegin() {
        return dateBegin;
    }

    /**
     * Метод установки даты начала прохождения теста
     * @param dateBegin дата начала прохождения теста
     */
    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    /**
     * Метод получения даты завершения прохождения теста
     * @return возращает дату завершения прохождения теста
     */
    public Date getDateEnd() {
        return dateEnd;
    }

    /**
     * Метод установки даты завершения прохождения теста
     * @param dateEnd дата завершения прохождения теста
     */
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * Метод получения оценки по тесту
     * @return возвращает оценку по тесту
     */
    public Float getMark() {
        return mark;
    }

    /**
     * Метод установки оценки по тесту
     * @param mark оценка по тесту
     */
    public void setMark(Float mark) {
        this.mark = mark;
    }

    /**
     * Метод получения результатов по ответам конкретного вопроса
     * @return возращает коллекцию результатов по ответам конкретного вопроса
     */
    public Collection<ResultQuestion> getResultQuestions() {
        return resultQuestions;
    }

    /**
     * Метод установки результатов по ответам конкретного вопроса
     * @param resultQuestions коллекция результатов по ответам конкретного вопроса
     */
    public void setResultQuestions(Collection<ResultQuestion> resultQuestions) {
        this.resultQuestions = resultQuestions;
    }
}
