import jenkins.model.Jenkins
//import hudson.slaves.EnvironmentVariablesNodeProperty
//import hudson.EnvVars

def commoncode(){
    timeout(150) {
        node {
            environment {
                def gitremote_training = "git@github.com:Sonos-Inc/pdsw-sonos-controller-player-s2-training.git"
                def jenkinsdslgitremote = "git@github.com:Sonos-Inc/pdsw-jenkins-dsl.git"
                def jenkinsdslgitbranch = "p4/main"
            }
                
            stage('Build') {
                catchError(buildResult: 'SUCCESS', stageResult: 'UNSTABLE') {
                    print "DEBUG: parameter jobtype = ${jobtype}"
                }
            }
            stage('Test') {
                print "DEBUG: parameter jobtype = ${jobtype}"
            }
            stage('Git Fetch tags') {
                 
                sh '''#!/bin/bash
                    set -e -x -o pipefail
                    rm -fr gitrepo
                    mkdir gitrepo
                    cd gitrepo
                    git clone ${gitremote} . --no-checkout
                    if [ "${gitremote_training}" ]; then
                        git remote add training "${gitremote_training}"
                    fi
                    git fetch --all
                    echo ========== Initial Git Refs for Source ============
                    git show-ref
                    cd ..
                    rm -fr jenkinsdsl
                    mkdir jenkinsdsl
                    cd jenkinsdsl
                    git clone ${jenkinsdslgitremote} . --no-checkout
                    git fetch --all --tags
                    git checkout ${jenkinsdslgitbranch}
                    echo ========== Git refs for Jenkins DSL ===============
                    git show-ref
                    cd ..
                '''
            }
            stage('WS clean'){
                sh 'rm -fr *'
            }
        }
    }
}
return this
