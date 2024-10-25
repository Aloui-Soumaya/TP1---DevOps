FROM jenkins/jenkins:2.414.3-jdk11

USER jenkins

# Install Jenkins plugins
RUN jenkins-plugin-cli --plugins "blueocean"
