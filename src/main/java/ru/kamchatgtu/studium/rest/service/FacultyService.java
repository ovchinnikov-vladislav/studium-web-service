package ru.kamchatgtu.studium.rest.service;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.entity.Faculty;
import ru.kamchatgtu.studium.rest.Service;
import java.util.Collection;

/**
 * Объект класса {@code FacultyService} отвечает за сервис доступа к факультетам:
 * <br>1. Получение факультета по id
 * <br>2. Получение всех факультетов
 * <br>3. Добавление факультета
 * <br>4. Удаление факультета
 * <br>5. Обновление факультета
 * <br>6. Поиск факультета
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/faculty_service
 * @author Овчинников В.А.
 */
@RestController
@RequestMapping(value = "/faculty_service")
public class FacultyService extends Service<Faculty> {

    public FacultyService() {
        super(Factory.getInstance().getFacultyDAO());
    }

    /**
     * Get-метод получения факультета по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/faculty_service/faculty?id=[Код факультета]
     * @param id код факультета
     * @return возвращает факультет
     */
    @Override
    @GetMapping(value = "/faculty", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Faculty get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех факультетов. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/faculty_service/faculties
     * @return возвращает коллекцию направлений подготовки
     */
    @Override
    @GetMapping(value = "/faculties", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления факультета. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/faculty_service/add
     * @param request факультетов
     * @return возвращает факультетов
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Faculty add(@RequestBody Faculty request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления факультета. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/faculty_service/delete
     * @param request факультет
     * @return возвращает факультет
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Faculty remove(@RequestBody Faculty request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления факультета. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/faculty_service/update
     * @param request факультет
     * @return возвращает факультет
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Faculty update(@RequestBody Faculty request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска факультетов. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/faculty_service/search
     * @param request факультет
     * @return возвращает коллекцию факультетов
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody Faculty request) {
        return super.search(request);
    }
}
