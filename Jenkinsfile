pipeline {
    agent any

    stages {
        stage('Run Groovy Script') {
            steps {
                script {
                    // Load the Groovy script
                    def groovyScript = load 'sample.groovy'
                    
                    // Call the hello method
                    groovyScript.hello()
                }
            }
        }
    }
}
