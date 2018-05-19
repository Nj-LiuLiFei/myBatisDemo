import com.google.gson.Gson;
import entity.BookEntity;
import factory.GetSqlSessionFactory;

import mapper.BookMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

    public  static  void main(String[] args) {

        //如果sqlsessionFactory.openSession(true)参数是布尔值，如果设置为true，就不需要commit提交事务了
        SqlSession session = GetSqlSessionFactory.getSqlSessionFactory().openSession();
        try {
            Gson gson = new Gson();
            BookMapper bookMapper = session.getMapper(BookMapper.class);
            //BookEntity bookEntity = bookMapper.selectBook(5);
            BookEntity bookEntity = new BookEntity();
            //bookEntity.setId(-1); insert 插入成功会返还最新的主键;

            bookEntity.setId(1);
            bookEntity.setName("我是新的值");

            List<BookEntity> bookEntityList = bookMapper.getSelectBook("测试多行更新");
            System.out.println(bookEntityList);
            System.out.println(gson.toJson(bookEntityList));
            bookMapper.insertBook(bookEntity);
            //bookMapper.selectBook(1);
            //int row = bookMapper.updateBook(bookEntity); //更新的额时候会返回一个改变的行数

            //Map<String,String> map = new HashMap<String, String>();
            //map.put("sourceName","LiuLiFei");
            //map.put("newName","测试多行更新");
            //int row = bookMapper.updateBookName(map);
            //System.out.println("更新的行数："+row);
            //切记：增删改操作时，要执行commit操作 查询不需要执行commit();
            session.commit();

            System.out.println(bookEntity);
        } finally {
            session.close();
        }
    }
}
