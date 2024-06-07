package mortalkombatbversion.Game;

import mortalkombatbversion.Components.GameCharacter;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Location {

    private int currentLocation = 1;
    private int currentEnemyNumber = 0;
    private ArrayList<GameCharacter> currentEnemiesList = new ArrayList<>();
    private GameCharacter[] fullEnemiesList = null;
    private int locationSize;

    public void setFullEnemiesList(GameCharacter[] list) {
        fullEnemiesList = list;
    }

    public ArrayList<GameCharacter> getCurrentEnemies() {
        return currentEnemiesList;
    }

    public void setCurrentEnemies(int maxEnemies) {
        currentEnemiesList = new ArrayList<>();
        locationSize = 1 + (int) (Math.random() * maxEnemies);
        for (int i = 0; i < locationSize; i++) {
            GameCharacter enemy = getRandomEnemy();
            currentEnemiesList.add(enemy);
        }
    }

    public static final int MAX_ENEMIES = 4;
    public static final int DEFAULT_ENEMY_INDEX = 4;

    private GameCharacter getRandomEnemy() {
        int enemyIndex = (int) (Math.random() * MAX_ENEMIES);
        GameCharacter enemy = fullEnemiesList[enemyIndex];
        setEnemyPhoto(enemy);
        return enemy;
    }

    private void setEnemyPhoto(GameCharacter enemy) {
        File f = new File(System.getProperty("java.class.path"));
        File dir = f.getAbsoluteFile().getParentFile();
        String path = dir.toString();
        enemy.setPhoto(String.format("%s%s.jpg",path,"/"+enemy.getStringName()));
    }

    public void resetLocation(boolean isNextLocation, int maxEnemies) {
        if (isNextLocation) {
            currentLocation += 1;
            currentEnemyNumber = 0;
            setCurrentEnemies(maxEnemies);
        } else {
            currentLocation = 1;
            currentEnemyNumber = 0;
            setCurrentEnemies(0);
        }
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public int getCurrentEnemyNumber() {
        return currentEnemyNumber;
    }

    public GameCharacter getCurrentEnemy() {
        GameCharacter enemy;
        if (currentEnemyNumber != locationSize) {
            currentEnemyNumber += 1;
            return currentEnemiesList.get(currentEnemyNumber - 1);
        } else {
            currentEnemyNumber = 0;
            enemy = fullEnemiesList[DEFAULT_ENEMY_INDEX];
            setEnemyPhoto(enemy);
            return enemy;
        }
    }
}