package com.hillel.ua.jbehave.scenariosteps.API;

import com.hillel.ua.API.DTO.ProfileDTO;
import com.hillel.ua.API.ProfileApiSteps;
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

public class ProfileRestApiScenario {

    private static final String CREATED_PROFILE_KEY = "created_profile_key";
    private static final String EXPECTED_PROFILE_DATA_KEY = "expected_profile_data_key";
    private static final String UPDATED_PROFILE_DATA_KEY = "updated_profile_data_key";
    private static final String FILTERED_PROFILES_BY_QUERY_PARAMS_KEY = "filtered_profiles_by_query_params_key";
    private static final Integer EXPECTED_PROFILE_ID = 1;

    @Steps
    private ProfileApiSteps profileApiSteps;

    @BeforeScenario
    public void deleteApiResources() {
        Logger.out.debug("! ------------ Removing Rest Api Created Resources ------------ !");
        profileApiSteps.removeProfileById(EXPECTED_PROFILE_ID);
        Logger.out.debug("! ------------ Removing Rest Api Created Resources Done ------------ !");
    }

    @Given("user creates new 'Profile', using Api: $profileData")
    public void createNewProfile(final ExamplesTable profileInfo) {
        final ProfileDTO profileData = profileInfo.getRowsAs(ProfileDTO.class).get(0);
        final Response newProfileResponse = profileApiSteps.createNewProfile(profileData);
        Serenity.setSessionVariable(CREATED_PROFILE_KEY).to(newProfileResponse);
        Serenity.setSessionVariable(EXPECTED_PROFILE_DATA_KEY).to(profileData);
    }

    @When("user update existing profile, using following data: $newProfileData")
    public void updateExistingProfile(final ExamplesTable requestBody) {
        final ProfileDTO body = requestBody.getRowsAs(ProfileDTO.class).get(0);
        final Response createdProfile = Serenity.sessionVariableCalled(CREATED_PROFILE_KEY);
        final Integer createdProfileId = createdProfile.jsonPath().get("id");
        final ProfileDTO updatedProfile = profileApiSteps.updateProfileById(body, createdProfileId);
        Serenity.setSessionVariable(UPDATED_PROFILE_DATA_KEY).to(updatedProfile);
    }

    @When("user filters retrieved Profiles by next filter params: $filterParams")
    public void filterAllProfilesByQueryParameters(final ExamplesTable filterParams) {
        final Map<String, String> queryParams = filterParams.getRow(0);
        final List<ProfileDTO> filteredByQueryParams = profileApiSteps.getByQueryParams(queryParams);
        Serenity.setSessionVariable(FILTERED_PROFILES_BY_QUERY_PARAMS_KEY).to(filteredByQueryParams);
    }

    @Then("following profile should be updated")
    public void isCreatedProfileUpdatedByNewData() {
        final ProfileDTO expectedProfileData = Serenity.sessionVariableCalled(UPDATED_PROFILE_DATA_KEY);
        final ProfileDTO actualProfileData = profileApiSteps.getProfileById(expectedProfileData.getId());
        ReflectionAssert.assertReflectionEquals("There is incorrect 'updated' Profile!",
                expectedProfileData, actualProfileData);
    }

    @Then("each filtered Profile should contain such data only: $filteredData")
    public void areProfilesFilteredCorrectly(final ExamplesTable filteredData) {
        final Map<String, String> expectedFilteredProfiles = filteredData.getRow(0);

        final List<ProfileDTO> actualFilteredProfiles = Serenity.sessionVariableCalled(FILTERED_PROFILES_BY_QUERY_PARAMS_KEY);

        Assertions.assertThat(actualFilteredProfiles)
                .as("There are no filtered Profiles retrieved!")
                .isNotEmpty();

        actualFilteredProfiles.forEach(profile -> {

            Assertions.assertThat(profile.getName())
                    .as("There is incorrect name!")
                    .isEqualTo(expectedFilteredProfiles.get("name"));

            Assertions.assertThat(profile.getRating())
                    .as("There is incorrect rating!")
                    .isEqualTo(expectedFilteredProfiles.get("rating"));
        });
    }

    @Then("new profile should be created")
    public void isNewProfileCreated() {
        final Response createdProfileResponse = Serenity.sessionVariableCalled(CREATED_PROFILE_KEY);

        final ProfileDTO actualProfile = createdProfileResponse.as(ProfileDTO.class);
        final ProfileDTO expectedProfile = Serenity.sessionVariableCalled(EXPECTED_PROFILE_DATA_KEY);

        final SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(createdProfileResponse.getStatusCode())
                .as("Incorrect status code!")
                .isEqualTo(201);

        softAssertions.assertThat(actualProfile.getName())
                .as("There is incorrect name!")
                .isEqualTo(expectedProfile.getName());

        softAssertions.assertThat(actualProfile.getRating())
                .as("There is incorrect rating!")
                .isEqualTo(expectedProfile.getRating());

        softAssertions.assertThat(actualProfile.getDemand())
                .as("There is incorrect demand!")
                .isEqualTo(expectedProfile.getDemand());

        softAssertions.assertAll();
    }
}
