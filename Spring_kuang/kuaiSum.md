F:\Java\jdk-17\bin\java.exe "-javaagent:F:\idea_2021.2.2\IntelliJ IDEA 2021.2.2\lib\idea_rt.jar=55679:F:\idea_2021.2.2\IntelliJ IDEA 2021.2.2\bin" -Dfile.encoding=UTF-8 -classpath F:\java_workspace\kjl_learn_liaoJava\Spring_kuang\spring-10-mybatis\target\test-classes;F:\java_workspace\kjl_learn_liaoJava\Spring_kuang\spring-10-mybatis\target\classes;F:\maven\repository\org\springframework\spring-webmvc\5.2.0.RELEASE\spring-webmvc-5.2.0.RELEASE.jar;F:\maven\repository\org\springframework\spring-aop\5.2.0.RELEASE\spring-aop-5.2.0.RELEASE.jar;F:\maven\repository\org\springframework\spring-beans\5.2.0.RELEASE\spring-beans-5.2.0.RELEASE.jar;F:\maven\repository\org\springframework\spring-context\5.2.0.RELEASE\spring-context-5.2.0.RELEASE.jar;F:\maven\repository\org\springframework\spring-core\5.2.0.RELEASE\spring-core-5.2.0.RELEASE.jar;F:\maven\repository\org\springframework\spring-jcl\5.2.0.RELEASE\spring-jcl-5.2.0.RELEASE.jar;F:\maven\repository\org\springframework\spring-expression\5.2.0.RELEASE\spring-expression-5.2.0.RELEASE.jar;F:\maven\repository\org\springframework\spring-web\5.2.0.RELEASE\spring-web-5.2.0.RELEASE.jar;F:\maven\repository\org\springframework\spring-jdbc\5.3.12\spring-jdbc-5.3.12.jar;F:\maven\repository\org\springframework\spring-tx\5.3.12\spring-tx-5.3.12.jar;F:\maven\repository\org\aspectj\aspectjweaver\1.9.4\aspectjweaver-1.9.4.jar;F:\maven\repository\org\mybatis\mybatis-spring\2.0.6\mybatis-spring-2.0.6.jar;F:\maven\repository\org\mybatis\mybatis\3.5.2\mybatis-3.5.2.jar;F:\maven\repository\junit\junit\4.12\junit-4.12.jar;F:\maven\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;F:\maven\repository\mysql\mysql-connector-java\8.0.27\mysql-connector-java-8.0.27.jar;F:\maven\repository\com\google\protobuf\protobuf-java\3.11.4\protobuf-java-3.11.4.jar Mytest
12月 05, 2021 8:04:54 上午 org.apache.ibatis.logging.commons.JakartaCommonsLoggingImpl warn
警告: Property 'mapperLocations' was specified but matching resources are not found.
Exception in thread "main" org.apache.ibatis.binding.BindingException: Type interface com.rafa.mapper.UserMapper is not known to the MapperRegistry.
at org.apache.ibatis.binding.MapperRegistry.getMapper(MapperRegistry.java:47)
at org.apache.ibatis.session.Configuration.getMapper(Configuration.java:779)
at org.mybatis.spring.SqlSessionTemplate.getMapper(SqlSessionTemplate.java:312)
at com.rafa.mapper.UserMapperImpl.selectUser(UserMapperImpl.java:17)
at Mytest.main(Mytest.java:16)

Process finished with exit code 1

**ANS:**
```xml
<build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>
```