package com.wordstobytes.labs

import com.wordstobytes.labs.scm.Project

import com.wordstobytes.labs.scm.Artifact

/**
 * wordstobytes business solutions
 * User: yassine.elassad
 * Date: 22.03.13
 * Time: 11:18 
 */

class ProjectTest extends GroovyTestCase{
    def project = new Project();

       void testDownloadAll(){
           project.name="wordstobytes crm"
           Artifact ar = new Artifact();
           Artifact [] artifacts = new Artifact[5];
           Artifact ar1 = new Artifact();
           ar1.name ="jboss-as-7.1"
           ar1.destination="/jboss-as"
           ar1.version='7.1-Final'
           ar1.dependencies = new Artifact[2]
           ar1.source='http://localhost:8080/downloads/jboss-as-7.1-Final.zip'


           Artifact ar2 = new Artifact() ;
           ar2.setName("jboss-derby-jdbc-driver");
           ar2.setDestination(ar1.destination + "/standalone ");
           ar2.version='1.0.0'

           Artifact ar3 = new Artifact()  ;
           ar3.setName("maven");
           ar3.setDestination("./maven");
           ar3.setVersion("3.0.1")


           Artifact ar4 = new Artifact()  ;
           ar4.name = "jboss-postgresql-jdbc-driver"
           ar4.destination ="./maven"
           ar4.version ="3.0.1"
           ar4.dependencies= new Artifact[2]
           ar4.dependencies=ar


           artifacts[0]= ar1;
           artifacts[1]= ar2;
           artifacts[2]= ar3;

           ar1.dependencies[0]=ar2
           ar1.dependencies[1]=ar3

           Project project = new Project();
           project.setArtifacts(artifacts);
           project.createConfigRepo();
           project.init()
           project.downloadALL();
       }
}
