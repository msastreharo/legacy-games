package org.factoriaf5.legacygames.controllers;

import org.factoriaf5.legacygames.models.Category;
import org.factoriaf5.legacygames.models.Game;
import org.factoriaf5.legacygames.services.CategoryService;
import org.factoriaf5.legacygames.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private GameService gameService;
    private CategoryService categoryService;

    @Autowired
    public HomeController(GameService gameService, CategoryService categoryService) {
        this.gameService = gameService;
        this.categoryService = categoryService;
    }

    @GetMapping(path={"/", "/home", "/index"})
    public String home(Model model, @RequestParam(required = false) Long categoryId) {
        List<Game> games;
        if (categoryId == null) {
            games = gameService.allGames();
        } else {
            Category category = categoryService.getCategory(categoryId);
            games = category.getGames();
        }

        model.addAttribute("title", "Game List");
        model.addAttribute("games", games);
        model.addAttribute("categories", categoryService.allCategories());
        return "home";
    }
}