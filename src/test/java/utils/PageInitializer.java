package utils;

import pages.*;

public class PageInitializer {
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static PimPage pimPage;
    public static ESSDashboardPage essDashboardPage;
    public static ESSMyInfoPage essMyInfoPage;

    public static void initializePageObjects() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        pimPage = new PimPage();
        essDashboardPage = new ESSDashboardPage();
        essMyInfoPage = new ESSMyInfoPage();
    }

}
