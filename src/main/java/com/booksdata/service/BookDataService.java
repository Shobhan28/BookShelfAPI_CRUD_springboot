package com.booksdata.service;

import com.booksdata.entity.Books;
import com.booksdata.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class BookDataService {

        @Autowired
       private BookRepo bookRepo;

        // retrive all books
        public List<Books> getBooks(){
            return bookRepo.findAll();
        }

        // retreive a spacific book by ID
        public Books getBookById(int id){
            try{
                return bookRepo.findById(id);
            }
            catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }

        // create
        public void addNewBook(Books books){
            bookRepo.save(books);
        }

        // delete
        public void deleteBookById(int id){
            try{
                bookRepo.deleteById(id);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        // Update
        public Books updateById(Books book, int id){
            book.setId(id);
            try{
                bookRepo.deleteById(id);
            }
            catch(Exception e){
                e.printStackTrace();
            }

            bookRepo.save(book);
            return book;
        }

    }
