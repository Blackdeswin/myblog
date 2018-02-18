package ru.izebit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.izebit.model.Article;
import ru.izebit.service.ArticleService;


@Controller
@RequestMapping("/blog")
public class MainController {

    @Autowired
    private ArticleService service;

    @RequestMapping
    public String mainPage(Model model) {
        model.addAttribute("articles", service.getAll());
        return "main";
    }

    @RequestMapping(value = "/admin")
    public String adminPage(Model model) {
        model.addAttribute("article", new Article());//Добовляе в модель новый объект Article, у котрого поля пустые
        return "admin"; // Отображет страницу с названием admin
    }

    @RequestMapping(value = "/admin/submit", method = RequestMethod.POST)
    public String submitArticle(@ModelAttribute Article article) {// Получает данные со страницы и сохраняет в бд
        service.save(article);
        return "redirect:../";
    }

    @RequestMapping(value = "/admin/submit2", method = RequestMethod.POST)
    public String deleteArticle(@ModelAttribute Article article) {// Получает данные со страницы и сохраняет в бд
        service.deleteAll(article);
        return "redirect:../";
    }
    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
