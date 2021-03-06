pipeline {
    agent any
    tools { 
        maven 'maven_3.6.3'
    }
    stages {
        stage('Maven Build') {
            steps {
               sh "mvn clean install"
            }
        }
    }
}
