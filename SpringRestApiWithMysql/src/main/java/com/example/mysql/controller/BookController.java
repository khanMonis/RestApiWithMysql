package com.example.mysql.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mysql.model.Book;
import com.example.mysql.repo.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@PostMapping("/bookSave")
	public String insertBook(@RequestBody Book book){
		bookRepository.save(book);
	return "Your record is saved Succcessfully !!!!";
		}
	
	@PostMapping("/multipleBookSave")
	public String insertBook(@RequestBody List<Book> book){
		bookRepository.saveAll(book);
	return "Your record is saved Succcessfully !!!!";
		}
	
	@GetMapping("/getallBook")
	public List<Book> getBook(){
	return (List<Book>)	bookRepository.findAll();
		}
	@GetMapping("/getByBookID/{bookId}")
	public Optional<Book> getBookById(@PathVariable("bookId")Long id){
	return bookRepository.findById(id);
		}
	@GetMapping("/getByBookName/{name}")
	public List<Book> getBookByName(@PathVariable("name")String bookName){
	return (List<Book>)	bookRepository.findBybookName(bookName);
		}
}
