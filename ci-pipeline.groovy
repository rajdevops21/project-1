node {
   stage("Determine build file") {
      String JenkinsFile = nightly.groovy
   }
   // Here the Jenkins build file is loaded and executed
   load JenkinsFile
}
