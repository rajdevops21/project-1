def ciBranch(){
    node {
        environment {
            gitremote = "${params.gitremote}"
            gitremote_training = "${params.gitremote_training}"
            jenkinsdslgitremote = "${params.jenkinsdslgitremote}"
            jenkinsdslgitbranch = "${params.jenkinsdslgitbranch}"
            jobtype = "${params.jobtype}"
        }
        stage('Build') {
            print "DEBUG: parameter jobtype = ${jobtype}"
        }
        stage('Test') {
            print "DEBUG: parameter jobtype = ${jobtype}"
        }
    }
}
return this
