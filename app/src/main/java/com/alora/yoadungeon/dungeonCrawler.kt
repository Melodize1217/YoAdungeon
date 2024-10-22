package com.alora.yoadungeon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class dungeonCrawler : AppCompatActivity() {

    internal lateinit var randomRoom: ImageView

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

    internal lateinit var dialogue: TextView




    var roomNumber = 1
    var nextRoomNumber = 2
    var currentMonster = "neutralGhost"
    var currentSpecies = "Ghost"
    var currentRoom = 1
    var randomMonsterNumber = 0

    var element = "Neutral"
    var health = 10
    var mana = 10
    var coins = 0
    var keys = 0
    var chainamount = 0
    var healthPamount = 0
    var manaPamount = 0
    var confusePamount = 0
    var enemyHealth = 2

    var enemyElement = "Neutral"
    var selectedText = "Attack"
    var textScreen = "Base"
    var isElementSwitched = false
    var currentTurn = "You"
    var turn = 1
    var turnsTillAttack = 0
    var turnsTillCharge = 2
    var isEnemyCharged = false
    var enemyState = "Idle"
    var isEnemyChained = false
    var chainTurns = 0
    var healthMax = 10
    var manaMax = 10

    var dialogSetting = "Filler"

    var shopDebugCode = "Down"

    var invincibilityCode = "Left1"

    var shopIshere = false

    var DropsNumber = 0

   var  blockingIsActive = false

    var isConfuseaActive = false
    var confuseTurns = 0

    var shopChance = 0

    var isBlockDebugActive = false

    var sanctuaryCalculation = 0


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

        dialogue = findViewById(R.id.dialogue)

        randomRoom = findViewById(R.id.randomRoom)





        upButton.setOnClickListener {
            if (textScreen == "Base") {
                if (selectedText == "Attack") {
                    attackselected.visibility = View.GONE
                    attackUnselected.visibility = View.VISIBLE
                    blockselected.visibility = View.VISIBLE
                    blockUnselected.visibility = View.GONE
                    selectedText = "Block"
                } else if (selectedText == "Block") {
                    blockselected.visibility = View.GONE
                    blockUnselected.visibility = View.VISIBLE
                    attackselected.visibility = View.VISIBLE
                    attackUnselected.visibility = View.GONE
                    selectedText = "Attack"
                }else if (selectedText == "Item") {
                    itemsselected.visibility = View.GONE
                    itemsUnselected.visibility = View.VISIBLE
                    magicselected.visibility = View.VISIBLE
                    magicUnselected.visibility = View.GONE
                    selectedText = "Magic"
                } else if (selectedText == "Magic") {
                    magicselected.visibility = View.GONE
                    magicUnselected.visibility = View.VISIBLE
                    itemsselected.visibility = View.VISIBLE
                    itemsUnselected.visibility = View.GONE
                    selectedText = "Item"
                }

            } else if (textScreen == "Element") {
                if (selectedText == "Fire") {
                    fireselected.visibility = View.GONE
                    fireUnselected.visibility = View.VISIBLE
                    grassselected.visibility = View.VISIBLE
                    grassUnselected.visibility = View.GONE
                    selectedText = "Grass"
                } else if (selectedText == "Grass") {
                    grassselected.visibility = View.GONE
                    grassUnselected.visibility = View.VISIBLE
                    fireselected.visibility = View.VISIBLE
                    fireUnselected.visibility = View.GONE
                    selectedText = "Fire"
                }else if (selectedText == "Water") {
                    waterselected.visibility = View.GONE
                    waterUnselected.visibility = View.VISIBLE
                    neutralselected.visibility = View.VISIBLE
                    neutralUnselected.visibility = View.GONE
                    selectedText = "Neutral"
                } else if (selectedText == "Neutral") {
                    neutralselected.visibility = View.GONE
                    neutralUnselected.visibility = View.VISIBLE
                    waterselected.visibility = View.VISIBLE
                    waterUnselected.visibility = View.GONE
                    selectedText = "Water"
                }

            } else if (textScreen == "Items") {
                if (selectedText == "Health") {
                    healthPselected.visibility = View.GONE
                    healthPUnselected.visibility = View.VISIBLE
                    confusePselected.visibility = View.VISIBLE
                    confusePUnselected.visibility = View.GONE
                    selectedText = "Confuse"
                } else if (selectedText == "Confuse") {
                    confusePselected.visibility = View.GONE
                    confusePUnselected.visibility = View.VISIBLE
                    healthPselected.visibility = View.VISIBLE
                    healthPUnselected.visibility = View.GONE
                    selectedText = "Health"
                }else if (selectedText == "Mana") {
                    manaPselected.visibility = View.GONE
                    manaPUnselected.visibility = View.VISIBLE
                    chainselected.visibility = View.VISIBLE
                    chainUnselected.visibility = View.GONE
                    selectedText = "Chain"
                } else if (selectedText == "Chain") {
                    chainselected.visibility = View.GONE
                    chainUnselected.visibility = View.VISIBLE
                    manaPselected.visibility = View.VISIBLE
                    manaPUnselected.visibility = View.GONE
                    selectedText = "Mana"
                }

            } else if (textScreen == "Shop") {
                if (selectedText == "HealthShop") {
                    healthPshopselected.visibility = View.GONE
                    healthPshopUnselected.visibility = View.VISIBLE
                    confusePshopselected.visibility = View.VISIBLE
                    confusePshopUnselected.visibility = View.GONE
                    selectedText = "ConfuseShop"
                } else if (selectedText == "ConfuseShop") {
                    confusePshopselected.visibility = View.GONE
                    confusePshopUnselected.visibility = View.VISIBLE
                    healthPshopselected.visibility = View.VISIBLE
                    healthPshopUnselected.visibility = View.GONE
                    selectedText = "HealthShop"
                }else if (selectedText == "ManaShop") {
                    manaPshopselected.visibility = View.GONE
                    manaPshopUnselected.visibility = View.VISIBLE
                    chainshopselected.visibility = View.VISIBLE
                    chainshopUnselected.visibility = View.GONE
                    selectedText = "ChainShop"
                } else if (selectedText == "ChainShop") {
                    chainshopselected.visibility = View.GONE
                    chainshopUnselected.visibility = View.VISIBLE
                    manaPshopselected.visibility = View.VISIBLE
                    manaPshopUnselected.visibility = View.GONE
                    selectedText = "ManaShop"
                }

            }
            if (shopDebugCode == "Up") {
                shopDebugCode = "Right"
            } else {
                shopDebugCode = "Down"
            }

            if (invincibilityCode == "Up1") {
                invincibilityCode = "Down1"
            } else if (invincibilityCode == "Up2") {
                invincibilityCode = "Down2"
            } else {
                invincibilityCode = "Right1"
            }
        }
        leftButton.setOnClickListener {
            if (textScreen == "Base") {
                if (selectedText == "Attack") {
                    attackselected.visibility = View.GONE
                    attackUnselected.visibility = View.VISIBLE
                    magicselected.visibility = View.VISIBLE
                    magicUnselected.visibility = View.GONE
                    selectedText = "Magic"
                } else if (selectedText == "Block") {
                    blockselected.visibility = View.GONE
                    blockUnselected.visibility = View.VISIBLE
                    itemsselected.visibility = View.VISIBLE
                    itemsUnselected.visibility = View.GONE
                    selectedText = "Item"
                }else if (selectedText == "Magic") {
                    magicselected.visibility = View.GONE
                    magicUnselected.visibility = View.VISIBLE
                    attackselected.visibility = View.VISIBLE
                    attackUnselected.visibility = View.GONE
                    selectedText = "Attack"
                } else if (selectedText == "Item") {
                    itemsselected.visibility = View.GONE
                    itemsUnselected.visibility = View.VISIBLE
                    blockselected.visibility = View.VISIBLE
                    blockUnselected.visibility = View.GONE
                    selectedText = "Block"
                }

            } else if (textScreen == "Element") {
                if (selectedText == "Fire") {
                    fireselected.visibility = View.GONE
                    fireUnselected.visibility = View.VISIBLE
                    waterselected.visibility = View.VISIBLE
                    waterUnselected.visibility = View.GONE
                    selectedText = "Water"
                } else if (selectedText == "Grass") {
                    grassselected.visibility = View.GONE
                    grassUnselected.visibility = View.VISIBLE
                    neutralselected.visibility = View.VISIBLE
                    neutralUnselected.visibility = View.GONE
                    selectedText = "Neutral"
                }else if (selectedText == "Water") {
                    waterselected.visibility = View.GONE
                    waterUnselected.visibility = View.VISIBLE
                    fireselected.visibility = View.VISIBLE
                    fireUnselected.visibility = View.GONE
                    selectedText = "Fire"
                } else if (selectedText == "Neutral") {
                    neutralselected.visibility = View.GONE
                    neutralUnselected.visibility = View.VISIBLE
                    grassselected.visibility = View.VISIBLE
                    grassUnselected.visibility = View.GONE
                    selectedText = "Grass"
                }

            } else if (textScreen == "Items") {
                if (selectedText == "Health") {
                    healthPselected.visibility = View.GONE
                    healthPUnselected.visibility = View.VISIBLE
                    manaPselected.visibility = View.VISIBLE
                    manaPUnselected.visibility = View.GONE
                    selectedText = "Mana"
                } else if (selectedText == "Confuse") {
                    confusePselected.visibility = View.GONE
                    confusePUnselected.visibility = View.VISIBLE
                    chainselected.visibility = View.VISIBLE
                    chainUnselected.visibility = View.GONE
                    selectedText = "Chain"
                }else if (selectedText == "Mana") {
                    manaPselected.visibility = View.GONE
                    manaPUnselected.visibility = View.VISIBLE
                    healthPselected.visibility = View.VISIBLE
                    healthPUnselected.visibility = View.GONE
                    selectedText = "Health"
                } else if (selectedText == "Chain") {
                    chainselected.visibility = View.GONE
                    chainUnselected.visibility = View.VISIBLE
                    confusePselected.visibility = View.VISIBLE
                    confusePUnselected.visibility = View.GONE
                    selectedText = "Confuse"
                }

            } else if (textScreen == "Shop") {
                if (selectedText == "HealthShop") {
                    healthPshopselected.visibility = View.GONE
                    healthPshopUnselected.visibility = View.VISIBLE
                    manaPshopselected.visibility = View.VISIBLE
                    manaPshopUnselected.visibility = View.GONE
                    selectedText = "ManaShop"
                } else if (selectedText == "ConfuseShop") {
                    confusePshopselected.visibility = View.GONE
                    confusePshopUnselected.visibility = View.VISIBLE
                    chainshopselected.visibility = View.VISIBLE
                    chainshopUnselected.visibility = View.GONE
                    selectedText = "ChainShop"
                }else if (selectedText == "ManaShop") {
                    manaPshopselected.visibility = View.GONE
                    manaPshopUnselected.visibility = View.VISIBLE
                    healthPshopselected.visibility = View.VISIBLE
                    healthPshopUnselected.visibility = View.GONE
                    selectedText = "HealthShop"
                } else if (selectedText == "ChainShop") {
                    chainshopselected.visibility = View.GONE
                    chainshopUnselected.visibility = View.VISIBLE
                    confusePshopselected.visibility = View.VISIBLE
                    confusePshopUnselected.visibility = View.GONE
                    selectedText = "ConfuseShop"
                }

            }
            if (shopDebugCode == "Left") {
                shopDebugCode = "Up"
            } else {
                shopDebugCode = "Down"
            }

            if (invincibilityCode == "Right1") {
                invincibilityCode = "Right2"
            } else if (invincibilityCode == "Right2") {
                invincibilityCode = "Left1"
            } else {
                invincibilityCode = "Right1"
            }
        }
        downButton.setOnClickListener {
            if (textScreen == "Base") {
                if (selectedText == "Attack") {
                    attackselected.visibility = View.GONE
                    attackUnselected.visibility = View.VISIBLE
                    blockselected.visibility = View.VISIBLE
                    blockUnselected.visibility = View.GONE
                    selectedText = "Block"
                } else if (selectedText == "Block") {
                    blockselected.visibility = View.GONE
                    blockUnselected.visibility = View.VISIBLE
                    attackselected.visibility = View.VISIBLE
                    attackUnselected.visibility = View.GONE
                    selectedText = "Attack"
                }else if (selectedText == "item") {
                    itemsselected.visibility = View.GONE
                    itemsUnselected.visibility = View.VISIBLE
                    magicselected.visibility = View.VISIBLE
                    magicUnselected.visibility = View.GONE
                    selectedText = "Magic"
                } else if (selectedText == "Magic") {
                    magicselected.visibility = View.GONE
                    magicUnselected.visibility = View.VISIBLE
                    itemsselected.visibility = View.VISIBLE
                    itemsUnselected.visibility = View.GONE
                    selectedText = "Item"
                }

            } else if (textScreen == "Element") {
                if (selectedText == "Fire") {
                    fireselected.visibility = View.GONE
                    fireUnselected.visibility = View.VISIBLE
                    grassselected.visibility = View.VISIBLE
                    grassUnselected.visibility = View.GONE
                    selectedText = "Grass"
                } else if (selectedText == "Grass") {
                    grassselected.visibility = View.GONE
                    grassUnselected.visibility = View.VISIBLE
                    fireselected.visibility = View.VISIBLE
                    fireUnselected.visibility = View.GONE
                    selectedText = "Fire"
                }else if (selectedText == "Water") {
                    waterselected.visibility = View.GONE
                    waterUnselected.visibility = View.VISIBLE
                    neutralselected.visibility = View.VISIBLE
                    neutralUnselected.visibility = View.GONE
                    selectedText = "Neutral"
                } else if (selectedText == "Neutral") {
                    neutralselected.visibility = View.GONE
                    neutralUnselected.visibility = View.VISIBLE
                    waterselected.visibility = View.VISIBLE
                    waterUnselected.visibility = View.GONE
                    selectedText = "Water"
                }

            } else if (textScreen == "Items") {
                if (selectedText == "Health") {
                    healthPselected.visibility = View.GONE
                    healthPUnselected.visibility = View.VISIBLE
                    confusePselected.visibility = View.VISIBLE
                    confusePUnselected.visibility = View.GONE
                    selectedText = "Confuse"
                } else if (selectedText == "Confuse") {
                    confusePselected.visibility = View.GONE
                    confusePUnselected.visibility = View.VISIBLE
                    healthPselected.visibility = View.VISIBLE
                    healthPUnselected.visibility = View.GONE
                    selectedText = "Health"
                }else if (selectedText == "Mana") {
                    manaPselected.visibility = View.GONE
                    manaPUnselected.visibility = View.VISIBLE
                    chainselected.visibility = View.VISIBLE
                    chainUnselected.visibility = View.GONE
                    selectedText = "Chain"
                } else if (selectedText == "Chain") {
                    chainselected.visibility = View.GONE
                    chainUnselected.visibility = View.VISIBLE
                    manaPselected.visibility = View.VISIBLE
                    manaPUnselected.visibility = View.GONE
                    selectedText = "Mana"
                }

            } else if (textScreen == "Shop") {
                if (selectedText == "HealthShop") {
                    healthPshopselected.visibility = View.GONE
                    healthPshopUnselected.visibility = View.VISIBLE
                    confusePshopselected.visibility = View.VISIBLE
                    confusePshopUnselected.visibility = View.GONE
                    selectedText = "ConfuseShop"
                } else if (selectedText == "ConfuseShop") {
                    confusePshopselected.visibility = View.GONE
                    confusePshopUnselected.visibility = View.VISIBLE
                    healthPshopselected.visibility = View.VISIBLE
                    healthPshopUnselected.visibility = View.GONE
                    selectedText = "HealthShop"
                }else if (selectedText == "ManaShop") {
                    manaPshopselected.visibility = View.GONE
                    manaPshopUnselected.visibility = View.VISIBLE
                    chainshopselected.visibility = View.VISIBLE
                    chainshopUnselected.visibility = View.GONE
                    selectedText = "ChainShop"
                } else if (selectedText == "ChainShop") {
                    chainshopselected.visibility = View.GONE
                    chainshopUnselected.visibility = View.VISIBLE
                    manaPshopselected.visibility = View.VISIBLE
                    manaPshopUnselected.visibility = View.GONE
                    selectedText = "ManaShop"
                }

            }

            if (shopDebugCode == "Down") {
                shopDebugCode = "Left"
            }

            if (invincibilityCode == "Down1") {
                invincibilityCode = "Up2"
            } else if (invincibilityCode == "Down2") {
                invincibilityCode = "B"
            } else {
                invincibilityCode = "Right1"
            }
        }
        rightButton.setOnClickListener {
            if (textScreen == "Base") {
                if (selectedText == "Attack") {
                    attackselected.visibility = View.GONE
                    attackUnselected.visibility = View.VISIBLE
                    magicselected.visibility = View.VISIBLE
                    magicUnselected.visibility = View.GONE
                    selectedText = "Magic"
                } else if (selectedText == "Block") {
                    blockselected.visibility = View.GONE
                    blockUnselected.visibility = View.VISIBLE
                    itemsselected.visibility = View.VISIBLE
                    itemsUnselected.visibility = View.GONE
                    selectedText = "Item"
                }else if (selectedText == "Magic") {
                    magicselected.visibility = View.GONE
                    magicUnselected.visibility = View.VISIBLE
                    attackselected.visibility = View.VISIBLE
                    attackUnselected.visibility = View.GONE
                    selectedText = "Attack"
                } else if (selectedText == "Item") {
                    itemsselected.visibility = View.GONE
                    itemsUnselected.visibility = View.VISIBLE
                    blockselected.visibility = View.VISIBLE
                    blockUnselected.visibility = View.GONE
                    selectedText = "Block"
                }

            } else if (textScreen == "Element") {
                if (selectedText == "Fire") {
                    fireselected.visibility = View.GONE
                    fireUnselected.visibility = View.VISIBLE
                    waterselected.visibility = View.VISIBLE
                    waterUnselected.visibility = View.GONE
                    selectedText = "Water"
                } else if (selectedText == "Grass") {
                    grassselected.visibility = View.GONE
                    grassUnselected.visibility = View.VISIBLE
                    neutralselected.visibility = View.VISIBLE
                    neutralUnselected.visibility = View.GONE
                    selectedText = "Neutral"
                }else if (selectedText == "Water") {
                    waterselected.visibility = View.GONE
                    waterUnselected.visibility = View.VISIBLE
                    fireselected.visibility = View.VISIBLE
                    fireUnselected.visibility = View.GONE
                    selectedText = "Fire"
                } else if (selectedText == "Neutral") {
                    neutralselected.visibility = View.GONE
                    neutralUnselected.visibility = View.VISIBLE
                    grassselected.visibility = View.VISIBLE
                    grassUnselected.visibility = View.GONE
                    selectedText = "Grass"
                }

            } else if (textScreen == "Items") {
                if (selectedText == "Health") {
                    healthPselected.visibility = View.GONE
                    healthPUnselected.visibility = View.VISIBLE
                    manaPselected.visibility = View.VISIBLE
                    manaPUnselected.visibility = View.GONE
                    selectedText = "Mana"
                } else if (selectedText == "Confuse") {
                    confusePselected.visibility = View.GONE
                    confusePUnselected.visibility = View.VISIBLE
                    chainselected.visibility = View.VISIBLE
                    chainUnselected.visibility = View.GONE
                    selectedText = "Chain"
                }else if (selectedText == "Mana") {
                    manaPselected.visibility = View.GONE
                    manaPUnselected.visibility = View.VISIBLE
                    healthPselected.visibility = View.VISIBLE
                    healthPUnselected.visibility = View.GONE
                    selectedText = "Health"
                } else if (selectedText == "Chain") {
                    chainselected.visibility = View.GONE
                    chainUnselected.visibility = View.VISIBLE
                    confusePselected.visibility = View.VISIBLE
                    confusePUnselected.visibility = View.GONE
                    selectedText = "Confuse"
                }

            } else if (textScreen == "Shop") {
                if (selectedText == "HealthShop") {
                    healthPshopselected.visibility = View.GONE
                    healthPshopUnselected.visibility = View.VISIBLE
                    manaPshopselected.visibility = View.VISIBLE
                    manaPshopUnselected.visibility = View.GONE
                    selectedText = "ManaShop"
                } else if (selectedText == "ConfuseShop") {
                    confusePshopselected.visibility = View.GONE
                    confusePshopUnselected.visibility = View.VISIBLE
                    chainshopselected.visibility = View.VISIBLE
                    chainshopUnselected.visibility = View.GONE
                    selectedText = "ChainShop"
                }else if (selectedText == "ManaShop") {
                    manaPshopselected.visibility = View.GONE
                    manaPshopUnselected.visibility = View.VISIBLE
                    healthPshopselected.visibility = View.VISIBLE
                    healthPshopUnselected.visibility = View.GONE
                    selectedText = "HealthShop"
                } else if (selectedText == "ChainShop") {
                    chainshopselected.visibility = View.GONE
                    chainshopUnselected.visibility = View.VISIBLE
                    confusePshopselected.visibility = View.VISIBLE
                    confusePshopUnselected.visibility = View.GONE
                    selectedText = "ConfuseShop"
                }

            }

            if (shopDebugCode == "Right") {
                shopDebugCode = "B"
            } else {
                shopDebugCode = "Down"
            }

            if (invincibilityCode == "Left1") {
                invincibilityCode = "Left2"
            } else if (invincibilityCode == "Left2") {
                invincibilityCode = "Up1"
            } else {
                invincibilityCode = "Right1"
            }
        }
        aButton.setOnClickListener {
            if (textScreen == "Base") {
                if (selectedText == "Magic") {
                    magicselected.visibility = View.GONE
                    itemsUnselected.visibility = View.GONE
                    attackUnselected.visibility = View.GONE
                    blockUnselected.visibility = View.GONE
                    fireselected.visibility = View.VISIBLE
                    waterUnselected.visibility = View.VISIBLE
                    grassUnselected.visibility = View.VISIBLE
                    neutralUnselected.visibility = View.VISIBLE
                    textScreen = "Element"
                    selectedText = "Fire"
                } else if (selectedText == "Item") {
                    magicUnselected.visibility = View.GONE
                    itemsselected.visibility = View.GONE
                    attackUnselected.visibility = View.GONE
                    blockUnselected.visibility = View.GONE

                    healthPselected.text = "HealthP: $healthPamount"
                    healthPUnselected.text = "HealthP: $healthPamount"
                    manaPUnselected.text = "ManaP: $manaPamount"
                    manaPselected.text = "ManaP: $manaPamount"
                    chainUnselected.text = "Chain: $chainamount"
                    chainselected.text = "Chain: $chainamount"
                    confusePselected.text = "ConfuseP: $confusePamount"
                    confusePUnselected.text = "ConfuseP: $confusePamount"

                    healthPselected.visibility = View.VISIBLE
                    confusePUnselected.visibility = View.VISIBLE
                    manaPUnselected.visibility = View.VISIBLE
                    chainUnselected.visibility = View.VISIBLE
                    textScreen = "Items"
                    selectedText = "Health"
                } else if (selectedText == "Attack") {
                    attack()
                    if (enemyHealth > 0) {
                        if (enemyState == "Idle") {
                            textScreen = "EnemyTurn"
                            dialogOn()
                            dialogue.text = "Enemy Charges attack"
                            dialogue.visibility = View.VISIBLE
                        } else if (turnsTillAttack == 1) {
                            textScreen = "EnemyTurn"
                            dialogOn()

                            dialogue.text = "Enemy attacks you"
                            dialogue.visibility = View.VISIBLE
                        } else if (turnsTillAttack > 1) {
                            textScreen = "EnemyTurn"
                            dialogOn()
                            dialogue.text = "Enemy is charging for $turnsTillAttack turns"
                            dialogue.visibility = View.VISIBLE
                        }
                        enemyTurn()
                    } else {

                        dialogOn()
                        if (shopIshere == false) {
                            textScreen = "EnemyDefeated"
                            dialogue.text =
                                "You defeated $currentMonster \n Push A to continue to next room"
                            dialogue.visibility = View.VISIBLE


                            enemyDrops()
                        } else if (shopIshere == true) {
                            textScreen = "Shop?"

                            dialogue.text = "Push A to use one key to get into the shop \n Or Push B to go to the next room"
                            dialogue.visibility = View.VISIBLE
                            enemyDrops()
                        }
                    }



                    Toast.makeText(this, "You attack the enemy", Toast.LENGTH_SHORT).show()
                } else if (selectedText == "Block") {
                    blockSystem()
                    Toast.makeText(this, "You block this turn", Toast.LENGTH_SHORT).show()
                }
            } else if (textScreen == "Shop?") {
                if (keys >= 1) {
                    dialogue.visibility = View.GONE
                    healthPshopselected.visibility = View.VISIBLE
                    manaPshopUnselected.visibility = View.VISIBLE
                    confusePshopUnselected.visibility = View.VISIBLE
                    chainshopUnselected.visibility = View.VISIBLE
                    keys -= 1
                    textScreen = "Shop"
                    selectedText = "HealthShop"

                    keytotalText.text = "Keys: $keys"

                    ghostEnemy.visibility = View.GONE
                    gremlinEnemy.visibility = View.GONE
                    spiderEnemy.visibility = View.GONE
                    skeletonEnemy.visibility = View.GONE
                    restrainingOrder.visibility = View.GONE

                    shopKeeper.visibility = View.VISIBLE
                } else {
                    Toast.makeText(this, "Oof no keys guess you gotta say no", Toast.LENGTH_SHORT).show()
                }
            } else if (textScreen == "Shop") {
                if (selectedText == "HealthShop") {
                    if (coins >= 3) {
                        healthPamount += 1
                        coins -= 3
                        cointotalText.text = "Coin: $coins"

                    } else {
                        Toast.makeText(this, "Damn guess you poor as heck", Toast.LENGTH_SHORT).show()
                    }
                } else if (selectedText == "ManaShop") {
                    if (coins >= 5) {
                        manaPamount += 1
                        coins -= 5
                        cointotalText.text = "Coin: $coins"
                    } else {
                        Toast.makeText(this, "Damn guess you poor as heck", Toast.LENGTH_SHORT).show()

                    }               } else if (selectedText == "ConfuseShop") {
                    if (coins >= 7) {
                        confusePamount += 1
                        coins -= 7
                        cointotalText.text = "Coin: $coins"
                    } else {
                        Toast.makeText(this, "Damn guess you poor as heck", Toast.LENGTH_SHORT).show()

                    }               } else if (selectedText == "ChainShop") {
                    if (coins >= 10) {
                        chainamount += 1
                        coins -= 10
                        cointotalText.text = "Coin: $coins"
                    } else {
                        Toast.makeText(this, "Damn guess you poor as heck", Toast.LENGTH_SHORT).show()
                    }
                }
            } else if (textScreen == "Items") {
                if (selectedText == "Health") {
                    if (health < healthMax) {
                        if (healthPamount > 0) {
                            healthPamount -= 1
                            health += 5

                            enemyTurn()
                            textScreen = "EnemyTurn"
                            dialogOn()
                            dialogue.text = "You took a health potion"
                            dialogue.visibility = View.VISIBLE
                            if (health > healthMax) {
                                health -= health - healthMax
                            }
                            healthText.text = "Health: $health/$healthMax"
                        } else {
                            Toast.makeText(this, "Don't know if you are blind but like you don't have this", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "I don't think you wanna waste this", Toast.LENGTH_SHORT).show()
                    }
                } else if (selectedText == "Mana") {
                    if (mana < manaMax) {
                        if (manaPamount > 0) {
                            manaPamount -= 1
                            mana += 5
                            enemyTurn()
                            textScreen = "EnemyTurn"
                            dialogOn()
                            dialogue.text = "You took a mana potion"
                            dialogue.visibility = View.VISIBLE
                            if (mana > manaMax) {
                                mana -= mana - manaMax
                            }
                            manaText.text = "Mana: $mana/$manaMax"
                        } else {
                            Toast.makeText(this, "Don't know if you are blind but like you don't have this", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this, "I don't think you wanna waste this", Toast.LENGTH_SHORT).show()
                    }
                } else if (selectedText == "Confuse") {

                        //This is a feature to be added if time allows it
                        //RAHHHHHHHHHHHHHHHH
                        if (confusePamount >= 1) {
                            confusePamount -= 1
                            isConfuseaActive = true
                            confuseTurns = 5
                            Toast.makeText(this, "This feature is not available and will be very soon \n just too lazy to go add it.", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else if (selectedText == "Chain") {
                    if (enemyState == "Charged") {
                        if (chainamount >= 1) {
                            chainamount -= 1
                            turnsTillAttack += 3
                            dialogOn()
                            dialogue.text = "You chained the enemy"
                            dialogue.visibility = View.VISIBLE
                            enemyTurn()
                        }
                } else {
                    Toast.makeText(this, "Hold off on this it only works \n if enemy is charged", Toast.LENGTH_SHORT).show()
                }
            } else if (textScreen == "Element") {
                if (selectedText == "Fire") {
                    if (mana >= 5) {
                        elementChosen.setImageResource(R.drawable.fireelement)
                        swordshield.setImageResource(R.drawable.fire)
                        element = "Fire"
                        mana -= 5
                        manaText.text = "Mana: $mana/$manaMax"

                        enemyTurn()
                        textScreen = "EnemyTurn"
                        dialogOn()
                        dialogue.text = "You are a fire lord now"
                        dialogue.visibility = View.VISIBLE
                    }
                } else if (selectedText == "Water") {
                    if (mana >= 5) {
                        elementChosen.setImageResource(R.drawable.waterelement)
                        swordshield.setImageResource(R.drawable.water)
                        element = "Water"
                        mana -= 5
                        manaText.text = "Mana: $mana/$manaMax"

                        enemyTurn()
                        textScreen = "EnemyTurn"
                        dialogOn()
                        dialogue.text = "You are a water saint now"
                        dialogue.visibility = View.VISIBLE
                    }
                } else if (selectedText == "Grass") {
                    if (mana >= 5) {
                        elementChosen.setImageResource(R.drawable.grasselement)
                        swordshield.setImageResource(R.drawable.grass)
                        element = "Grass"
                        mana -= 5
                        manaText.text = "Mana: $mana/$manaMax"

                        enemyTurn()
                        textScreen = "EnemyTurn"
                        dialogOn()
                        dialogue.text = "You are a grass monk now"
                        dialogue.visibility = View.VISIBLE
                    }
                } else if (selectedText == "Neutral") {
                    if (mana >= 0) {
                        elementChosen.setImageResource(R.drawable.neutralelement)
                        swordshield.setImageResource(R.drawable.neutral)
                        element = "Neutral"
                        mana -= 0
                        manaText.text = "Mana: $mana/$manaMax"

                        enemyTurn()
                        textScreen = "EnemyTurn"
                        dialogOn()
                        dialogue.text = "Well, You are you \n And that will be enough \n At least to me"
                        dialogue.visibility = View.VISIBLE
                    }
                }
            } else if (textScreen == "EnemyTurn") {
                dialogue.visibility = View.GONE
                if (isBlockDebugActive == false) {
                    blockingIsActive = false
                }
                dialogOff()

                turn += 1


            } else if (textScreen == "EnemyDefeated") {
                dialogue.visibility = View.GONE
                attackselected.visibility = View.VISIBLE
                magicUnselected.visibility = View.VISIBLE
                itemsUnselected.visibility = View.VISIBLE
                blockUnselected.visibility = View.VISIBLE
                selectedText = "Attack"
                textScreen = "Base"


                nextRoomGeneration()
            } else if (textScreen == "Sanctuary") {

                santuaryHealth()
                dialogOff()
                nextRoomGeneration()


            }

            if (shopDebugCode == "A") {
                textScreen = "Shop?"

                dialogue.text = "Push A to use one key to get into the shop \n Or Push B to go to the next room"
                dialogue.visibility = View.VISIBLE

                attackselected.visibility = View.GONE
                attackUnselected.visibility = View.GONE
                blockselected.visibility = View.GONE
                blockUnselected.visibility = View.GONE
                magicselected.visibility = View.GONE
                magicUnselected.visibility = View.GONE
                itemsselected.visibility = View.GONE
                itemsUnselected.visibility = View.GONE

                chainselected.visibility = View.GONE
                chainUnselected.visibility = View.GONE
                confusePselected.visibility = View.GONE
                confusePUnselected.visibility = View.GONE
                manaPUnselected.visibility = View.GONE
                healthPselected.visibility = View.GONE
                healthPUnselected.visibility = View.GONE
                manaPselected.visibility = View.GONE

                fireselected.visibility = View.GONE
                fireUnselected.visibility = View.GONE
                waterselected.visibility = View.GONE
                waterUnselected.visibility = View.GONE
                grassUnselected.visibility = View.GONE
                grassselected.visibility = View.GONE
                neutralUnselected.visibility = View.GONE
                neutralselected.visibility = View.GONE

                shopDebugCode = "Down"


            } else {
                shopDebugCode = "Down"
            }

            if (invincibilityCode == "A") {
                invincibilityCode = "Right1"
                if (isBlockDebugActive == false) {
                    Toast.makeText(this, "You have become immortal", Toast.LENGTH_SHORT).show()
                    isBlockDebugActive = true
                } else {
                    Toast.makeText(this, "You have become mortal", Toast.LENGTH_SHORT).show()
                    isBlockDebugActive = false
                }
            } else {
                invincibilityCode = "Right1"
            }
        }
        bButton.setOnClickListener {
            if (textScreen == "Element") {
                magicselected.visibility = View.VISIBLE
                itemsUnselected.visibility = View.VISIBLE
                attackUnselected.visibility = View.VISIBLE
                blockUnselected.visibility = View.VISIBLE
                fireselected.visibility = View.GONE
                fireUnselected.visibility = View.GONE
                waterUnselected.visibility = View.GONE
                grassUnselected.visibility = View.GONE
                neutralUnselected.visibility = View.GONE
                waterselected.visibility = View.GONE
                grassselected.visibility = View.GONE
                neutralselected.visibility = View.GONE
                textScreen = "Base"
                selectedText = "Magic"
            } else if (textScreen == "Items") {
                    magicUnselected.visibility = View.VISIBLE
                    itemsselected.visibility = View.VISIBLE
                    attackUnselected.visibility = View.VISIBLE
                    blockUnselected.visibility = View.VISIBLE

                    chainselected.visibility = View.GONE
                    chainUnselected.visibility = View.GONE
                    confusePselected.visibility = View.GONE
                    confusePUnselected.visibility = View.GONE
                    manaPUnselected.visibility = View.GONE
                    healthPselected.visibility = View.GONE
                    healthPUnselected.visibility = View.GONE
                    manaPselected.visibility = View.GONE
                    textScreen = "Base"
                    selectedText = "Item"

            } else if (textScreen == "Shop?") {
                dialogue.visibility = View.GONE

                magicUnselected.visibility = View.VISIBLE
                itemsUnselected.visibility = View.VISIBLE
                attackselected.visibility = View.VISIBLE
                blockUnselected.visibility = View.VISIBLE

                textScreen = "Base"
                selectedText = "Attack"

                nextRoomGeneration()


                //Go back to random room in queue
            } else if (textScreen == "Shop") {
                //This should go to the next random room in the queue

                shopKeeper.visibility = View.GONE

                magicUnselected.visibility = View.VISIBLE
                itemsUnselected.visibility = View.VISIBLE
                attackselected.visibility = View.VISIBLE
                blockUnselected.visibility = View.VISIBLE

                chainshopselected.visibility = View.GONE
                chainshopUnselected.visibility = View.GONE
                confusePshopselected.visibility = View.GONE
                confusePshopUnselected.visibility = View.GONE
                manaPshopUnselected.visibility = View.GONE
                healthPshopselected.visibility = View.GONE
                healthPshopUnselected.visibility = View.GONE
                manaPshopselected.visibility = View.GONE

                textScreen = "Base"
                selectedText = "Attack"

                nextRoomGeneration()
            }

            if (shopDebugCode == "B") {
                shopDebugCode = "A"
            } else {
                shopDebugCode = "Down"
            }

            if (invincibilityCode == "B") {
                invincibilityCode = "A"
            } else {
                invincibilityCode = "Right1"
            }
        }
    }

    private fun attack() {
        if (currentTurn == "You") {
            if (element == "Neutral" && enemyElement == "Neutral") {
                if (enemyHealth > 1) {
                    enemyHealth -= 1
                } else if (enemyHealth == 1) {
                    enemyHealth = 0



                    if (currentMonster == "neutralGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                    } else if (currentMonster == "fireGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                    } else if (currentMonster == "waterGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                    } else if (currentMonster == "grassGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostghurt)
                    } else if (currentMonster == "neutralSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                    } else if (currentMonster == "fireSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                    } else if (currentMonster == "waterSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                    } else if (currentMonster == "grassSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                    } else if (currentMonster == "neutralSpider") {
                        spiderEnemy.setImageResource(R.drawable.spidernhurt)
                    } else if (currentMonster == "fireSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                    } else if (currentMonster == "waterSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                    } else if (currentMonster == "grassSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderghurt)
                    } else if (currentMonster == "neutralGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                    } else if (currentMonster == "fireGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                    } else if (currentMonster == "waterGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                    } else if (currentMonster == "grassGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                    } else if (currentMonster == "RestrainingOrder" ) {
                        restrainingOrder.setImageResource(R.drawable.restrainhurt)
                    }
                }
            } else if (element == "Fire" && enemyElement == "Fire") {
                if (enemyHealth > 1) {
                    enemyHealth -= 1
                } else if (enemyHealth == 1) {
                    enemyHealth = 0
                    if (currentMonster == "neutralGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                    } else if (currentMonster == "fireGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                    } else if (currentMonster == "waterGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                    } else if (currentMonster == "grassGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostghurt)
                    } else if (currentMonster == "neutralSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                    } else if (currentMonster == "fireSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                    } else if (currentMonster == "waterSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                    } else if (currentMonster == "grassSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                    } else if (currentMonster == "neutralSpider") {
                        spiderEnemy.setImageResource(R.drawable.spidernhurt)
                    } else if (currentMonster == "fireSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                    } else if (currentMonster == "waterSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                    } else if (currentMonster == "grassSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderghurt)
                    } else if (currentMonster == "neutralGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                    } else if (currentMonster == "fireGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                    } else if (currentMonster == "waterGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                    } else if (currentMonster == "grassGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                    } else if (currentMonster == "RestrainingOrder") {
                        restrainingOrder.setImageResource(R.drawable.restrainhurt)
                    }
                }
                } else if (element == "Water" && enemyElement == "Water") {
                    if (enemyHealth > 1) {
                        enemyHealth -= 1
                    } else if (enemyHealth == 1) {
                        enemyHealth = 0
                        if (currentMonster == "neutralGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                        } else if (currentMonster == "fireGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                        } else if (currentMonster == "waterGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                        } else if (currentMonster == "grassGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostghurt)
                        } else if (currentMonster == "neutralSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                        } else if (currentMonster == "fireSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                        } else if (currentMonster == "waterSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                        } else if (currentMonster == "grassSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                        } else if (currentMonster == "neutralSpider") {
                            spiderEnemy.setImageResource(R.drawable.spidernhurt)
                        } else if (currentMonster == "fireSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                        } else if (currentMonster == "waterSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                        } else if (currentMonster == "grassSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderghurt)
                        } else if (currentMonster == "neutralGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                        } else if (currentMonster == "fireGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                        } else if (currentMonster == "waterGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                        } else if (currentMonster == "grassGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                        } else if (currentMonster == "RestrainingOrder") {
                            restrainingOrder.setImageResource(R.drawable.restrainhurt)
                        }
                    }
                } else if (element == "Grass" && enemyElement == "Grass") {
                    if (enemyHealth > 1) {
                        enemyHealth -= 1
                    } else if (enemyHealth == 1) {
                        enemyHealth = 0
                        if (currentMonster == "neutralGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                        } else if (currentMonster == "fireGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                        } else if (currentMonster == "waterGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                        } else if (currentMonster == "grassGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostghurt)
                        } else if (currentMonster == "neutralSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                        } else if (currentMonster == "fireSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                        } else if (currentMonster == "waterSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                        } else if (currentMonster == "grassSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                        } else if (currentMonster == "neutralSpider") {
                            spiderEnemy.setImageResource(R.drawable.spidernhurt)
                        } else if (currentMonster == "fireSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                        } else if (currentMonster == "waterSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                        } else if (currentMonster == "grassSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderghurt)
                        } else if (currentMonster == "neutralGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                        } else if (currentMonster == "fireGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                        } else if (currentMonster == "waterGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                        } else if (currentMonster == "grassGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                        } else if (currentMonster == "RestrainingOrder") {
                            restrainingOrder.setImageResource(R.drawable.restrainhurt)
                        }
                    }
                } else if (element == "Water" && enemyElement == "Fire") {
                    if (enemyHealth > 3) {
                        enemyHealth -= 3
                    } else if (enemyHealth <= 3) {
                        enemyHealth = 0
                        if (currentMonster == "neutralGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                        } else if (currentMonster == "fireGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                        } else if (currentMonster == "waterGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                        } else if (currentMonster == "grassGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostghurt)
                        } else if (currentMonster == "neutralSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                        } else if (currentMonster == "fireSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                        } else if (currentMonster == "waterSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                        } else if (currentMonster == "grassSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                        } else if (currentMonster == "neutralSpider") {
                            spiderEnemy.setImageResource(R.drawable.spidernhurt)
                        } else if (currentMonster == "fireSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                        } else if (currentMonster == "waterSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                        } else if (currentMonster == "grassSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderghurt)
                        } else if (currentMonster == "neutralGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                        } else if (currentMonster == "fireGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                        } else if (currentMonster == "waterGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                        } else if (currentMonster == "grassGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                        } else if (currentMonster == "RestrainingOrder") {
                            restrainingOrder.setImageResource(R.drawable.restrainhurt)
                        }
                    }
                }else if (element == "Fire" && enemyElement == "Grass") {
                    if (enemyHealth > 3) {
                        enemyHealth -= 3
                    } else if (enemyHealth <= 3) {
                        enemyHealth = 0
                        if (currentMonster == "neutralGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                        } else if (currentMonster == "fireGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                        } else if (currentMonster == "waterGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                        } else if (currentMonster == "grassGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostghurt)
                        } else if (currentMonster == "neutralSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                        } else if (currentMonster == "fireSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                        } else if (currentMonster == "waterSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                        } else if (currentMonster == "grassSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                        } else if (currentMonster == "neutralSpider") {
                            spiderEnemy.setImageResource(R.drawable.spidernhurt)
                        } else if (currentMonster == "fireSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                        } else if (currentMonster == "waterSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                        } else if (currentMonster == "grassSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderghurt)
                        } else if (currentMonster == "neutralGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                        } else if (currentMonster == "fireGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                        } else if (currentMonster == "waterGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                        } else if (currentMonster == "grassGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                        } else if (currentMonster == "RestrainingOrder") {
                            restrainingOrder.setImageResource(R.drawable.restrainhurt)
                        }
                    }
                } else if (element == "Grass" && enemyElement == "Water") {
                    if (enemyHealth > 3) {
                        enemyHealth -= 3
                    } else if (enemyHealth <= 3) {
                        enemyHealth = 0
                        if (currentMonster == "neutralGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                        } else if (currentMonster == "fireGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                        } else if (currentMonster == "waterGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                        } else if (currentMonster == "grassGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostghurt)
                        } else if (currentMonster == "neutralSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                        } else if (currentMonster == "fireSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                        } else if (currentMonster == "waterSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                        } else if (currentMonster == "grassSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                        } else if (currentMonster == "neutralSpider") {
                            spiderEnemy.setImageResource(R.drawable.spidernhurt)
                        } else if (currentMonster == "fireSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                        } else if (currentMonster == "waterSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                        } else if (currentMonster == "grassSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderghurt)
                        } else if (currentMonster == "neutralGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                        } else if (currentMonster == "fireGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                        } else if (currentMonster == "waterGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                        } else if (currentMonster == "grassGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                        } else if (currentMonster == "RestrainingOrder") {
                            restrainingOrder.setImageResource(R.drawable.restrainhurt)
                        }
                    }
                } else if (element == "Fire" && enemyElement == "Water") {
                    if (enemyHealth > 1) {
                        enemyHealth -= 1
                    } else if (enemyHealth <= 1) {
                        enemyHealth = 0
                        if (currentMonster == "neutralGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                        } else if (currentMonster == "fireGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                        } else if (currentMonster == "waterGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                        } else if (currentMonster == "grassGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostghurt)
                        } else if (currentMonster == "neutralSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                        } else if (currentMonster == "fireSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                        } else if (currentMonster == "waterSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                        } else if (currentMonster == "grassSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                        } else if (currentMonster == "neutralSpider") {
                            spiderEnemy.setImageResource(R.drawable.spidernhurt)
                        } else if (currentMonster == "fireSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                        } else if (currentMonster == "waterSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                        } else if (currentMonster == "grassSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderghurt)
                        } else if (currentMonster == "neutralGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                        } else if (currentMonster == "fireGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                        } else if (currentMonster == "waterGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                        } else if (currentMonster == "grassGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                        } else if (currentMonster == "RestrainingOrder") {
                            restrainingOrder.setImageResource(R.drawable.restrainhurt)
                        }
                    }
                } else if (element == "Grass" && enemyElement == "Fire") {
                    if (enemyHealth > 1) {
                        enemyHealth -= 1
                    } else if (enemyHealth <= 1) {
                        enemyHealth = 0
                        if (currentMonster == "neutralGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                        } else if (currentMonster == "fireGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                        } else if (currentMonster == "waterGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                        } else if (currentMonster == "grassGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostghurt)
                        } else if (currentMonster == "neutralSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                        } else if (currentMonster == "fireSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                        } else if (currentMonster == "waterSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                        } else if (currentMonster == "grassSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                        } else if (currentMonster == "neutralSpider") {
                            spiderEnemy.setImageResource(R.drawable.spidernhurt)
                        } else if (currentMonster == "fireSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                        } else if (currentMonster == "waterSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                        } else if (currentMonster == "grassSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderghurt)
                        } else if (currentMonster == "neutralGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                        } else if (currentMonster == "fireGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                        } else if (currentMonster == "waterGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                        } else if (currentMonster == "grassGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                        } else if (currentMonster == "RestrainingOrder") {
                            restrainingOrder.setImageResource(R.drawable.restrainhurt)
                        }
                    }
                } else if (element == "Water" && enemyElement == "Grass") {
                    if (enemyHealth > 1) {
                        enemyHealth -= 1
                    } else if (enemyHealth <= 1) {
                        enemyHealth = 0
                        if (currentMonster == "neutralGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                        } else if (currentMonster == "fireGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                        } else if (currentMonster == "waterGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                        } else if (currentMonster == "grassGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostghurt)
                        } else if (currentMonster == "neutralSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                        } else if (currentMonster == "fireSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                        } else if (currentMonster == "waterSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                        } else if (currentMonster == "grassSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                        } else if (currentMonster == "neutralSpider") {
                            spiderEnemy.setImageResource(R.drawable.spidernhurt)
                        } else if (currentMonster == "fireSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                        } else if (currentMonster == "waterSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                        } else if (currentMonster == "grassSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderghurt)
                        } else if (currentMonster == "neutralGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                        } else if (currentMonster == "fireGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                        } else if (currentMonster == "waterGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                        } else if (currentMonster == "grassGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                        } else if (currentMonster == "RestrainingOrder") {
                            restrainingOrder.setImageResource(R.drawable.restrainhurt)
                        }
                    }
                } else if (element == "Fire" && enemyElement == "Neutral") {
                    if (enemyHealth > 2) {
                        enemyHealth -= 2
                    } else if (enemyHealth <= 2) {
                        enemyHealth = 0
                        if (currentMonster == "neutralGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                        } else if (currentMonster == "fireGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                        } else if (currentMonster == "waterGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                        } else if (currentMonster == "grassGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostghurt)
                        } else if (currentMonster == "neutralSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                        } else if (currentMonster == "fireSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                        } else if (currentMonster == "waterSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                        } else if (currentMonster == "grassSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                        } else if (currentMonster == "neutralSpider") {
                            spiderEnemy.setImageResource(R.drawable.spidernhurt)
                        } else if (currentMonster == "fireSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                        } else if (currentMonster == "waterSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                        } else if (currentMonster == "grassSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderghurt)
                        } else if (currentMonster == "neutralGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                        } else if (currentMonster == "fireGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                        } else if (currentMonster == "waterGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                        } else if (currentMonster == "grassGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                        } else if (currentMonster == "RestrainingOrder") {
                            restrainingOrder.setImageResource(R.drawable.restrainhurt)
                        }
                    }
                } else if (element == "Water" && enemyElement == "Neutral") {
                    if (enemyHealth > 2) {
                        enemyHealth -= 2
                    } else if (enemyHealth <= 2) {
                        enemyHealth = 0
                        if (currentMonster == "neutralGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                        } else if (currentMonster == "fireGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                        } else if (currentMonster == "waterGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                        } else if (currentMonster == "grassGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostghurt)
                        } else if (currentMonster == "neutralSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                        } else if (currentMonster == "fireSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                        } else if (currentMonster == "waterSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                        } else if (currentMonster == "grassSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                        } else if (currentMonster == "neutralSpider") {
                            spiderEnemy.setImageResource(R.drawable.spidernhurt)
                        } else if (currentMonster == "fireSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                        } else if (currentMonster == "waterSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                        } else if (currentMonster == "grassSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderghurt)
                        } else if (currentMonster == "neutralGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                        } else if (currentMonster == "fireGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                        } else if (currentMonster == "waterGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                        } else if (currentMonster == "grassGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                        } else if (currentMonster == "RestrainingOrder") {
                            restrainingOrder.setImageResource(R.drawable.restrainhurt)
                        }
                    }
                } else if (element == "Grass" && enemyElement == "Neutral") {
                    if (enemyHealth > 2) {
                        enemyHealth -= 2
                    } else if (enemyHealth <= 2) {
                        enemyHealth = 0
                        if (currentMonster == "neutralGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                        } else if (currentMonster == "fireGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                        } else if (currentMonster == "waterGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                        } else if (currentMonster == "grassGhost") {
                            ghostEnemy.setImageResource(R.drawable.ghostghurt)
                        } else if (currentMonster == "neutralSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                        } else if (currentMonster == "fireSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                        } else if (currentMonster == "waterSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                        } else if (currentMonster == "grassSkeleton") {
                            skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                        } else if (currentMonster == "neutralSpider") {
                            spiderEnemy.setImageResource(R.drawable.spidernhurt)
                        } else if (currentMonster == "fireSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                        } else if (currentMonster == "waterSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                        } else if (currentMonster == "grassSpider") {
                            spiderEnemy.setImageResource(R.drawable.spiderghurt)
                        } else if (currentMonster == "neutralGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                        } else if (currentMonster == "fireGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                        } else if (currentMonster == "waterGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                        } else if (currentMonster == "grassGremlin") {
                            gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                        } else if (currentMonster == "RestrainingOrder") {
                            restrainingOrder.setImageResource(R.drawable.restrainhurt)
                        }
                    }
                } else if (element == "Neutral" && enemyElement == "Fire") {
                if (enemyHealth > 1) {
                    enemyHealth -= 1
                } else if (enemyHealth <= 1) {
                    enemyHealth = 0
                    if (currentMonster == "neutralGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                    } else if (currentMonster == "fireGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                    } else if (currentMonster == "waterGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                    } else if (currentMonster == "grassGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostghurt)
                    } else if (currentMonster == "neutralSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                    } else if (currentMonster == "fireSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                    } else if (currentMonster == "waterSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                    } else if (currentMonster == "grassSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                    } else if (currentMonster == "neutralSpider") {
                        spiderEnemy.setImageResource(R.drawable.spidernhurt)
                    } else if (currentMonster == "fireSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                    } else if (currentMonster == "waterSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                    } else if (currentMonster == "grassSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderghurt)
                    } else if (currentMonster == "neutralGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                    } else if (currentMonster == "fireGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                    } else if (currentMonster == "waterGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                    } else if (currentMonster == "grassGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                    } else if (currentMonster == "RestrainingOrder") {
                        restrainingOrder.setImageResource(R.drawable.restrainhurt)
                    }
                }
            } else if (element == "Neutral" && enemyElement == "Water") {
                if (enemyHealth > 1) {
                    enemyHealth -= 1
                } else if (enemyHealth <= 1) {
                    enemyHealth = 0
                    if (currentMonster == "neutralGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                    } else if (currentMonster == "fireGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                    } else if (currentMonster == "waterGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                    } else if (currentMonster == "grassGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostghurt)
                    } else if (currentMonster == "neutralSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                    } else if (currentMonster == "fireSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                    } else if (currentMonster == "waterSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                    } else if (currentMonster == "grassSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                    } else if (currentMonster == "neutralSpider") {
                        spiderEnemy.setImageResource(R.drawable.spidernhurt)
                    } else if (currentMonster == "fireSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                    } else if (currentMonster == "waterSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                    } else if (currentMonster == "grassSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderghurt)
                    } else if (currentMonster == "neutralGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                    } else if (currentMonster == "fireGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                    } else if (currentMonster == "waterGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                    } else if (currentMonster == "grassGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                    } else if (currentMonster == "RestrainingOrder") {
                        restrainingOrder.setImageResource(R.drawable.restrainhurt)
                    }
                }
            } else if (element == "Neutral" && enemyElement == "Grass") {
                if (enemyHealth > 1) {
                    enemyHealth -= 1
                } else if (enemyHealth <= 1) {
                    enemyHealth = 0
                    if (currentMonster == "neutralGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostnhurt)
                    } else if (currentMonster == "fireGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostfhurt)
                    } else if (currentMonster == "waterGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostwhurt)
                    } else if (currentMonster == "grassGhost") {
                        ghostEnemy.setImageResource(R.drawable.ghostghurt)
                    } else if (currentMonster == "neutralSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellynhurt)
                    } else if (currentMonster == "fireSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellyfhurt)
                    } else if (currentMonster == "waterSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellywhurt)
                    } else if (currentMonster == "grassSkeleton") {
                        skeletonEnemy.setImageResource(R.drawable.skellyghurt)
                    } else if (currentMonster == "neutralSpider") {
                        spiderEnemy.setImageResource(R.drawable.spidernhurt)
                    } else if (currentMonster == "fireSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderfhurt)
                    } else if (currentMonster == "waterSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderwhurt)
                    } else if (currentMonster == "grassSpider") {
                        spiderEnemy.setImageResource(R.drawable.spiderghurt)
                    } else if (currentMonster == "neutralGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmynhurt)
                    } else if (currentMonster == "fireGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmyfhurt)
                    } else if (currentMonster == "waterGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmywhurt)
                    } else if (currentMonster == "grassGremlin") {
                        gremlinEnemy.setImageResource(R.drawable.gremmyghurt)
                    } else if (currentMonster == "RestrainingOrder") {
                        restrainingOrder.setImageResource(R.drawable.restrainhurt)
                    }
                }
            }

        }
    }


    private fun santuaryHealth() {
        healthMax += 10
        manaMax += 10
        health = healthMax
        mana = manaMax
        healthText.text = "Health: $health/$healthMax"
        manaText.text = "Mana: $mana/$manaMax"

        healthTower.visibility = View.GONE
        dialogue.visibility = View.GONE



    }
    private fun enemyTurn() {
        if (enemyState == "Idle") {
            enemyState = "Charged"
            if (currentMonster == "neutralGhost") {
                ghostEnemy.setImageResource(R.drawable.ghostncharge)
                turnsTillAttack = 2
            } else if (currentMonster == "fireGhost") {
                ghostEnemy.setImageResource(R.drawable.ghostfcharge)
                turnsTillAttack = 2
            } else if (currentMonster == "waterGhost") {
                ghostEnemy.setImageResource(R.drawable.ghostwcharge)
                turnsTillAttack = 2
            } else if (currentMonster == "grassGhost") {
                ghostEnemy.setImageResource(R.drawable.ghostgcharge)
                turnsTillAttack = 2
            } else if (currentMonster == "neutralSkeleton") {
                skeletonEnemy.setImageResource(R.drawable.skellyncharge)
                turnsTillAttack = 3
            } else if (currentMonster == "fireSkeleton") {
                skeletonEnemy.setImageResource(R.drawable.skellyfcharge)
                turnsTillAttack = 3
            } else if (currentMonster == "waterSkeleton") {
                skeletonEnemy.setImageResource(R.drawable.skellywcharge)
                turnsTillAttack = 3
            } else if (currentMonster == "grassSkeleton") {
                skeletonEnemy.setImageResource(R.drawable.skellygcharge)
                turnsTillAttack = 3
            } else if (currentMonster == "neutralGremlin") {
                gremlinEnemy.setImageResource(R.drawable.gremmyncharge)
                turnsTillAttack = 4
            } else if (currentMonster == "fireGremlin") {
                gremlinEnemy.setImageResource(R.drawable.gremmyfcharge)
                turnsTillAttack = 4
            } else if (currentMonster == "waterGremlin") {
                gremlinEnemy.setImageResource(R.drawable.gremmywcharge)
                turnsTillAttack = 4
            } else if (currentMonster == "grassGremlin") {
                gremlinEnemy.setImageResource(R.drawable.gremmygcharge)
                turnsTillAttack = 4
            } else if (currentMonster == "neutralSpider") {
                spiderEnemy.setImageResource(R.drawable.spiderncharge)
                turnsTillAttack = 5
            } else if (currentMonster == "fireSpider") {
                spiderEnemy.setImageResource(R.drawable.spiderfcharge)
                turnsTillAttack = 5
            } else if (currentMonster == "waterSpider") {
                spiderEnemy.setImageResource(R.drawable.spiderwcharge)
                turnsTillAttack = 5
            } else if (currentMonster == "grassSpider") {
                spiderEnemy.setImageResource(R.drawable.spidergcharge)
                turnsTillAttack = 5
            } else if (currentMonster == "RestrainingOrder") {
                restrainingOrder.setImageResource(R.drawable.restraincharge)
                turnsTillAttack = 10
            }

            enemyState = "Charged"
        } else if (enemyState == "Charged") {
            if (turnsTillAttack > 1) {
                turnsTillAttack -= 1
            } else if (turnsTillAttack == 1) {
                turnsTillAttack -= 0

                if (currentMonster == "neutralGhost") {
                    ghostEnemy.setImageResource(R.drawable.ghostnattack)

                } else if (currentMonster == "fireGhost") {
                    ghostEnemy.setImageResource(R.drawable.ghostfattack)

                } else if (currentMonster == "waterGhost") {
                    ghostEnemy.setImageResource(R.drawable.ghostwattack)

                } else if (currentMonster == "grassGhost") {
                    ghostEnemy.setImageResource(R.drawable.ghostgattack)

                } else if (currentMonster == "neutralSkeleton") {
                    skeletonEnemy.setImageResource(R.drawable.skellynattack)

                } else if (currentMonster == "fireSkeleton") {
                    skeletonEnemy.setImageResource(R.drawable.skellyfattack)

                } else if (currentMonster == "waterSkeleton") {
                    skeletonEnemy.setImageResource(R.drawable.skellywattack)

                } else if (currentMonster == "grassSkeleton") {
                    skeletonEnemy.setImageResource(R.drawable.skellygattack)

                } else if (currentMonster == "neutralGremlin") {
                    gremlinEnemy.setImageResource(R.drawable.gremmynattack)

                } else if (currentMonster == "fireGremlin") {
                    gremlinEnemy.setImageResource(R.drawable.gremmyfattack)

                } else if (currentMonster == "waterGremlin") {
                    gremlinEnemy.setImageResource(R.drawable.gremmywattack)

                } else if (currentMonster == "grassGremlin") {
                    gremlinEnemy.setImageResource(R.drawable.gremmygattack)

                } else if (currentMonster == "neutralSpider") {
                    spiderEnemy.setImageResource(R.drawable.spidernattack)

                } else if (currentMonster == "fireSpider") {
                    spiderEnemy.setImageResource(R.drawable.spiderfattack)

                } else if (currentMonster == "waterSpider") {
                    spiderEnemy.setImageResource(R.drawable.spiderwattack)

                } else if (currentMonster == "grassSpider") {
                    spiderEnemy.setImageResource(R.drawable.spidergattack)

                } else if (currentMonster == "RestrainingOrder") {
                    restrainingOrder.setImageResource(R.drawable.restrainattack)

                }


                enemyState = "Attack"
                if (enemyElement == "Neutral" && element == "Neutral") {
                    if (blockingIsActive == false) {
                    if (health > 1) {
                        health -= 1
                        healthText.text = "Health: $health/$healthMax"
                    } else if (health <= 1) {
                        val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                        startActivity(intent)
                        finish()
                    }
                        }
                } else if (enemyElement == "Fire" && element == "Fire") {
                    if (blockingIsActive == false) {
                        if (health > 1) {
                            health -= 1
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 1) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }

                } else if (enemyElement == "Water" && element == "Water") {
                    if (blockingIsActive == false) {
                        if (health > 1) {
                            health -= 1
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 1) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }

                } else if (enemyElement == "Grass" && element == "Grass") {
                    if (blockingIsActive == false) {
                        if (health > 1) {
                            health -= 1
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 1) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }

                } else if (enemyElement == "Fire" && element == "Grass") {
                    if (blockingIsActive == false) {
                        if (health > 3) {
                            health -= 3
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 3) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }

                } else if (enemyElement == "Grass" && element == "Water") {
                    if (blockingIsActive == false) {
                        if (health > 3) {
                            health -= 3
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 3) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }

                } else if (enemyElement == "Water" && element == "Fire") {

                        if (blockingIsActive == false) {
                            if (health > 3) {
                            health -= 3
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 3) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else if (enemyElement == "Fire" && element == "Neutral") {
                    if (blockingIsActive == false) {
                        if (health > 2) {
                            health -= 2
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 2) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else if (enemyElement == "Water" && element == "Neutral") {
                    if (blockingIsActive == false) {
                        if (health > 2) {
                            health -= 2
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 2) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else if (enemyElement == "Grass" && element == "Neutral") {
                    if (blockingIsActive == false) {
                        if (health > 2) {
                            health -= 2
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 2) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }

                } else if (enemyElement == "Neutral" && element == "Fire") {
                    if (blockingIsActive == false) {
                        if (health > 1) {
                            health -= 1
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 1) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }

                } else if (enemyElement == "Neutral" && element == "Water") {
                    if (blockingIsActive == false) {
                        if (health > 1) {
                            health -= 1
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 1) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else if (enemyElement == "Neutral" && element == "Grass") {
                    if (blockingIsActive == false) {
                        if (health > 1) {
                            health -= 1
                            healthText.text = "Health: $health/$healthMax"
                        } else if (health <= 1) {
                            val intent = Intent(this@dungeonCrawler, DeathScreen::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            }

        } else if (enemyState == "Attack") {
            enemyState = "Idle"
            when (currentMonster) {
                "neutralGhost" -> {
                    ghostEnemy.setImageResource(R.drawable.ghostnidle)
                }
                "fireGhost" -> {
                    ghostEnemy.setImageResource(R.drawable.ghostfidle)
                }
                "grassGhost" -> {
                    ghostEnemy.setImageResource(R.drawable.ghostgidle)
                }
                "waterGhost" -> {
                    ghostEnemy.setImageResource(R.drawable.ghostwidle)
                }
                "neutralSkeleton" -> {
                    skeletonEnemy.setImageResource(R.drawable.skellynidle)
                }
                "fireSkeleton" -> {
                    skeletonEnemy.setImageResource(R.drawable.skellyfidle)
                }
                "grassSkeleton" -> {
                    skeletonEnemy.setImageResource(R.drawable.skellygidle)
                }
                "waterSkeleton" -> {
                    skeletonEnemy.setImageResource(R.drawable.skellywidle)
                }
                "neutralGremlin" -> {
                    gremlinEnemy.setImageResource(R.drawable.gremmynidle)
                }
                "fireGremlin" -> {
                    gremlinEnemy.setImageResource(R.drawable.gremmyfidle)
                }
                "grassGremlin" -> {
                    gremlinEnemy.setImageResource(R.drawable.gremmygidle)
                }
                "waterGremlin" -> {
                    gremlinEnemy.setImageResource(R.drawable.gremmywidle)
                }
                "neutralSpider" -> {
                    spiderEnemy.setImageResource(R.drawable.spidernidle)
                }
                "fireSpider" -> {
                    spiderEnemy.setImageResource(R.drawable.spiderfidle)
                }
                "grassSpider" -> {
                    spiderEnemy.setImageResource(R.drawable.spidergidle)
                }
                "waterSpider" -> {
                    spiderEnemy.setImageResource(R.drawable.spiderwidle)
                }
                "restrainingOrder" -> {
                    restrainingOrder.setImageResource(R.drawable.restrainidle)
                }
            }
        }
    }


    private fun dialogOn() {

        //This will make things easier when you need to turn everything off for a dialog and reusable
        attackselected.visibility = View.GONE
        attackUnselected.visibility = View.GONE
        blockUnselected.visibility = View.GONE
        blockselected.visibility = View.GONE
        itemsselected.visibility = View.GONE
        itemsUnselected.visibility = View.GONE
        magicselected.visibility = View.GONE
        magicUnselected.visibility = View.GONE

        healthPUnselected.visibility = View.GONE
        healthPselected.visibility = View.GONE
        confusePselected.visibility = View.GONE
        confusePUnselected.visibility = View.GONE
        chainselected.visibility = View.GONE
        chainUnselected.visibility = View.GONE
        manaPUnselected.visibility = View.GONE
        manaPselected.visibility = View.GONE

        healthPshopUnselected.visibility = View.GONE
        healthPshopselected.visibility = View.GONE
        confusePshopselected.visibility = View.GONE
        confusePshopUnselected.visibility = View.GONE
        chainshopselected.visibility = View.GONE
        chainshopUnselected.visibility = View.GONE
        manaPshopUnselected.visibility = View.GONE
        manaPshopselected.visibility = View.GONE

        fireselected.visibility = View.GONE
        fireUnselected.visibility = View.GONE
        waterselected.visibility = View.GONE
        waterUnselected.visibility = View.GONE
        grassselected.visibility = View.GONE
        grassUnselected.visibility = View.GONE
        neutralselected.visibility = View.GONE
        neutralUnselected.visibility = View.GONE
    }
    private fun dialogOff() {
        textScreen = "Base"
        selectedText = "Attack"
        attackselected.visibility = View.VISIBLE
        magicUnselected.visibility = View.VISIBLE
        itemsUnselected.visibility = View.VISIBLE
        blockUnselected.visibility = View.VISIBLE
    }


    private fun enemyDrops() {
        DropsNumber = Random.nextInt(1,6)


        when (DropsNumber) {
            1 -> {
                coins += 1
                cointotalText.text = "Coins: $coins"
            }
            2 -> {
                coins += 2
                cointotalText.text = "Coins: $coins"
            }
            3 -> {
                coins += 3
                cointotalText.text = "Coins: $coins"
            }
            4 -> {
                keys += 1
                coins += 2
                keytotalText.text = "Keys: $keys"
                cointotalText.text = "Coins: $coins"
            }
            5 -> {
                keys += 1
                keytotalText.text = "Keys: $keys"
            }
            6 -> {
                keys += 2
                keytotalText.text = "Keys: $keys"
            }
        }

    }

    private fun blockSystem() {
        blockingIsActive = true
        enemyTurn()
        dialogOn()
        dialogue.text = "You blocked this turn"
        textScreen = "EnemyTurn"
        dialogue.visibility = View.VISIBLE
    }

private fun nextRoomGeneration() {
    if (currentMonster == "neutralGhost" || currentMonster == "fireGhost"|| currentMonster == "waterGhost"|| currentMonster == "grassGhost") {
        ghostEnemy.visibility = View.GONE
    } else if (currentMonster == "neutralSkeleton" || currentMonster == "fireSkeleton"|| currentMonster == "waterSkeleton"|| currentMonster == "grassSkeleton") {
        skeletonEnemy.visibility = View.GONE
    }else if (currentMonster == "neutralSpider" || currentMonster == "fireSpider"|| currentMonster == "waterSpider"|| currentMonster == "grassSpider") {
        spiderEnemy.visibility = View.GONE
    } else if (currentMonster == "neutralGremlin" || currentMonster == "fireGremlin"|| currentMonster == "waterGremlin"|| currentMonster == "grassGremlin") {
        gremlinEnemy.visibility = View.GONE
    } else if (currentMonster == "restraingOrder") {
        restrainingOrder.visibility = View.GONE
    }

sanctuaryCalculation = roomNumber + 1


    if (sanctuaryCalculation == 10) {
        randomRoom.setImageResource(R.drawable.sanctuary)

        dialogOn()
        dialogue.text = "Push A for a blessing"
        dialogue.visibility = View.VISIBLE
        gremlinEnemy.visibility = View.GONE
        ghostEnemy.visibility = View.GONE
        skeletonEnemy.visibility = View.GONE
        spiderEnemy.visibility = View.GONE
        restrainingOrder.visibility = View.GONE
        shopKeeper.visibility = View.GONE
        healthTower.visibility = View.VISIBLE
        textScreen = "Sanctuary"
        roomNumber += 1
        roomText.text = "Room: \n $roomNumber"

    } else if (sanctuaryCalculation == 20) {
        randomRoom.setImageResource(R.drawable.sanctuary)
        dialogOn()
        dialogue.text = "Push A for a blessing"
        dialogue.visibility = View.VISIBLE
        gremlinEnemy.visibility = View.GONE
        ghostEnemy.visibility = View.GONE
        skeletonEnemy.visibility = View.GONE
        spiderEnemy.visibility = View.GONE
        restrainingOrder.visibility = View.GONE
        shopKeeper.visibility = View.GONE
        healthTower.visibility = View.VISIBLE


        textScreen = "Sanctuary"
        roomNumber += 1
        roomText.text = "Room: \n $roomNumber"
    } else if (sanctuaryCalculation == 30) {
        randomRoom.setImageResource(R.drawable.sanctuary)
        dialogOn()
        dialogue.text = "Push A for a blessing"
        dialogue.visibility = View.VISIBLE
        gremlinEnemy.visibility = View.GONE
        ghostEnemy.visibility = View.GONE
        skeletonEnemy.visibility = View.GONE
        spiderEnemy.visibility = View.GONE
        restrainingOrder.visibility = View.GONE
        shopKeeper.visibility = View.GONE
        healthTower.visibility = View.VISIBLE
        textScreen = "Sanctuary"
        roomNumber += 1
        roomText.text = "Room: \n $roomNumber"
        } else if (sanctuaryCalculation == 30) {
        randomRoom.setImageResource(R.drawable.sanctuary)
        dialogOn()
        dialogue.text = "Push A for a blessing"
        dialogue.visibility = View.VISIBLE
        gremlinEnemy.visibility = View.GONE
        ghostEnemy.visibility = View.GONE
        skeletonEnemy.visibility = View.GONE
        spiderEnemy.visibility = View.GONE
        restrainingOrder.visibility = View.GONE
        shopKeeper.visibility = View.GONE
        healthTower.visibility = View.VISIBLE
        textScreen = "Sanctuary"
        roomNumber += 1
        roomText.text = "Room: \n $roomNumber"
    } else if (sanctuaryCalculation == 40) {
        randomRoom.setImageResource(R.drawable.sanctuary)
        dialogOn()
        dialogue.text = "Push A for a blessing"
        dialogue.visibility = View.VISIBLE
        gremlinEnemy.visibility = View.GONE
        ghostEnemy.visibility = View.GONE
        skeletonEnemy.visibility = View.GONE
        spiderEnemy.visibility = View.GONE
        restrainingOrder.visibility = View.GONE
        shopKeeper.visibility = View.GONE
        healthTower.visibility = View.VISIBLE
        textScreen = "Sanctuary"
        roomNumber += 1
        roomText.text = "Room: \n $roomNumber"
    } else if (sanctuaryCalculation == 50) {
        randomRoom.setImageResource(R.drawable.sanctuary)
        dialogOn()
        dialogue.text = "Push A for a blessing"
        dialogue.visibility = View.VISIBLE
        gremlinEnemy.visibility = View.GONE
        ghostEnemy.visibility = View.GONE
        skeletonEnemy.visibility = View.GONE
        spiderEnemy.visibility = View.GONE
        restrainingOrder.visibility = View.GONE
        shopKeeper.visibility = View.GONE
        healthTower.visibility = View.VISIBLE
        textScreen = "Sanctuary"
        roomNumber += 1
        roomText.text = "Room: \n $roomNumber"
    }else if (sanctuaryCalculation == 60) {
        randomRoom.setImageResource(R.drawable.sanctuary)
        dialogOn()
        dialogue.text = "Push A for a blessing"
        dialogue.visibility = View.VISIBLE
        gremlinEnemy.visibility = View.GONE
        ghostEnemy.visibility = View.GONE
        skeletonEnemy.visibility = View.GONE
        spiderEnemy.visibility = View.GONE
        restrainingOrder.visibility = View.GONE
        shopKeeper.visibility = View.GONE
        healthTower.visibility = View.VISIBLE
        textScreen = "Sanctuary"
        roomNumber += 1
        roomText.text = "Room: \n $roomNumber"
    }else if (sanctuaryCalculation == 70) {
        randomRoom.setImageResource(R.drawable.sanctuary)
        dialogOn()
        dialogue.text = "Push A for a blessing"
        dialogue.visibility = View.VISIBLE
        gremlinEnemy.visibility = View.GONE
        ghostEnemy.visibility = View.GONE
        skeletonEnemy.visibility = View.GONE
        spiderEnemy.visibility = View.GONE
        restrainingOrder.visibility = View.GONE
        shopKeeper.visibility = View.GONE
        healthTower.visibility = View.VISIBLE
        textScreen = "Sanctuary"
        roomNumber += 1
        roomText.text = "Room: \n $roomNumber"
    }else if (sanctuaryCalculation == 80) {
        randomRoom.setImageResource(R.drawable.sanctuary)
        dialogOn()
        dialogue.text = "Push A for a blessing"
        dialogue.visibility = View.VISIBLE
        gremlinEnemy.visibility = View.GONE
        ghostEnemy.visibility = View.GONE
        skeletonEnemy.visibility = View.GONE
        spiderEnemy.visibility = View.GONE
        restrainingOrder.visibility = View.GONE
        shopKeeper.visibility = View.GONE
        healthTower.visibility = View.VISIBLE
        textScreen = "Sanctuary"
        roomNumber += 1
        roomText.text = "Room: \n $roomNumber"
    }else if (sanctuaryCalculation == 90) {
        randomRoom.setImageResource(R.drawable.sanctuary)
        dialogOn()
        dialogue.text = "Push A for a blessing"
        dialogue.visibility = View.VISIBLE
        gremlinEnemy.visibility = View.GONE
        ghostEnemy.visibility = View.GONE
        skeletonEnemy.visibility = View.GONE
        spiderEnemy.visibility = View.GONE
        restrainingOrder.visibility = View.GONE
        shopKeeper.visibility = View.GONE
        healthTower.visibility = View.VISIBLE
        textScreen = "Sanctuary"
        roomNumber += 1
        roomText.text = "Room: \n $roomNumber"
    } else if (sanctuaryCalculation == 100) {
        randomRoom.setImageResource(R.drawable.sanctuary)
        dialogOn()
        dialogue.text = "Push A for a blessing"
        dialogue.visibility = View.VISIBLE
        gremlinEnemy.visibility = View.GONE
        ghostEnemy.visibility = View.GONE
        skeletonEnemy.visibility = View.GONE
        spiderEnemy.visibility = View.GONE
        restrainingOrder.visibility = View.GONE
        shopKeeper.visibility = View.GONE
        healthTower.visibility = View.VISIBLE
        textScreen = "Sanctuary"
        roomNumber += 1
        roomText.text = "Room: \n $roomNumber"
    }
    else {
        nextRoomNumber = Random.nextInt(1, 5)

        when (nextRoomNumber) {
            1 -> {
                randomRoom.setImageResource(R.drawable.roomone)
            }

            2 -> {
                randomRoom.setImageResource(R.drawable.roomtwo)
            }

            3 -> {
                randomRoom.setImageResource(R.drawable.roomthree)
            }

            4 -> {
                randomRoom.setImageResource(R.drawable.roomfour)
            }

            5 -> {
                randomRoom.setImageResource(R.drawable.roomfive)
            }
        }

        roomNumber += 1

        roomText.text = "Room: \n $roomNumber"
        shopChance = Random.nextInt(1, 10)

        if (shopChance == 10) {
            shopIshere = true
        } else {
            shopIshere = false
        }


        randomMonsterNumber = Random.nextInt(1,17)

        when (randomMonsterNumber) {
            1 -> {
                currentMonster = "neutralGhost"
                currentSpecies = "Ghost"
                enemyHealth = roomNumber + 1
                enemyElement = "Neutral"
                enemyState = "Idle"
                ghostEnemy.setImageResource(R.drawable.ghostnidle)
                ghostEnemy.visibility = View.VISIBLE
            }
            2 -> {
                currentMonster = "fireGhost"
                currentSpecies = "Ghost"
                enemyHealth = roomNumber + 1
                enemyElement = "Fire"
                enemyState = "Idle"
                ghostEnemy.setImageResource(R.drawable.ghostfidle)
                ghostEnemy.visibility = View.VISIBLE
            }
            3 -> {
                currentMonster = "waterGhost"
                currentSpecies = "Ghost"
                enemyHealth = roomNumber + 1
                enemyElement = "Water"
                enemyState = "Idle"
                ghostEnemy.setImageResource(R.drawable.ghostwidle)
                ghostEnemy.visibility = View.VISIBLE
            }
            4 -> {
                currentMonster = "grassGhost"
                currentSpecies = "Ghost"
                enemyHealth = roomNumber + 1
                enemyElement = "Grass"
                enemyState = "Idle"
                ghostEnemy.setImageResource(R.drawable.ghostgidle)
                ghostEnemy.visibility = View.VISIBLE
            }
            5 -> {
                currentMonster = "neutralSkeleton"
                currentSpecies = "Skeleton"
                enemyHealth = roomNumber + 1
                enemyElement = "Neutral"
                enemyState = "Idle"
                skeletonEnemy.setImageResource(R.drawable.skellynidle)
                skeletonEnemy.visibility = View.VISIBLE
            }
            6 -> {
                currentMonster = "fireSkeleton"
                currentSpecies = "Skeleton"
                enemyHealth = roomNumber + 1
                enemyElement = "Fire"
                enemyState = "Idle"
                skeletonEnemy.setImageResource(R.drawable.skellyfidle)
                skeletonEnemy.visibility = View.VISIBLE
            }
            7 -> {
                currentMonster = "waterSkeleton"
                currentSpecies = "Skeleton"
                enemyHealth = roomNumber + 1
                enemyElement = "Water"
                enemyState = "Idle"
                skeletonEnemy.setImageResource(R.drawable.skellywidle)
                skeletonEnemy.visibility = View.VISIBLE
            }
            8 -> {
                currentMonster = "grassSkeleton"
                currentSpecies = "Skeleton"
                enemyHealth = roomNumber + 1
                enemyElement = "Grass"
                enemyState = "Idle"
                skeletonEnemy.setImageResource(R.drawable.skellygidle)
                skeletonEnemy.visibility = View.VISIBLE
            }
            9 -> {
                currentMonster = "neutralGremlin"
                currentSpecies = "Gremlin"
                enemyHealth = roomNumber + 1
                enemyElement = "Neutral"
                enemyState = "Idle"
                gremlinEnemy.setImageResource(R.drawable.gremmynidle)
                gremlinEnemy.visibility = View.VISIBLE
            }
            10 -> {
                currentMonster = "fireGremlin"
                currentSpecies = "Gremlin"
                enemyHealth = roomNumber + 1
                enemyElement = "Fire"
                enemyState = "Idle"
                gremlinEnemy.setImageResource(R.drawable.gremmyfidle)
                gremlinEnemy.visibility = View.VISIBLE
            }
            11 -> {
                currentMonster = "waterGremlin"
                currentSpecies = "Gremlin"
                enemyHealth = roomNumber + 1
                enemyElement = "Water"
                enemyState = "Idle"
                gremlinEnemy.setImageResource(R.drawable.gremmywidle)
                gremlinEnemy.visibility = View.VISIBLE
            }
            12 -> {
                currentMonster = "grassGremlin"
                currentSpecies = "Gremlin"
                enemyHealth = roomNumber + 1
                enemyElement = "Grass"
                enemyState = "Idle"
                gremlinEnemy.setImageResource(R.drawable.gremmygidle)
                gremlinEnemy.visibility = View.VISIBLE
            }
            13 -> {
                currentMonster = "neutralSpider"
                currentSpecies = "Spider"
                enemyHealth = roomNumber + 1
                enemyElement = "Neutral"
                enemyState = "Idle"
                spiderEnemy.setImageResource(R.drawable.spidernidle)
                spiderEnemy.visibility = View.VISIBLE
            }
            14 -> {
                currentMonster = "fireSpider"
                currentSpecies = "Spider"
                enemyHealth = roomNumber + 1
                enemyElement = "Fire"
                enemyState = "Idle"
                spiderEnemy.setImageResource(R.drawable.spiderfidle)
                spiderEnemy.visibility = View.VISIBLE
            }
            15 -> {
                currentMonster = "waterSpider"
                currentSpecies = "Spider"
                enemyHealth = roomNumber + 1
                enemyElement = "Water"
                enemyState = "Idle"
                spiderEnemy.setImageResource(R.drawable.spiderwidle)
                spiderEnemy.visibility = View.VISIBLE
            }
            16 -> {
                currentMonster = "grassSpider"
                currentSpecies = "Spider"
                enemyHealth = roomNumber + 1
                enemyElement = "Grass"
                enemyState = "Idle"
                spiderEnemy.setImageResource(R.drawable.spidergidle)
                spiderEnemy.visibility = View.VISIBLE
            }
            17 -> {
                currentMonster = "restrainingOrder"
                currentSpecies = "Restrain"
                enemyHealth = roomNumber + 1
                enemyElement = "Neutral"
                enemyState = "Idle"
                restrainingOrder.setImageResource(R.drawable.restrainidle)
                restrainingOrder.visibility = View.VISIBLE
            }
        }
    }
}

}