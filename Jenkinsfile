pipeline {
  agent {
    docker {
      image 'gradle:4.8-jdk8-alpine'
      args '-v /home/ujjawaln/.gradlew/caches'
    }

  }
  stages {
    stage('Initial Message') {
      steps {
        sh './gradlew clean'
      }
    }
  }
}