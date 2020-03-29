package com.hillel.ua.API;

import com.hillel.ua.API.DTO.CommentsDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class CommentsApiSteps extends AbstractApiSteps {

    private static final String COMMENTS_API_PATH = "/comments";

    @Step
    public void removeCommentById(final Integer commentId) {
        RestAssured.delete(format("%s/%s", COMMENTS_API_PATH, commentId));
    }

    @Step
    public Response createNewComment(final CommentsDTO commentRequest) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(commentRequest)
                .post(COMMENTS_API_PATH);
    }

    @Step
    public List<CommentsDTO> getAllComments() {
        return Arrays.asList(RestAssured.given()
                .contentType(ContentType.JSON)
                .get(COMMENTS_API_PATH)
                .as(CommentsDTO[].class));
    }

    @Step
    public CommentsDTO getCommentById(final Integer commentId) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .get(format("%s/%s", COMMENTS_API_PATH, commentId))
                .as(CommentsDTO.class);
    }

    @Step
    public List<CommentsDTO> getByQueryParams(final Map<String, String> params) {
        return Arrays.asList(RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParams(params)
                .get(COMMENTS_API_PATH)
                .as(CommentsDTO[].class));
    }

    @Step
    public CommentsDTO updateCommentById(final CommentsDTO newCommentData, final Integer existingCommentId) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(newCommentData)
                .put(format("%s/%s", COMMENTS_API_PATH, existingCommentId))
                .as(CommentsDTO.class);
    }
}
