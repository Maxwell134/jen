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
        stage('Check Last Commit') {
            steps {
                script {
                    // Get the last commit information
                    def lastCommitInfo = sh(script: "git log -1 --pretty=format:'%h %s'", returnStdout: true).trim()
                    echo "Last commit: ${lastCommitInfo}"
                    
                    // Get the list of files changed in the last commit
                    def changedFiles = sh(script: "git diff-tree --no-commit-id --name-only -r HEAD", returnStdout: true).trim().split("\n")
                    changedFiles = changedFiles.findAll { it } // Remove any empty strings
                    
                    // Log the changed files
                    echo "Files changed in the last commit: ${changedFiles}"
                    
                    // Check the number of files changed in the last commit
                    if (changedFiles.size() == 1) {
                        // If exactly one file is changed, check if it is mintu.txt
                        if (changedFiles.contains('mintu.txt')) {
                            echo "Recent changes made in mintu.txt. Skipping Maven build stage."
                            currentBuild.result = 'SUCCESS'
                            return
                        } else {
                            echo "Recent changes found but not in mintu.txt. Proceeding with Maven build stage."
                        }
                    } else {
                        echo "No recent changes or multiple changes found. Proceeding with Maven build stage."
                    }
                }
            }
        }

        stage('Build') {
            when {
                expression { currentBuild.result != 'SUCCESS' }
            }
            steps {
                echo 'Building the project with Maven..123.'
                // Example Maven build steps
                
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Add your test steps here
                // Example test steps:
                // Run unit tests
                
            }
        }

        stage('Deploy') {
            when {
                expression { currentBuild.result != 'SUCCESS' }
            }
            steps {
                echo 'Deploying the project...'
                // Add your deployment steps here
                // Example deployment steps:
                // Deploy to staging environment
               
            }
        }
    }
}









