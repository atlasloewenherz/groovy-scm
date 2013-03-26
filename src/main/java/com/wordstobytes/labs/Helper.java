package com.wordstobytes.labs;


import com.wordstobytes.labs.scm.Artifact;
import com.wordstobytes.labs.scm.Project;

/**
 * Example Java class.
 */

public class Helper
{
    public static void main(String [] args){
    Artifact ar = new Artifact();
        ar.setName("ok");
        System.out.println(ar.getName());

        Artifact [] artifacts = new Artifact[5];
        Artifact ar1 = new Artifact();
            ar1.setName("ar1");
            ar1.setDestination("ar1-----");

        Artifact ar2 = new Artifact() ;
            ar2.setName("ar2");
            ar2.setDestination("ar2-----");

        Artifact ar3 = new Artifact()  ;
            ar3.setName("ar3");
            ar3.setDestination("ar3-----");


        artifacts[0]= ar1;
        artifacts[1]= ar2;
        artifacts[2]= ar3;
        Project project = new Project();
        project.setArtifacts(artifacts);
        project.createConfigRepo();
        project.downloadALL();



    }
}
