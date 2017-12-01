package edu.harding.pokemonteambuilder

class Move {

    var name: String? = null
    var effect: Boolean? = null
    var physical: Boolean? = null
    var flavorText: String? = null
    var power: Int = 0
    var accuracy: Int = 0
    var learnLevel: Int = 0

    constructor(name: String, flavorText: String, accuracy: Int) {
        this.name = name
        effect = true
        physical = null
        this.flavorText = flavorText
        power = 0
        this.accuracy = accuracy
    }

    constructor(name: String, physical: Boolean?, flavorText: String, power: Int, accuracy: Int) {
        this.name = name
        effect = false
        this.physical = physical
        this.flavorText = flavorText
        this.power = power
        this.accuracy = accuracy
    }

    constructor(name: String, flavorText: String, accuracy: Int, learnLevel: Int) {
        this.name = name
        effect = true
        physical = null
        this.flavorText = flavorText
        power = 0
        this.accuracy = accuracy
        this.learnLevel = learnLevel
    }

    constructor(name: String, physical: Boolean?, flavorText: String,
                power: Int, accuracy: Int, learnLevel: Int) {
        this.name = name
        effect = false
        this.physical = physical
        this.flavorText = flavorText
        this.power = power
        this.accuracy = accuracy
        this.learnLevel = learnLevel
    }


}
