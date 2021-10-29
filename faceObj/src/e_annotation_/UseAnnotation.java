package e_annotation_;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class UseAnnotation {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        person.name="kjl";
        person.city="中国台湾省台北市";
        //check(person); 用这个，check函数得加 static 修饰
        UseAnnotation useAnnotation = new UseAnnotation();
        useAnnotation.check(person);
    }

     void check(Person person) throws IllegalAccessException {
         // 遍历所有Field:
        for(Field field : person.getClass().getFields()){
            Range range = field.getAnnotation(Range.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(person);
                // 如果值是String:
                if (value instanceof String) {
                    String s = (String) value;
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: "+ field.getName());
                    }
                }
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {
    int min() default 0;
    int max() default 255;
}

class Person {
    @Range(min = 1 , max = 20)
    public String name;

    @Range(max = 10)
    public String city;
}