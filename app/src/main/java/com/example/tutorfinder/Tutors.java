package com.example.tutorfinder;

public class Tutors {

    public String Name;
    public String Class1;
    public String Locality;
    public String PastResults;
    public String Image1;
    public String Image2;
    public String Image3;
    public String Subject;
    public String PhoneNumber;
    public String Address;
    public  String TeachingExperience;


    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTeachingExperience() {
        return TeachingExperience;
    }

    public void setTeachingExperience(String teachingExperience) {
        TeachingExperience = teachingExperience;
    }

    Tutors(String Name, String Class1,
           String Locality, String PastResults, String Image1, String Image2,
           String Image3, String Subject, String PhoneNumber, String  Address, String TeachingExperience) {

        this.Name = Name;
        this.Class1 = Class1;
        this.Locality= Locality;
        this.Subject = Subject;
        this.Image1 = Image1;
        this.Image2 = Image2;
        this.Image3 = Image3;
        this.PastResults = PastResults;
        this.PhoneNumber=PhoneNumber;
        this.Address =Address;
        this.TeachingExperience = TeachingExperience;


    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getClass1() {
        return Class1;
    }

    public void setClass1(String class1) {
        Class1 = class1;
    }

    public String getLocality() {
        return Locality;
    }

    public void setLocality(String locality) {
        Locality = locality;
    }

    public String getPastResults() {
        return PastResults;
    }

    public void setPastResults(String pastResults) {
        PastResults = pastResults;
    }

    public String getImage1() {
        return Image1;
    }

    public void setImage1(String image1) {
        Image1 = image1;
    }

    public String getImage2() {
        return Image2;
    }

    public void setImage2(String image2) {
        Image2 = image2;
    }

    public String getImage3() {
        return Image3;
    }

    public void setImage3(String image3) {
        Image3 = image3;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }


}