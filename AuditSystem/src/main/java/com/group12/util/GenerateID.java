package com.group12.util;

import java.util.UUID;
/**  Suggested by Mr Arinze Anikwue in ADP3
 *   Added in by: Rachael Klein
 *   Reason: Used within System, updated Domain Model.
 *   Student no: 218 057 377
 *   Date: 01-07-2020
 *   Description: auto generateID
 */
public class GenerateID {


    //this is method which will generate a random ID, when pulled across other classes
    public static String generateID(){
        return UUID.randomUUID().toString();
    }


}
