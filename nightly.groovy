def ciBranch(){
    pipeline {
        agent ubuntu
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
