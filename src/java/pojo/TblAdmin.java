package pojo;
// Generated Sep 10, 2023 8:57:47 PM by Hibernate Tools 4.3.1

import DAO.DAOLogin;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TblAdmin  implements java.io.Serializable {


     private Integer idAdmin;
     private String username;
     private String password;

    public TblAdmin() {
    }

    public TblAdmin(String username, String password) {
       this.username = username;
       this.password = password;
    }
   
    public Integer getIdAdmin() {
        return this.idAdmin;
    }
    
    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String validasiLogin(){
        DAOLogin uDao = new DAOLogin();
        List<TblAdmin> us = uDao.getBy(username, password);
        if (us != null){
            username = us.get(0).username;
            password = us.get(0).password;
            return "home";
        }
        return "error";        
    }


}


