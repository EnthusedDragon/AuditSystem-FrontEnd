package com.group12.controller.faculty;

import com.group12.entity.Faculty;
import com.group12.factory.FacultyFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;


/**  Author: Ebenezer Mathebula
 *   Student no: 217301827
 *   Date: 26-09-2020
 *   Description: Tests for the Faculty Controller
 */


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacultyControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/AuditSystem/faculty/";

    private static final String Admin_Username = "Boss";
    private static final String Admin_Password = "123";


    @Test
    public void a_create() {
        System.out.println("\nCREATE");

        String url = baseURL + "create";

        try {
            // Instances to test with
            Faculty engineering = FacultyFactory.createFaculty("Engineering");
            Faculty accounting = FacultyFactory.createFaculty("Accounting");
            Faculty acting = FacultyFactory.createFaculty("Acting");

            ResponseEntity<String> engPostRes = restTemplate.withBasicAuth(Admin_Username, Admin_Password).postForEntity(url, engineering, String.class);
            ResponseEntity<String> accPostRes = restTemplate.withBasicAuth(Admin_Username, Admin_Password).postForEntity(url, accounting, String.class);
            ResponseEntity<String> actPostRes = restTemplate.withBasicAuth(Admin_Username, Admin_Password).postForEntity(url, acting, String.class);

            Assert.assertEquals(200, engPostRes.getStatusCodeValue());
            System.out.println("");
        }
        catch (Exception e) {
            Assert.fail();
        }

    }


    @Test
    public void c_getAllStartingWith() {
        System.out.println("GET ALL STARTING WITH");

        String url = baseURL + "getAllStartWith/Ac";
        ResponseEntity<HashSet> getRes = restTemplate.withBasicAuth(Admin_Username, Admin_Password).getForEntity(url, HashSet.class);

        Assert.assertEquals(200, getRes.getStatusCodeValue());

        for (Object fac: getRes.getBody()){
            System.out.println(fac);
        }
        System.out.println("");
    }

    @Test
    public void d_getByName() {
        System.out.println("GET BY NAME");

        String name = "Acting";
        String url = baseURL + "getByName/" + name;

        ResponseEntity<String> getRes = restTemplate.withBasicAuth(Admin_Username, Admin_Password).getForEntity(url, String.class);

        Assert.assertEquals(200, getRes.getStatusCodeValue());

        System.out.println(getRes.getBody());
        System.out.println("");
    }

    @Test
    public void e_getById() {
        System.out.println("GET BY ID");

        String id = restTemplate.getForEntity(baseURL+"getByName/Acting", Faculty.class).getBody().getFacultyId();

        String url = baseURL + "getById/" + id;

        ResponseEntity<String> getRes = restTemplate.withBasicAuth(Admin_Username, Admin_Password).getForEntity(url, String.class);

        Assert.assertEquals(200, getRes.getStatusCodeValue());

        System.out.println(getRes.getBody());
        System.out.println("");
    }

    @Test
    public void f_update() {
        System.out.println("UPDATE");
        String url = baseURL + "update";

        Faculty accounting = restTemplate.withBasicAuth(Admin_Username, Admin_Password).getForEntity(baseURL + "getByName/Accounting", Faculty.class).getBody();

        Faculty newAccounting = new Faculty
                .Builder()
                .copy(accounting)
                .setFacultyName("Financial Accounting")
                .build();

        HttpEntity<Faculty> request = new HttpEntity<>(newAccounting, null);
        ResponseEntity<Faculty> res = restTemplate.withBasicAuth(Admin_Username, Admin_Password).exchange(url, HttpMethod.PUT, request, Faculty.class);

        Assert.assertEquals(200, res.getStatusCodeValue());

        System.out.println(res.getBody());
        System.out.println("");
    }

    @Test
    public void g_delete() {
        System.out.println("DELETE");

        String id = restTemplate.withBasicAuth(Admin_Username, Admin_Password).getForEntity(baseURL + "getByName/Engineering", Faculty.class).getBody().getFacultyId();
        String url = baseURL + "delete/" + id;

        ResponseEntity delRes = restTemplate.withBasicAuth(Admin_Username, Admin_Password).exchange(url, HttpMethod.DELETE, null, boolean.class);

        Assert.assertEquals(200, delRes.getStatusCodeValue());

        System.out.println(delRes.getBody());
        System.out.println("");

    }


    @Test
    public void h_getAll() {
        System.out.println("GET ALL");
        String url = baseURL + "getAll";

        ResponseEntity<HashSet> getRes = restTemplate.withBasicAuth(Admin_Username, Admin_Password).getForEntity(url, HashSet.class);

        Assert.assertEquals(200, getRes.getStatusCodeValue());

        for (Object fac: getRes.getBody()){
            System.out.println(fac);
        }
        System.out.println("");
    }



}