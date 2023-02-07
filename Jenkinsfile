pipeline {
    agent any
    tools{
        maven '3.8.7'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/amaniem/Devops']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t amaniem/devops .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u amaniem -p ${dockerhubpwd}'

}
                   sh 'docker push amaniem/devops'
                }
            }
        }
        stage('Deploy to k8s'){
            steps{
                script{
                   
                    sh 'kubectl apply -f ${WORKSPACE}/deployment.yml --kubeconfig=${WORKSPACE}/kubeconf'
                }
            }
        }
    }
}
