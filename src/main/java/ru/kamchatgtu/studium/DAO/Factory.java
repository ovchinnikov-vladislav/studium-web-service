package ru.kamchatgtu.studium.DAO;

import ru.kamchatgtu.studium.DAO.impl.*;

/**
 * Объект класса {@code Factory} реализует фабричные методы singleton для следующих классов:
 * <br>1. AnswerDAOImpl
 * <br>2. DirectionDAOImpl
 * <br>3. FacultyDAOImpl
 * <br>4. GroupDAOImpl
 * <br>5. QuestionDAOImpl
 * <br>6. ResultQuestionDAOImpl
 * <br>7. ResultTestDAOImpl
 * <br>8. RoleDAOImpl
 * <br>9. SubjectDAOImpl
 * <br>10. TestDAOImpl
 * <br>11. ThemeDAOImpl
 * <br>12. UserDAOImpl
 * @author Овчинников В.А.
 */
public class Factory {

    private static final Factory instance;
    private AnswerDAOImpl answerDAO;
    private DirectionDAOImpl directionDAO;
    private FacultyDAOImpl facultyDAO;
    private GroupDAOImpl groupDAO;
    private QuestionDAOImpl questionDAO;
    private ResultQuestionDAOImpl resultQuestionDAO;
    private ResultTestDAOImpl resultTestDAO;
    private RoleDAOImpl roleDAO;
    private SubjectDAOImpl subjectDAO;
    private TestDAOImpl testDAO;
    private ThemeDAOImpl themeDAO;
    private UserDAOImpl userDAO;
    private LogDAOImpl logDAO;

    static {
        instance = new Factory();
    }

    private Factory() {
        answerDAO = new AnswerDAOImpl();
        directionDAO = new DirectionDAOImpl();
        facultyDAO = new FacultyDAOImpl();
        groupDAO = new GroupDAOImpl();
        questionDAO = new QuestionDAOImpl();
        resultQuestionDAO = new ResultQuestionDAOImpl();
        resultTestDAO = new ResultTestDAOImpl();
        roleDAO = new RoleDAOImpl();
        subjectDAO = new SubjectDAOImpl();
        testDAO = new TestDAOImpl();
        themeDAO = new ThemeDAOImpl();
        userDAO = new UserDAOImpl();
        logDAO = new LogDAOImpl();
    }

    /**
     * Метод возращения singleton объекта класса {@code Factory}
     * @return возращает объект класса {@code Factory}
     */
    public static synchronized Factory getInstance() {
        return instance;
    }

    /**
     * Метод возращения singleton объекта класса {@code AnswerDAOImpl}
     * @return возращает объект класса {@code AnswerDAOImpl}
     */
    public synchronized AnswerDAOImpl getAnswerDAO() {
        return answerDAO;
    }

    /**
     * Метод возращения singleton объекта класса {@code DirectionDAOImpl}
     * @return возращает объект класса {@code DirectionDAOImpl}
     */
    public synchronized DirectionDAOImpl getDirectionDAO() {
        return directionDAO;
    }

    /**
     * Метод возращения singleton объекта класса {@code FacultyDAOImpl}
     * @return возращает объект класса {@code FacultyDAOImpl}
     */
    public synchronized FacultyDAOImpl getFacultyDAO() {
        return facultyDAO;
    }

    /**
     * Метод возращения singleton объекта класса {@code GroupDAOImpl}
     * @return возращает объект класса {@code GroupDAOImpl}
     */
    public synchronized GroupDAOImpl getGroupDAO() {
        return groupDAO;
    }

    /**
     * Метод возращения singleton объекта класса {@code QuestionDAOImpl}
     * @return возращает объект класса {@code QuestionDAOImpl}
     */
    public synchronized QuestionDAOImpl getQuestionDAO() {
        return questionDAO;
    }

    /**
     * Метод возращения singleton объекта класса {@code ResultQuestionDAOImpl}
     * @return возращает объект класса {@code ResultQuestionDAOImpl}
     */
    public synchronized ResultQuestionDAOImpl getResultQuestionDAO() {
        return resultQuestionDAO;
    }

    /**
     * Метод возращения singleton объекта класса {@code ResultTestDAOImpl}
     * @return возращает объект класса {@code ResultTestDAOImpl}
     */
    public synchronized ResultTestDAOImpl getResultTestDAO() {
        return resultTestDAO;
    }

    /**
     * Метод возращения singleton объекта класса {@code RoleDAOImpl}
     * @return возращает объект класса {@code RoleDAOImpl}
     */
    public synchronized RoleDAOImpl getRoleDAO() {
        return roleDAO;
    }

    /**
     * Метод возращения singleton объекта класса {@code SubjectDAOImpl}
     * @return возращает объект класса {@code SubjectDAOImpl}
     */
    public synchronized SubjectDAOImpl getSubjectDAO() {
        return subjectDAO;
    }

    /**
     * Метод возращения singleton объекта класса {@code TestDAOImpl}
     * @return возращает объект класса {@code TestDAOImpl}
     */
    public synchronized TestDAOImpl getTestDAO() {
        return testDAO;
    }

    /**
     * Метод возращения singleton объекта класса {@code ThemeDAOImpl}
     * @return возращает объект класса {@code ThemeDAOImpl}
     */
    public synchronized ThemeDAOImpl getThemeDAO() {
        return themeDAO;
    }

    /**
     * Метод возращения singleton объекта класса {@code UserDAOImpl}
     * @return возращает объект класса {@code UserDAOImpl}
     */
    public synchronized UserDAOImpl getUserDAO() {
        return userDAO;
    }

    public synchronized LogDAOImpl getLogDAO() { return logDAO; }
}
