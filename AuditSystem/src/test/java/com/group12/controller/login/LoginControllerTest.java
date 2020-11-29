package com.group12.controller.login;


import com.group12.entity.Login;
import com.group12.entity.UserAccount;
import com.group12.factory.LoginFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Controller Test for login
 * Date: 22 September 2020
 */
@Deprecated
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginControllerTest
{
    private static Login login = LoginFactory.createLogin("brian@gmail.com", "123456");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/login";

    @Test
    public void a_create()
    {
        String url = baseURL + "/create";
        ResponseEntity<Login> postResponse = restTemplate.postForEntity(url, login, Login.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(login.getLoginID(), postResponse.getBody().getLoginID());
        System.out.println("URL: " + url);
        System.out.println("Body: " + postResponse.getBody());
    }

    @Test
    public void b_read()
    {
        String url = baseURL + "/read/" + login.getLoginID();
        ResponseEntity<Login> responseEntity = restTemplate.getForEntity(url, Login.class);
        assertEquals(login.getLoginID(), responseEntity.getBody().getLoginID());
        System.out.println("URL: " + url);
        System.out.println("Body: " + responseEntity.getBody());
    }

    @Test
    public void c_update()
    {
        Login updated = new Login.Builder().copy(login).setPassword("forthelulz456").build();
        String url = baseURL + "/update";
        ResponseEntity<Login> responseEntity = restTemplate.postForEntity(url, updated, Login.class);
        assertEquals(login.getLoginID(), responseEntity.getBody().getLoginID());
        System.out.println("URL: " + url);
        System.out.println("Body: " + updated);
    }

    @Test
    public void e_delete()
    {
        String url = baseURL + "/delete/" + login.getLoginID();
        System.out.println("URL: " + url);
        ResponseEntity updateResponse = restTemplate.exchange(url, HttpMethod.DELETE, null, boolean.class);
        assertEquals(updateResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void d_getAll()
    {
        String url = baseURL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
    }
}