pipeline {
    agent any

    triggers {
        // Requires https://plugins.jenkins.io/parameterized-scheduler/
        parameterizedCron('''
            # pdsw-sonos-controller-player-s2 repo
            H 23 * * *   %jobtype=parent-nightly
        ''')
    }
    stages {
        stage('Nightly-Run') {
            steps {
                script {
                def nightly = load "common.groovy"
                nightly.mycommoncode()
                }
            }
        }
    }
}
