package com.example.szilvi.tour_guide_bp;

class Items {

    /**
     * Constant value that represents no image is provided for that place
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    private String info;
    /**
     * Name of the place
     */
    private String name;
    /**
     * Address of the place
     */
    private String address;
    private String phone;
    private String web;
    /**
     * Image resource ID for the place
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Create a a constructor that contain image.
     *
     * @param name            is the name of the place.
     * @param address         is the address of the place.
     * @param imageResourceId is the drawable resource ID for the image associated with the Place.
     * @param info            is the info from the place.
     */
    public Items(String name, String address, String info, String phone, String web, int imageResourceId) {
        this.name = name;
        this.info = info;
        this.address = address;
        this.phone = phone;
        this.web = web;
        mImageResourceId = imageResourceId;
    }


    /**
     * Get the name of that place.
     */
    public String getPlaceName() {
        return this.name;
    }

    /**
     * Get the address of that place.
     */
    public String getPlaceAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getWeb() {
        return this.web;
    }

    /**
     * Return the image resource ID of the Place.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getInfo() {
        return this.info;
    }


    /**
     * Return whether or not there is an image for that Place.
     */

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
