package com.backend.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author armen.arzumanyan@gmail.com
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    private ObjectId _id;
    private Long id;
    private String title;
    private String description;
    private String imageId;
    private Date registeredDate;
    private Integer status;

    public Category() {

    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.description);
        hash = 37 * hash + Objects.hashCode(this.registeredDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.registeredDate, other.registeredDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Category{" + "_id=" + _id + ", id=" + id + ", title=" + title + ", description=" + description + ", imageId=" + imageId + ", registeredDate=" + registeredDate + ", status=" + status + '}';
    }    
    
}
