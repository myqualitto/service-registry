pipeline{
    
    agent any
    
    environment{
        currJobName = jobName()
        imagename = "ivamsi2001/${currJobName}"
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
                    docker.withRegistry('https://registry.hub.docker.com', dockerCrdtl){
                        dockerImage.push("${env.BUILD_NUMBER}")
                        dockerImage.push('latest')
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
