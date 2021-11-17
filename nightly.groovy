import jenkins.model.Jenkins
import hudson.slaves.EnvironmentVariablesNodeProperty
import hudson.EnvVars

def ciBranch(){
    node {
        stage('Build') {
            print "DEBUG: parameter jobtype = ${jobtype}"
        }
        stage('Test') {
            print "DEBUG: parameter jobtype = ${jobtype}"
        }
        stage('Git Fetch tags') {
             sh '''#!/bin/bash
                    set -e -x -o pipefail
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
        post {
            always {
                echo 'Cleaning workspace'
                deleteDir()
            }
        }
    }
}
return this
