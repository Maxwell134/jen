def hello(image, tag, port) {
    // Get the list of container IDs
    def containers = sh(script: 'docker ps -qa', returnStdout: true).trim()
    
    // Check if there are any containers to remove
    if (containers) {
        // Split the container IDs into a list
        def containerIds = containers.tokenize()
        
        // Remove each container
        containerIds.each { id ->
            sh "docker rm -f ${id}"
        }
    }
    
    // Run a new container
    sh "docker run -d -p ${port}:80 ${image}:${tag}"
}

return this
