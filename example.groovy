pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'echo "$pwd"'
            }
        }
        stage('Test') {
            steps {
                sh 'echo "$whoami"'
            }
        }
    }
}
