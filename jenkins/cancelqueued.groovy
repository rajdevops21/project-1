node {
  timestamps {
    checkout scm
    
    stage('Get the Queued list') {
      sh '''#!/bin/bash
          which groovy
          pwd
          ls -larth
          chmod +x jenkins/queued.groovy
          groovy jenkins/queued.groovy
      '''
    }
    stage('Workspace Clean') {
      sh 'rm -fr *'
    }
  }
}
