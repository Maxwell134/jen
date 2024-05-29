// import groovy.json.JsonSlurperClassic

pipeline {
    agent any

    stages {
        stage('Initialization') {
            steps {
                script {
                    // Read the JSON file from the workspace
                    // def inputFile = readFile(file: 'pipeline.json')
                    // // Parse the JSON content
                    // def parserJson = new JsonSlurperClassic().parseText(inputFile)
                    // // Load the external Groovy script
                    sh 'ls -lrth'
                    groovyScript = load 'sample.groovy'
                    
                    // Call the sample function from the loaded script with parsed JSON
                    groovyScript.sample()
                }
            }
        }
    }
}
