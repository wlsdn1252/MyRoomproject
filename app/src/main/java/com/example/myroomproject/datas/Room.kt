package com.example.myroomproject.datas

import java.io.Serializable

class Room (val price : Int, val address : String, val floor : Int,  val Described : String) :
    Serializable {

    // 집값을 억, 만원으로 바꿔주는 함수
    fun getFormmatedPrice() : String{
        if(this.price >= 10000){
            val uk = this.price / 10000
            val rest = this.price % 10000
            
            return "${uk}억 ${rest}만원"
        }else{
            return "${this.price}만원"
        }
    }
    
    fun getFormmatedFloor() : String{
        if(this.floor > 0){
            return "${this.floor}층"
        }else if(this.floor == 0){
            return "반지하"
        }else{
            return "지하${-this.floor}층"
        }
    }
}