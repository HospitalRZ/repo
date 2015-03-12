/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_clases;

/**
 *
 * @author PROGRAMADOR
 */
public class usuario extends estandar{
    String login;
    String password;
    
    public String getLogin()
    {
        return login;
    }
    public String getPassword()
    {
        return password;
    }
    public void setLogin(String login)
    {
        this.login = login;
    }
    public void setPassword(String passwd)
    {
        this.password = passwd;
    }
}
