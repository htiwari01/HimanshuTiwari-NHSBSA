Feature: Job Search Page Feature

  Scenario: Basic job search
    Given I am a jobseeker on NHS Jobs website
    When I enters job title "Test Engineer"
    And I enters town "Newcastle Upon Tyne"
    And I clicks on Search button
    Then I should get a list of jobs which matches my preferences
    And I sort my search results with "publicationDateDesc"
    Then I should get sorted list of jobs which matches my preference
    
    
  Scenario: Job search without Job Title value
    Given I am a jobseeker on NHS Jobs website
    When I enters job title ""
    And I enters town "Newcastle Upon Tyne"
    And I clicks on Search button
    Then I should get a list of jobs with town preferences
    And I sort my search results with "publicationDateDesc"
    Then I should get sorted list of jobs which matches my preference
    
    
  Scenario: Job search without Town value
    Given I am a jobseeker on NHS Jobs website
    When I enters job title "Care Assistant"
    And I enters town ""
    And I clicks on Search button
    Then I should get a list of jobs with Job Title preferences
    And I sort my search results with "publicationDateDesc"
    Then I should get sorted list of jobs which matches my preference
        
         
  Scenario: Job search without passing any filter value
    Given I am a jobseeker on NHS Jobs website
    When I clicks on Search button
    And I sort my search results with "publicationDateDesc"
    Then I should get a list of jobs
    
    
  Scenario: Job search with invalid job title
    Given I am a jobseeker on NHS Jobs website
    When I enters job title "@£$%^&*("
    And I enters town "Newcastle Upon Tyne"
    And I clicks on Search button
    Then I should get No result found message
    
    
  Scenario: Job search with invalid job title
    Given I am a jobseeker on NHS Jobs website
    When I enters job title "Test Engineer"
    And I enters town "!@£$%^&*"
    And I clicks on Search button
    Then I should get Location not found message 
    
    
  #Scenario: Advance job search with Full Time and Contract Type Permanent filters
    #Given I am a jobseeker on NHS Jobs website
    #When I enters job title "Automation Engineer"
    #And I enters town "Gateshead"
    #And I clicks on Search button
    #And I sort my search results with "publicationDateDesc"
    #Then I should get sorted list of jobs which matches my preference
    #And I apply Full Time Working Pattern filter
    #And I clicks on Apply Filter button
    #Then I get a list of jobs which matches my preferences with full time filter
    #And I apply Contract Type as Permanent filter
    #And I clicks on Apply Filter button
    #Then I get a list of jobs which matches my preferences with Permanent filter

