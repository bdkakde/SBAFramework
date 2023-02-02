pipeline {      // declarative pipeline

    agent any

    environment {
            recipientEmails = "bdkakde@gmail.com"
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
    }

    post{
            always{
                emailext to: "${recipientEmails}",
                subject: "Test Email",
                body: "Test",
                attachLog: true
            }
        }
}

