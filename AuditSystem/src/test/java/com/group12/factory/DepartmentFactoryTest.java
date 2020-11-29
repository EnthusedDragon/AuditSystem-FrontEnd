package com.group12.factory;


import com.group12.entity.Department;
import org.junit.Assert;
import org.junit.Test;



public class DepartmentFactoryTest {



    @Test

    public void testCreateDepartment()

    {

      try {


          Department department = DepartmentFactory.createDepartment("Informatics and Design", "1234-1234");




      }
      catch (Exception ex)
      {
           Assert.fail();
      }


    }



}
