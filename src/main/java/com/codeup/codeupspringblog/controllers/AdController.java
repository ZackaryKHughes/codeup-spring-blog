package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.AdUser;
import com.codeup.codeupspringblog.repositories.AdRepository;
import com.codeup.codeupspringblog.repositories.AdUserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class AdController {

    private final EmailService emailService;

    private final AdRepository adDao;
    private final AdUserRepository adUserDao;

    public AdController(EmailService emailService, AdRepository adDao, AdUserRepository adUserDao) {
        this.emailService = emailService;
        this.adDao = adDao;
        this.adUserDao = adUserDao;
    }

    @GetMapping("/ads")
    public String index(Model model) {
        model.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/create")
    public String createAdForm(Model model){
        model.addAttribute("ad", new Ad());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String createAdInDB(@ModelAttribute Ad ad){
        System.out.println(ad.toString());

        AdUser user = (AdUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(user);

        ad.setUser(user);
        adDao.save(ad);


        emailService.sendAdEmail(ad, "yo here's your ad", "ok this is a body");

        return "redirect:/ads";
    }

    @GetMapping("/ads/{id}")
    public String showOneAd(@PathVariable long id, Model model){
        Ad ad = adDao.findAdById(id);
        model.addAttribute("ad", Objects.requireNonNullElseGet(ad, () -> new Ad("not found", "could not find that ad")));
        return "ads/show";
    }

}