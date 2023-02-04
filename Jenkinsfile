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

    stage('Email Jenkins Pipeline') {
         steps {
          mail bcc: '',
          body: 'Hello, This is an email from jenkins pipeline.',
          cc: '',
          from: 'bdkakde@gmail.com',
          replyTo: '',
          subject: 'EmailJenkinsPipeline',
          to: 'bdkakde@gmail.com'
         }
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

