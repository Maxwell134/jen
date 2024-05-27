def call(String imageName, String imageTag) {
    docker.image('docker:latest').inside('-v /var/run/docker.sock:/var/run/docker.sock') {
        echo "Building Docker image ${imageName}:${imageTag}"
        sh """
            docker build -t ${imageName}:${imageTag} .
        """
    }
}
