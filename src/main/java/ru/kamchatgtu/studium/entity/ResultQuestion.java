package ru.kamchatgtu.studium.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "result_question")
public class ResultQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_result_q")
    private Integer idResultQ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_answer")
    private Answer answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_question")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_result")
    private ResultTest resultTest;

    public ResultQuestion() {
    }

    public Integer getIdResult() {
        return idResultQ;
    }

    public void setIdResult(Integer idResult) {
        this.idResultQ = idResult;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ResultTest getResultTest() {
        return resultTest;
    }

    public void setResultTest(ResultTest resultTest) {
        this.resultTest = resultTest;
    }
}
