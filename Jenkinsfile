pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Example Build mit docker agent') {
                agent { docker 'maven:3.9.9-eclipse-temurin-21' }
                steps {
                    echo 'Hello, Maven'
                    sh './mvnw -Dmaven.test.failure.ignore=true clean package'
                }
            }

        stage('Which Java?') {
                steps {
                    sh 'java --version'
                }
            }
        stage('Build') {
            steps {
//                 // Get some code from a GitHub repository
//                 git 'https://github.com/jglick/simple-maven-project-with-tests.git'

                // Run Maven on a Unix agent.
                sh "./mvnw -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}