package com.juaracoding.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestApiMovieDbMoviePopular {

    String endpoint = "https://api.themoviedb.org/3/movie/popular?api_key=548481d626844f5908856857746faeb4&language=en-US&page=1";

    @Test
    public void testMoviePopular(){
        Response response = RestAssured.get(endpoint);

        //cek respon
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("content-type"));

        //valdiasi
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("Status code : Sesuai ");
    }

    @Test
    public void testMostPopularMovie(){
        given().get(endpoint)
                .then()
                .statusCode(200)
                .body("results.popularity[0]",equalTo(3422.537F));
//        System.out.println("Nama movie terpopuler : "+given().get(endpoint).asString());

        //popularity":3422.537
    }
}
