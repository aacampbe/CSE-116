package tests
import Character.Character
import Character.Party
import org.scalatest._
class TestParty extends FunSuite {
  test("Test Party Class") {
    val lethal: Int = 310
    val dummy: Character = new Character
    val dummy2: Character = new Character
    val dummy3: Character = new Character
    val enemy1: Character = new Character
    val enemy2: Character = new Character
    val enemy3: Character = new Character
    val hero: Character = new Character
    val hero2: Character = new Character
    val hero3: Character = new Character
    dummy.takeDamage(lethal)
    dummy2.takeDamage(lethal)
    dummy3.takeDamage(lethal)
    enemy1.gainExp(dummy)
    enemy2.gainExp(dummy2)
    enemy3.gainExp(dummy3)
    enemy1.takeDamage(lethal)
    enemy2.takeDamage(lethal)
    enemy3.takeDamage(lethal)
    val enemies: List[Character] = List(enemy1, enemy2, enemy3)
    val heroes: List[Character] = List(hero, hero2, hero3)
    val party: Party = new Party(heroes)
    party.charactersDefeat(enemies)
    for(character <- heroes){
      assert(hero.exp == 99)
    }
  }
}
