package com.bridgelabz.json_aussred_testing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonRestAussredTesting {
    @Test
    public void postRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"typicode\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"typicode\"\n" +
                        "    }\n" +
                        "]")
                .when()
                .post(" http://localhost:3000/posts");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }

    @Test
    public void getRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void putRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"typicode\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"Mohini\"\n" +
                        "    }\n" +
                        "]")
                .when()
                .put("http://localhost:3000/posts/2");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void postRequestForComments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "    \"id\": 2,\n" +
                        "    \"body\": \"some comment\",\n" +
                        "    \"postId\": 1\n" +
                        "\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": 10,\n" +
                        "    \"body\": \"some comment\",\n" +
                        "    \"postId\": 1\n" +
                        "}\n" +
                        "]")
                .when()
                .post("http://localhost:3000/comments");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }

    @Test
    public void getRequestForComments() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/comments");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void putRequestForComments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"body\": \"Mohini\",\n" +
                        "        \"postId\": 1\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"body\": \"My name is Mohini\",\n" +
                        "        \"postId\": 1\n" +
                        "    }\n" +
                        "]")
                .when()
                .put("http://localhost:3000/comments/2");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    public void postRequestForProfile() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\" : 1,\n" +
                        "    \"name\": \"Mohini balaji patange\",\n" +
                        "    \"Address\" : \"RajgadPark , plot no. 300\",\n" +
                        "    \"Email\" : \"Mohinipatange@gmail.com\"\n" +
                        "\n" +
                        "}")
                .when()
                .post("http://localhost:3000/profile");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }

    @Test
    public void getRequestForProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get(" http://localhost:3000/profile");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}