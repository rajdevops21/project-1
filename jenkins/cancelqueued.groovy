import hudson.model.*
import jenkins.model.Jenkins
node {
  timestamps {
    checkout scm
    
    properties([[$class: 'BuildDiscarderProperty',
                    strategy: [$class: 'LogRotator', numToKeepStr: '30']],
                    pipelineTriggers([cron('H 23 * * *')]),
              ])
    
    stage('Get the Queued list') {
      script {
        def jobName = 'DEV'
        def q = Jenkins.instance.queue
        q.items.findAll { it.task.name.contains(jobName) }.each {
          println("queued: " + it.task.name)
          q.cancel(it.task)
        }
        def running = Jenkins.instance.getView('All').getBuilds().findAll{ it.getResult().equals(null) && it.toString().contains(jobName) }
        running.each {
          println("running: " + it)
        }
      }
    }
    stage('Workspace Clean') {
      sh 'rm -fr *'
    }
  }
}
