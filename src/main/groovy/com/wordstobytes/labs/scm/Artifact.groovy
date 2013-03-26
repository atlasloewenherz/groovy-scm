package com.wordstobytes.labs.scm

import groovy.util.logging.Slf4j

@Slf4j
class Artifact {
    def String name
    def String source
    def String destination
    def Artifact [] dependencies
    def boolean downloaded = false
    def boolean isInstalled = false
    def String version

    /**
     *
     * Download address to destination
     */
    public void download() {
        def file;
        def out;
        try {
            file = new FileOutputStream(destination)
            out = new BufferedOutputStream(file)
            out << new URL(source+name).openStream()
            out.close()
            downloaded = true
        } catch(e) {
            com.wordstobytes.labs.scm.Artifact.log.error('***************************************************************')
            com.wordstobytes.labs.scm.Artifact.log.error('* Error downloading the following artifact: '+  name+'        *')
            com.wordstobytes.labs.scm.Artifact.log.error('***************************************************************')
            e.printStackTrace()
        }
    }
    def install() {
    }

}