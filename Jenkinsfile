pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from Git repository
                git branch: 'main', url: 'https://github.com/beeru405/webcalc-java.git'
            }
        }

        stage('Build and Test') {
            steps {
                // Use Maven to build and test the project
                sh 'mvn clean test install'
            }
        }
        stage('SonarQube Analysis') {
           steps{
              withSonarQubeEnv('sonarqube') {
              sh 'mvn sonar:sonar'
                }
            }
        }
    
        stage('Deploy to Tomcat') {
            steps {
                // Copy the war file to Tomcat webapps directory
                deploy adapters: [tomcat8(credentialsId: 'tomcat', path: '', url: 'http://192.168.138.114:8081/')], contextPath: null, war: '**/*.war'
            }
        }
    }

    post {
        success {
            // Notify success, send emails, or perform other post-build actions
            echo 'Deployment successful!'
        }
        failure {
            // Notify failure, send emails, or perform other post-build actions
            echo 'Deployment failed!'
        }
    }
}
