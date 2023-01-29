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
            
                  stage('Reports') {
              steps {
                 allure([
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
}

