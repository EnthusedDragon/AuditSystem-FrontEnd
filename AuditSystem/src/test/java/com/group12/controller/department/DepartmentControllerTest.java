package com.group12.controller.department;

import com.group12.entity.Department;
import com.group12.factory.DepartmentFactory;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**  Author: Enver Human
 *   Student no: 216174929
 *   Date: 27-09-2020
 *   Description: Testing Controller  for Department
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentControllerTest {


    private static String USERNAME = "Client";
    private static String PASSWORD = "147";



    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/department";

    private Department department = DepartmentFactory.createDepartment("MultimediaTechnology", "1234-1234");
    private Department electricalEngineering = DepartmentFactory.createDepartment("ElectricalEngineering", "1234-1234");


    @Test
    public void a_create() {


        String url = baseURL + "/create";

        try {




            ResponseEntity<String> engPostRes = restTemplate.withBasicAuth(USERNAME, PASSWORD).postForEntity(url, department, String.class);
            ResponseEntity<String> accPostRes = restTemplate.withBasicAuth(USERNAME, PASSWORD).postForEntity(url, electricalEngineering, String.class);


            assertEquals(200, engPostRes.getStatusCodeValue());
            System.out.println("");
        }
        catch (Exception e) {
            Assert.fail();
        }

    }

    @Test
    public void b_read() {
        try {

            String urlRead = baseURL+"/readDepartment?departmentID="+department.getDepid();

            ResponseEntity<Department> responseDepartment = restTemplate.withBasicAuth(USERNAME, PASSWORD).getForEntity(urlRead, Department.class);

            System.out.printf(responseDepartment.getBody().toString()+"\n");
            System.out.println(responseDepartment.getBody().getDepName());

            assertNotNull(responseDepartment);
            // assertEquals(responseDepartment.getStatusCode(), HttpStatus.OK);
            // assertEquals(department.getDepid(), responseDepartment.getBody().getDepid());


        }catch(Exception e)
        {

            e.printStackTrace();
            fail();
        }
    }



    @Test
    public void c_update() {
        System.out.println("UPDATE");
        String url = baseURL + "update";

        Department electricalEngineering = restTemplate.getForEntity(baseURL + "/read?Depname=ElectricalEngineering", Department.class).getBody();

        Department newElectricalEngineering = new Department
                .Builder()
                .copy(electricalEngineering)
                .setDepName("Civil Engineering")
                .build();

        HttpEntity<Department> request = new HttpEntity<>(newElectricalEngineering, null);
        ResponseEntity<Department> res = restTemplate.withBasicAuth(USERNAME, PASSWORD).exchange(url, HttpMethod.PUT, request, Department.class);

        System.out.println(res.getBody());
        System.out.println("");
    }

    @Test
    public void d_delete() {


        String id = restTemplate.withBasicAuth(USERNAME, PASSWORD).getForEntity(baseURL + "/getById/"+department.getDepid(), Department.class).getBody().getDepid();
        System.out.println(id);
        String url = baseURL + "/delete?" + department.getDepid();

        ResponseEntity delRes = restTemplate.withBasicAuth(USERNAME, PASSWORD).exchange(url, HttpMethod.DELETE, null, boolean.class);

        System.out.println(delRes.getBody());
        System.out.println("");

    }


    @Test
    public void e_getAll() {

        String url = baseURL + "/getAll";

        ResponseEntity<HashSet> getRes = restTemplate.withBasicAuth(USERNAME, PASSWORD).getForEntity(url, HashSet.class);

        for (Object department: getRes.getBody()){
            System.out.println(department);
        }
        System.out.println("");
    }



}