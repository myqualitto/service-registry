node {
    def app
    environment {
       jobName = jobName()
    }
    stage('Clone repository') {
        checkout scm
    }
    stage('Build image') {
       app = docker.build("ivamsi2001/${env.jobName}")
    }
    stage('Test image') {
        app.inside {
            sh 'echo "Tests passed"'
        }
    }
    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}

def jobName() {
  def jobNameParts = env.JOB_NAME.tokenize('/') as String[]
  jobNameParts.length < 2 ? env.JOB_NAME : jobNameParts[jobNameParts.length - 2]
}
