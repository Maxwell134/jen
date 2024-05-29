def hello(image, tag, port) {
    def container = 'docker ps -a'
    def output = sh(script: container, returnStdout: true).trim()
    
    if (output) {
        sh "docker rm -f $(docker ps -qa)"
    }
    
    sh "docker run -d -p ${port}:80 ${image}:${tag}"
}

return this
