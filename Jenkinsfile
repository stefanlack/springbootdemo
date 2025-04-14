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


         stage('sonar') {
//             agent { docker 'maven:3.9.9-eclipse-temurin-21' }
               steps {
                   echo "execute  './mvnw clean verify sonar:sonar' ..."
//                 Auskommentiert, da jenkins noch nicht localse sonar installation erreichen wird. (nicht mehr getestet)
//                 withCredentials([string(credentialsId: 'sonarCredentials', variable: 'SONAR_TOKEN')]) {
//                         sh './mvnw clean verify sonar:sonar -Dsonar.token=${SONAR_TOKEN}'
//                 }
              }
         }

        // Auskommentiert, da java 17 in jenkins installiert und ich 21 brauche. Man würde Build Jobs m.E. sowieso nicht direkt im jenkins host ausführen, sondern in build agents
//      stage('Build') {
//        steps {
//          sh "./mvnw -Dmaven.test.failure.ignore=true clean package"
//       }
//     }


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