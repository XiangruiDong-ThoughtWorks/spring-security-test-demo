pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                mvn --version
                mvn clean
                mvn package
                pwd
                ls
                java
            }
        }
    }
}