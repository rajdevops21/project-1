def ciBranch(){
    node {
        stage('Build') {
            sh 'echo $date'
        }
        stage('Test') {
            sh 'echo $time'
        }
    }
}
return this
