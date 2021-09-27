package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class runner {
	@Given(": I am at the home page")
	public void i_am_at_the_home_page() {
	   System.out.println("I am at home page");
	}

	@When(": I click on the {string} search filter")
	public void i_click_on_the_search_filter(String string) {
		System.out.println("I click on the search filters");
	}

	@Then(": I should be at the {string} search page with {string}")
	public void i_should_be_at_the_search_page_with(String string, String string2) {
		System.out.println("I should be at the search page with");
	}

	@And(": The title should be {string} search page")
	public void the_title_should_be_search_page(String string) {
		System.out.println("The title should be search page");
	}

	@Then(": I select the {string} with description as {string}")
	public void i_select_the_with_description_as(String string, String string2) {
		System.out.println("I select the with description");
	}

	@And(": Add it to the cart")
	public void add_it_to_the_cart() {
		System.out.println("Add it to the cart");
	}

	@Then(": Navigate to user details page and provide the following details")
	public void navigate_to_user_details_page_and_provide_the_following_details(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("Navigate to user detail page and provide the following details");
	}
}
