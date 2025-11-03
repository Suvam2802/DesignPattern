package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {


    private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
    private By cb = By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");
    private By to = By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']");
    private By selectDate = By.xpath("//a[@class='ui-state-default ui-state-active']");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void CheckAvail(HashMap<String, String> ReservationDetails) {

        System.out.println("I am inside RoundTrip");

        findElement(rdo).click();
        findElement(from).click();
        selectOriginCity(ReservationDetails.get("Origin"));
        selectDestinationCity(ReservationDetails.get("Destination"));
        findElement(selectDate).click();
        findElement(cb).click();
        findElement(search).click();

    }

    public void selectOriginCity(String origin) {

        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestinationCity(String Destination) {

        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + Destination + "'])[2]")).click();
    }

    /*@Override
    public void CheckAvail(HashMap<String, String> ReservationDetails) {

    }*/
}