pipeline {      // declarative pipeline

    agent any

    environment {
            fromEmail = "bdkakde@rediffmail.com"
            recipientEmails = "bdkakde@gmail.com"
            APP_NAME = 'Amazon'
        }

    stages
    {
        stage('checkout from SCM repo')
        {
            steps
            {
               git 'https://github.com/bdkakde/SBAFramework.git'
            }
        }

        stage ('Test')          // run tests
        {
            steps
            {
              bat 'gradle runSerial'
            }
            
        post {
          always {
            script {
              allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
              ])
            }
          }
         }
        }

   stage("Email"){
   			steps{
                    archiveArtifacts artifacts: 'generatedFile.txt', onlyIfSuccessful: false
                    echo 'I will always say Hello again!'
   				    emailext attachLog: true, attachmentsPattern: 'target/allure-results',
                                body: 'Test mail',
                                recipientProviders: 'bdkakde@gmail.com',
                                subject: Automation Status
   			}
   		}
   	}
  }
