def cancelqueue()

node {
  timestamps {
    checkout scm
    
    cancelqueue = load 'queued.groovy'
    cancelqueue.queue()
  }
}
