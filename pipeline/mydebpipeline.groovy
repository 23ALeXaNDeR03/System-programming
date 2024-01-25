pipeline {
    agent any

    stages {
        stage('Execute commands') {
            steps {
                script {
                    sh 'mkdir testdebian'
                    sh 'mkdir testdebian/DEBIAN'
                    sh 'mkdir testdebian/usr'
                    sh 'mkdir testdebian/usr/local'
                    sh 'mkdir testdebian/usr/local/bin'
                    sh 'wget https://github.com/23ALeXaNDeR03/system_programming/archive/main.zip'
                    sh 'unzip main.zip'
                    sh 'mv system_programming-main/debian/control testdebian/DEBIAN'
                    sh 'mv system_programming-main/count_files.sh testdebian/usr/local/bin/'
                    sh 'dpkg-deb --build testdebian'
                }
            }
        }
        stage('Install Debian Package') {
            steps {
                script {
                    sh 'dpkg -i testdebian.deb'
                    sh 'chmod +x /usr/local/bin/count_files.sh'
                    sh 'count_files.sh --check_dir=system_programming-main'
                    sh 'rm -r system_programming-main'
                }
            }
        }
    }
}
