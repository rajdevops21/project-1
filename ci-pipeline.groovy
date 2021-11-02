pipeline { 
    agent any 
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') { 
            steps { 
                sh 'date'
            }
        }
        stage('Test'){
            steps {
                sh 'du -sh' 
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo "Test-1"'
            }
        }
    }
}
