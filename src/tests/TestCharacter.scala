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
    val defense: Int = 5
    player.attack(player2, defense)
    assert(player2.hp == 290)
    val spiritDefense: Int = 40
    player.spiritAttack(player2, spiritDefense)
    assert(player2.hp == 240)
    assert(player.mp == 350)
  }
}
