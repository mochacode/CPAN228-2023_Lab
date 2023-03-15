package com.cpan228.Assignment2.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cpan228.Assignment2.model.Item;

//It will be an interface that defines operations with the item
//table in the database
//This interface will extend PagingAndSortingRepository, which will allow us to retrieve items in pages
public interface ItemRepositoryPaginated extends PagingAndSortingRepository<Item, Long> {
}