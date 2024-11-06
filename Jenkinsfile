pipeline {
    agent any
    tools {
        maven 'MAVEN'
    }
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean'
                sh 'mvn compile'
            }
        }
        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}