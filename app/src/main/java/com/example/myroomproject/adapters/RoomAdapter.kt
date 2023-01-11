package com.example.myroomproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.myroomproject.datas.Room

class RoomAdapter (
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Room>) : ArrayAdapter<Room>(mContext, resId, mList) {

    // xml을 객체로 변환(화면에 뿌리도록 도와줌)해주는 변수지정
    val inflater = LayoutInflater.from(mContext)

    //리스트를 내가 원하는 모양으로 뿌리기위해 오버라이딩
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


    }


}