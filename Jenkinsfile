pipeline {
    agent any

    stages {
        stage('Read JSON') {
            steps {
                script {
                    // Read the JSON file
                    def jsonFile = readFile 'pipeline.json'
                    def jsonContent = readJSON text: jsonFile
                    
                    // Extract the variable from JSON
                    def image = jsonContent.dockerConfig.image
                    def tag = jsonContent.dockerConfig.tag
                    def port = jsonContent.dockerConfig.port
                    
                    
                    // Load the Groovy script
                    def sample = load 'sample.groovy'
                    
                    // Call the hello method with the greeting message
                    sample.hello(image, tag, port)
                }
            }
        }       
    }
}
