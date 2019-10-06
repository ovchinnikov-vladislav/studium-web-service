package ru.kamchatgtu.studium.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Объект класса {@code Answer} моделирует ответ на вопрос
 * @author Овчинников В.А.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "answer")
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_answer")
    private Integer idAnswer;

    @Column(name = "answer_text")
    private String answerText;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_edit")
    private Date dateEdit;

    @Column(name = "dir_image")
    private String dirImage;

    @Column(name = "dir_audio")
    private String dirAudio;

    @Column(name = "dir_video")
    private String dirVideo;

    @Column(name = "correct")
    private Boolean correct;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_question")
    private Question question;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answer")
    private Collection<ResultQuestion> resultQuestions;

    public Answer() {}

    /**
     * Метод возрата id ответа
     * @return возращает id ответа
     */
    public Integer getIdAnswer() {
        return idAnswer;
    }

    /**
     * Метод установки id ответа
     * @param idAnswer id ответа
     */
    public void setIdAnswer(Integer idAnswer) {
        this.idAnswer = idAnswer;
    }

    /**
     * Метод получения текста ответа
     * @return возвращает текст ответа
     */
    public String getAnswerText() {
        return answerText;
    }

    /**
     * Метод установки текста ответа
     * @param answerText текст ответа
     */
    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    /**
     * Метод получения даты редактирования
     * @return возращает дату редактирования
     */
    public Date getDateEdit() {
        return dateEdit;
    }

    /**
     * Метод установки даты редактирования
     * @param dateEdit дата редактирования
     */
    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }

    /**
     * Метод получения адреса изображения ответа
     * @return возращает адрес изображения ответа
     */
    public String getDirImage() {
        return dirImage;
    }

    /**
     * Метод установки адреса изображения ответа
     * @param dirImage возращает адрес изображения ответа
     */
    public void setDirImage(String dirImage) {
        this.dirImage = dirImage;
    }

    /**
     * Метод получения адреса аудио ответа
     * @return возращает адрес аудио ответа
     */
    public String getDirAudio() {
        return dirAudio;
    }

    /**
     * Метод установки адреса аудио ответа
     * @param dirAudio адрес аудио ответа
     */
    public void setDirAudio(String dirAudio) {
        this.dirAudio = dirAudio;
    }

    /**
     * Метод получения адреса видео ответа
     * @return возращает адрес видео ответа
     */
    public String getDirVideo() {
        return dirVideo;
    }

    /**
     * Метод установки адреса видео ответа
     * @param dirVideo адрес видео ответа
     */
    public void setDirVideo(String dirVideo) {
        this.dirVideo = dirVideo;
    }

    /**
     * Метод получения правильности ответа
     * @return возращает логическое значение true или false в зависимости от правильности ответа
     */
    public Boolean getCorrect() {
        return correct;
    }

    /**
     * Метод установки правильности ответа
     * @param correct правильность ответа
     */
    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    /**
     * Метод получения пользователя, создавшего ответ
     * @return возращает пользователя, создавшего ответ
     */
    public User getUser() {
        return user;
    }

    /**
     * Метод установки пользователя, создавшего ответ
     * @param user пользователь, создавший ответ
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Метод получения вопроса, которому принадлежит ответ
     * @return возращает вопрос, которому принадлежит ответ
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Метод установки вопроса, которому принадлежит ответ
     * @param question возпрос, которому принадлежит ответ
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * Метод получения списка результатов по ответам, принадлежащим конретным вопросам
     * @return возращает коллекцию результатов по ответам, принадлежащим конретным вопросам
     */
    public Collection<ResultQuestion> getResultQuestions() {
        return resultQuestions;
    }

    /**
     * Метод установки списка результатов по ответам, принадлежащим конретным вопросам
     * @param resultQuestions коллекция результатов по ответам, принадлежащим конретным вопросам
     */
    public void setResultQuestions(Collection<ResultQuestion> resultQuestions) {
        this.resultQuestions = resultQuestions;
    }
}
