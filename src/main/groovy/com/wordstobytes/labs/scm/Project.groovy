package com.wordstobytes.labs.scm

import groovy.util.logging.Slf4j
import groovy.xml.StreamingMarkupBuilder

/**
 * wordstobytes business solutions
 * User: yassine.elassad
 * Date: 22.03.13
 * Time: 09:59 
 */
@Slf4j
class Project {
    def String name
    def registryxml = new StreamingMarkupBuilder()
    def Artifact[] artifacts
    def Configuration[] configurations

    def init(){
        registryxml.encoding ='UTF-8'
        def xmlString = registryxml.bind {
            mkp.xmlDeclaration()
            project(name: this.name, "creation-date":System.currentTimeMillis() ) {
            "packages"{
                artifacts.each { current ->
                    "package"{
                        addArtifact.delegate = delegate
                        addArtifact(current)
                    }
                }
            }
            }

            log.debug(registryxml.toString())
        }.toString()
        System.out.println(xmlString.toString())
    }

    def downloadALL() {
        log.info('invoked')
    }

    def createConfigRepo() {
        def wasCreated = new File(System.getProperty("user.home") + '.groovy-scm').mkdirs()
        if (wasCreated) log.debug('registry exist')
    }

    def addArtifact = { currentArtifact ->
        def artifactsClosure = addArtifactAndDep.clone()
        def dependencyClosure = addDependencies.clone()
        if(currentArtifact!=null){
            artifact{
                artifactsClosure.delegate = delegate
                artifactsClosure(currentArtifact)
                dependencyClosure.delegate = delegate
            }
        }
    }


    def addDependencies = { dependencies ->
        //"deps" {//
            dependencies.each{ dependency ->

                if(dependency!=null){
                    "artifact"(name:dependency?.name, version:dependency?.version)
                }
            }
        //}      //
    }

    def addArtifactAndDep = { it ->
        def dependencyClosure = addDependencies.clone()
        if(it!=null){
            //artifact(name: it?.name,destination:it?.destination,source:it?.source,downloaded:it?.downloaded,isInstalled:it.isInstalled,version:it.version)
            name(it?.name)
            destination(it?.destination)
            source(it?.source)
            downloaded(it?.downloaded)
            isInstalled(it.isInstalled)
            version(it.version)
            dependencyClosure.delegate = delegate
            "dependencies"{ dep ->
                dependencyClosure(it.dependencies)
            }
        }
    }



}