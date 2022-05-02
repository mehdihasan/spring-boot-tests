package me.mh.springtest.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public String getDashboard(Model model) {
        model.addAttribute("message", "Hello World!");
        model.addAttribute("analyticsGraph", dashboardService.getAnalyticsGraphData());
        return "dashboard";
    }
}
