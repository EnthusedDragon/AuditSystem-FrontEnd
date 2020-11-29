package com.group12.controller.report;

import com.group12.entity.Login;
import com.group12.entity.Report;
import com.group12.factory.ReportFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
 * Desc: Controller Test for report
 * Date: 22 September 2020
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReportControllerTest
{
    private static Report report = ReportFactory.createReport("Brian");
    private static String USERNAME = "Client";
    private static String PASSWORD = "147";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/report";


    @Test
    public void a_create()
    {
        String url = baseURL + "/create";
        ResponseEntity<Report> postResponse = restTemplate.withBasicAuth(USERNAME, PASSWORD).postForEntity(url, report, Report.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        //assertEquals(report.getReportId(), postResponse.getBody().getReportId());
        System.out.println("URL: " + url);
        System.out.println("Body: " + postResponse.getBody());
        System.out.println(postResponse.getStatusCode());
    }

    @Test
    public void b_read()
    {
        String url = baseURL + "/read/" + report.getReportId();
        ResponseEntity<Report> responseEntity = restTemplate.withBasicAuth(USERNAME, PASSWORD).getForEntity(url, Report.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        //assertEquals(report.getReportId(), responseEntity.getBody().getReportId());
        System.out.println("URL: " + url);
        System.out.println("Body: " + responseEntity.getBody());
        System.out.println(responseEntity.getStatusCode());
    }

    @Test
    public void c_update()
    {
        Report updated = new Report.Builder().copy(report).setReportAuth("Rebecca").build();
        String url = baseURL + "/update";
        ResponseEntity<Report> responseEntity = restTemplate.withBasicAuth(USERNAME, PASSWORD).postForEntity(url, updated, Report.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        //assertEquals(report.getReportId(), responseEntity.getBody().getReportId());
        System.out.println("URL: " + url);
        System.out.println("Body: " + updated);
        System.out.println(responseEntity.getStatusCode());
    }

    @Test
    @Ignore
    public void e_delete()
    {
        String url = baseURL + "/delete/" + report.getReportId();
        System.out.println("URL: " + url);
        ResponseEntity updateResponse = restTemplate.withBasicAuth(USERNAME, PASSWORD).exchange(url, HttpMethod.DELETE, null, boolean.class);
        assertEquals(HttpStatus.OK, updateResponse.getStatusCode());
        //assertEquals(updateResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void d_getAll()
    {
        String url = baseURL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(USERNAME, PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println(response);
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
    }
}