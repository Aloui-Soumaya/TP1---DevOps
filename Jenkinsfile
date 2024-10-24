pipeline {
    agent any
    tools {
        jdk "jdk17"
        maven "maven"
    }
    stages {
        stage("Compile") {
            steps {
                script {
                    echo "Compiling..."
                    sh "mvn clean compile -DskipTests"
                }
            }
        }

        stage("Build") {
            steps {
                script {
                    echo "Building the JAR file..."
                    sh "mvn package -DskipTests"
                }
            }
        }

        stage("Test") {
            steps {
                script {
                    echo "Test ..."
                    sh "mvn test -X"
                }
            }
        }
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
    stage('Snyk Security Test') {
        steps {
            script {
                echo "Running Snyk to check for vulnerabilities..."
                withCredentials([string(credentialsId: 'snyk_cred')]) {
                    // Run Snyk with the token for authentication
                    sh 'snyk test --org=my-org --token=$snyk_cred'
                }
            }
        }
    }

    }
    post {

        always {
            junit "target/surefire-reports/*.xml"
        }
    }
}





