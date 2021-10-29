package g_Collection_.MAP_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Map_ {
    public static void main(String[] args){
        Map map = new HashMap();  //定义Map集合对象
        map.put("apple","新鲜的苹果");  //向集合中添加对象
        map.put("computer","配置优良的计算机");
        map.put("book","堆积成山的图书");
        Collection values = map.values();  //获取Map集合的value集合
        System.out.println(values.getClass());
        for(Object object:values){
            System.out.println("键值:"+object.toString());  //输出键值对象
        }
        System.out.println("---------------------------");
        map.put("banana","香蕉");
        map.put("huluobu","胡萝卜");
        System.out.println(values);
        System.out.println("---------------------------");
        values.remove("新鲜的苹果");
        System.out.println(map);
    }
}
