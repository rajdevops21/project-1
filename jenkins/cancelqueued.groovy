node {
  timestamps {
    checkout scm
    
    stage('Get the Queued list') {
      sh '''#!/bin/bash
          which groovy
          pwd
          ls -larth
      '''
    }
    stage('Workspace Clean') {
      sh 'rm -fr *'
    }
  }
}
