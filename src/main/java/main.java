import entity.BookEntity;
import factory.GetSqlSessionFactory;

import mapper.BookMapper;
import org.apache.ibatis.session.SqlSession;

public class main {

    public  static  void main(String[] args) {

        //如果sqlsessionFactory.openSession(true)参数是布尔值，如果设置为true，就不需要commit提交事务了
        SqlSession session = GetSqlSessionFactory.getSqlSessionFactory().openSession();
        try {
            BookMapper bookMapper = session.getMapper(BookMapper.class);
            //BookEntity bookEntity = bookMapper.selectBook(5);
            BookEntity bookEntity = new BookEntity();
            //bookEntity.setId(-1); insert 插入成功会返还最新的主键;
            bookEntity.setName("LiuLiFei");
            bookMapper.insertBook(bookEntity);

            //切记：增删改操作时，要执行commit操作 查询不需要执行commit();
            session.commit();
            System.out.println(bookEntity);
        } finally {
            session.close();
        }
    }
}
