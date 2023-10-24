def gv = load "script1.groovy"

pipeline {
    agent any
    parameters {
    //    string(name: 'VERSION', defaultValue: '', description: 'abcdef')
        choice(name: 'VERSION', choices: ['1.0', '1.1', '1.2', '2.0'], description: 'abcdef')
        booleanParam(name: 'executeTest', defaultValue: true, description: 'fghijk')
    }
    stages {
        stage("build") {
            steps {
                script {
                    gv.buildApp
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
                    gv.testApp
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deploydApp
                }
            }
        }
    }
}   
