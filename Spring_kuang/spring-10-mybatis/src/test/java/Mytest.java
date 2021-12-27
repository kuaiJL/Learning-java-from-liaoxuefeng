import com.rafa.mapper.UserMapper;
import com.rafa.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class Mytest {


    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);

        for (User user : userMapper.selectUser()) {
            System.out.println(user);
        }
    }
}
