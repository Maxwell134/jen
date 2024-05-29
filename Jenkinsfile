pipeline {
    agent any

    stages {
        stage('Initialization') {
            steps {
                script {
                    // Read the pipeline.json file from the workspace
                    def jsonFile = readFile 'pipeline.json'
                    // Parse the JSON content
                    def jsonParser = new groovy.json.JsonSlurper().parseText(jsonFile)
                    // Convert LazyMap to a HashMap
                    def jsonMap = new HashMap<>(jsonParser)

                    // Load and call the sample.groovy script
                    def groovyScript = load 'sample.groovy'
                    groovyScript.sample(jsonMap)
                }
            }
        }
    }
}
