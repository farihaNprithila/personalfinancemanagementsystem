package com.fariha.userservice.data.repository.temp;

import com.fariha.userservice.data.entity.temp.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
