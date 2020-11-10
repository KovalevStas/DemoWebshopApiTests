package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.is;

public class RemoveTest extends TestBase {

    @Test
    void removeTest() {

        try {
            String text = new String(Files.readAllBytes(Paths.get("body.txt")), StandardCharsets.UTF_8);
            given()
                    .cookie("Nop.customer=136932cd-a5a6-409f-b954-265464d33a1a; ARRAffinity=ee34a24226ab32a8911d8213bc61638c0a238bf662e0bad7090e344fefc05587; " +
                            "__utma=78382081.1387020602.1601880663.1601880663.1601880663.1; __utmc=78382081; __utmz=78382081.1601880663.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); " +
                            "NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=2; __atuvc=6%7C41; __atuvs=5f7acf5f52401679002; __utmt=1; __utmb=78382081.29.10.1601880663")
                    .contentType("multipart/form-data; boundary=----WebKitFormBoundaryn5XDxFuBNIYecXXm")
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                    .body(text)
                .when()
                    .post("/cart")
                .then()
                    .log().body()
                    .statusCode(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
