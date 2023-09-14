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
import pojo.TblBooks;

/**
 *
 * @author Rasyid
 */
public class DAOBook {
    public void addBook(TblBooks bok){
        Transaction trans = null;
        Session session = ELibraryUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(bok);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteBook(String idB){
        Transaction trans = null;
        Session session = ELibraryUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            TblBooks bok = 
            (TblBooks) session.load(TblBooks.class, new Integer(idB));
            session.delete(bok);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<TblBooks> getbyID(String idB){
        TblBooks bok = new TblBooks();
        List<TblBooks> lBok = new ArrayList();
        
        Transaction trans = null;
        Session session = ELibraryUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = 
            session.createQuery("from TblBooks where id_books= :id");
            query.setString("id", idB);
            bok = (TblBooks) query.uniqueResult();
            lBok = query.list();
            trans.commit();
        } catch (Exception e){
            
        }
        return lBok;
    }
    
    public List<TblBooks> retrieveTblBook(){
        
        List stud = new ArrayList();
        TblBooks stud1 = new TblBooks();
        Transaction trans = null;
        Session session = ELibraryUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblBooks");
            stud = query.list();
            trans.commit();
        } catch (Exception e){
            
        }
        return stud;
    }
    
    public void updateBook(TblBooks bok){
        Transaction trans = null;
        Session session = ELibraryUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.update(bok);
            trans.commit();
        } catch (Exception e){
            
        }
    }

    public void deleteBook(Integer idBook) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
