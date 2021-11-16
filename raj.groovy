pipeline {
  agent any
  def rajci = load 'raj-ci.groovy'
  rajci.raj()
}
