package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MobTest {
    Mob skeleton;
    Mob zombie;

    @BeforeEach
    public void setup() {
        skeleton = new Mob("skeleton", 20, 2);
        zombie = new Mob("zombie", 15, 3);
    }

    @Test
    public void getNameReturnsName() {
        assertEquals("skeleton", skeleton.getName());
        assertEquals("zombie", zombie.getName());
    }

    @Test
    public void getMaxHealthReturnsMaxHealth() {
        assertEquals(20, skeleton.getMaxHealth());
        assertEquals(15, zombie.getMaxHealth());
    }

    @Test
    public void getHealthReturnsMaxHealth() {
        assertEquals(20, skeleton.getHealth());
        assertEquals(15, zombie.getHealth());
    }

    @Test
    public void getHealthReturnsInjuredHealth() {
        skeleton.takeDamage(10);
        zombie.takeDamage(10);
        assertEquals(10, skeleton.getHealth());
        assertEquals(5, zombie.getHealth());
    }

    @Test
    public void getHealthReturnsDeadHealth() {
        skeleton.takeDamage(20);
        zombie.takeDamage(15);
        assertEquals(0, skeleton.getHealth());
        assertEquals(0, zombie.getHealth());
    }

    @Test
    public void toStringWorksWhenHealthy() {
        assertEquals("healthy skeleton", skeleton.toString());
        assertEquals("healthy zombie", zombie.toString());
    }

    @Test
    public void toStringWorksWhenInjured() {
        skeleton.takeDamage(10);
        zombie.takeDamage(10);
        assertEquals("injured skeleton", skeleton.toString());
        assertEquals("injured zombie", zombie.toString());
    }

    @Test
    public void toStringWorksWhenDead() {
        skeleton.takeDamage(20);
        zombie.takeDamage(15);
        assertEquals("dead skeleton", skeleton.toString());
        assertEquals("dead zombie", zombie.toString());
    }

    @Test
    public void equalsReturnTrueSamePassObj() {
        assertEquals(true, zombie.equals(zombie));
        assertEquals(true, skeleton.equals(skeleton));
    }

    @Test
    public void equalsReturnFalseDifPassObj() {
        assertEquals(false, skeleton.equals(zombie));
        assertEquals(false, zombie.equals(skeleton));
    }

    @Test
    public void isInjuredMaxHealth() {
        assertEquals(false, skeleton.isInjured());
        assertEquals(false, zombie.isInjured());
    }

    @Test
    public void isInjuredInjured() {
        skeleton.takeDamage(10);
        zombie.takeDamage(10);
        assertEquals(true, skeleton.isInjured());
        assertEquals(true, zombie.isInjured());
    }

    @Test
    public void isInjuredDead() {
        skeleton.takeDamage(20);
        zombie.takeDamage(15);
        assertEquals(true, skeleton.isInjured());
        assertEquals(true, zombie.isInjured());
    }

    @Test
    public void isAliveReturnsTrueAlive() {
        assertEquals(true, skeleton.isAlive());
        assertEquals(true, zombie.isAlive());
    }

    @Test
    public void isAliveReturnsTrueInjured() {
        skeleton.takeDamage(10);
        zombie.takeDamage(10);
        assertEquals(true, skeleton.isAlive());
        assertEquals(true, zombie.isAlive());
    }

    @Test
    public void isAliveReturnsFalseDead() {
        skeleton.takeDamage(20);
        zombie.takeDamage(15);
        assertEquals(false, skeleton.isAlive());
        assertEquals(false, zombie.isAlive());
    }

    @Test
    public void getCurrentStrength() {
        assertEquals(2, skeleton.getCurrentStrength());
        assertEquals(3, zombie.getCurrentStrength());
    } // need to come back to write more test of more testing

    @Test
    public void getCurrentStrengthWhenDamaged() {
        skeleton.takeDamage(5);
        zombie.takeDamage(10);
        assertEquals(2, skeleton.getCurrentStrength());
        assertEquals(1, zombie.getCurrentStrength());
    }

    @Test
    public void takeDamageTestDamageLessThanHealth() {
        skeleton.takeDamage(15);
        assertEquals(5, skeleton.getHealth());
    }
    @Test
    public void takeDamageTestDamageGreaterThanHealth() {
        zombie.takeDamage(50000);
        assertEquals(0, zombie.getHealth());
    }

    @Test
    public void attackWontLetMobAttackItself() {
        assertEquals("A mob cannot attack itself!", skeleton.attack(skeleton));
        assertEquals("A mob cannot attack itself!", zombie.attack(zombie));
    }

    @Test
    public void attackRejectsDeadAttacker() {
        // Kill skeleton.
        skeleton.takeDamage(skeleton.getMaxHealth());

        assertEquals("The dead skeleton cannot attack the healthy zombie.",
                skeleton.attack(zombie));
    }

    @Test
    public void attackRejectsDeadVictim() {
        // Kill zombie.
        zombie.takeDamage(zombie.getMaxHealth());
        assertEquals("The zombie is already dead.",
                skeleton.attack(zombie));
    }

    @Test
    public void attackDamagesOpponent() {
        String description = skeleton.attack(zombie);
        int expectedHealth = zombie.getMaxHealth() - skeleton.getCurrentStrength();
        String expectedResponse = "The skeleton does " + skeleton.getCurrentStrength()
                + " damage to the zombie, which now has health " + expectedHealth + ".";
        assertEquals(expectedResponse, description);
        assertEquals(expectedHealth, zombie.getHealth());
    }

    @Test
    public void attackDoesNotDamageAttacker() {
        skeleton.attack(zombie);
        assertEquals(skeleton.getMaxHealth(), skeleton.getHealth());
    }

    @Test
    public void attackDamagesVictim() {
        skeleton.attack(zombie);
        assertEquals(zombie.getMaxHealth() - skeleton.getCurrentStrength(), zombie.getHealth());
    }

    @Test
    public void attackKillsVictim() {
        // Weaken zombie so one attack will finish it.
        zombie.takeDamage(zombie.getMaxHealth() - skeleton.getCurrentStrength());

        String description = skeleton.attack(zombie);
        assertEquals(description,
                "The skeleton does " + skeleton.getCurrentStrength() + " damage to the zombie, which is now dead.");
        assertEquals(0, zombie.getHealth());
        assertFalse(zombie.isAlive());
    }

    @Test
    public void attackDoesNotMakeVictimsHealthNegative() {
        // Weaken zombie so it has just one health point remaining.
        zombie.takeDamage(zombie.getMaxHealth() - 1);

        String description = skeleton.attack(zombie);
        assertEquals(description,
                "The skeleton does 1 damage to the zombie, which is now dead.");
        assertEquals(0, zombie.getHealth());
        assertFalse(zombie.isAlive());
    }
}