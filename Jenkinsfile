pipeline {
    agent any
    tools {
        jdk "jdk17"
        maven "maven"
    }
    stages {


        stage('Snyk Security Test') {
            steps {
                            script {
                                echo 'Running Snyk Security Test...'
                                withCredentials([string(credentialsId: 'snyk_cred', variable: 'SNYK_TOKEN')]) {
                                    sh 'snyk test --org=my-org --token=$SNYK_TOKEN'
                                }
                            }
        }               }
    }
    post {

        always {
            junit "target/surefire-reports/*.xml"
        }
    }
}





