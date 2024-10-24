pipeline {
    agent any
    tools {
        jdk "jdk17"
        maven "maven"
    }
    stages {


        stage('Test') {
                  steps {
                    echo 'Testing...'
                    snykSecurity(
                      snykInstallation: 'snyk>',
                      snykTokenId: '<snyk_cred>',
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





