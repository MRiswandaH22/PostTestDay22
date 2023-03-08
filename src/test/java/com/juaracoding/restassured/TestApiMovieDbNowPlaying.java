package com.juaracoding.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestApiMovieDbNowPlaying {

    String endpoint = "https://api.themoviedb.org/3/movie/now_playing?api_key=548481d626844f5908856857746faeb4&language=en-US&page=1";

    @Test
    public void testNovPlaying(){

        Response response = RestAssured.get(endpoint);

        //cek respon
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("content-type"));

        //valdiasi
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("Status code : Sesuai ");

        //"title":"Knock at the Cabin","video":false,"vote_average":6.5

    }
    @Test
    public void testMovieName(){
        given().get(endpoint)
                .then()
                .statusCode(200)
                .body("results.title[0]",equalTo("Knock at the Cabin"));

    }

}
