def ciBranch(){
    node {
        stage('Build') {
            print "DEBUG: parameter jobtype = ${jobtype}"
        }
        stage('Test') {
            print "DEBUG: parameter jobtype = ${jobtype}"
        }
    }
}
return this
