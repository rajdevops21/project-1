def ci

node{
  checkout scm
  
  properties([[$class: 'BuildDiscarderProperty',
                strategy: [$class: 'LogRotator', numToKeepStr: '30']],
            pipelineTriggers([cron('H/10 * * * *')]),
            parameters(
              [string(name: 'gitremote', defaultValue: 'https://github.com/github/hackathons.git', description: 'Git remote with product source code'),
               string(name: 'jobtype', defaultValue: 'ci', description: 'Type of jobs to trigger: ci, parent-nightly, weekly-nightly'),]
            )
                ])
  
  ci = load 'common.groovy'
  ci.commoncode()
}
