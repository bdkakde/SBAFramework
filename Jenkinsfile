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

            post {
                            // If Maven was able to run the tests, even if some of the test
                            // failed, record the test results and archive the jar file.
                            success { allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'allure-results']]
                            ])
                        }
        }

     }
}

