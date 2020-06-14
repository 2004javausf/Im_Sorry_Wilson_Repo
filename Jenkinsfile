pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean compile'
      }
    }

    stage('Publish') {
      steps {
        sh 'mvn package'
        archive 'target/*.jar'
      }
    }

  }
}