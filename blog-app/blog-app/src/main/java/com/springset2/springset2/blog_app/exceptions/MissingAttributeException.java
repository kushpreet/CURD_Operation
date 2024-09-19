package com.springset2.springset2.blog_app.exceptions;

public class MissingAttributeException extends RuntimeException {


    private String attributeName;

    public MissingAttributeException(String attributeName) {
        super(String.format("Missing required attribute: %s", attributeName));
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return attributeName;
    }
}
