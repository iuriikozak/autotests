package TestAutomation.TemplateMonster.businessobjects;

import TestAutomation.TemplateMonster.utility.PropertyReader;

import java.io.IOException;

/**
 * Created by victorp on 25.03.15.
 */
public class Offer {

    private String offerName = null;
    private Integer offerPrice = null;
    private Boolean priceDiscount = null;


	public Offer(String fileLocation) throws IOException {
		//super();

		PropertyReader propertyReader = new PropertyReader();
		this.offerName = propertyReader.getPropertyValue(fileLocation, "offerName");

	}

    public Integer getOfferPrice() {
        return offerPrice;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public void setOfferPrice(Integer offerPrice) {
        this.offerPrice = offerPrice;
    }

    public Offer() {
    }

    public Offer(String offerName, Integer offerPrice, Boolean priceDiscount) {
        this.offerName = offerName;
        this.offerPrice = offerPrice;
        this.priceDiscount = priceDiscount;
    }

    public Boolean getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Boolean priceDiscount) {
        this.priceDiscount = priceDiscount;
    }
}
