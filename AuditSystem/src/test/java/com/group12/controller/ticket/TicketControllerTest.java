package com.group12.controller.ticket;

import com.group12.entity.Issue;
import com.group12.entity.Ticket;
import com.group12.entity.UserAccount;
import com.group12.factory.IssueFactory;
import com.group12.factory.TicketFactory;
import com.group12.service.ticket.TicketService;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 * @author Stefano Ngantweni - 216283132
 * Desc: Controller Implementation test for ticket
 * Date: 23 September 2020
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@RunWith(SpringRunner.class)
public class TicketControllerTest {
    private static Issue issue = IssueFactory.createIssue("Health","First Aid", "1234-1234",new UserAccount.Builder().build());
    private static Ticket ticket= TicketFactory.createTicket(new Ticket.Builder().build());

    private static String USERNAME = "Boss";
    private static String PASSWORD = "123";

    @Autowired
    private TestRestTemplate restTemplate;

    private static String baseURL = "http://localhost:8080/ticket/";

    @Test
    public void a_create() {
        String url = baseURL + "create";

        ResponseEntity<Ticket> postResponse = restTemplate.withBasicAuth(USERNAME,PASSWORD).postForEntity(url, ticket, Ticket.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" +  ticket.getTicketId();
        System.out.println("URL: " + url);
        ResponseEntity<Ticket> TickResponse = restTemplate.withBasicAuth(USERNAME,PASSWORD).withBasicAuth(USERNAME,PASSWORD).getForEntity(url, Ticket.class);
        assertNotNull(ticket.getTicketId());
        System.out.println(TickResponse.getBody());


    }

    @Test
    public void c_update() {

        Issue updatedIss = new Issue.Builder().copy(issue).setIsResolved(true).build();
        Ticket updated = new Ticket.Builder().copy(ticket).setTicketIssue(updatedIss).build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Put data: " + updated);
        HttpEntity<Ticket> httpsEntityTicket = new HttpEntity<Ticket>(updated, null);
        ResponseEntity<Ticket> updateResponse = restTemplate.withBasicAuth(USERNAME,PASSWORD).exchange(url, HttpMethod.PUT, httpsEntityTicket, Ticket.class);
        assertEquals( HttpStatus.OK, updateResponse.getStatusCode());
        //assertNotNull(updated.getTicketIssue().getIsResolved());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response= restTemplate.withBasicAuth(USERNAME,PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void g_delete() {

        String url = baseURL + "delete/" + ticket.getTicketId();
        System.out.println("URL: " + url);
        ResponseEntity updateResponse = restTemplate.withBasicAuth(USERNAME,PASSWORD).exchange(url, HttpMethod.DELETE, null, boolean.class);
        assertEquals(updateResponse.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void e_closeTicket() {
    }

    @Test
    public void f_getAllOpen() {
    }
}