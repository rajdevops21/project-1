node{
  checkout scm
  def ci = load "nightly.groovy"
  ci.ciBranch()
}
