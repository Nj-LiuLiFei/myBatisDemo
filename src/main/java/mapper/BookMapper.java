package mapper;

import entity.BookEntity;

import java.util.List;
import java.util.Map;


public interface BookMapper {
    BookEntity selectBook(int id);
    List<BookEntity> getSelectBook(String name);
    void insertBook(BookEntity bookEntity);
    int updateBook(BookEntity bookEntity);
    int updateBookName(Map<String,String> map);
}
