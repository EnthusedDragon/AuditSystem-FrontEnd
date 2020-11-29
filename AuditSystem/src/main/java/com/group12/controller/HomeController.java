package com.group12.controller;

/**  Author: Rachael Klein
 *   Student no: 218 057 377
 *   Date: 21-09-2020
 *   Description: Controller
 */

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {

    @RequestMapping("/")
    String home() {
        return "Audit System Application Demo";
    }

}
