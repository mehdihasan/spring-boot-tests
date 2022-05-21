package me.mh.springtest.testslice.web;

import me.mh.springtest.customer.Customer;
import me.mh.springtest.customer.CustomerController;
import me.mh.springtest.customer.CustomerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Write a test class with @WebMvcTest to test your web layer.
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    // Use @MockBean to mock and specify the behavior of any collaborator of the controller under test
    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMockMvcIsNotNull() {
        assertNotNull(mockMvc);
    }

    // Add a test and invoke your API endpoint with MockMvc and make sure it returns the HTTP status code 200
    @Test
    void apiReturnsHttpStatusCode200() throws Exception {
        when(customerService.getAllCustomers())
                .thenReturn(List.of(new Customer("mehdi", ZonedDateTime.now())));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // Write another test to verify the JSON response contains the expected fields. Use jsonPath for this purpose
    @Test
    void testGetAllResponseContainsExpectedFields() throws Exception {
        when(customerService.getAllCustomers())
                .thenReturn(List.of(new Customer("mehdi", ZonedDateTime.now())));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("mehdi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].joinedAt").isNotEmpty());
    }

    @Test
    @WithMockUser(username = "hasan", roles = {"USER", "ADMIN"})
    void getGetCustomerWithAValidUser() throws Exception {
        when(customerService.getCustomerById(1L))
                .thenReturn(new Customer(1L,"mehdi", ZonedDateTime.now()));

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/api/customers/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("mehdi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.joinedAt").isNotEmpty());
    }

    @Test
    void canCreateNewCustomer() throws Exception {
        when(customerService
                .storeNewCustomer(new Customer("Oroni"
                        , ZonedDateTime.parse("2022-01-01T14:00:00+06:00"))))
                .thenReturn(1L);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customers")
                        .with(SecurityMockMvcRequestPostProcessors.user("mehdi").roles("ADMIN"))
                        .with(SecurityMockMvcRequestPostProcessors.csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Oroni\", \"joinedAt\": \"2022-01-01T14:00:00+06:00\"}")
                )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"))
                .andExpect(MockMvcResultMatchers.header().string("Location", Matchers.containsString("/api/customers")));

        verify(customerService).storeNewCustomer(any(Customer.class));
    }



    // Advanced: Add Spring Security to the course application, secure your endpoint with basic auth and write a test that ensures anonymous users won't have access
}
