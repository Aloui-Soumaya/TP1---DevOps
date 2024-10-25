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
                    snykSecurity(
                      snykInstallation: 'snyk',
                      snykTokenId: 'snyk_cred2',
                      // place other parameters here
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





