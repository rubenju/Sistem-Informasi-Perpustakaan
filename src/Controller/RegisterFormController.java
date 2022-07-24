/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Akun;
import Model.AkunDAO;

/**
 *
 * @author Wind10
 */
public class RegisterFormController {

    AkunDAO akunDAO;

    public RegisterFormController() {
        akunDAO = new AkunDAO();
    }

    public void InsertAkun(String username, String password, String nama, String email) {
        akunDAO.InsertAkun(new Akun(username, password, nama, email));
    }
}
