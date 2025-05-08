package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    private CustomHashMap<String,Book> bookMap;

    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        bookMap = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new NullPointerException("Book cannot be null");
        }
        bookMap.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        if (isbn == null) {
            throw new NullPointerException("ISBN cannot be null");
        }
        Book book = bookMap.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found");
        }
        return book;
    }

    public boolean isBookAvailable(String isbn) {
        Book book = this.getBookByIsbn(isbn);
        return book.isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book book = this.getBookByIsbn(isbn);
        book.setAvailable(available);
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = this.getBookByIsbn(isbn);
        Member member = memberManager.getMember(memberId);
        book.addToWaitlist(member);
    }

    public Member getNextFromWaitlist(String isbn) {
        Book book = this.getBookByIsbn(isbn);
        return book.getNextInWaitlist();
    }

    public boolean hasWaitlist(String isbn) {
        Book book = this.getBookByIsbn(isbn);
        return book.hasWaitlist();
    }
}