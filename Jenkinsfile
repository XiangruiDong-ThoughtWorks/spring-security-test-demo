pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn clean'
                sh 'mvn package'
            }
        }
        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('deploy') {
            steps {
                sh 'java -jar target/spring-security-test-demo-0.0.1-SNAPSHOT.jar'
            }
        }

    }
}