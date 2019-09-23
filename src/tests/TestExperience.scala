package tests
import Character.Character
import org.scalatest._
class TestExperience extends FunSuite {
  test("Test Exp"){
    var player: Character = new Character
    var player2: Character = new Character
    val lethal: Int = 310
    player2.takeDamage(lethal)
    player.gainExp(player2)
    player.nextLevel()
    assert(player.exp == 100)
    assert(player.level == 1)

  }

}
