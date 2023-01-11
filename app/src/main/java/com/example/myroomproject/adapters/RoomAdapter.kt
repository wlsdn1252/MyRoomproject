package com.example.myroomproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.myroomproject.R
import com.example.myroomproject.datas.Room

class RoomAdapter (
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Room>) : ArrayAdapter<Room>(mContext, resId, mList) {

    // xml을 객체로 변환(화면에 뿌리도록 도와줌)해주는 변수지정
    val inflater = LayoutInflater.from(mContext)

    //리스트를 내가 원하는 모양으로 뿌리기위해 오버라이딩
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // 뷰가 없을떄 재사용할 뷰(convertView)를 변수에 담는다.
        var tempRow = convertView

        if(tempRow == null){
            // 만약 tempRow에 뿌려진 뷰가 없으면
            // R.layout.detail_list_room.xml파일을 tempRow에 inflate시켜라
            tempRow = inflater.inflate(R.layout.detail_list_room, null)
        }

        // tempRow값이 null이 절대아니니 row에 대입
        val row = tempRow!!

        // 리스트 한 줄에 뿌려질 정보가있는 mList의 position에 맞는 데이터 들고오기
        val  roomData = mList[position]

        // 리스트 한 줄에있는 정보를 변수에 담아주기
        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)
        val describedTxt = row.findViewById<TextView>(R.id.describedTxt)

        // 리스트의 각 정보에 맞는 데이터 삽입
        priceTxt.text = roomData.getFormmatedPrice()
        addressTxt.text = "${roomData.address}, ${roomData.getFormmatedFloor()}"
        describedTxt.text = roomData.getFormmatedFloor()


        return row

    }


}