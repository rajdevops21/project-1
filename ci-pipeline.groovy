def ci
node{
  checkout scm
  ci = load "nightly.groovy"
  ci.ciBranch()
}
