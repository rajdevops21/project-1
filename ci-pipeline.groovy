def ci
node{
  triggers {
            // Requires https://plugins.jenkins.io/parameterized-scheduler/
            parameterizedCron('''
                # pdsw-sonos-controller-player-s2 repo
                H 23 * * *   %jobtype=parent-nightly
            ''')
  }
  ci = load 'nightly.groovy'
  ci.ciBranch()
}
