package Character

class Character {

  var beam: Int = 10
  var defense: Int = 60
  var spiritBeam: Int = 50
  var spiritShield: Int = 100
  var hp: Int = 300
  var health: Int = hp
  var mp: Int = 400
  var magicPoints: Int = mp
  var dead: Boolean = true
  def takeDamage(damage: Int): Unit = {
    hp = hp - damage
    if((hp - damage) <= 0){
      dead = true
    }
    else{
      dead = false
    }
  }
  def attack(player2: Character, defense: Int): Unit = {
    if(player2.defense < this.beam){
      takeDamage(this.beam)
    }
  }
  def spiritAttack(player2: Character, spiritDefense: Int): Unit = {
    if(player2.spiritShield < this.spiritBeam){
      takeDamage(this.spiritBeam)
      mp = mp - 50
    }
    if(mp == 0){
      spiritBeam = 0
    }
  }





}
