def ci
node{
  parameters {
        string(name: 'gitremote', defaultValue: 'git@github.com:Sonos-Inc/pdsw-sonos-controller-player-s2.git', description: 'Git remote with product source code')
        string(name: 'gitremote_training', defaultValue: 'git@github.com:Sonos-Inc/pdsw-sonos-controller-player-s2-training.git', description: 'Git remote with product source code')
        string(name: 'jenkinsdslgitremote', defaultValue: 'git@github.com:Sonos-Inc/pdsw-jenkins-dsl.git', description: 'Git remote for Jenkins DSL repo')
        string(name: 'jenkinsdslgitbranch', defaultValue: 'p4/main', description: 'Git branch for Jenkins DSL repo to pull dsl-branches and enabled-jobs.json from')
        string(name: 'jobtype', defaultValue: 'ci', description: 'Type of jobs to trigger: ci, parent-nightly, weekly-nightly')
  }
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
