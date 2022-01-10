import hudson.model.*
import jenkins.model.Jenkins
node ('master') {
  timestamps {
    
    properties([[$class: 'BuildDiscarderProperty',
                    strategy: [$class: 'LogRotator', numToKeepStr: '30']],
                    pipelineTriggers([cron('H 22 * * *')]),
              ])
    
    stage('Get the Queued list') {
      script {
        def jobName = 'DEV'
        def q = Jenkins.instance.queue
        q.items.findAll { it.task.name.contains(jobName) }.each {
          println("queued: " + it.task.name)
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
