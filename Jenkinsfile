pipeline {
  agent any
  tools {
    maven 'maven_3.6.3'
  }
  environment {
    imagename = "ivams2001/${env.JOB_NAME}"
    registryCredential = 'qualitto-dockerhub'
    dockerImage = ''
  }
  stages {
    stage('Maven Build') {
      steps {
        sh "mvn clean install"
      }
    }
    stage('Building image') {
      steps {
        sh "docker build -t hello:lts ."
      }
    }
  }
}