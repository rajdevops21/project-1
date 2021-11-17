def nightly

timeout(150) {
  node{
    checkout scm
    
    properties([[$class: 'BuildDiscarderProperty',
                 strategy: [$class: 'LogRotator', numToKeepStr: '30']],
            pipelineTriggers([cron('H/10 * * * *')]),
            parameters(
              [string(name: 'gitremote', defaultValue: 'https://github.com/github/hackathons.git', description: 'Git remote with product source code'),
               string(name: 'jobtype', defaultValue: 'nightly', description: 'Type of jobs to trigger: ci, parent-nightly, weekly-nightly')]
            )
                ])
    nightly = load 'common.groovy'
    nightly.commoncode()
  }
}
