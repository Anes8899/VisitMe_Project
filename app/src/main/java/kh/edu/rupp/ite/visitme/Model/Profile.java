package kh.edu.rupp.ite.visitme.Model;

import java.util.List;

public class Profile {
    private int id;
    private String firstName;
    private String lastName;

    private  String email;
    private  String bio;

    private String coverImage;
    private String profileImage;
    private List<FavoritePlaceinProfile> favoritePlaces;
    public List<FavoritePlaceinProfile> getFavoritePlaces() {
        return favoritePlaces;
    }

    public void setFavoritePlaces(List<FavoritePlaceinProfile> favoritePlaces) {
        this.favoritePlaces = favoritePlaces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }


}