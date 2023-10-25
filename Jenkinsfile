pipeline {
    agent any
    tools {
        maven 'maven-395'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building my application"
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building my docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t fromclippertojava/my-repo:jma-2.0 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push fromclippertojava/my-repo:jma-2.0'
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying my application"
                }
            }
        }
    }   
}
