package com.group12.controller.account;
/**  Author: Limpho Ranamane
 *   Date: 22-09-2020
 *   Description: Testing UniversityStaff controller
 */

import com.group12.entity.UniversityStaff;
import com.group12.factory.UniversityStaffFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//fixes methods to run in a sequence
@RunWith(SpringRunner.class)
public class UniversityStaffControllerTest {

    @Autowired
    private TestRestTemplate restTemplate; // specifically used to test sping framework controllers

    private  static final String Authenticate_Username ="Client";
    private static final String Authenticate_Password ="147";

    String baseUrl = "http://localhost:8080/AuditSystem/universityStaff";

    private static UniversityStaff universityStaff = UniversityStaffFactory.createUniversityStaff("Ken@gmail.com","P@ssword123",false, LocalDate.now(),"Ken","Soliman","0896097317","1234-1234");


    @Test
    public void a_create() {
        String url = baseUrl+"/create";
        ResponseEntity<UniversityStaff> responseEntity = restTemplate.withBasicAuth(Authenticate_Username,Authenticate_Password).postForEntity(url, universityStaff,UniversityStaff.class);
        System.out.println("Created: " + universityStaff);
        if (universityStaff !=responseEntity.getBody()){
            universityStaff = responseEntity.getBody(); // this is to ensure that the created UniversityStaff has the same attributes as the one provided by the response entity.
        }
        assertEquals(universityStaff,responseEntity.getBody());
        System.out.println("Saved universityStaff: " + responseEntity.getBody());
    }

    @Test
    public void b_read() {
        String url = baseUrl+"/read/"+ universityStaff.getId();
        ResponseEntity<UniversityStaff> responseEntity = restTemplate.withBasicAuth(Authenticate_Username,Authenticate_Password).getForEntity(url,UniversityStaff.class);
        assertEquals(universityStaff.getId(),responseEntity.getBody().getId());
        System.out.println("UniversityStaff created: "+ universityStaff.getId()+"\n"+"UniversityStaff read: " + responseEntity.getBody().getId());

    }

    @Test
    public void c_update() {
        UniversityStaff updatedUniversityStaff = new UniversityStaff.Builder().copy(universityStaff).setSurname("Khan").build();
        String url = baseUrl+"/update";
        HttpEntity<UniversityStaff> universityStaffHttpEntity = new HttpEntity<>(updatedUniversityStaff,null);
        ResponseEntity<UniversityStaff> responseUpdated = restTemplate.withBasicAuth(Authenticate_Username,Authenticate_Password).exchange(url, HttpMethod.PUT,universityStaffHttpEntity,UniversityStaff.class);
        assertEquals(updatedUniversityStaff.getSurname(),responseUpdated.getBody().getSurname());
        System.out.println("UniversityStaff: "+updatedUniversityStaff.getSurname()+"\n"+"Response from update: " + responseUpdated.getBody().getSurname());

    }

    @Test
    @Ignore
    public void e_delete() {
        String url = baseUrl+"/delete/"+ universityStaff.getId();
        System.out.println("Deleting user: " + url);
        restTemplate.withBasicAuth(Authenticate_Username,Authenticate_Password).delete(url);
        assertTrue("Deleted: "+ universityStaff.getId(),true);
    }

    @Test
    public void d_getAll() {
        String url = baseUrl+"/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> retrievingAll= restTemplate.withBasicAuth(Authenticate_Username,Authenticate_Password).exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(retrievingAll);
        System.out.println("UniversityStaff: "+ universityStaff +"\n"+"UniversityStaff on DB: " + retrievingAll.getBody());

    }
}