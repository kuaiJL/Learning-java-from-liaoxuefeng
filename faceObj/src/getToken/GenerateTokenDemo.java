package getToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * All rights Reserved, Designed By fudabd
 */
public class GenerateTokenDemo {
    public static void main(String[] args) {
        //1、生成数据签名
        String appId = "xxxxx5358eeb9b2ee399d308b6b98e98fa5c6";
        // secrerKey 授权码的密钥
        String secretKey = "xxxxxc2934c5b7295a66ab707cc955fd1640314984233nhQ";
        //时间戳
        Long timestamp = System.currentTimeMillis();
        List<String> tokenParams = new ArrayList<>();
        System.out.println(timestamp);
        tokenParams.add(appId);
        tokenParams.add(secretKey);
        tokenParams.add(timestamp + "");
        //自然排序
        Collections.sort(tokenParams);
        //生成token 签名
        System.out.println(tokenParams.toString());
        String tokenSignature = MD5.MD5Encode(tokenParams.toString());
        System.out.println(tokenSignature);
    }
}