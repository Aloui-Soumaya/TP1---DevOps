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

- Unit Test:
* fetchUserByUsername():
Purpose: To verify that the service retrieves a user entity by its username correctly.
Test Logic: This test calls the fetchUserByUsername method with a known username ("testUser") and asserts that the returned user's first name matches the expected value ("Test"). This ensures that the user retrieval functionality is working as intended.
* addNewUser():
Purpose: To validate that a new user can be added successfully and that the returned user entity matches the provided data.
Test Logic: This test invokes the addNewUser method with a new user DTO. It asserts that the user ID of the returned entity is as expected (5 in this case, assuming a predefined setup) and that the username matches the input ("testUser"). This verifies both the creation and data integrity of the user.
* fetchAllUsers():
Purpose: To ensure that the service correctly retrieves a list of all users.
Test Logic: This test checks that the fetchAllUsers method returns the expected number of user entities (4 in this scenario). Additionally, it verifies that the first user's first name matches the expected value ("testUser"). This confirms that the user retrieval functionality works correctly and that the list contains the appropriate data.

![Uploading image.png…]()


