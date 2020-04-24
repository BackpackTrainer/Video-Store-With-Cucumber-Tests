package movieRental;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public double getChargesFor() {
		double charge = 0;
		
		//determine amounts for each line
		switch (getMovie().getPriceCode())  {
		case Movie.REGULAR:
			charge +=2;
			if(getDaysRented() > 2) {
				charge +=(getDaysRented() - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			charge += (getDaysRented() * 3);
			break;
		case Movie.CHILDRENS:
			charge += 1.5;
			if(getDaysRented() > 3) {
				charge += (getDaysRented() - 3) * 1.5;
			}
			break;
		}
		return charge;
	}

	int getFrequentRenterPoints() {
		
		int basePoints = 1;
		
		int bonusPoints = calculateBonusPoints();
		
		return basePoints + bonusPoints;
	}

	private int calculateBonusPoints() {
		int bonus = 0;
	
		if((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
			bonus = 1;
			}
		return bonus;
	}
}
