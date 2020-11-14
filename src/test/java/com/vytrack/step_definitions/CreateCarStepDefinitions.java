package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.CreateCarPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreateCarStepDefinitions {

    CreateCarPage createCarPage = new CreateCarPage();

    @Given("user clicks on create car button")
    public void user_clicks_on_create_car_button() {
        createCarPage.clickOnCreateCar();
    }


    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String, String> dataTable) {
        dataTable.forEach((k, v) -> System.out.println("Key: " + k + ", value: " + v));

        System.out.println("License plate: " + dataTable.get("License Plate"));
        System.out.println("Model Year: " + dataTable.get("Model Year"));

        createCarPage.enterLicensePlate(dataTable.get("License Plate"));
        createCarPage.enterModelYear(dataTable.get("Model Year"));

    }

}
