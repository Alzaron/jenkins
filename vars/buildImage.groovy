def call () {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t alzaron/demo-app:test-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push alzaron/demo-app:test-2.0'
    }
} 
