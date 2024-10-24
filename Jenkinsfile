pipeline {
    agent any
    tools {
        jdk "jdk17"
        maven "maven"
    }
    stages {
        stage("Code Quality check"){
            steps{
                script{
                    echo "Running SonarQube Scanner..."
                    withSonarQubeEnv() {
                        sh "mvn verify sonar:sonar -Dsonar.url=http://172.31.240.1:9000/ -Dsonar.login=squ_90bc1fef228bfdb69c5719a7298c2e1eb43dcf96 -Dsonar.projectKey=TP2_DevOps -Dsonar.projectName=TP2_DevOps"
                    }
                }
            }
        }
    }
}





