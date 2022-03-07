package com.br.vetstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/")
public class MainController {
  @Autowired
  private AnimalsRepository animalsRepository;

  @Autowired
  private CategoriesRepository categoriesRepository;
  
  private static final String ONLINE = "Online";

  @PostMapping(path="/animals/add")
  public @ResponseBody String addNewAnimal (
    @RequestParam Integer categorieId,
    @RequestParam String name,
    @RequestParam String age,
    @RequestParam String photo,
    @RequestParam String owner,
    @RequestParam String info,
    @RequestParam String created) {

    Animals n = new Animals();
    n.setCategorieId(categorieId);
    n.setName(name);
    n.setAge(age);
    n.setPhoto(photo);
    n.setOwner(owner);
    n.setInfo(info);
    n.setCreated(created);
    animalsRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/animals")
  public @ResponseBody Iterable<Animals> getAllAnimals() {
    return animalsRepository.findAll();
  }

  @PostMapping(path="/categories/add")
  public @ResponseBody String addNewCategory (@RequestParam String name, @RequestParam String slug) {

    Categories n = new Categories();
    n.setName(name);
    n.setSlug(slug);
    categoriesRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/categories")
  public @ResponseBody Iterable<Categories> getAllCategories() {
    return categoriesRepository.findAll();
  }

  @GetMapping(path="/")
  public @ResponseBody Home home() {
    return new Home(ONLINE);
  }
}