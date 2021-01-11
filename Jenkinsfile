pipeline {
    agent maven
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean'
                sh 'mvn package'
                sh 'pwd'
            }
        }
    }
}