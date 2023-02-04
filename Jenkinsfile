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

    stage('Email Jenkins Pipeline') {
         steps {
          mail subject: 'Email Jenkins Pipeline',
          body: 'Hello, This is an email from jenkins pipeline.',
          attachmentsPattern: 'allure-report.zip'
          from: "${fromEmail}",
          to: "${recipientEmails}",
          cc: '',
          bcc: ''
         }
    }
  }

/*     post{
            always{
                mail to: "${recipientEmails}",
                subject: "Test Email",
                body: "Test"
            }
        } */
}

