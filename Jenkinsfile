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
                                           sh 'mvn dependency:tree -DoutputType=dot --batch-mode --non-recursive --file="pom.xml"'

                           }
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





