/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Wind10
 */
import Model.Akun;
import Model.AkunDAO;

public class LoginFormController {

    AkunDAO akunDAO;

    public LoginFormController() {
        akunDAO = new AkunDAO();
    }

    public boolean SelectAkun(String username, String password) {
        return akunDAO.SelectAkun(new Akun(username, password));
    }

}
