package com.example.QR_Attend_doctors.api

class AddTopicData {
    private var Name: String? = null
    private var Mat_ID: Int? = null
    private var Discption:String? = null

    constructor(Name: String?, Mat_ID: Int?, Discption: String?) {
        this.Name = Name
        this.Mat_ID = Mat_ID
        this.Discption = Discption
    }
}