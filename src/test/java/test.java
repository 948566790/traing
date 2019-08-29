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
        String a = "我是谁";
        a = a.replace("是", "撒大");
        System.out.println(a);
    }
}
