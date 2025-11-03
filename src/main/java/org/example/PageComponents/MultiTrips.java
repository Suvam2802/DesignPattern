package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrips extends AbstractComponent implements SearchFlightAvail {


    By rdo1 = By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_2']");
    By popup = By.xpath("//a[@id='MultiCityModelAlert']");
    By from1 = By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']");
    By to1 = By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']");
    By from2 = By.xpath("//input[@id='ctl00_mainContent_ddl_originStation2_CTXT']");
    By search = By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']");


    public MultiTrips(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void CheckAvail(HashMap<String, String> ReservationDetails) {

        MakeStateReady(s->selectOriginCity(ReservationDetails.get("Origin")));
        //selectOriginCity(origin);
        selectDestinationCity(ReservationDetails.get("Destination"));
        selectDestinationCity1(ReservationDetails.get("Destination1"));
        findElement(search).click();


    }

    public void MakeStateReady(Consumer<MultiTrips> consumer)
    {

        System.out.println("I am inside Multi Trip");
        findElement(rdo1).click();
        findElement(popup).click();
        waitForElementToDisappear(popup);
        consumer.accept(this);
        System.out.println("I am done");
    }

    public void selectOriginCity(String origin) {

        findElement(from1).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestinationCity(String Destination) {

        findElement(to1).click();
        findElement(By.xpath("(//a[@value='" + Destination + "'])[2]")).click();
    }
    public void selectDestinationCity1(String Destination) {

        findElement(from2).click();
        findElement(By.xpath("(//a[@value='" + Destination + "'])[3]")).click();
    }

    /*@Override
    public void CheckAvail(HashMap<String, String> ReservationDetails) {

    }*/
}
