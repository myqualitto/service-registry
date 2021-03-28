pipeline{
    
    agent any
    
    environment{
        currJobName = jobName()
        imagename = "qualitto007/${currJobName}:${env.BUILD_NUMBER}"
        dockerCrdtl = 'dockerhub'
        dockerImage = ''
    }
    
    tools{
        maven 'maven_3.6.3'
    }
    
    stages{
        
        stage('Maven Build'){
            steps{
               sh "mvn clean install -Dmaven.test.skip=true"
            }
        }
        
        stage('Building image'){
            steps{
                script{
                    dockerImage = docker.build imagename
                }
            }
        }
        
        stage('Deploy Image'){
            steps{
                script{
                    docker.withRegistry('', dockerCrdtl){
                        dockerImage.push()
                        dockerImage.push('latest')
                    }
                }
            }
        }
        
        stage('Deploy K8S') {
            steps {
                script {
                    withKubeConfig([credentialsId: 'kubeconfig']) {
                        sh 'kubectl apply -f kube8s.yml'
                    }
                }
            }
        }
    }
}

def String jobName() {
    def jobNameParts = env.JOB_NAME.tokenize('/') as String[]
    return jobNameParts.length < 2 ? env.JOB_NAME : jobNameParts[jobNameParts.length - 2]
}
