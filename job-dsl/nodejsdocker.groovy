job('NodeJS Docker example') {
    scm {
        git('git://github.com/wardviaene/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('anirudhreddy6')
            node / gitConfigEmail('anirudhreddy06@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('anirudhreddy67/jenkinstest')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('a42d0663-fdc0-4470-ac8e-6ce95bec5d3d')
            forcePull(true)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
