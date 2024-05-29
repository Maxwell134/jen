import groovy.json.JsonSlurperClassic 
pipeline {
    agent any

    stages {
        // stage('Intialization') {
        //     steps {
        //         script {
        //             // Import the required class
        //             inputFile = readFile("${env.WORKSPACE}/pipeline.json")
        //             parserJson = new JsonSlurperClassic().parseText(inputFile)
        //             println "Reading Json"
                
        //         }
        //     }
        // }
    
    stage('Demo') {
            steps {
                script {
                    // Import the required class
                    stageName = "applying sample"
                    new = load 'sample.groovy'
                    sh 'new.sample(world)'
                         
                }
                // sample(parserJson)
            }
        }  
    
    }
}
