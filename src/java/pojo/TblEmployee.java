package pojo;
// Generated Sep 10, 2023 8:57:47 PM by Hibernate Tools 4.3.1

import DAO.DAOEmployee;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TblEmployee  implements java.io.Serializable {


     private Integer idEmployee;
     private String employeeName;
     private String employeeAddress;
     private int phone;

    public TblEmployee() {
    }

    public TblEmployee(String employeeName, String employeeAddress, int phone) {
       this.employeeName = employeeName;
       this.employeeAddress = employeeAddress;
       this.phone = phone;
    }
   
    public Integer getIdEmployee() {
        return this.idEmployee;
    }
    
    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }
    public String getEmployeeName() {
        return this.employeeName;
    }
    
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getEmployeeAddress() {
        return this.employeeAddress;
    }
    
    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
    public int getPhone() {
        return this.phone;
    }
    
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String update(){
        DAOEmployee emp = new DAOEmployee();
        emp.updateEmployee(this);
        employeeName = "";
        employeeAddress = "";
        phone = 0;        
        idEmployee = 0;
        return "data_employee";
    }

    public String save(){
        DAOEmployee emp = new DAOEmployee();
        emp.addEmployee(this);
        return "data_employee";
    }
    
    public void delete(){
        DAOEmployee emp = new DAOEmployee();
        emp.deleteEmployee(idEmployee.toString());
        employeeName = "";
        employeeAddress = "";
        phone = 0;        
        idEmployee = 0;
    }
    
    public String getbyid(){
        DAOEmployee emp = new DAOEmployee();
        List<TblEmployee> lEmp = emp.getbyID(idEmployee.toString());
        employeeName = lEmp.get(0).employeeName;
        employeeAddress = lEmp.get(0).employeeAddress;
        phone = lEmp.get(0).phone;        
        idEmployee = lEmp.get(0).idEmployee;
        return "updateData_employee";
    }
    
    public List<TblEmployee> getallrecords(){
        DAOEmployee emp = new DAOEmployee();
        List<TblEmployee> lEmp = emp.retrieveTblEmployee();
        return lEmp;
    }


}


