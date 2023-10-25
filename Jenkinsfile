def gv

pipeline {
    agent any
    parameters {
    //    string(name: 'VERSION', defaultValue: '', description: 'abcdef')
        choice(name: 'VERSION', choices: ['1.0', '1.1', '1.2', '2.0'], description: 'abcdef')
        booleanParam(name: 'executeTest', defaultValue: true, description: 'fghijk')
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script1.groovy"
                }
            }
        }
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("test") {
            when {
                expression {
                    params.executeTest == true
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("deploy") {
            input {
                message "wybierz środowisko do wdrożenia"
                ok "zrobione"
                parameters {
                    choice(name: 'ENV1', choices: ['DEV', 'UAT', 'PREPROD', 'PROD'], description: 'opis1')
                    choice(name: 'ENV2', choices: ['DEV', 'UAT', 'PREPROD', 'PROD'], description: 'opis2')
                }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "wdrażam na ${ENV1}"
                    echo "wdrażam na ${ENV2}"
                }
            }
        }
    }
}   
