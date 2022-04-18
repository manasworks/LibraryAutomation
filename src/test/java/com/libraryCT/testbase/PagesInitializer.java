package com.libraryCT.testbase;

import com.libraryCT.pages.DashboardPage;
import com.libraryCT.pages.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * This an initializer class which will initialize all pages classes. Once pages
 * class created, create an object of it here inside the constructor
 */
public class PagesInitializer{

	protected static LoginPage loginPage;
	protected static DashboardPage dashboardPage;

	public static void initializePageObjects() {
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
	}

}
