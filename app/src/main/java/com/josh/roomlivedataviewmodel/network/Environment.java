package com.josh.roomlivedataviewmodel.network;


/**
 * Created by shekhar on 13/06/16.
 */
public enum Environment {

    STAGING {
        @Override
        public String getBaseUrl() {
            return "http://15.206.131.71/api/";
        }

        @Override
        public String getAwsBucketName() {
//            return AWSConstants.BUCKET_NAME_STAGING;
//            return AWSConstants.BUCKET_NAME_STAGING;
            return "";
        }

    }, PRODUCTION {
        @Override
        public String getBaseUrl() {
            return "http://15.206.131.71/api/";
        }

        @Override
        public String getAwsBucketName() {

//            return AWSConstants.BUCKET_NAME_PRODUCTION;
            return "";
        }

    };

    public abstract String getBaseUrl();

    public abstract String getAwsBucketName();

}
