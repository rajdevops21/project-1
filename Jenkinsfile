pipeline {
        agent any
        triggers {
            // Requires https://plugins.jenkins.io/parameterized-scheduler/
            parameterizedCron('''
                # pdsw-sonos-controller-player-s2 repo
                H 23 * * *   %jobtype=parent-nightly
            ''')
        }
def common = load “nightly.groovy”
common.mycode()

}
