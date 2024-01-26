pipeline {
    agent any

    stages {
        stage('Execute commands') {
            steps {
                script {
                    if(!fileExists('testdebian')){
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
        }
        stage('Install Debian Package') {
            steps {
                script {
                    sh 'sudo dpkg -i testdebian.deb'
                    sh 'sudo chmod +x /usr/local/bin/count_files.sh'
                    sh 'sudo count_files.sh --check_dir=system_programming-main'
                    sh 'sudo rm -rf system_programming-main'
                }
            }
        }
    }
}
