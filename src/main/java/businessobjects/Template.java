package businessobjects;

import services_and_utilities.Logs;
import services_and_utilities.PropertyReader;
import services_and_utilities.FileReaders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Template {

    private String templateName = null;
    private Integer templatePrice = null;
    private String templateID = null;
    private String templateLicence = null;
    private List<String> templateOffers = new ArrayList<>();
    private List<Integer> templateOfferPrices = new ArrayList<>();
    private Boolean priceDicount = null;
    
	public Template(String fileLocation) throws IOException {
		super();
		
		PropertyReader propertyReader = new PropertyReader();
		this.templateName = propertyReader.getPropertyValue(fileLocation, "templateName");
		this.templateID = propertyReader.getPropertyValue(fileLocation, "templateID");
        this.templateLicence = propertyReader.getPropertyValue(fileLocation, "templateLicence");

	}

    public Template(String fileLocation, String fileOffer) throws IOException {
        super();

        PropertyReader propertyReader = new PropertyReader();
        this.templateName = propertyReader.getPropertyValue(fileLocation, "templateName");
        this.templateID = propertyReader.getPropertyValue(fileLocation, "templateID");
        this.templateLicence = propertyReader.getPropertyValue(fileLocation, "templateLicence");
        this.templateOffers = FileReaders.listReader(fileOffer);

    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Integer getTemplatePrice() {
        return templatePrice;
    }

    public void setTemplatePrice(Integer templatePrice) {
        this.templatePrice = templatePrice;
    }

    public String getTemplateID() {
        return templateID;
    }

    public void setTemplateID(String templateID) {
        this.templateID = templateID;
    }

    public String getTemplateLicence() {
        return templateLicence;
    }

    public void setTemplateLicence(String templateLicence) {
        this.templateLicence = templateLicence;
    }

    public List<String> getTemplateOffers() {
        Logs.info("businessobjects.Template offers - "+templateOffers);
        return templateOffers;
    }

    public void setTemplateOffers(List<String> templateOffers) {
        for (String offer:templateOffers){
            this.templateOffers.add(offer);
        }
    }

    public List<Integer> getTemplateOfferPrices() {
        return templateOfferPrices;
    }

    public void setTemplateOfferPrices(List<Integer> templateOfferPrices) {
        this.templateOfferPrices = templateOfferPrices;
    }

    public Integer getTotalPrice(){
        Integer offersSum = 0;
        List<Integer> offers = getTemplateOfferPrices();
        if (offers.size()!=0){
            for (int i = 0; i < offers.size(); i++) {
                offersSum+=offers.get(i);
            }
        }
        offersSum+=getTemplatePrice();
        Logs.info("Total price of template = "+offersSum);
        return offersSum;
    }

    public void addOffer(String offerName){
        this.templateOffers.add(offerName);
    }

    public Boolean getPriceDicount() {
        return priceDicount;
    }

    public void setPriceDicount(Boolean priceDicount) {
        this.priceDicount = priceDicount;
    }

}
