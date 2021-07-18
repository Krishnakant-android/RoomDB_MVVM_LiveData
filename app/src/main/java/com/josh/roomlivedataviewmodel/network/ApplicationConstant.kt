package com.urdhvam.appClass


object ApplicationConstant {
    //Flag for debugging log mode
    var isDebuggable = false

    //Api url component
//    val SERVER_URL = Environment.STAGING.baseUrl
//    val AWS_BUCKET_URL = Environment.STAGING.awsBucketName

    //Connection timeout
    val TIMEOUT_CONNECTION = 1
    val TIMEOUT_READ = 1

    //Http request header content
    val ACCEPT_TYPE = "application/vnd.urdhvam.in; version=1"
    val CONTENT_TYPE = "application/json"


    // Use for data transfer
    var GPS_LOCATION_CODE = 1111
    var MAP_DETAILS = 1112
    var ADD_BOREWELL = 1113
    var REQUEST_TAKE_PHOTO = 1
    var REQUEST_FROM_GALLERY = 2
    var REQUEST_FROM_GALLERY_VIDEO = 3
    val MESSAGE = "message"

}