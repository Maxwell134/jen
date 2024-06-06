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
        stage('Check Changes') {
            steps {
                script {
                    def fileName = 'mintu.txt' // Replace 'mintu.txt' with the actual file name

                    // Get the last modification time of the file
                    def lastModifiedTime = sh(script: "stat -c %Y ${fileName}", returnStdout: true).trim().toLong()

                    // Get the current timestamp
                    def currentTimestamp = sh(script: 'date "+%s"', returnStdout: true).trim().toLong()

                    if (lastModifiedTime == currentTimestamp) {
                        echo "Changes for file ${fileName} exist at the current timestamp. Skipping build stage."
                        currentBuild.result = 'SUCCESS'
                        return
                    } else {
                        echo "No changes found for file ${fileName} at the current timestamp. Proceeding with build stage."
                    }
                }
            }
        }

        stage('Build') {
            when {
                expression { currentBuild.result != 'SUCCESS' }
            }
            steps {
                script {
                    echo 'Building the project...'
                    // Example build steps:
                    // Compile the code
                    sh 'make compile'
                    // Run additional build scripts or commands as needed
                    sh 'make build'
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Add your test steps here
                // Example test steps:
                // Run unit tests
                sh 'make test'
                // Run integration tests
                sh 'make integration-test'
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
                sh 'make deploy-staging'
                // Deploy to production environment
                sh 'make deploy-production'
            }
        }
    }
}









