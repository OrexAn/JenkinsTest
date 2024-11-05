pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('build') {
            steps {
                sh 'mwn clean'
                sh 'mwn compile'
            }
        }
        stage('test') {
            steps {
                sh 'mwn test'
            }
        }
    }
}