package com.xmu.wowoto.aftersale;

import com.xmu.wowoto.aftersale.domain.AftersalesService;
import com.xmu.wowoto.aftersale.util.JacksonUtil;
import org.junit.jupiter.api.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AftersaleApplicationTests {
    @Value("http://${host}:${port}/aftersaleService/{id}/user")
    String url;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void test1() throws Exception{
        /* 登陆 */

        URI uri = new URI(url.replace("{id}", "1"));

        String response = testRestTemplate.getForObject(uri, String.class);

        Integer errno = JacksonUtil.parseInteger(response, "errno");
        assertEquals(0, errno);

        AftersalesService ass=JacksonUtil.parseObject(response,"data",AftersalesService.class);
        assertEquals(1, ass.getId());
        assertEquals(1001, ass.getUserId());
        assertEquals(false, ass.getType());
        assertEquals(3, ass.getNumber());
        assertEquals(10086, ass.getOrderItemId());
        assertEquals("不要了", ass.getApplyReason());
    }

}
