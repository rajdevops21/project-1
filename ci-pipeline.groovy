pipeline { 
    agent any 
    options {
        skipStagesAfterUnstable()
    }
     triggers {
        // Requires https://plugins.jenkins.io/parameterized-scheduler/
        parameterizedCron('''
            # pdsw-sonos-controller-player-s2 repo
            H/10 * * * * %jobtype=parent-nightly
        ''')
    }
    stages {
        stage('Build') {
            String jenkinsFile = ./common.groovy
            }
        load jenkinsFile
        }
       
    }
}
