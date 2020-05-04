package com.book_store.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoBookDetails extends CrudRepository<BookDetails, Long>{
}
