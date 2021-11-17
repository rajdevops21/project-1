def ci
properties([[$class: 'BuildDiscarderProperty',
                strategy: [$class: 'LogRotator', numToKeepStr: '10']],
                pipelineTriggers([cron('H/10 * * * *')]),
                ])
node{
  checkout scm
  properties(
    [
      parameters(
        [string(name: 'gitremote', defaultValue: 'git@github.com:github/hackathons.git', description: 'Git remote with product source code'),
        string(name: 'gitremote_training', defaultValue: 'git@github.com:Sonos-Inc/pdsw-sonos-controller-player-s2-training.git', description: 'Git remote with product source code'),
        string(name: 'jenkinsdslgitremote', defaultValue: 'git@github.com:github/hackathons.git', description: 'Git remote for Jenkins DSL repo'),
        string(name: 'jenkinsdslgitbranch', defaultValue: 'main', description: 'Git branch for Jenkins DSL repo to pull dsl-branches and enabled-jobs.json from'),
        string(name: 'jobtype', defaultValue: 'ci', description: 'Type of jobs to trigger: ci, parent-nightly, weekly-nightly')]
        )
      ]
  )
//  environment {
//            gitremote = "${params.gitremote}"
//            gitremote_training = "${params.gitremote_training}"
//            jenkinsdslgitremote = "${params.jenkinsdslgitremote}"
//            jenkinsdslgitbranch = "${params.jenkinsdslgitbranch}"
//            jobtype = "${params.jobtype}"
//  }
  ci = load 'nightly.groovy'
  ci.ciBranch()
}
