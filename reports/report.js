$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/Login.feature");
formatter.feature({
  "name": "Login functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Test Two",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@testtwo"
    }
  ]
});
formatter.step({
  "name": "I login successfully",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStep.iLogin(String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat stepdefs.LoginStep.iLogin(LoginStep.java:63)\r\n\tat ✽.I login successfully(file:src/test/java/features/Login.feature:12)\r\n",
  "status": "failed"
});
});