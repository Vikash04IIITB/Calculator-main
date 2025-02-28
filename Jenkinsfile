pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'vikash04/calculator-app'
        GITHUB_REPO_URL = 'https://github.com/Vikash04IIITB/Calculator-main.git'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: "${GITHUB_REPO_URL}"
            }
        }
        stage('Build and Test') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t ${DOCKER_IMAGE_NAME} .'
            }
        }
        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB_TOKEN', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh 'docker push ${DOCKER_IMAGE_NAME}'
                }
            }
        }
        stage('Run Ansible Playbook') {
            steps {
                sh 'ansible-playbook deploy.yaml'
            }
        }
    }
}