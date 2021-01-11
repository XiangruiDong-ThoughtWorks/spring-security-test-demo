pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean'
                sh 'mvn package'
                sh 'java -jar target/spring-security-test-demo-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}