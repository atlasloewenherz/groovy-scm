package com.wordstobytes.labs.db2

import groovy.sql.Sql

/**
 * wordstobytes business solutions
 * User: yassine.elassad
 * Date: 26.03.13
 * Time: 17:07 
 */
class DB2Test extends GroovyTestCase{
    def jdbcUrl = "jdbc:db2://HOST:PORT/DB"
    def jdbcDriver = 'com.ibm.db2.jcc.DB2Driver'
    def user = 'USER'
    def password = 'PASS'


    def sql = Sql.newInstance(jdbcUrl,user,password, jdbcDriver)

    public void testConnection(){

    }



}
