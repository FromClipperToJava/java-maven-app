def buildJar() {
    echo "building my application"
    sh 'mvn package'
} 

def buildImage() {
    echo "building my docker image 2.1"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t fromclippertojava/my-repo:jma-2.1 .'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh 'docker push fromclippertojava/my-repo:jma-2.1'    }
} 

def deployApp() {
    echo "deploying my application 2.1"
} 

return this
