node {
    timestamps {
        checkout scm
        withGroovy {
            import hudson.model.*
            def jobName = 'DEV'
            def q = Jenkins.instance.queue
            q.items.findAll { it.task.name.contains(jobName) }.each { 
                println("queued: " + it.task.name)
            }
            def running = Jenkins.instance.getView('All').getBuilds().findAll{ it.getResult().equals(null) && it.toString().contains(jobName) }
            running.each {
                println("running: " + it)
            }
        }
    }
}
