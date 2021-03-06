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
        sh "docker build -t $imagename ."
      }
    }
    stage('Deploy Image') {
      steps {
        script {
          docker.withRegistry('', registryCredential) {
            dockerImage.push("$BUILD_NUMBER")
            dockerImage.push('latest')

          }
        }
      }
    }
    stage('Remove Unused docker image') {
      steps {
        sh "docker rmi $imagename:$BUILD_NUMBER"
        sh "docker rmi $imagename:latest"

      }
    }
  }
}