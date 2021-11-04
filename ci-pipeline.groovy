node {
     triggers {
        // Requires https://plugins.jenkins.io/parameterized-scheduler/
        parameterizedCron('''
            # pdsw-sonos-controller-player-s2 repo
            H/10 * * * * %jobtype=parent-nightly
        ''')
    }
    stage("Run the main pipieline") {
        load "common.groovy"
    }
}
