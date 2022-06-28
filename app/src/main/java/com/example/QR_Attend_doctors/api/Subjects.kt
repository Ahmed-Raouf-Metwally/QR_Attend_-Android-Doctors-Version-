package com.example.QR_Attend_doctors.api

class Subjects {
    private  var mID :Int? = null
    private var Name:String? = null
    private var Code:String? = null

    constructor(mID: Int?, Name: String?, Code: String?) {
        this.mID = mID
        this.Name = Name
        this.Code = Code
    }
}