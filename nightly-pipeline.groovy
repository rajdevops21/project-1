#!groovy

@Library('test-jenkins') _
jenkinsCommon 'parent-nightly'

triggers {
        // Requires https://plugins.jenkins.io/parameterized-scheduler/
        parameterizedCron('''
            # pdsw-sonos-controller-player-s2 repo
            H 23 * * *   %jobtype=parent-nightly
        ''')
    }
