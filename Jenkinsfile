#!/usr/bin/env groovy

pipeline {
    agent any
    triggers { pollSCM('* * * * *') }
    stages {
        // implicit checkout stage

        stage('Build') {
            steps {
                sh './mvnw clean compile'
            }
        }

        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }

        stage('Package') {
            steps {
                sh './mvnw package'
            }

            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }

                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}