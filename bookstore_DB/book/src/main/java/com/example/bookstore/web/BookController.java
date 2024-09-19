package com.example.bookstore.web;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.bookstore.domain.Book;
import com.example.bookstore.repository.BookRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

import org.slf4j.Logger;

@Controller
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = {"/", "/booklist"})
    public String booklist(Model model) {
       model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @RequestMapping("/addbook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addBook(Book book) {
        log.info("Saving book: " + book);
        bookRepository.save(book);
        return "redirect:/booklist";
    }
    
    @RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    } 

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long id, Model model) {
        Optional<Book> book = bookRepository.findById(id);
        model.addAttribute("book", book.get());
        return "editbook";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }
    
}
