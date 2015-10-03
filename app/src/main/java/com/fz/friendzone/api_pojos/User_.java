package com.fz.friendzone.api_pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class User_ {

    @SerializedName("yourFriend")
    @Expose
    private Boolean yourFriend;
    @SerializedName("lastOnline")
    @Expose
    private String lastOnline;
    @SerializedName("profilePicture")
    @Expose
    private String profilePicture;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("__v")
    @Expose
    private Integer V;
    @SerializedName("friendList")
    @Expose
    private List<Object> friendList = new ArrayList<Object>();

    /**
     *
     * @return
     * The yourFriend
     */
    public Boolean getYourFriend() {
        return yourFriend;
    }

    /**
     *
     * @param yourFriend
     * The yourFriend
     */
    public void setYourFriend(Boolean yourFriend) {
        this.yourFriend = yourFriend;
    }

    /**
     *
     * @return
     * The lastOnline
     */
    public String getLastOnline() {
        return lastOnline;
    }

    /**
     *
     * @param lastOnline
     * The lastOnline
     */
    public void setLastOnline(String lastOnline) {
        this.lastOnline = lastOnline;
    }

    /**
     *
     * @return
     * The profilePicture
     */
    public String getProfilePicture() {
        return profilePicture;
    }

    /**
     *
     * @param profilePicture
     * The profilePicture
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     *
     * @return
     * The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     * The lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The V
     */
    public Integer getV() {
        return V;
    }

    /**
     *
     * @param V
     * The __v
     */
    public void setV(Integer V) {
        this.V = V;
    }

    /**
     *
     * @return
     * The friendList
     */
    public List<Object> getFriendList() {
        return friendList;
    }

    /**
     *
     * @param friendList
     * The friendList
     */
    public void setFriendList(List<Object> friendList) {
        this.friendList = friendList;
    }

}
