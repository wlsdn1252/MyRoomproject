package com.example.myroomproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myroomproject.adapters.RoomAdapter
import com.example.myroomproject.datas.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 실제로 뿌릴 데이터들이 모여있는 Room클래스를 변수로 담아준다.
    val mRoomList = ArrayList<Room>()

    // 뿌릴 방법이 있는 RoomAdapter를 변수에 연결
    lateinit var mRoomAdapter : RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Room파일의 생성자 양식으로 그냥 적어줌
        mRoomList.add( Room( 24500, "서울시 서대문구", 0, "서대문구의 반지하 2억 4500만원 방 입니다." ) )
        mRoomList.add( Room( 8500, "서울시 동작구", 0, " 동작구의 반지하 8500만원 방 입니다." ) )
        mRoomList.add( Room( 4500, "서울시 은평구", -2, " 은평구의 지하 2층 4500만원 방 입니다." ) )
        mRoomList.add( Room( 182500, "서울시 중랑구", 5, " 중랑구의 5층 1억 18억 2500만원 방 입니다." ) )
        mRoomList.add( Room( 235000, "서울시 도봉구", 7, " 도봉구의 7층 1억 23억 5000만원 방 입니다." ) )
        mRoomList.add( Room( 24000, "서울시 강남구", 19, " 강남구의 19층 2억 4000만원 방 입니다." ) )
        mRoomList.add( Room( 3700, "서울시 서초구", -1, " 서초구의 지하 1층 3700만원 방 입니다." ) )

        //
        mRoomAdapter = RoomAdapter(this,R.layout.detail_list_room,mRoomList)

        // 전체 리스트에 어댑터를 연결하는데 mRoomAdapter를 연결시킨다.
        myListView.adapter = mRoomAdapter

        // 리스트의 한 줄을 클릭했을때
        myListView.setOnItemClickListener { parent, view, position, id -> 
            // 해당 줄의 position을 담는다
            val clickedRoom = mRoomList[position]

            // myIntent에 Intent정보를 담는다.(출발 액티비티, 도착 액티비티)
            val myIntent = Intent(this, ViewRoomDetailActivity :: class.java)

            // myIntent에서 정보를 넘기는데 이름은 room으로 하고 clickedRoom에 담긴 모든 정보를 putExtra(담아서 넘겨라)
            // Room.kt파일에서 생정자 옆에  : Serializable을 적어줘야 함
            myIntent.putExtra("room", clickedRoom)

            // 액티비티 시작
            startActivity(myIntent)
        }

    }
}