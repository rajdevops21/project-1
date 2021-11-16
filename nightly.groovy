def ciBranch(){
    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    sh 'echo $date'
                }
            }
            stage('Test') {
                steps {
                    sh 'echo $time'
                }
            }
        }
    }
}
return this
