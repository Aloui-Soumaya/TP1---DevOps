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
                      snykToken: '97082c80-c0a2-480e-a900-0930e7dc5924',
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





