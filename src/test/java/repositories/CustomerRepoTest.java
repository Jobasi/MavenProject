package repositories;

import exception.EmailException;
import helpers.Validation;
import models.Customer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import patterns.CustomerBuilder;

/**
 * Created on 27/10/2016.
 */
public class CustomerRepoTest {
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = EmailException.class)
    public void test_user_with_invalid_email() throws Exception, EmailException {

        Validation validation = Mockito.mock(Validation.class);

        Customer customer = new CustomerBuilder("Some", "Guy")
                .withEmail("")
                .withPhone(111129990L)
                .build();

        CustomerRepo cRepo = new CustomerRepo();

        cRepo.setValidation(validation);

        Mockito.when(validation.email(customer.getEmail()))
                .thenThrow(new EmailException());

        cRepo.save(customer, 4L);

        Mockito.verify(validation.email(customer.getEmail()));


    }

    @Test
    public void test_user_with_valid_email() throws Exception, EmailException {

//        Validation validation = Mockito.mock(Validation.class);
//
//
//        Customer customer = new CustomerBuilder("Some", "Guy")
//                .withEmail("valid@email.com")
//                .withPhone(111129990L)
//                .build();
//
//        CustomerRepo customerRepo = new CustomerRepo();
//
//        Long customerId = customerRepo.save(customer, customer.getPersonId());
//
//        Mockito.when(validation.email(customer.getEmail())).thenReturn(Boolean.parseBoolean(String.valueOf(customer.getPersonId())));
//
//        Mockito.verify(validation.email(customer.getEmail()));
//
//        Assert.assertEquals(Boolean.parseBoolean(String.valueOf(customerId)), Mockito.verify(validation.email(customer.getEmail())));




    }


    @Test
    public void testFetchAllCustomers() throws Exception {

    }

    @Test
    public void testFindCustomerById() throws Exception {

    }

    @Test
    public void testUpdateCustomer() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testFindCustomerByEmail() throws Exception {

    }
}