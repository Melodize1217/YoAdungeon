package com.alora.yoadungeon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

    internal lateinit var dialogue: TextView




    var roomNumber = 1
    var nextRoomNumber = 2
    var nextMonster = "placeholder"
    var nextRoom = "placeholder"
    var element = "neutral"
    var health = 10
    var mana = 10
    var coins = 100
    var keys = 1
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

    var dialogSetting = "Filler"

    var shopDebugCode = "Down"
    var shopDebugActive = false


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

                    healthPselected.visibility = View.VISIBLE
                    confusePUnselected.visibility = View.VISIBLE
                    manaPUnselected.visibility = View.VISIBLE
                    chainUnselected.visibility = View.VISIBLE
                    textScreen = "Items"
                    selectedText = "Health"
                } else if (selectedText == "Attack") {
                    Toast.makeText(this, "You attack the enemy", Toast.LENGTH_SHORT).show()
                } else if (selectedText == "Block") {
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
                } else {
                    Toast.makeText(this, "Oof no keys guess you gotta say no", Toast.LENGTH_SHORT).show()
                }
            } else if (textScreen == "Shop") {
                if (selectedText == "HealthShop") {
                    if (coins >= 3) {
                        healthPamount += 1
                        coins -= 3
                    }
                } else if (selectedText == "ManaShop") {
                    if (coins >= 5) {
                        manaPamount += 1
                        coins -= 5
                    }
                } else if (selectedText == "ConfuseShop") {
                    if (coins >= 7) {
                        confusePamount += 1
                        coins -= 7
                    }
                } else if (selectedText == "ChainShop") {
                    if (coins >= 10) {
                        confusePamount += 1
                        coins -= 10
                    }
                }
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
            } else {
                shopDebugCode = "Down"
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

                magicselected.visibility = View.VISIBLE
                itemsUnselected.visibility = View.VISIBLE
                attackUnselected.visibility = View.VISIBLE
                blockUnselected.visibility = View.VISIBLE

                textScreen = "Base"
                selectedText = "Attack"


                //Go back to random room in queue
            } else if (textScreen == "Shop") {
                //This should go to the next random room in the queue

                magicselected.visibility = View.VISIBLE
                itemsUnselected.visibility = View.VISIBLE
                attackUnselected.visibility = View.VISIBLE
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

            }

            if (shopDebugCode == "B") {
                shopDebugCode = "A"
            } else {
                shopDebugCode = "Down"
            }
        }
    }
}