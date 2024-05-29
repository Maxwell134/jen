pipeline {
    agent any

    stages {
        stage('Initialization') {
            steps {
                script {
                    // Read the pipeline.json file from the workspace
                   
                    def groovyScript = load 'sample.groovy'
                    groovyScript.hello()
                }
            }
        }
    }
}
