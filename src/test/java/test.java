import com.ucar.training.domain.User;
import com.ucar.training.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class test {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.userChange(new User("zeming", "123456", "100", "man", "2", "15795618", "456489@sad.ccc", "code,game", "臭傻逼"));
        System.out.println(i);
    }
}
