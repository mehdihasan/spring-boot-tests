package me.mh.springtest.testslice.web;

import me.mh.springtest.dashboard.DashboardController;
import me.mh.springtest.dashboard.DashboardService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@WebMvcTest(DashboardController.class)
public class DashboardControllerTest {

    @MockBean
    private DashboardService dashboardService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnViewWithPrefilledData() throws Exception {
        when(dashboardService.getAnalyticsGraphData()).thenReturn(new Integer[] {23, 43});

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/dashboard"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("dashboard"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("message"))
                .andExpect(MockMvcResultMatchers.model().attribute("analyticsGraph", Matchers.arrayContaining(23, 43)));
    }

}
