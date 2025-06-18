package utils;

import pages.DashboardPage;
import pages.LoginPage;
import pages.PimPage;

public class PageInitializer {
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static PimPage pimPage;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        pimPage = new PimPage();
    }

}
