pipeline {      // declarative pipeline

    agent any

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
        }

        stage('Publish') {

                publishHTML(
                        target: [
                                allowMissing         : false,
                                alwaysLinkToLastBuild: false,
                                keepAll              : true,
                                reportDir            : 'allure-results',
                                reportFiles          : 'index.html',
                                reportName           : "Allure Report"
                        ]
                )
            }

     }
}

