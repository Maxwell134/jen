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
                    def greetingMessage = jsonContent.greeting
                    
                    // Print the greeting message
                    echo greetingMessage
                }
            }
        }
    }
}
