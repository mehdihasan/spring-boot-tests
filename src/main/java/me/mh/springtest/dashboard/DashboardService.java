package me.mh.springtest.dashboard;

import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    public Integer[] getAnalyticsGraphData() {
        return new Integer[] {23, 23, 34, 45, 2, 34, 45, 56};
    }
}
