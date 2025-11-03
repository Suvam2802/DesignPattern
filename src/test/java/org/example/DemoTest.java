package org.example;

import org.example.PageComponents.MultiTrips;
import org.example.PageComponents.RoundTrip;

import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends Basetest{

    //By SectionElement = By.id("flightSearchContainer");
    WebDriver driver;
    TravelHomePage tm;

    @BeforeTest
    public void setup()
    {
        driver = initiateDriver();

         tm = new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void FlightTest(HashMap<String, String> ReservationDetails)
    {

        tm.goTo();
        tm.getFooterNav().GetFlightAttribute();

        tm.getNavigationBar().GetFlightAttribute();

        tm.getNavigationBar().getNumberOfLinks();

        tm.getFooterNav().getNumberOfLinks();


        //Check Availability - Oneway/Round Trip/Multi Trip

        tm.setBookingStrategy("MultiTrips");



        tm.checkAvail(ReservationDetails);

        /*tm.setBookingStrategy(new RoundTrip(driver, SectionElement));
        tm.checkAvail("MAA","HYD");*/

        tm.gettitle();

    }

    @AfterTest
    public void teardown()
    {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
       /* HashMap<String, String> ReservationDetails = new HashMap<String, String>();
        ReservationDetails.put("Origin", "MAA");
        ReservationDetails.put("Destination", "HYD");
        ReservationDetails.put("Destination1", "STV");


        HashMap<String, String> ReservationDetails1 = new HashMap<String, String>();
        ReservationDetails1.put("Origin", "DEL");
        ReservationDetails1.put("Destination", "MAA");
        ReservationDetails1.put("Destination1", "HYD");

        List<HashMap<String, String>> l = new ArrayList();
        l.add(ReservationDetails1);
        l.add(ReservationDetails);*/

        List<HashMap<String, String>> l = getJsonData(System.getProperty("user.dir")+"//src//test//java//org//example//DataLoads//ReservationDetails.json");

        return new Object[][]

                {

                        {l.get(0)} , {l.get(1)}

                };

    }



}
