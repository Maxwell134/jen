// pipeline {
//     agent any

//     stages {
//         stage('Read JSON') {
//             steps {
//                 script {
//                     // Read the JSON file
//                     def jsonFile = readFile 'pipeline.json'
//                     def jsonContent = readJSON text: jsonFile
                    
//                     // Extract the variable from JSON
//                     def image = jsonContent.dockerConfig.image
//                     def tag = jsonContent.dockerConfig.tag
//                     def port = jsonContent.dockerConfig.port
                    
                    
//                     // Load the Groovy script
//                     def sample = load 'sample.groovy'
                    
//                     // Call the hello method with the greeting message
//                     sample.hello(image, tag, port)
//                 }
//             }
//         }       
//     }
// }


pipeline {
    agent any

    stages {
        stage('Check Commit') {
            steps {
                script {
                    def fileName = 'mintu.txt' // Replace 'your-file-name.ext' with the actual file name
                    def commitExists = sh(script: "git log --oneline -- ${fileName}", returnStatus: true) == 0

                    if (commitExists) {
                        echo "A commit for file ${fileName} exists in the repository. Skipping build stage."
                        currentBuild.result = 'SUCCESS'
                        return
                    } else {
                        echo "No commit found for file ${fileName} in the repository. Proceeding with build stage."
                    }
                }
            }
        }

        stage('Build') {
            when {
                expression { currentBuild.result != 'SUCCESS' }
            }
            steps {
                echo 'Building the project...'
                // Add your build steps here
            }
        }

        stage('Test') {
            
            steps {
                echo 'Running tests...'
                // Add your test steps here
            }
        }

        stage('Deploy') {
            when {
                expression { currentBuild.result != 'SUCCESS' }
            }
            steps {
                echo 'Deploying the project...'
                // Add your deployment steps here
            }
        }
    }
}











