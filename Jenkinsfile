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
                    
                    // Load the Groovy script
                    def sample = load 'sample.groovy'
                    
                    // Call the hello method with the greeting message
                    sample.hello(greetingMessage)
                }
            }
        }
    }
}
