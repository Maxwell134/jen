def hello(image, tag, port) {
    sh "docker run -d -p ${port}:80 ${image}:${tag}"
}

return this
