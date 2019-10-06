package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.entity.Theme;
import ru.kamchatgtu.studium.rest.Service;
import java.util.Collection;

/**
 * Объект класса {@code ThemeService} отвечает за сервис доступа к темам:
 * <br>1. Получение темы по id
 * <br>2. Получение всех тем
 * <br>3. Добавление темы
 * <br>4. Удаление темы
 * <br>5. Обновление темы
 * <br>6. Поиск тем
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/theme_service
 * @author Овчинников В.А.
 */
@RestController
@RequestMapping(value = "/theme_service")
public class ThemeService extends Service<Theme> {

    public ThemeService() {
        super(Factory.getInstance().getThemeDAO());
    }

    /**
     * Get-метод получения темы по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/theme_service/theme?id=[Код темы]
     * @param id код темы
     * @return возвращает тему
     */
    @Override
    @GetMapping(value = "/theme", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Theme get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех тем. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/theme_service/themes
     * @return возвращает коллекцию тем
     */
    @Override
    @GetMapping(value = "/themes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления темы. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/theme_service/add
     * @param request тема
     * @return возвращает тему
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Theme add(@RequestBody Theme request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления темы. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/theme_service/delete
     * @param request тема
     * @return возвращает тему
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Theme remove(@RequestBody Theme request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления темы. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/theme_service/update
     * @param request тема
     * @return возвращает тему
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Theme update(@RequestBody Theme request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска тем. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/theme_service/search
     * @param request тема
     * @return возвращает коллекцию тем
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody Theme request) {
        return super.search(request);
    }
}
