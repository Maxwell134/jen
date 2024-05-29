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

    stage('Install K3s') {
            steps {
                script {
                    // Read the JSON file
                   sh 'curl -sfL https://get.k3s.io | sh - 
                // Check for Ready node, takes ~30 seconds 
                    sudo k3s kubectl get node 
                }
            }
        }
    }
}
