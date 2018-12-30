package ru.kamchatgtu.studium.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Integer idQuestion;

    @Column(name = "text_question")
    private String textQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_theme")
    private Theme theme;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss a z")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_edit")
    private Date dateReg;

    @Column(name = "type_question")
    private Byte typeQuestion;

    @Column(name = "dir_image")
    private String dirImage;

    @Column(name = "dir_audio")
    private String dirAudio;

    @Column(name = "dir_video")
    private String dirVideo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Set<Answer> answers;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Set<ResultQuestion> resultQuestions;

    public Question() {}

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    public Byte getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(Byte typeQuestion) {
        this.typeQuestion = typeQuestion;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public Set<ResultQuestion> getResultQuestions() {
        return resultQuestions;
    }

    public void setResultQuestions(Set<ResultQuestion> resultQuestions) {
        this.resultQuestions = resultQuestions;
    }
}
