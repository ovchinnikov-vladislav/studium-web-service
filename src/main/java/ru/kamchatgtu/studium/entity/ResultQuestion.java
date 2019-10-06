package ru.kamchatgtu.studium.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * Объект класса {@code ResultQuestion} моделирует результат по ответам, принадлежащим конкретным вопросам
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "result_question")
public class ResultQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_result_question")
    private Integer idResultQuestion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_answer")
    private Answer answer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_question")
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_result")
    private ResultTest resultTest;

    public ResultQuestion() {
    }

    /**
     * Метод получения id результата по ответу, принадлежащему конкретному вопросу
     * @return возращает id результата по ответу, принадлежащему конретному вопросу
     */
    public Integer getIdResultQuestion() {
        return idResultQuestion;
    }

    /**
     * Метод установки id результата по ответу, принадлежащему конкретному вопросу
     * @param idResultQuestion id результата по ответу, принадлежащему конкретному вопросу
     */
    public void setIdResultQuestion(Integer idResultQuestion) {
        this.idResultQuestion = idResultQuestion;
    }

    /**
     * Метод получения ответа
     * @return возращает ответ
     */
    public Answer getAnswer() {
        return answer;
    }

    /**
     * Метод установки ответа
     * @param answer ответ
     */
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    /**
     * Метод получения пользователя
     * @return возвращает пользователя
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
     * Метод получения вопроса
     * @return возращает вопрос
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Метод установки вопроса
     * @param question вопрос
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * Метод получения результата по тесту
     * @return возращает результат по тесту
     */
    public ResultTest getResultTest() {
        return resultTest;
    }

    /**
     * Метод устновки результата по тесту
     * @param resultTest результат по тесту
     */
    public void setResultTest(ResultTest resultTest) {
        this.resultTest = resultTest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultQuestion that = (ResultQuestion) o;
        return idResultQuestion.intValue() == that.idResultQuestion.intValue() &&
                answer.equals(that.answer) &&
                user.equals(that.user) &&
                question.equals(that.question) &&
                resultTest.equals(that.resultTest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idResultQuestion, answer, user, question, resultTest);
    }
}
