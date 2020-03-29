package com.hillel.ua.jbehave.scenariosteps.API;

import com.hillel.ua.API.CommentsApiSteps;
import com.hillel.ua.API.DTO.CommentsDTO;
import com.hillel.ua.logging.Logger;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.List;
import java.util.Map;

public class CommentsRestApiScenario {

    @Steps
    private CommentsApiSteps commentsApiSteps;

    private static final String CREATED_COMMENT_KEY = "created_comment_key";
    private static final String EXPECTED_COMMENT_DATA_KEY = "expected_comment_data_key";
    private static final String UPDATED_COMMENT_DATA_KEY = "updated_comment_data_key";
    private static final String FILTERED_COMMENTS_BY_QUERY_PARAMS_KEY = "filtered_comments_by_query_params_key";
    private static final Integer EXPECTED_COMMENT_ID = 1;

    @BeforeScenario
    public void deleteApiResources() {
        Logger.out.debug("! ------------ Removing Rest Api Created Resources ------------ !");
        commentsApiSteps.removeCommentById(EXPECTED_COMMENT_ID);
        Logger.out.debug("! ------------ Removing Rest Api Created Resources Done ------------ !");
    }

    @Given("user creates new 'Comment', using API: $commentData")
    public void createNewComment(final ExamplesTable newCommentInfo) {
        final CommentsDTO newCommentsData = newCommentInfo.getRowsAs(CommentsDTO.class).get(0);
        final Response newCommentResponse = commentsApiSteps.createNewComment(newCommentsData);
        Serenity.setSessionVariable(CREATED_COMMENT_KEY).to(newCommentResponse);
        Serenity.setSessionVariable(EXPECTED_COMMENT_DATA_KEY).to(newCommentsData);
    }

    @When("user update existing comment, using following data: $newCommentData")
    public void updateExistingComment(final ExamplesTable requestBody) {
        final CommentsDTO body = requestBody.getRowsAs(CommentsDTO.class).get(0);
        final Response createdComment = Serenity.sessionVariableCalled(CREATED_COMMENT_KEY);
        final Integer createdCommentId = createdComment.jsonPath().get("id");
        final CommentsDTO updatedComment = commentsApiSteps.updateCommentById(body, createdCommentId);
        Serenity.setSessionVariable(UPDATED_COMMENT_DATA_KEY).to(updatedComment);
    }

    @When("user filters retrieved Comments by next filter params: $filterParams")
    public void filterAllCommentsByQueryParameters(final ExamplesTable filterParams) {
        final Map<String, String> queryParams = filterParams.getRow(0);
        final List<CommentsDTO> filteredByQueryParams = commentsApiSteps.getByQueryParams(queryParams);
        Serenity.setSessionVariable(FILTERED_COMMENTS_BY_QUERY_PARAMS_KEY).to(filteredByQueryParams);
    }

    @Then("following comment should be updated")
    public void isCreatedCommentUpdatedByNewData() {
        final CommentsDTO expectedCommentData = Serenity.sessionVariableCalled(UPDATED_COMMENT_DATA_KEY);
        final CommentsDTO actualCommentData = commentsApiSteps.getCommentById(expectedCommentData.getId());
        ReflectionAssert.assertReflectionEquals("There is incorrect 'updated' Comment!",
                expectedCommentData, actualCommentData);
    }

    @Then("each filtered Comment should contain such data only: $filteredData")
    public void areCommentsFilteredCorrectly(final ExamplesTable filteredData) {
        final Map<String, String> expectedFilteredComments = filteredData.getRow(0);

        final List<CommentsDTO> actualFilteredComments = Serenity.sessionVariableCalled(FILTERED_COMMENTS_BY_QUERY_PARAMS_KEY);

        Assertions.assertThat(actualFilteredComments)
                .as("There are no filtered Comments retrieved!")
                .isNotEmpty();

        actualFilteredComments.forEach(comment -> {

            Assertions.assertThat(comment.getBody())
                    .as("There is incorrect body!")
                    .isEqualTo(expectedFilteredComments.get("body"));
            Assertions.assertThat(comment.getLevel())
                    .as("There is incorrect level!")
                    .isEqualTo(expectedFilteredComments.get("level"));
        });
    }

    @Then("new comment should be created")
    public void isNewCommentCreated() {
        final Response createdCommentResponse = Serenity.sessionVariableCalled(CREATED_COMMENT_KEY);

        final CommentsDTO actualComment = createdCommentResponse.as(CommentsDTO.class);
        final CommentsDTO expectedComment = Serenity.sessionVariableCalled(EXPECTED_COMMENT_DATA_KEY);

        final SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(createdCommentResponse.getStatusCode())
                .as("Incorrect status code!")
                .isEqualTo(201);

        softAssertions.assertThat(actualComment.getBody())
                .as("There is incorrect body!")
                .isEqualTo(expectedComment.getBody());

        softAssertions.assertThat(actualComment.getLevel())
                .as("There is incorrect level!")
                .isEqualTo(expectedComment.getLevel());

        softAssertions.assertThat(actualComment.getPostId())
                .as("There is incorrect postId")
                .isEqualTo(expectedComment.getPostId());

        softAssertions.assertAll();
    }
}
