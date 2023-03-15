package com.cpan228.Assignment2.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpan228.Assignment2.model.dto.ItemSearchByDateDto;
import com.cpan228.Assignment2.repository.ItemRepository;
import com.cpan228.Assignment2.repository.ItemRepositoryPaginated;

@Controller
@RequestMapping("/itemlist")
public class ItemListController {
    private static final int PAGE_SIZE = 5;
    private ItemRepository itemRepository;

    private ItemRepositoryPaginated itemRepositoryPaginated;

    public ItemListController(ItemRepository itemRepository,
            ItemRepositoryPaginated itemRepositoryPaginated) {
        this.itemRepository = itemRepository;
        this.itemRepositoryPaginated = itemRepositoryPaginated;
    }

    @GetMapping
    public String showItems(Model model) {
        return "itemlist";
    }

    /**
     * This method will allow us to populate the model with initial item details
     * 1. We will use the itemRepositoryPaginated to retrieve the first page of
     * items (we set the page size to 5)
     * 
     * @param model
     */
    @ModelAttribute
    public void items(Model model) {
        var itemPage = itemRepositoryPaginated.findAll(PageRequest.of(0, PAGE_SIZE));
        model.addAttribute("items", itemPage);
        model.addAttribute("currentPage", itemPage.getNumber());
        model.addAttribute("totalPages", itemPage.getTotalPages());
    }

    @ModelAttribute
    public void itemsByDateDto(Model model) {
        model.addAttribute("itemsByDateDto", new ItemSearchByDateDto());
    }

    @PostMapping
    public String searchItemsByDate(@ModelAttribute ItemSearchByDateDto itemsByDateDto,
            Model model) {
        var dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        model.addAttribute("items", itemRepository.findByNameStartsWithAndCreatedAtBetween(
                itemsByDateDto.getName(), LocalDate.parse(itemsByDateDto.getStartDate(), dateFormatter),
                LocalDate.parse(itemsByDateDto.getEndDate(), dateFormatter)));
        return "itemlist";
    }

    @GetMapping("/switchPage")
    public String switchPage(Model model,
            @RequestParam("pageToSwitch") Optional<Integer> pageToSwitch) {
        var page = pageToSwitch.orElse(0);
        var totalPages = (int) model.getAttribute("totalPages");
        if (page < 0 || page >= totalPages) {
            return "itemlist";
        }
        var itemPage = itemRepositoryPaginated.findAll(PageRequest.of(pageToSwitch.orElse(0),
                PAGE_SIZE));
        model.addAttribute("items", itemPage.getContent());
        model.addAttribute("currentPage", itemPage.getNumber());
        return "itemlist";
    }
}