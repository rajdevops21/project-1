def ciBranch(){
    node {
        stage('Build') {
            echo "Job type is: ${jobtype}"
        }
        stage('Test') {
            echo "Job type is: ${jobtype}"
        }
    }
}
return this
