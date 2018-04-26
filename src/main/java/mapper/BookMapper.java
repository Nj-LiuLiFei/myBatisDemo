package mapper;

import entity.BookEntity;



public interface BookMapper {
    BookEntity selectBook(int id);
    void insertBook(BookEntity bookEntity);
}
