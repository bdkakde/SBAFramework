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

               stage ('Report')          // run tests
                {
                    steps
                    {
                      bat 'allure serve allure-results'
                    }
                }
     }
}

