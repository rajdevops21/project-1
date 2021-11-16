def rajci
pipeline {
  agent any
  checkout scm
  rajci = load 'nightly.groovy'
  rajci.raj()
}
