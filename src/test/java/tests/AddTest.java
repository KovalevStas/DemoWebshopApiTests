package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class AddTest extends TestBase {

    @Test
    void addToCardTest() {
        given()
                .cookie("Nop.customer=136932cd-a5a6-409f-b954-265464d33a1a; ARRAffinity=ee34a24226ab32a8911d8213bc61638c0a238bf662e0bad7090e344fefc05587; " +
                        "__utma=78382081.1387020602.1601880663.1601880663.1601880663.1; __utmc=78382081; __utmz=78382081.1601880663.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); " +
                        "NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=2; __utmt=1; __atuvc=5%7C41; __atuvs=5f7acf5f52401679001; __utmb=78382081.25.10.1601880663")
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("product_attribute_74_5_26=82&product_attribute_74_6_27=85&product_attribute_74_3_28=87&product_attribute_74_8_29=89&addtocart_74.EnteredQuantity=1")
            .when()
                .post("/addproducttocart/details/74/1")
            .then()
                .log().body()
                .statusCode(200)
                .body("success", is(true));
    }
}
