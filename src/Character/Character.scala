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
  def attack(player2: Character, Defense: Int): Unit = {
    if(Defense < this.beam){
      player2.takeDamage(this.beam)
    }
  }
  def spiritAttack(player2: Character, spiritDefense: Int): Unit = {
    if(spiritDefense < this.spiritBeam){
      player2.takeDamage(this.spiritBeam)
      this.mp = this.mp - 50
    }
    if(mp == 0){
      spiritBeam = 0
    }
  }
}
