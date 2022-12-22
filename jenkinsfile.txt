pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Get code from a GitHub repository
                echo 'Pulling code from github repository'
                git url: 'https://github.com/bdkakde/SBAFramework.git/', branch: 'main',
                 credentialsId: 'github_creds'
            }
        }
         stage('Run Tests') {
                    steps {
                        gradle runSerial tests
                    }
         }

          stage('Generate report') {
                 steps {
                           allure serve allure-results
                        }
          }
    }
}