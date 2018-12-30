package ru.kamchatgtu.studium.DAO;

import ru.kamchatgtu.studium.DAO.impl.*;

public class Factory {

    private static final Factory instance;
    private AnswerDAOImpl answerDAO;
    private GroupDAOImpl groupDAO;
    private PositionDAOImpl positionDAO;
    private QuestionDAOImpl questionDAO;
    private ThemeDAOImpl themeDAO;
    private ResultQuestionDAOImpl resultQuestionDAO;
    private ResultTestDAOImpl resultTestDAO;
    private SubjectDAOImpl subjectDAO;
    private TestDAOImpl testDAO;
    private UserDAOImpl userDAO;

    static {
        instance = new Factory();
    }

    private Factory() {
        answerDAO = new AnswerDAOImpl();
        groupDAO = new GroupDAOImpl();
        positionDAO = new PositionDAOImpl();
        questionDAO = new QuestionDAOImpl();
        resultTestDAO = new ResultTestDAOImpl();
        resultQuestionDAO = new ResultQuestionDAOImpl();
        subjectDAO = new SubjectDAOImpl();
        testDAO = new TestDAOImpl();
        userDAO = new UserDAOImpl();
        themeDAO = new ThemeDAOImpl();
    }

    public static synchronized Factory getInstance() {
        return instance;
    }

    public synchronized AnswerDAOImpl getAnswerDAO() {
        return answerDAO;
    }

    public synchronized GroupDAOImpl getGroupDAO() {
        return groupDAO;
    }

    public synchronized PositionDAOImpl getPositionDAO() {
        return positionDAO;
    }

    public synchronized QuestionDAOImpl getQuestionDAO() {
        return questionDAO;
    }

    public synchronized ThemeDAOImpl getThemeDAO() {return themeDAO;}

    public synchronized ResultTestDAOImpl getResultTestDAO() {
        return resultTestDAO;
    }

    public synchronized ResultQuestionDAOImpl getResultQuestionDAO() {
        return resultQuestionDAO;
    }

    public synchronized SubjectDAOImpl getSubjectDAO() {
        return subjectDAO;
    }

    public synchronized TestDAOImpl getTestDAO() {
        return testDAO;
    }

    public synchronized UserDAOImpl getUserDAO() {
        return userDAO;
    }
}
