/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.ELibraryUtil;
import pojo.TblEmployee;

/**
 *
 * @author Rasyid
 */
public class DAOEmployee {
    public void addEmployee(TblEmployee emp){
        Transaction trans = null;
        Session session = ELibraryUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(emp);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteEmployee(String idE){
        Transaction trans = null;
        Session session = ELibraryUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            TblEmployee emp = 
            (TblEmployee) session.load(TblEmployee.class, new Integer(idE));
            session.delete(emp);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<TblEmployee> getbyID(String idE){
        TblEmployee emp = new TblEmployee();
        List<TblEmployee> lEmp = new ArrayList();
        
        Transaction trans = null;
        Session session = ELibraryUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = 
            session.createQuery("from TblEmployee where id_employee= :id");
            query.setString("id", idE);
            emp = (TblEmployee) query.uniqueResult();
            lEmp = query.list();
            trans.commit();
        } catch (Exception e){
            
        }
        return lEmp;
    }
    
    public List<TblEmployee> retrieveTblEmployee(){
        
        List stud = new ArrayList();
        TblEmployee stud1 = new TblEmployee();
        Transaction trans = null;
        Session session = ELibraryUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblEmployee");
            stud = query.list();
            trans.commit();
        } catch (Exception e){
            
        }
        return stud;
    }
    
    public void updateEmployee(TblEmployee emp){
        Transaction trans = null;
        Session session = ELibraryUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(emp);
            trans.commit();
        } catch (Exception e){
            
        }
    }

    public void deleteEmployee(Integer idEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
