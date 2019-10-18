import com.ucar.training.domain.User;
import com.ucar.training.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import java.io.IOException;
import java.io.InputStream;

public class test {

    @Autowired
    public JmsTemplate jmsTemplate;

    @Test
    public static void jsm() {

    }


}
