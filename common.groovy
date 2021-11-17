import jenkins.model.Jenkins
//import hudson.slaves.EnvironmentVariablesNodeProperty
//import hudson.EnvVars

def commoncode(){
    timeout(150) {
        node {
            properties([
                parameters(
                    [string(name: 'gitremote_training', defaultValue: 'https://github.com/github/hackathons.git', description: 'Git remote with product source code'),
                     string(name: 'jenkinsdslgitremote', defaultValue: 'https://github.com/github/hackathons.git', description: 'Git remote for Jenkins DSL repo'),
                     string(name: 'jenkinsdslgitbranch', defaultValue: 'main', description: 'Git branch for Jenkins DSL repo to pull dsl-branches and enabled-jobs.json from'),]
                )
            ])
            stage('Build') {
                print "DEBUG: parameter jobtype = ${jobtype}"
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
