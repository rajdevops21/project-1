def rajci
pipeline {
  agent any
  checkout scm
  ci = load 'nightly.groovy'
  ci.ciBranch()
}
