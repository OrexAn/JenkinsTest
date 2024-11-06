pipeline {
    agent any
    tools {
        maven 'MAVEN'
    }
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Compile') {
            steps {
                sh 'mvn clean'
                sh 'mvn compile'
            }
        }
        stage('Checkstyle') {
            steps {
                sh 'mvn checkstyle:check'
            }
        }
        stage('Spotbugs') {
            steps {
                sh 'mvn spotbugs:check'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn package'
            }
        }
    }
}