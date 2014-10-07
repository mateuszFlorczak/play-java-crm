package models;

import org.hibernate.validator.constraints.Email;
import play.data.validation.Constraints.Pattern;
//import play.db.ebean.Model;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by keen on 10/7/14.
 */

@Entity
public class User{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Required
    @Column(length = 200)
    @MaxLength(200)
    @Email
    public String email;
    @Required
    @Column(length = 100)
    @MaxLength(100)
    @Pattern("[A-Za-z ]*")
    public String name;
    @Required
    @Column(length = 100)
    @MaxLength(100)
    public String password;

    @OneToMany(targetEntity=Contact.class, mappedBy="user")
    public Collection contacts;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.contacts= new ArrayList<Contact>();
    }

    public Collection getContacts(int id){
        return this.contacts;
    }

}
