import groovy.json.JsonSlurper

def sample(variable) {
    def jsonSlurper = new JsonSlurper()
    def jsonObject = jsonSlurper.parseText(variable)
    println "Hello ${jsonObject.message}"
}

// Sample JSON input as a string
def jsonString = '{"message": "Hello World"}'

// Call the sample function with the JSON string
sample(jsonString)
