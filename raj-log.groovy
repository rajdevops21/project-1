pipeline {
    agent any
    options { timestamps () }
    stages {
        stage('Example Build') {
            steps {
                sh '''#!/bin/bash
                  chmod +x log.py
                  python3 log.py
                '''
            }
        }
     }
}
