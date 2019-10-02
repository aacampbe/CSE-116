package Character
class Party(characters: List[Character]) {
  def charactersDefeat(enemies: List[Character]): Unit = {
    for(character <- characters){
      for(enemy <- enemies){
        if(enemies.forall(enemy => !enemy.alive)){
          character.exp = character.exp + (enemy.exp / characters.count(character => character.alive))
        }
      }
    }
  }
}
