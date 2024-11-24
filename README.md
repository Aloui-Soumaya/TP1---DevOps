# Introduction

In this lab, we will do the process of integrating automated tests and security checks into a DevOps pipeline using SonarQube. The main objectives are to configure a CI/CD pipeline, implement unit and integration tests, analyze the code for bugs and vulnerabilities, and document the findings. The focus is on achieving code quality and security in a continuous integration setup, enhancing the reliability of the software development lifecycle.
The Spring Boot application we are using is a simple REST API that manages users, allowing functionalities such as:
- Fetching a user by username.
- Adding a new user.
- Fetching all users.

# Description of the Spring Boot Application
The Spring Boot application includes a UsersController class with the following endpoints:
![image](https://github.com/user-attachments/assets/440542a1-acd9-464e-a606-684140228677)
![image](https://github.com/user-attachments/assets/3bccbe13-68ca-4483-85af-d74ac5bd0e98)
![image](https://github.com/user-attachments/assets/4bdf7778-19de-47c4-9f4e-fd6e7ef2ebe0)

# Configuration of the DevOps Environment
For the Continuous Integration and Continuous Deployment (CI/CD) pipeline in this lab, I used Jenkins and SonarQube within a Docker container to streamline the setup process and ensure that the Jenkins and SonarQube environments  are isolated and reproducible.

To enhance the functionality of Jenkins and integrate it with Docker, I created a custom Dockerfile based on the official Jenkins image. This allowed me to install specific plugins and set up Jenkins with the tools required for this lab.

After that we created a docker compose file. This Docker Compose file is used to set up a CI/CD pipeline that integrates Jenkins and SonarQube. Jenkins manages the pipeline (building, testing, deploying code), while SonarQube analyzes the code's quality and security. Both services are containerized for easy setup and deployment, and data 


# Test of the Spring Boot Application

## Unit Test:
* fetchUserByUsername():
Purpose: To verify that the service retrieves a user entity by its username correctly.
Test Logic: This test calls the fetchUserByUsername method with a known username ("testUser") and asserts that the returned user's first name matches the expected value ("Test"). This ensures that the user retrieval functionality is working as intended.
* addNewUser():
Purpose: To validate that a new user can be added successfully and that the returned user entity matches the provided data.
Test Logic: This test invokes the addNewUser method with a new user DTO. It asserts that the user ID of the returned entity is as expected (5 in this case, assuming a predefined setup) and that the username matches the input ("testUser"). This verifies both the creation and data integrity of the user.
* fetchAllUsers():
Purpose: To ensure that the service correctly retrieves a list of all users.
Test Logic: This test checks that the fetchAllUsers method returns the expected number of user entities (4 in this scenario). Additionally, it verifies that the first user's first name matches the expected value ("testUser"). This confirms that the user retrieval functionality works correctly and that the list contains the appropriate data.

![image](https://github.com/user-attachments/assets/2527ce6f-8f5f-4dd2-a413-de48f65abed8)


## Integration Test
For integration tests, we need to test how various components (controllers, services and databases) work together in the application. Integration tests ensure that the entire flow from the API (controller) through the service layer and to the database or any external systems behaves as expected.
- fetchUserByUsernameEndpoint(): This ensures that the controller correctly handles the GET request for fetching users and returns the appropriate data from the database.
- addUserEndpoint(): This verifies that the controller properly processes the addition of new users, maps the request body correctly, and persists the data in the database.
- fetchAllUsersEndpoint():This verifies that the endpoint correctly retrieves and returns all users from the database, and ensures that the returned data is accurate.

![image](https://github.com/user-attachments/assets/a78c8727-078e-4b8b-871b-c9b9f5de8ee9)

# Jenkins file :
This Jenkins pipeline automates the build process for a Java project using Maven. It begins by defining the environment, specifying JDK 17 and Maven as the tools. The pipeline consists of four main stages:
- Compile: This stage compiles the source code without running tests.
- Build: In this stage, the project is packaged into a JAR file, again skipping tests.
- Test: Here, all unit tests are executed with debug output enabled to help diagnose any issues.
- Code Quality Check: This final stage runs a SonarQube analysis to assess code quality and sends the results to a specified SonarQube server. We specified the login secret and the SonarQube project that we created previously.
- Vulnerability scanning : With Snyk
- Build Docker image
- Deploy Docker image in Docker Desktop
  

![image](https://github.com/user-attachments/assets/a3f702bf-27d1-4e71-8142-86092ba53830)
![image](https://github.com/user-attachments/assets/2ae2440d-b5a1-45b5-a7cb-79d9a0fe64db)

![image](https://github.com/user-attachments/assets/98b3027f-30e1-40d0-9173-92859ecd565d)


![image](https://github.com/user-attachments/assets/bf00fbb5-c231-4de0-bd87-0db0b35f5c5f)






