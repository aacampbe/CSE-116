package Character
abstract class Character(var location: PhysicsVector) {
  var warriors: Map[String, Warrior] = Map()
  var wizards: Map[String, Wizard] = Map()
  var beam: Int = 10
  var defense: Int = 60
  var spiritBeam: Int = 50
  var spiritShield: Int = 100
  var hp: Int = 300
  var health: Int = hp
  var mp: Int = 400
  var magicPoints: Int = mp
  var alive: Boolean = true
  var exp: Int = 0
  var level: Int = 0
  def takeDamage(damage: Int): Unit = {
    health = health - damage
    if(health <= 0){
      alive = false
    }
    else{
      alive = true
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
      this.magicPoints = this.magicPoints - 50
    }
    if(mp == 0){
      spiritBeam = 0
    }
  }
  def gainExp(player2: Character): Unit = {
    if(!player2.alive){
      this.exp += 100
    }
  }
  def nextLevel(): Unit = {
    this.level = (this.exp * .01).toInt
  }
  def battleOptions(): List[String]
  def takeAction(action: String, character: Character): Unit
}