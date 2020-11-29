////package com.group12.service.login.impl;
////
////import com.group12.entity.Login;
////import com.group12.entity.UserAccount;
////import com.group12.factory.LoginFactory;
////import com.group12.factory.UserAccountFactory;
////import com.group12.repository.account.UserAccountRepository;
////import com.group12.service.login.LoginService;
////import static org.junit.Assert.*;
////import org.junit.FixMethodOrder;
////import org.junit.Test;
////import org.junit.runners.MethodSorters;
////
////import java.time.LocalDate;
////import java.util.Set;
//<<<<<<< HEAD
////
//=======
////@Deprecated
//>>>>>>> b0f0339931ce729b745b2dfadc17fbb5235bb96e
////@FixMethodOrder(MethodSorters.NAME_ASCENDING)
////public class LoginServiceImplTest
////{
////
////    private static LoginService service = LoginServiceImpl.getService();
//<<<<<<< HEAD
////    private static UserAccountRepository repository = UserAccountRepositoryImpl.getInstance();
//=======
////    private static UserAccountRepository repository;
//>>>>>>> b0f0339931ce729b745b2dfadc17fbb5235bb96e
////    private static Login login = LoginFactory
////            .createLogin("rachaelk.private@gmail.com", "12345678rR1@!");
////    static LocalDate date = LocalDate.now();
////    private static UserAccount userAccount;
////
////
////    @Test
////    public void a_create()
////    {
////        try
////        {
////            userAccount = UserAccountFactory
////                    .createUserAccount("rachaelk.private@gmail.com",
////                            "12345678rR1@!", false, date);
////        }
////        catch (Exception e)
////        {
////            e.printStackTrace();
////        }
////        UserAccount createdUserAccount = repository.save(userAccount);
////        Login createdLogin = service.create(login);
////        assertEquals(login.getLoginID(), createdLogin.getLoginID());
////        assertEquals(userAccount.getUserId(), createdUserAccount.getUserId());
////        System.out.println("Created Login: " + createdLogin);
////        System.out.println("Created User: " + createdUserAccount);
////    }
////
////    @Test
////    public void b_read()
////    {
////        Login read = service.read(login.getLoginID());
////        assertNotNull(read);
////        System.out.println("Read: " + read);
////    }
////
////    @Test
////    public void d_update()
////    {
////        Login updated = new Login.Builder()
////                .copy(login).setPassword("forthelulz12345")
////                .build();
////        updated = service.update(updated);
////        assertEquals(updated.getPassword(), service.read(login.getLoginID()).getPassword());
////        System.out.println("Updated: " + updated);
////    }
////
////    @Test
////    public void f_delete()
////    {
////        boolean deleted = service.delete(login.getLoginID());
////        assertTrue(deleted);
////    }
////
////    @Test
////    public void e_getAll()
////    {
////        Set<Login> logins = service.getAll();
////        assertEquals(1, logins.size());
////        System.out.println("All Logins: " + logins);
////    }
//<<<<<<< HEAD
////}
//=======
////}
//>>>>>>> b0f0339931ce729b745b2dfadc17fbb5235bb96e
