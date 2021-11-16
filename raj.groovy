pipeline {
  agent any
  def rajci = load 'nightly.groovy'
  rajci.raj()
}
