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
          mail subject: 'Email',body: 'Hello, This is an email from jenkins pipeline.',attachmentsPattern: 'allure-report.zip'from: "bdkakde@rediffmail.com',to: 'bdkakde@rediffmail.com',cc: '',bcc: ''
         }
    }
  }


