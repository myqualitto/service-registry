pipeline {
    agent any

    stages {
        stage('SCM') {
            steps {
               git branch: 'main', credentialsId: 'techhmr', url: 'https://github.com/harimanda123/techhmr-microservices'
            }
        }
        
        stage('Maven Build') {
            steps {
               sh "mvn clean install"
            }
        }
        
        stage('Docker Image') {
            steps {
                dir('techhmr-serviceregistry') {
                    sh "docker build -t techhmr/techhmr-serviceregistry:V1.0.0 ."
                }
            }
        }
    }
}
