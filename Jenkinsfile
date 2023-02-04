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
   				emailext (to: 'bdkakde@gmail.com', replyTo: 'bdkakde@gmail.com', subject: "Email Report from - '${env.JOB_NAME}' ", body: readFile("allure-results"), mimeType: 'text/html');
   			}
   		}
  }


