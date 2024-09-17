Feature: Login_Feature





Background: 
Given user launch browser
Given user open url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"

@Test_Id_1
Scenario:  Successful Login with valid credentials
 And user enter email text as "admin@yourstore.com...." 
 And user enter password text as "admin"
 And user click on login button
 Then user verify title of the page "Dashboard / nopCommerce administration"
 When user click on logout button
 Then user verify title of the page "Your store. Login"
 And user close the browser