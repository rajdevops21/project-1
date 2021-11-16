def ciBranch(){
    node {
        stage('Build') {
            sh 'echo "${jobtype}"'
        }
        stage('Test') {
            sh 'echo "${jobtype}"'
        }
    }
}
return this
