package models;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;

import javax.persistence.*;

//import play.db.ebean.Model;
//import play.utils.dao.BasicModel;

/**
 * Created by keen on 10/7/14.
 */
@Entity
public class Contact{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long key;

    @ManyToOne
    private MyUser user;

    @Basic
    @Required
    @MaxLength(100)
    @Column(length=100)
    public String name;

    public Contact(String name) {
        this.name = name;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key=key;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

}
