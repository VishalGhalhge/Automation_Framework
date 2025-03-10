Feature: sampleFeature

  @multi-window
  Scenario: Amazon handling multi window.
    Given user launch "chrome" browser with "https://www.amazon.in/" url
    Given user waits for page to load for 5
#   Given user waits for "Search Amazon.in" text to load for 20
    Then user validate page title and should be "Home Decor items Online @Upto 70% in India | Amazon.in"
    And user waits for element to load xpath "//*[@id='twotabsearchtextbox']"
    And user enter text "Samsung Phone" using xpath "//*[@id='twotabsearchtextbox']"
    When user click on the button "//*[@id='nav-search-submit-button']"
    Given user waits for page to load for 10
    When user click on the button "(//*[contains (text(),'Samsung Galaxy')])[7]"
    And user switches to the child window with the title "Samsung Phone"
    And user waits for element to load xpath "//*[@id='size_name_1']"
    And user scroll down by "800" pixel
    When user click on the button "//*[@id='size_name_1']"


#    And user copy text from the element of xpath ""
#    Then user validate text for element of "" and should be ""

#    Then user validate page title and should be "OrangeHRM"
#    Given user waits for "Dashboard" text to load for 5
#    When user select "" value from dropdown for xpath ""
#    When user select 3 value from dropdown for xpath ""

#    Then user validate text and should be ""
#    Then user waits for text to appear ""
#    And user switches to the child window with the title ""
#    And user switches to the main window with the title ""