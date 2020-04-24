package movieRental;

public class Movie {
	public static final int CHILDRENS = 1;
	public static final int REGULAR = 2;
	public static final int NEW_RELEASE = 3;
	
	public static int getCode(String code) {

		switch(code)  {
		case "Childrens" :
			return CHILDRENS;
			
		case "Regular" :
			return REGULAR;
			
		case "New Release" :
			return NEW_RELEASE;
			
		default : return 0;
			
		}
	}

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode)  {
		this.title = title;
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}
}

