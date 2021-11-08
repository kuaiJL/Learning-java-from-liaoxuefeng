package g_Collection_.MAP_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Map_ {
    public static void main(String[] args){
        {
            Map<String, String> map = new HashMap();  //定义Map集合对象
            String s0 = map.put("apple", "新鲜的苹果");  //向集合中添加对象
            System.out.println(s0);//返回null
            map.put("computer", "配置优良的计算机");
            map.put("book", "堆积成山的图书");
            //原来关联的value对象"堆积成山的图书"就被“冲掉”了。实际上，put()方法的签名是V put(K key, V value)，
            // 如果放入的key已经存在，put()方法会返回被删除的旧的value，否则，返回null。
            String s = map.put("book", "堆积成山的图书1");
            System.out.println(s);
            Collection values = map.values();  //获取Map集合的value集合
            System.out.println(values.getClass());
            for (Object object : values) {
                System.out.println("键值:" + object.toString());  //输出键值对象
            }
            System.out.println("---------------------------");
            map.put("banana", "香蕉");
            map.put("huluobu", "胡萝卜");
            System.out.println(values);
            System.out.println("---------------------------");
            values.remove("新鲜的苹果");
            System.out.println(map);
        }
        System.out.println("---------------------------");
        System.out.println("蒯金亮".hashCode());
        for (int i = 0; i < 16; i++) {
            System.out.println(("蒯金亮"+i+"py").hashCode()& 0xf);
        }
    }
}
