package factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqlSessionFactory {


    public static SqlSessionFactory sqlSessionFactory = null;


    public  static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory == null) {
            sqlSessionFactory = builder();
        }
        return sqlSessionFactory;

    }
    public static SqlSessionFactory  builder(){

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            return  sqlSessionFactory;
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }
}
