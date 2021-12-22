import jenkins.model.Jenkins
//import hudson.slaves.EnvironmentVariablesNodeProperty
//import hudson.EnvVars

def commoncode(){
    timeout(150) {
        node {
            timestamps {
                properties([
                disableConcurrentBuilds()
                ])
                env.gitremote_training = "git@github.com:Sonos-Inc/pdsw-sonos-controller-player-s2-training.git"
                env.jenkinsdslgitremote = "git@github.com:Sonos-Inc/pdsw-jenkins-dsl.git"
                env.jenkinsdslgitbranch = "p4/main"
                
                stage('Build') {
                    catchError(buildResult: 'SUCCESS', stageResult: 'UNSTABLE') {
                        print "DEBUG: parameter jobtype"
                    }
                }
                stage('Test') {
                    print "DEBUG: parameter jobtype"
                }
                stage('Example Build') {
                    sh '''#!/bin/bash
                        chmod +x log.py
                        python3 log.py
                    '''
                }
                stage('WS clean'){
                    sh 'rm -fr *'
                }
            }
        }
    }
}
return this
