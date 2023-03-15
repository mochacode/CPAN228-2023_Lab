package com.cpan228.Assignment2.controller;

import java.util.EnumSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan228.Assignment2.model.Item;
import com.cpan228.Assignment2.model.Item.Brand;
// import com.cpan228.Assignment2.repository.ItemRepository;

// import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping("/stock")
public class StockController {

    @GetMapping
    public String stock() {
        return "stock";
    }

    @ModelAttribute
    public void brands(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
        log.info("brands converted to string:  {}", brands);
    }

    @ModelAttribute
    public Item item() {
        return Item
                .builder()
                .build();
    }

}
