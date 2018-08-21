package com.example.ojonugwa.yfc.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "member")
public class MemberEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String firstname;
    private String lastname;
    private String matricNo;
    private String faculty;
    private String department;

    private int gender;
    private int level;
    private int priority;

    @ColumnInfo(name="date_of_birth")
    private Date dateOfBirth;
    @ColumnInfo(name="updated_at")
    private Date updatedAt;

    @Ignore
    public MemberEntry(String firstname, String lastname, String matricNo,
                       String faculty, String department, int level, int gender,
                       int priority, Date dateOfBirth, Date updatedAt) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.matricNo = matricNo;
        this.faculty = faculty;
        this.department = department;
        this.gender = gender;
        this.level = level;
        this.priority = priority;
        this.dateOfBirth = dateOfBirth;
        this.updatedAt = updatedAt;
    }

    public MemberEntry(int id, String firstname, String lastname, String matricNo,
                       String faculty, String department, int level, int gender,
                       int priority, Date dateOfBirth, Date updatedAt) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.matricNo = matricNo;
        this.faculty = faculty;
        this.department = department;
        this.gender = gender;
        this.level = level;
        this.priority = priority;
        this.dateOfBirth = dateOfBirth;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMatricNo() {
        return matricNo;
    }

    public void setMatricNo(String matricNo) {
        this.matricNo = matricNo;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
