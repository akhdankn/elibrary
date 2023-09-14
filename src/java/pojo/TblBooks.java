package pojo;
// Generated Sep 10, 2023 8:57:47 PM by Hibernate Tools 4.3.1


import DAO.DAOBook;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TblBooks  implements java.io.Serializable {


     private Integer idBooks;
     private String bookCode;
     private String title;
     private String author;
     private String publisher;

    public TblBooks() {
    }

    public TblBooks(String bookCode, String title, String author, String publisher) {
       this.bookCode = bookCode;
       this.title = title;
       this.author = author;
       this.publisher = publisher;
    }
   
    public Integer getIdBooks() {
        return this.idBooks;
    }
    
    public void setIdBooks(Integer idBooks) {
        this.idBooks = idBooks;
    }
    public String getBookCode() {
        return this.bookCode;
    }
    
    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String update(){
        DAOBook bok = new DAOBook();
        bok.updateBook(this);
        bookCode = "";
        title = "";
        author = "";
        publisher = "";
        idBooks = 0;
        return "data_books";
    }

    public String save(){
        DAOBook bok = new DAOBook();
        bok.addBook(this);
        return "data_books";
    }
    
    public String delete(){
        DAOBook bok = new DAOBook();
        bok.deleteBook(idBooks.toString());
        bookCode = "";
        title = "";
        author = "";
        publisher = "";
        idBooks = 0;
        return "data_books";
    }
    
    public String getbyid(){
        DAOBook bok = new DAOBook();
        List<TblBooks> lBok = bok.getbyID(idBooks.toString());
        bookCode = lBok.get(0).bookCode;
        title = lBok.get(0).title;
        author = lBok.get(0).author;
        publisher = lBok.get(0).publisher;
        idBooks = lBok.get(0).idBooks;
        return "updateData_books";
    }
    
    public List<TblBooks> getallrecords(){
        DAOBook bok = new DAOBook();
        List<TblBooks> lBok = bok.retrieveTblBook();
        return lBok;
    }


}


