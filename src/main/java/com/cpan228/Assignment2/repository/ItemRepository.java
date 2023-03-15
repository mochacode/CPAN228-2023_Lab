package com.cpan228.Assignment2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpan228.Assignment2.model.Item;
import com.cpan228.Assignment2.model.Item.Brand;


public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByBrandFrom(Brand brand);

    List<Item> findByNameStartsWithAndCreatedAtBetween(String name, LocalDate startDate, LocalDate endDate);
}