package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCalendarEventPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendarEventStepsDefinition {

    CreateCalendarEventPage createCalendarEvent = new CreateCalendarEventPage();

    @Given("user clicks on create calendar events button")
    public void user_clicks_on_create_calendar_events_button() {
        createCalendarEvent.clickOnCreateCalendarEvent();
    }

    @When("user adds new calendar event information")
    public void user_adds_new_calendar_event_information(Map<String, String> dataTable) {

        String title = dataTable.get("Title");
        String description = dataTable.get("Description");

        System.out.println("Title: " + title);
        System.out.println("Description: " + description);

        createCalendarEvent.enterTitle(title);

        createCalendarEvent.enterDescription(description);

    }

    @Then("user verifies that new calendar event is displayed")
    public void user_verifies_that_new_calendar_event_is_displayed(Map<String, String> dataTable) {
        BrowserUtils.wait(5);
        String title = dataTable.get("Title");
        String description = dataTable.get("Description");

        Assert.assertEquals(title, createCalendarEvent.getDataFromGeneralInfo("Title"));
        Assert.assertEquals(description, createCalendarEvent.getDataFromGeneralInfo("Description"));

    }


}
