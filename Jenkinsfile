pipeline {
    agent any

    stages {

        stage('Clean') {
                    steps {
                         echo '***** Cleaning workspace *****'

                    }
             }

        stage('Clone Git Repo') {
            steps {
                echo '***** Pulling code from github repository *****'
                git url: 'https://github.com/bdkakde/SBAFramework.git'
                 @credentialsId github_creds
            }
        }
         stage('Run Tests') {
                steps {
                     echo '***** Execution started for scenarios *****'
                     @runSerial
                }
         }

          stage('Publish Reports') {
                 steps {
                        echo "***** Publish Reports *****"

                        echo '***** Report generated successfully *****'
                 }
          }

          stage('Deploy') {
          			steps {
          				echo "***** Deploying... *****"
          			}
          		}
    }
}