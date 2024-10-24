pipeline {
    agent any
    tools {
        jdk "jdk17"
        maven "maven"
    }
    stages {

        stage('Snyk Test') {
            steps {
                   script {
                       // Run Snyk test
                       echo "Installing Node.js and npm..."
                                   sh '''
                                       curl -fsSL https://deb.nodesource.com/setup_14.x | bash -
                                       apt-get install -y nodejs
                                   '''

                                   // Verify installation
                                   echo "Verifying Node.js and npm installation..."
                                   sh 'node -v'
                                   sh 'npm -v'

                                   // Install Snyk
                                   echo "Installing Snyk CLI..."
                                   sh 'npm install -g snyk'
                       withCredentials([string(credentialsId: 'snyk_cred', variable: 'SNYK_TOKEN')]) {
                           sh "snyk test --token=$SNYK_TOKEN"
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





