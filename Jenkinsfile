pipeline {
    agent any
    stages {
        stage('Clone Git Repo') {
            steps {
                echo '***** Pulling code from github repository *****'
                @git 'https://github.com/bdkakde/SBAFramework.git/',
                 credentialsId: 'github_creds'
            }
        }
         stage('Run Tests') {
                steps {
                     echo '***** Execution started for scenarios *****'
                     @gradle runSerial tests
                }
         }

          stage('Publish Reports') {
                 steps {
                        echo "***** Publish Reports *****"
                        allure serve allure-results
                        echo '***** Report generated successfully *****'
                 }
          }
    }
}