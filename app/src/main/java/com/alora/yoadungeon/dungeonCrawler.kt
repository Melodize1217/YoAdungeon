package com.alora.yoadungeon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class dungeonCrawler : AppCompatActivity() {

    internal lateinit var upButton: Button
    internal lateinit var leftButton: Button
    internal lateinit var rightButton: Button
    internal lateinit var downButton: Button
    internal lateinit var aButton: Button
    internal lateinit var bButton: Button
    internal lateinit var ghostEnemy: ImageView
    internal lateinit var spiderEnemy: ImageView
    internal lateinit var skeletonEnemy: ImageView
    internal lateinit var gremlinEnemy: ImageView
    internal lateinit var restrainingOrder: ImageView
    internal lateinit var shopKeeper: ImageView
    internal lateinit var healthTower: ImageView
    internal lateinit var textBox: ImageView
    internal lateinit var swordshield: ImageView

    internal lateinit var attackUnselected: TextView
    internal lateinit var magicUnselected: TextView
    internal lateinit var blockUnselected: TextView
    internal lateinit var itemsUnselected: TextView
    internal lateinit var attackselected: TextView
    internal lateinit var magicselected: TextView
    internal lateinit var blockselected: TextView
    internal lateinit var itemsselected: TextView

    internal lateinit var fireUnselected: TextView
    internal lateinit var waterUnselected: TextView
    internal lateinit var grassUnselected: TextView
    internal lateinit var neutralUnselected: TextView
    internal lateinit var fireselected: TextView
    internal lateinit var waterselected: TextView
    internal lateinit var grassselected: TextView
    internal lateinit var neutralselected: TextView


    internal lateinit var healthPUnselected: TextView
    internal lateinit var manaPUnselected: TextView
    internal lateinit var confusePUnselected: TextView
    internal lateinit var chainUnselected: TextView
    internal lateinit var healthPselected: TextView
    internal lateinit var manaPselected: TextView
    internal lateinit var confusePselected: TextView
    internal lateinit var chainselected: TextView

    internal lateinit var healthPshopUnselected: TextView
    internal lateinit var manaPshopUnselected: TextView
    internal lateinit var confusePshopUnselected: TextView
    internal lateinit var chainshopUnselected: TextView
    internal lateinit var healthPshopselected: TextView
    internal lateinit var manaPshopselected: TextView
    internal lateinit var confusePshopselected: TextView
    internal lateinit var chainshopselected: TextView

    internal lateinit var pushAText: TextView
    internal lateinit var pushBText: TextView

    internal lateinit var elementChosen: ImageView
    internal lateinit var roomText: TextView
    internal lateinit var healthText: TextView
    internal lateinit var manaText: TextView
    internal lateinit var keytotalText: TextView
    internal lateinit var cointotalText: TextView

    internal lateinit var monsterDoor: ImageView
    internal lateinit var shopDoor: ImageView
    internal lateinit var sanctuaryDoor: ImageView

    internal lateinit var healingtowerText: TextView




    var roomNumber = 1
    var nextRoomNumber = 2
    var nextMonster = "placeholder"
    var nextRoom = "placeholder"
    var element = "neutral"
    var health = 10
    var mana = 10
    var coins = 0
    var keys = 0
    var chainamount = 0
    var healthPamount = 0
    var manaPamount = 0
    var confusePamount = 0
    var enemyHealth = 2
    var damage = 1
    var defense = 1
    var enemyDamage = 1
    var enemyDefense = 1
    var enemyElement = "neutral"
    var selectedText = "Attack"
    var textScreen = "Base"
    var isElementSwitched = false
    var turn = 1
    var turnsTillAttack = 0
    var turnsTillCharge = 2
    var isEnemyCharged = false
    var isEnemyChained = false
    var chainTurns = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dungeon_crawler)


        upButton = findViewById(R.id.upButton)
        rightButton = findViewById(R.id.rightButton)
        leftButton = findViewById(R.id.leftButton)
        downButton = findViewById(R.id.downButton)
        aButton = findViewById(R.id.aButton)
        bButton = findViewById(R.id.bButton)
        ghostEnemy = findViewById(R.id.ghostEnemy)
        spiderEnemy = findViewById(R.id.spiderEnemy)
        skeletonEnemy = findViewById(R.id.skeletonEnemy)
        gremlinEnemy = findViewById(R.id.gremlinEnemy)
        restrainingOrder = findViewById(R.id.restrainingOrder)
        shopKeeper = findViewById(R.id.shopKeeper)
        textBox = findViewById(R.id.textbox)
        healthTower = findViewById(R.id.healthTower)
        swordshield = findViewById(R.id.swordshield)

        attackUnselected = findViewById(R.id.attackUnselected)
        magicUnselected = findViewById(R.id.magicUnselected)
        itemsUnselected = findViewById(R.id.itemUnselected)
        blockUnselected = findViewById(R.id.blockUnselected)
        attackselected = findViewById(R.id.attackSelected)
        magicselected = findViewById(R.id.magicSelected)
        itemsselected = findViewById(R.id.itemSelected)
        blockselected = findViewById(R.id.blockSelected)

        fireUnselected = findViewById(R.id.fireUnSelected)
        waterUnselected = findViewById(R.id.waterUnSelected)
        grassUnselected = findViewById(R.id.grassUnSelected)
        neutralUnselected = findViewById(R.id.neutralUnSelected)
        fireselected = findViewById(R.id.fireSelected)
        waterselected = findViewById(R.id.waterSelected)
        grassselected = findViewById(R.id.grassSelected)
        neutralselected = findViewById(R.id.neutralSelected)


        healthPUnselected = findViewById(R.id.healthPUnSelected)
        manaPUnselected = findViewById(R.id.manaPUnSelected)
        confusePUnselected = findViewById(R.id.confusePUnSelected)
        chainUnselected = findViewById(R.id.chainUnSelected)
        healthPselected = findViewById(R.id.healthPSelected)
        manaPselected = findViewById(R.id.manaPSelected)
        confusePselected = findViewById(R.id.confusePSelected)
        chainselected = findViewById(R.id.chainSelected)

        healthPshopUnselected = findViewById(R.id.healthPshopUnSelected)
        manaPshopUnselected = findViewById(R.id.manaPshopUnSelected)
        confusePshopUnselected = findViewById(R.id.confusePshopUnSelected)
        chainshopUnselected = findViewById(R.id.chainshopUnSelected)
        healthPshopselected = findViewById(R.id.healthPshopSelected)
        manaPshopselected = findViewById(R.id.manaPshopSelected)
        confusePshopselected = findViewById(R.id.confusePshopSelected)
        chainshopselected = findViewById(R.id.chainshopSelected)

        pushAText = findViewById(R.id.pushAText)
        pushBText = findViewById(R.id.pushBText)

        elementChosen = findViewById(R.id.elementChosen)
        roomText = findViewById(R.id.roomText)
        healthText = findViewById(R.id.healthText)
        manaText = findViewById(R.id.manaText)
        keytotalText = findViewById(R.id.keytotalText)
        cointotalText = findViewById(R.id.cointotalText)

        monsterDoor = findViewById(R.id.monsterdoor)
        shopDoor = findViewById(R.id.shopDoor)
        sanctuaryDoor = findViewById(R.id.sanctuaryDoor)

        healingtowerText = findViewById(R.id.healingtowerText)





        upButton.setOnClickListener {

        }
        leftButton.setOnClickListener {
            Toast.makeText(this, "left", Toast.LENGTH_SHORT).show()
        }
        downButton.setOnClickListener {
            Toast.makeText(this, "down", Toast.LENGTH_SHORT).show()
        }
        rightButton.setOnClickListener {
            Toast.makeText(this, "right", Toast.LENGTH_SHORT).show()
        }
        aButton.setOnClickListener {
            Toast.makeText(this, "a", Toast.LENGTH_SHORT).show()
        }
        bButton.setOnClickListener {
            Toast.makeText(this, "b", Toast.LENGTH_SHORT).show()
        }
    }
}