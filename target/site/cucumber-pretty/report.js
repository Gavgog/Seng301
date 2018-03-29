$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ownerentry.feature");
formatter.feature({
  "line": 1,
  "name": "Register new owner",
  "description": "",
  "id": "register-new-owner",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Register new owner",
  "description": "",
  "id": "register-new-owner;register-new-owner",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "I am connected to the WOF database",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "I Register a new owner with values \"bob@gmail.com,bobby,bobson,bobsmyname\"",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "Next time I retrive information from the table , it will contain an owner with the email \"bob@gmail.com\"",
  "keyword": "Then "
});
formatter.match({
  "location": "VehicleTestSteps.i_am_connected_to_the_WOF_database()"
});
formatter.result({
  "duration": 145268327,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("vehicle.feature");
formatter.feature({
  "line": 1,
  "name": "Register new vehicle",
  "description": "",
  "id": "register-new-vehicle",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Register new vehicle",
  "description": "",
  "id": "register-new-vehicle;register-new-vehicle",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "I am connected to the WOF database",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "The Owner with the email \"gavgog1@gmail.com\" exists",
  "keyword": "And "
});
formatter.step({
  "line": 5,
  "name": "I Create a new vehicle with vinNum \"375696\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Next time I retrive information from the table vehicle, it will contain a vehicle with vinNum \"375696\"",
  "keyword": "Then "
});
formatter.match({
  "location": "VehicleTestSteps.i_am_connected_to_the_WOF_database()"
});
formatter.result({
  "duration": 666981,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "gavgog1@gmail.com",
      "offset": 26
    }
  ],
  "location": "VehicleTestSteps.theOwnerWithEmailExists(String)"
});
formatter.result({
  "duration": 8642150,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "375696",
      "offset": 36
    }
  ],
  "location": "VehicleTestSteps.iCreateANewVehicleWithVinNum(String)"
});
formatter.result({
  "duration": 1005880,
  "error_message": "cucumber.api.PendingException: TODO: implement me\n\tat steps.VehicleTestSteps.iCreateANewVehicleWithVinNum(VehicleTestSteps.java:41)\n\tat ✽.When I Create a new vehicle with vinNum \"375696\"(vehicle.feature:5)\n",
  "status": "pending"
});
formatter.match({
  "arguments": [
    {
      "val": "375696",
      "offset": 95
    }
  ],
  "location": "VehicleTestSteps.nextTimeIRetriveInformationFromTheTableVehicleItWillContainAVehicleWithVinNum(String)"
});
formatter.result({
  "status": "skipped"
});
});