package com.organization.LibraryApp.dto;

public record BookDto(Long id, String title, String author, String category, boolean available, double price) {
    public static BookDto fromEntity(com.organization.LibraryApp.book.model.Book book) {
        return new BookDto(
            book.getId(),
            book.getTitle(),
            book.getAuthor(),
            book.getCategory(),
            book.isAvailable(),
            book.getPrice()
        );
    }

}
