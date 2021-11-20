import com.kuai.service.UserService;
import com.kuai.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest1 {
    public static void main(String[] args) {
        //获取ApplicationContext: 拿到spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.getUser();
//        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
//        userServiceImpl.getUser();
    }
}
