package com.wordstobytes.labs.scm

import groovy.util.logging.Slf4j

/**
 * wordstobytes business solutions
 * User: yassine.elassad
 * Date: 22.03.13
 * Time: 09:59 
 */
@Slf4j
class Configuration {
    def Artifact artifact
    def Properties properties

    def apply(){
        if(artifact.isInstalled){
            properties.each { property ->
                artifact.destination
                log.debug(property.key+':'+property.value)
            }

        }

    }

}
