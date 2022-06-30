package com.example.QR_Attend_doctors.api

class Subjects {
    private  var mID :Int? = null
    private var Mat_ID:Int? = null
    private var Name:String? = null
    private var Code:String? = null

    constructor(mID: Int?, Name: String?, Code: String?) {

        this.Name = Name
        this.Code = Code
    }

    constructor(mID: Int?) {
        this.mID = mID
        this.Mat_ID = mID
    }

}