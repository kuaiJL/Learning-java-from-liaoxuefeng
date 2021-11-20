import com.kuai.dao.UserDaoMysqlImpl;
import com.kuai.dao.UserDaoOracleImpl;
import com.kuai.service.UserService;
import com.kuai.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        //MyTest相当于客户端，通过setUserDao(new UserDaoOracleImpl())，
        // 用户可以设置使用何种对象。这就叫控制反转。
        ((UserServiceImpl) userService).setUserDao(new UserDaoOracleImpl());
        userService.getUser();
    }
}
