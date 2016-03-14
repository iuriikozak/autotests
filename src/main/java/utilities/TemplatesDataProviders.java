package utilities;

import TestAutomation.TemplateMonster.businessobjects.Offer;
import TestAutomation.TemplateMonster.businessobjects.Template;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class TemplatesDataProviders {


    @DataProvider(name = "DefaultTemplate")

    public static Object[][] DefaultTemplate() throws IOException {
        return new Object[][] { { new Template("properties/template/template.properties") }};
    }

    @DataProvider(name = "EducationTemplate")

    public static Object[][] EducationTemplate() throws IOException {
        return new Object[][] { { new Template("properties/template/templateJoomla.properties") }};
    }

    @DataProvider(name = "PrestaShopTemplate")

    public static Object[][] PrestaShopTemplate() throws IOException {
        return new Object[][] { { new Template("properties/template/templatePrestaShop.properties") }};
    }

    @DataProvider(name = "PrestaShopSportTemplate")

    public static Object[][] PrestaShopSportTemplate() throws IOException {
        return new Object[][] { { new Template("properties/template/templatePrestaShopSport.properties") }};
    }

    @DataProvider(name = "SimpleSportTemplate")

    public static Object[][] SimpleSportTemplate() throws IOException {
        return new Object[][] { { new Template("properties/template/templateSimpleSport.properties") }};
    }

    @DataProvider(name = "TemplateInstallation")

    public static Object[][] TemplateInstallation() throws IOException {
        return new Object[][] { { new Template("properties/template/templateInstalation.properties") }};
    }

    @DataProvider(name = "TemplateBuyOut")

    public static Object[][] TemplateBuyOut() throws IOException {
        return new Object[][] { { new Template("properties/template/templateBuyOut.properties") }};
    }

    @DataProvider(name = "ProjectOnTemplateOffer")

    public static Object[][] ProjectOnTemplateOffer() throws IOException {
        return new Object[][] { { new Template("properties/template/templatePrestaShop.properties", "template/OnTemplateOfferProduct.txt") }};
    }

    @DataProvider(name = "PreSalesOnTemplateOffer")

    public static Object[][] PreSalesOnTemplateOffer() throws IOException {
        return new Object[][] { { new Template("properties/template/templatePrestaShop.properties", "template/OnTemplateOfferPresales.txt") }};
    }

    @DataProvider(name = "MixOnTemplateOffers")

    public static Object[][] MixOnTemplateOffers() throws IOException {
        return new Object[][] { { new Template("properties/template/templatePrestaShop.properties", "template/OnTemplateOffersMix.txt") }};
    }

    @DataProvider(name = "OnCartOffer")

    public static Object[][] OnCartOffer() throws IOException {
        return new Object[][] { { new Offer("properties/template/onCartOffer.properties") }};
    }

    @DataProvider(name = "PowerPointTemplate")

    public static Object[][] PowerPointTemplate() throws IOException {
        return new Object[][] { { new Template("properties/template/templatePowerPoint.properties") }};
    }

    @DataProvider(name = "OnCartOfferDiscount")

    public static Object[][] OnCartOfferDiscount() throws IOException {
        return new Object[][] { { new Offer("properties/template/onCartOfferDiscount.properties") }};
    }

}
