package tests

import Character.Character
import org.scalatest._

class TestCharacter extends FunSuite {
  test(" Test Character Class"){
    val player: Character = new Character
    val player2: Character = new Character
    player.takeDamage(player2.beam)
    assert(player.hp == 290)
    val lethal: Int = 310
    player.takeDamage(lethal)
    assert(player.dead === true)
  }
}
