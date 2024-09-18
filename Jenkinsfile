pipeline {
    agent any

    tools {
        maven "Maven"
    }

    stages {
        stage('GIT Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/KarthikeyanNagarajan/Integrating-Payment-Gateway.git']])
            }
        }
        stage('Maven Install') {
            steps {
                sh "mvn -Djasypt.encryptor.password=karthik -Dmaven.test.failure.ignore=true clean install"
            }
        }
	stage('OWASP Scanner') {
            steps {
                sh "mvn dependency-check:aggregate -PsonarReports"
            }
        }
        stage('Sonarqube Scanner') {
            steps {
                sh ''' mvn sonar:sonar \
                    -Dsonar.projectKey=Integrating-Payment-Gateway \
                    -Dsonar.projectName='Integrating-Payment-Gateway' \
                    -Dsonar.host.url=http://localhost:9000 \
                    -Dsonar.token=sqp_f9fad3b80636663ed7f177819bd6642e65a6bced '''
            }
        }
	stage('Build Image & Push') {
	    steps {
	        script {
	            withDockerRegistry(credentialsId: 'docker', toolName: 'docker', url: 'https://hub.docker.com') {
                        sh "docker build -t karthikeyan97/integrating-payment-gateway:latest ."
                        sh "docker image push --all-tags karthikeyan97/integrating-payment-gateway"
                    }
		}
	    }
	}
    }
}