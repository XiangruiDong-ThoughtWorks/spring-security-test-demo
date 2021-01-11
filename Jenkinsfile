pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean'
                sh 'mvn package'
                sh 'pwd'
                sh 'ls'
                sh 'java'
            }
        }
    }
}