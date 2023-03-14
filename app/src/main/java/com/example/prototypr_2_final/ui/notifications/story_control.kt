package com.example.prototypr_2_final.ui.notifications

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.prototypr_2_final.R

class story_control (val gs: game_storyScreen){

    var nextPosition1 = ""
    var nextPosition2 = ""
    var nextPosition3 = ""
    var greatSword = false
    var spear = false
    var triplesword = false
    var Herosword = false


    //เปลี่ยนจุด
    fun selectPosition(Position: String){
        when(Position){
            "startingPoint" -> startingPoint()
            "poop" -> poop()
            "Dead" -> Dead()
            "goAtgamestart" -> gs.goAtstart()

            "shop" -> shop()
            "sword" -> sword()
            "tripleSword" -> tripleSword()
            "spear" -> spear()

            "road" -> road()

            "demonArmy" -> demonArmy()
            "demonlevelONE" -> demonlevelONE()
            "demonlevelTWO" -> demonlevelTWO()
            "demonlevelTHREE" -> demonlevelTHREE()
            "demonlevelFOUR" -> demonlevelFOUR()
            "demonlevelFIVE" -> demonlevelFIVE()
            "demonKING" -> demonKING()

            "reciveCrown" -> reciveCrown()
            "haveCrown" -> haveCrown()
            "winEndgame" ->  winEndgame()
            "Hero_End" -> Hero_End()

            "aboutToreciveHerosword" -> aboutToreciveHerosword()
            "reciveHerosword" -> reciveHerosword()
            "Dead_tripleSword" -> Dead_tripleSword()
            "Dead_sword" -> Dead_sword()


            "Home" -> Home()
            "sleep" -> sleep()
            "bike" -> bike()
            "noWeapons" ->  noWeapons()
            "trapChest" -> trapChest()
            "outHome" -> outHome()
        }
    }
    //โชว์ปุ่ม ทั้ง 3
    fun showButtonVisible(){
        gs.findViewById<Button>(R.id.button_play_choice1).setVisibility(View.VISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.VISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.VISIBLE)
    }



    //จุดเริ่มต้น
    fun startingPoint(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้อยู่หน้าบ้านทำอะไรดี")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.house)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("เข้าไปข้างใน")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("ออกมา")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("ไปปลดทุกข์")

        showButtonVisible()

        nextPosition1 = "Home"
        nextPosition2 = "outHome"
        nextPosition3 = "poop"
    }

    fun poop(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป่ได้ปลดทุกข์")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.vomiting)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("อืม......กลับได้ยัง")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("ขอตายได้ไหม?")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        // gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "startingPoint"
        nextPosition2 = "Dead"
        nextPosition3 = ""
    }

    fun Home(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ตอนนี้ได้อยู่ในบ้านแล้วทำอะไรต่อดี")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.house)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("ไปนอน")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("ขี่จักยาน")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("ออกไป")

        showButtonVisible()

        nextPosition1 = "sleep"
        nextPosition2 = "bike"
        nextPosition3 = "startingPoint"
    }
    fun sleep(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ไม่เคยตื่นออกจากฟันหวานอีกเลย")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.guillotine)

        gs.findViewById<Button>(R.id.button_play_choice1).setText(" >")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "Dead"
        nextPosition2 = ""
        nextPosition3 = ""
    }
    fun bike(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้กลายเป็น Dat Boi!!! และได้หายไปจากสายตา")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.thatboi)

        gs.findViewById<Button>(R.id.button_play_choice1).setText(" > ")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "Dead"
        nextPosition2 = ""
        nextPosition3 = ""
    }
    fun outHome(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้เดินมาเจอกับทางแยก 2 สายไปทางไหนดี")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.horizonroad)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("ไปร้านค้า")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("ตรงไปต่อ")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("กลับบ้าน")

        showButtonVisible()

        nextPosition1 = "shop"
        nextPosition2 = "road"
        nextPosition3 = "startingPoint"
    }
    fun shop(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("พ่อค้าบอกเปเป้ว่ามีของ 2 อย่างให้เลือก เอาอะไรดี")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.shop)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("ดาบยักษ์")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("หอกก็ดี")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("เอาดาบมาให้หมด")

        showButtonVisible()

        nextPosition1 = "sword"
        nextPosition2 = "spear"
        nextPosition3 = "tripleSword"
    }
    fun sword(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้อาวุธและรู้สึกแข็งแกร่งขึ้น")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.piercingsword)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("ดี")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("*ฆ่าเจ้าของร้าน")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "Dead_sword"
        nextPosition2 = "Dead"
        nextPosition3 = ""

        greatSword = true
    }
    fun Dead_sword(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("จับดาบผิดทาง เลือดออกตาย")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.piercingsword)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("....")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "Dead"
        nextPosition2 = "Dead"
        nextPosition3 = ""

        greatSword = true
    }
    fun tripleSword(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้อาวุธและรู้สึกแข็งแกร่งขึ้น")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.crossedswords)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("วิชา3ดาบ......")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("*ฆ่าเจ้าของร้าน")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "Dead_tripleSword"
        nextPosition2 = "Dead"
        nextPosition3 = ""

        triplesword = true
    }
    fun Dead_tripleSword(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้โดนมีดปาดหลิ้นตาย")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.deadhead)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("...")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "Dead"
        nextPosition2 = "Dead"
        nextPosition3 = ""

        triplesword = true
    }
    fun spear(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้อาวุธและรู้สึกแข็งแกร่งขึ้น")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.spearfeather)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("ดี")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("*ฆ่าเจ้าของร้าน")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "startingPoint"
        nextPosition2 = "Dead"
        nextPosition3 = ""

        spear = true
    }

    fun road(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("หลังจากเดินมาได้สักพักก็เจอกับกองทัพมอนเตอร์")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.vomiting)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("เข้าไปฆ่ามันเลย")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("เปิดกล่องข้างทาง")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("กลับก่อน")

        showButtonVisible()

        nextPosition1 = "demonArmy"
        nextPosition2 = "trapChest"
        nextPosition3 = "outHome"
    }
    fun trapChest(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("ทันทีที่เปเป้เปิดกล่องข้างทางนั้นกล่องก็ได้กินเปเป้เข้าไปแล้ว")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.mimicchest)

        gs.findViewById<Button>(R.id.button_play_choice1).setText(">")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "Dead"
        nextPosition2 = ""
        nextPosition3 = ""
    }
    fun demonArmy(){
        if(greatSword||spear||triplesword||Herosword==true){
            gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้เจอกับbrute ทำยังไงกันดี")

            gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.brute)

            gs.findViewById<Button>(R.id.button_play_choice1).setText("โจมตี")
            gs.findViewById<Button>(R.id.button_play_choice2).setText("ป้องกัน")
            gs.findViewById<Button>(R.id.button_play_choice3).setText("ถอย")

            showButtonVisible()

            nextPosition1 = "demonlevelONE"
            nextPosition2 = "demonArmy"
            nextPosition3 = "road"
        }else if(greatSword||spear||triplesword||Herosword==false){
            gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้เจอกับbrute ทำยังไงกันดี")

            gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.brute)

            gs.findViewById<Button>(R.id.button_play_choice1).setText("โจมตี")
            gs.findViewById<Button>(R.id.button_play_choice2).setText("ป้องกัน")
            gs.findViewById<Button>(R.id.button_play_choice3).setText("ถอย")

            showButtonVisible()

            nextPosition1 = "noWeapons"
            nextPosition2 = "noWeapons"
            nextPosition3 = "road"
        }


    }
    fun noWeapons(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้สู้ด้วยมือเปล่า แต่ก็ถูกตัดแขนไป")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.deadhead)

        gs.findViewById<Button>(R.id.button_play_choice1).setText(" > ")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "Dead"
        nextPosition2 = ""
        nextPosition3 = "r"
    }
    fun demonlevelONE(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("OAPAJFOIA ANUBIS AKSQELSATACK")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.anubis)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("ASGTAVK")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("Dejndflnd")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("FLEASDEE")

        showButtonVisible()

        nextPosition1 = "demonlevelTWO"
        nextPosition2 = "demonArmy"
        nextPosition3 = "road"
    }
    fun demonlevelTWO(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้เจอกับกลัวย ห่ะ?")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.banana)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("ไปต่อ")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("กล้วย")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("กินกล้วย")

        showButtonVisible()

        nextPosition1 = "demonlevelTHREE"
        nextPosition2 = "demonlevelTWO"
        nextPosition3 = "Dead"
    }
    fun demonlevelTHREE(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้เจอกับหินพูดได้ ทำอะไรดี")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.golemhead)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("โจมตี")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("เดินหนี")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("ถอย")

        showButtonVisible()

        nextPosition1 = "Dead"
        nextPosition2 = "demonlevelFOUR"
        nextPosition3 = "road"
    }
    fun demonlevelFOUR(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้เจอกับ troll มันดูไร้สมอง")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.troll)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("โจมตี")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("บอกวิธีบินได้")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("ถอย")

        showButtonVisible()

        nextPosition1 = "Dead"
        nextPosition2 = "demonlevelFIVE"
        nextPosition3 = "road"
    }
    fun demonlevelFIVE(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้จากกับปีศาจแห่งการหลอกลวง ทำยังไงดี")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.fairy)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("โจมตี")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("ป้องกัน")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("ถอย")

        showButtonVisible()

        nextPosition1 = "Dead"
        nextPosition2 = "Dead"
        nextPosition3 = "demonKING"
    }

    fun demonKING(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้เจอกับราชาปีศาจ")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.goblinhead)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("โจมตี")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("ป้องกัน")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("ถอย")

        showButtonVisible()

        nextPosition1 = "Dead"
        nextPosition2 = "demonKING1"
        nextPosition3 = "Dead"
    }
    fun demonKING1(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้เจอกับราชาปีศาจ มันดูอ่อนแอ่ลง")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.devilmask)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("โจมตี")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("ป้องกัน")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("เต้นล่อสายตา")

        showButtonVisible()

        nextPosition1 = "Dead"
        nextPosition2 = "demonKING2"
        nextPosition3 = "Dead"
    }
    fun demonKING2(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้เจอกับราชาปีศาจ มันกำลังจะหนี")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.wyvern)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("โจมตี")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("ป้องกันและป้องกัน")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("บินตามไป")

        showButtonVisible()

        nextPosition1 = "reciveCrown"
        nextPosition2 = "road"
        nextPosition3 = "Dead"
    }
    fun reciveCrown(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป่ได้สังหาร ราชาปีศาจ")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.crown)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("รับมงกุฎไว้")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("ทำลายมงกุฎ")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "haveCrown"
        nextPosition2 = "aboutToreciveHerosword"
        nextPosition3 = ""
    }
    fun aboutToreciveHerosword(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("หลังจากที่ได้ทำลายมงกุฎ ดาบไร้นามก็ได้โพล่ออกมา")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.diamondhilt)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("รับไว้")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("ทำลายกายไร้นาม")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "reciveHerosword"
        nextPosition2 = "Dead"
        nextPosition3 = ""
    }
    fun reciveHerosword(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป่ได้ดาบฮีโร่ในตำนาน!!!")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.diamondhilt)

        gs.findViewById<Button>(R.id.button_play_choice1).setText(">")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "Hero_End"
        nextPosition2 = ""
        nextPosition3 = ""
    }
    fun Hero_End(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้กลายเป็นฮีโร่ และได้ออกผจญภัยไปสู้โลกกว้าง")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.masterofarms)

        gs.findViewById<Button>(R.id.button_play_choice1).setText(" :) ")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "goAtgamestart"
        nextPosition2 = ""
        nextPosition3 = ""
    }
    fun Dead(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้ตายลง....เขาจะถูกจดจำ :(")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.deadhead) //pepe die

        gs.findViewById<Button>(R.id.button_play_choice1).setText(" :( ")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "goAtgamestart"
        nextPosition2 = ""
        nextPosition3 = ""
    }


    fun haveCrown(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("เปเป้ได้กลายเป็นราชาของโลกใบนี้")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.crown)

        gs.findViewById<Button>(R.id.button_play_choice1).setText("ทรงพระเจริญ")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "winEndgame"
        nextPosition2 = ""
        nextPosition3 = ""
    }
    fun winEndgame(){
        gs.findViewById<TextView>(R.id.text_Quest).setText("แต่หลังจากนั้นเปเป้โดนรอบสังหาร")

        gs.findViewById<ImageView>(R.id.image_gameScreen).setImageResource(R.drawable.fencer) //pepe die

        gs.findViewById<Button>(R.id.button_play_choice1).setText(" :< ")
        gs.findViewById<Button>(R.id.button_play_choice2).setText("")
        gs.findViewById<Button>(R.id.button_play_choice3).setText("")

        gs.findViewById<Button>(R.id.button_play_choice2).setVisibility(View.INVISIBLE)
        gs.findViewById<Button>(R.id.button_play_choice3).setVisibility(View.INVISIBLE)

        nextPosition1 = "Dead"
        nextPosition2 = ""
        nextPosition3 = ""
    }









}