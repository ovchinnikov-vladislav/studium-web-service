package ru.kamchatgtu.studium.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_answer")
    private Integer idAnswer;

    @Column(name = "text_answer")
    private String textAnswer;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss a z")
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
    private Boolean right;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_question")
    private Question question;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answer")
    private Set<ResultQuestion> resultQuestions;

    public Answer() {}

    public Integer getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Integer idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public Date getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(Date dateEdit) {
        this.dateEdit = dateEdit;
    }

    public String getDirImage() {
        return dirImage;
    }

    public void setDirImage(String dirImage) {
        this.dirImage = dirImage;
    }

    public String getDirAudio() {
        return dirAudio;
    }

    public void setDirAudio(String dirAudio) {
        this.dirAudio = dirAudio;
    }

    public String getDirVideo() {
        return dirVideo;
    }

    public void setDirVideo(String dirVideo) {
        this.dirVideo = dirVideo;
    }

    public Boolean getRight() {
        return right;
    }

    public void setRight(Boolean right) {
        this.right = right;
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

    public Set<ResultQuestion> getResultQuestions() {
        return resultQuestions;
    }

    public void setResultQuestions(Set<ResultQuestion> resultQuestions) {
        this.resultQuestions = resultQuestions;
    }
}
