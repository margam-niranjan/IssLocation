pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/margam-niranjan/IssLocation.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy to EC2') {
            steps {
                script {
                    sshagent(['your-ssh-credential-id']) {
                        sh '''
                        scp target/issLocation-0.0.1-SNAPSHOT.jar ubuntu@51.20.96.248:/home/ubuntu/project/
                        ssh ubuntu@51.20.96.248 << EOF
                        sudo systemctl stop my-spring-boot-app
                        sudo mv /home/ubuntu/project/issLocation-0.0.1-SNAPSHOT.jar /home/ubuntu/project/app.jar
                        sudo systemctl start my-spring-boot-app
                        EOF
                        '''
                    }
                }
            }
        }
    }

    post {
        success {
            echo "Deployment successful!"
        }
        failure {
            echo "Deployment failed. Check logs!"
        }
    }
}
