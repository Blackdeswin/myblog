package ru.izebit.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.izebit.model.Article;

/**
 * @author <a href="mailto:izebit@gmail.com">Artem Konovalov</a> <br/>
 *         Creation date: 6/25/17.
 * @since 1.0
 */
@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer>{
    //Article - название класса, объекты которогог будут сохраняться в базу данных {
// Интерфейс для работы с БД(получать значения, задавать значения)
}
