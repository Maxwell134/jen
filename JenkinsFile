@Library('builder') _

pipeline {
    agent any

    environment {
        IMAGE_NAME = 'myapp'
        IMAGE_TAG = 'latest'
        DOCKER_USERNAME = '7002370412'
       
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    buildDockerImage(IMAGE_NAME, IMAGE_TAG)
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    pushDockerImage(DOCKER_USERNAME, IMAGE_NAME, IMAGE_TAG)
                }
            }
        }

       
    }
}
