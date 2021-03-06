package ru.izebit.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity  //Говорить фреймворку, что класс будет сохраняться в БД
public class Article implements Serializable, Comparable<Article> {

    @Id
    @GeneratedValue  //Говорить фреймворку, что данное значение будет сгенерированно автоматически при вставки
                        //ответа
    private Integer id;
    @Column // Говорить фреймворку, что данное значение будет маппиться в колонку
    // Можно написать явно название колонки @Column(name="")
    private String title;
    @Column(length = 1000000)
    @Lob
    private String content;
    @Column
    private long creationTimestamp;

    public Article() {
        this.creationTimestamp = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Article that) {
        return Long.compare(this.creationTimestamp, that.creationTimestamp);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
