pipeline {
    agent any

    environment {
    		echo 'Starting pipeline...'
    	}

    stages {

        stage('Clean') {
                    steps {
                         echo '***** Cleaning workspace *****'
                         clean
                    }
             }

        stage('Clone Git Repo') {
            steps {
                echo '***** Pulling code from github repository *****'
                git clone 'https://github.com/bdkakde/SBAFramework.git/',
                 credentialsId: 'github_creds'
            }
        }
         stage('Run Tests') {
                steps {
                     echo '***** Execution started for scenarios *****'
                     runSerial
                }
         }

          stage('Publish Reports') {
                 steps {
                        echo "***** Publish Reports *****"
                        allure serve allure-results
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