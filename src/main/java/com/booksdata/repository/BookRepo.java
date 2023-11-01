package com.booksdata.repository;


import com.booksdata.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface BookRepo extends JpaRepository<Books,Integer> {
        public Books findById(int id);
    }

