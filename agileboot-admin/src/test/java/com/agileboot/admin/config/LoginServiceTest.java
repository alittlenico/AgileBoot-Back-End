package com.agileboot.admin.config;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import com.agileboot.admin.AgileBootAdminApplication;
import com.agileboot.common.config.AgileBootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2023/5/5 15:51
 */
@SpringBootTest(classes = AgileBootAdminApplication.class)
@RunWith(SpringRunner.class)
public class LoginServiceTest {
    @Test
    public void test() {
        String originalPassword = "gA8LonbonJlxHOW1oqhlfeXr7HkUQxSkRERA6Rm1Q+r70yES16WszsOZaLNKCItxOjrg0irdx6PLnl1F43daTn4bBpBpzhzqKov2yABiSgJx38CfQrrwSB5m0SH4F2o2jBzVGULXV3c5UEbeVUeZ+NPItesm5+54dPYbQj/tl+Y=";
        byte[] decodedPassword = Base64.decode(originalPassword);
        String privateKey = AgileBootConfig.getRsaPrivateKey();
        byte[] decryptedPassword = SecureUtil.rsa(privateKey, null).decrypt(decodedPassword, KeyType.PrivateKey);
        String decryptedPasswordString = new String(decryptedPassword);
        System.out.println(decryptedPasswordString);
    }
}
