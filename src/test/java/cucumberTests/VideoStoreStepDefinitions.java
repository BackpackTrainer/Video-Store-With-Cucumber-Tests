package cucumberTests;


import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import movieRental.Customer;
import movieRental.Movie;
import movieRental.Rental;

public class VideoStoreStepDefinitions {
	
	Customer customer;
	double rentalAmount;
	
	@Given("^I am an existing customer named \"([^\"]*)\"$")
	public void i_am_an_existing_customer_named(String name) throws Throwable {
		customer = new Customer(name);
	   
	}

	@When("^I rent no movies$")
	public void i_rent_no_movies() throws Throwable {
	  
	}

	@Then("^my bill is ([-+]?[0-9]*\\.?[0-9]+)$")
	public void my_bill_is(double amount) throws Throwable {
		Assert.assertEquals(amount, customer.getTotalCharges(), .01); 
	}

	@When("^I rent \"([^\"]*)\" of \"([^\"]*)\" for (\\d+)$")
	public void i_rent_of_for(String movieName, String movieType, int days) throws Throwable {
		  int type = Movie.getCode(movieType);
	    Rental rental = new Rental(new Movie(movieName, type), days);
	    customer.addRental(rental);
	}
	


}
