pipeline {
    agent any
    tools {
        jdk "jdk17"
        maven "maven"
    }
    stages {
        stage('Snyk Security Test') {
            steps {
                echo 'Testing...'
                script {
                    // Give execute permissions to the mvnw file
                    sh 'chmod +x ./mvnw'
                    // Run the dependency tree command to verify maven wrapper works
                    sh './mvnw dependency:tree -DoutputType=dot --batch-mode --non-recursive --file="pom.xml"'
                }
                snykSecurity(
                    snykInstallation: 'snyk',
                    snykTokenId: 'snyk_cred2'
                )
            }
        }
    }
    post {

        always {
            junit "target/surefire-reports/*.xml"
        }
    }
}





