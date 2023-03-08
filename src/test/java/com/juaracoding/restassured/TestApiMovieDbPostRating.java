package com.juaracoding.restassured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestApiMovieDbPostRating {
    String apiKeyRating = "https://api.themoviedb.org/3/movie/436270/rating?api_key=548481d626844f5908856857746faeb4";
    String authKey = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1NDg0ODFkNjI2ODQ0ZjU5MDg4NTY4NTc3NDZmYWViNCIsInN1YiI6IjY0MDcyZGI0Zjg1OTU4MDBkMzgzMzE4NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.MUibneo_SXFXTsi6U70EXPJ0qTRz5rmrkwW-hdpNLUY";

    @Test
    public void testPostRatingMovie(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("value","9.5");
        System.out.println(requestBody.toJSONString());

        //verify
        given().header("Content-Type","aplication/json")

                .header("Authorization", authKey)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody.toJSONString())
                .when()
                .post(apiKeyRating)
                .then()
                .statusCode(201)
                .log().all();
        System.out.println("Data berhasil ditambahkan");
    }


}
