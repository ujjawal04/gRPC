pipeline {
  agent {
    docker {
      args '-v /home/ujjawaln/.gradlew/caches'
      image 'gradle:4.4-jdk8-alpine'
    }

  }
  stages {
    stage('Initial Message') {
      steps {
        sh './gradlew build'
      }
    }
  }
}