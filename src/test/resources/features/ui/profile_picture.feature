@ui @profilepicture
  Feature: As an ESS user, I should be able to upload a profile picture to enhance my personalization on
    the platform

    Background:
      Given the user is logged in with valid ESS credentials

    @regression @smoke
      Scenario: As a ESS user, I want to upload a profile picture
        And click on the my info tab
        And click on the profile picture
        And then select a profile picture file
        And click on the upload button
        Then I should see a success message indicating the profile picture has been uploaded successfully