package com.group12.util;

import java.time.LocalDate;
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: A class to generate and return the current date
 * Date: 24 August 2020
 */
public class GenerateDate
{
    // This method checks the current date of the localhost and returns it when called upon by other classes
    public static LocalDate generateDate()
    {
        return java.time.LocalDate.now();
    }
}
