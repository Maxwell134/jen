def call(String dockerUsername, String imageName, String imageTag) {
    docker.image('docker:latest').inside('-v /var/run/docker.sock:/var/run/docker.sock') {
        withDockerRegistry([credentialsId: 'dockerhub-credentials', url: '']) {
            echo "Pushing Docker image ${dockerUsername}/${imageName}:${imageTag}"
            sh """
                docker tag ${imageName}:${imageTag} ${dockerUsername}/${imageName}:${imageTag}
                docker push ${dockerUsername}/${imageName}:${imageTag}
            """
        }
    }
}
