node{
  checkout scm
  def ci = load "nightly.groovy"
}
