package com.example.QR_Attend_doctors.api

class AttendanceListRequest {
    private var Mat_ID : String? =null
    private var Topic_ID:String? = null

    constructor(Mat_ID: String?, Topic_ID: String?) {
        this.Mat_ID = Mat_ID
        this.Topic_ID = Topic_ID
    }
}