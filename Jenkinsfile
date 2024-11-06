pipeline {
    agent any
    tools {
        Maven "maven_home"
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