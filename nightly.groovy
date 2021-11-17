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
    }
}
return this
