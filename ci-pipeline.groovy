node {
   
       // now you are on slave labeled with 'label'
    def workspace = WORKSPACE
    // ${workspace} will now contain an absolute path to job workspace on slave

    workspace = env.WORKSPACE
    // ${workspace} will still contain an absolute path to job workspace on slave

    // When using a GString at least later Jenkins versions could only handle the env.WORKSPACE variant:
    echo "Current workspace is ${env.WORKSPACE}"

    // the current Jenkins instances will support the short syntax, too:
    echo "Current workspace is $WORKSPACE"
   
   stage("Determine build file") {
      String JenkinsFile = nightly.groovy
   }
   // Here the Jenkins build file is loaded and executed
   load JenkinsFile
}
