node {
   stage("Determine build file") {
      String jenkinsFile = ./nightly.groovy
   }
   // Here the Jenkins build file is loaded and executed
   load jenkinsFile
}
