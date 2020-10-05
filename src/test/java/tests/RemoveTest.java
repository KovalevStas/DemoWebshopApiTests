package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.is;

public class RemoveTest extends TestBase {

    @Test
    void removeTest() {
        given()
                .cookie("Nop.customer=136932cd-a5a6-409f-b954-265464d33a1a; ARRAffinity=ee34a24226ab32a8911d8213bc61638c0a238bf662e0bad7090e344fefc05587; __utma=78382081.1387020602.1601880663.1601880663.1601880663.1; __utmc=78382081; __utmz=78382081.1601880663.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=2; __atuvc=6%7C41; __atuvs=5f7acf5f52401679002; __utmt=1; __utmb=78382081.29.10.1601880663")
                .contentType("multipart/form-data; boundary=----WebKitFormBoundaryn5XDxFuBNIYecXXm")
                .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                .body("------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"removefromcart\"\n" +
                        "\n" +
                        "1492288\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"itemquantity1492288\"\n" +
                        "\n" +
                        "1\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"updatecart\"\n" +
                        "\n" +
                        "Update shopping cart\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"discountcouponcode\"\n" +
                        "\n" +
                        "\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"giftcardcouponcode\"\n" +
                        "\n" +
                        "\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"CountryId\"\n" +
                        "\n" +
                        "0\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"StateProvinceId\"\n" +
                        "\n" +
                        "0\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm\n" +
                        "Content-Disposition: form-data; name=\"ZipPostalCode\"\n" +
                        "\n" +
                        "\n" +
                        "------WebKitFormBoundaryn5XDxFuBNIYecXXm--\n")
                .when()
                .post("/cart")
                .then()
                .log().body()
                .statusCode(200);
    }
}
