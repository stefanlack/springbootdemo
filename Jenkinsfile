pipeline {
	agent any

    tools {
		// Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
		stage('Which Java?') {
			steps {
				sh 'java --version'
            }
            // in meinem schnell via docker installiertem Jenkins läuft noch java 17.0.14 2025-01-21, daher klappt der nächste step nicht
        }
        stage('Build') {
			agent { docker 'maven:3.9.9-eclipse-temurin-21' }
            steps {
				sh './mvnw -Dmaven.test.failure.ignore=true clean package'
            }
        }
	}
	post {
		always {
			archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
		}
		success {
			echo 'Build was successful!'
		}
		failure {
			echo 'Build failed!'
		}
	}

}