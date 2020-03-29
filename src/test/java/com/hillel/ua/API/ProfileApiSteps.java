package com.hillel.ua.API;

import com.hillel.ua.API.DTO.ProfileDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class ProfileApiSteps extends AbstractApiSteps {

    private static final String PROFILES_API_PATH = "/profile";

    @Step
    public void removeProfileById(final Integer profileId) {
        RestAssured.delete(format("%s/%s", PROFILES_API_PATH, profileId));
    }

    @Step
    public Response createNewProfile(final ProfileDTO profileRequest) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(profileRequest)
                .post(PROFILES_API_PATH);
    }

    @Step
    public List<ProfileDTO> getAllProfiles() {
        return Arrays.asList(RestAssured.given()
                .contentType(ContentType.JSON)
                .get(PROFILES_API_PATH)
                .as(ProfileDTO[].class));
    }

    @Step
    public ProfileDTO getProfileById(final Integer profileId) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .get(format("%s/%s", PROFILES_API_PATH, profileId))
                .as(ProfileDTO.class);
    }

    @Step
    public List<ProfileDTO> getByQueryParams(final Map<String, String> params) {
        return Arrays.asList(RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParams(params)
                .get(PROFILES_API_PATH)
                .as(ProfileDTO[].class));
    }

    @Step
    public ProfileDTO updateProfileById(final ProfileDTO newProfileData, final Integer existingProfileId) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(newProfileData)
                .put(format("%s/%s", PROFILES_API_PATH, existingProfileId))
                .as(ProfileDTO.class);
    }
}
