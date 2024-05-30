/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mortalkombatbversion.Characters.Character;
import mortalkombatbversion.Characters.Player;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Мария
 */
public class Game {

    CharacterAction action = new CharacterAction();
    ChangeTexts change = new ChangeTexts();
    Fight fight = new Fight();
    private final ArrayList<Result> results = new ArrayList<>();

    public Character NewEnemy(JLabel L1, JLabel L2,
                              JLabel L3, JLabel L4, JProgressBar pr2) {
        action.setEnemyes();
        Character enemy = action.ChooseEnemy(L1, L2, L3, L4);
        action.HP(enemy, pr2);
        pr2.setMaximum(enemy.getMaxHealth());
        return enemy;
    }
    
    public Player NewHuman(JProgressBar pr1){
        Player player = new Player(0,80,16,1);
        action.HP(player, pr1);
        pr1.setMaximum(player.getMaxHealth());
        return player;
    }

    public void EndGameTop(Player player, JTextField text, JTable table) throws IOException {
        results.add(new Result(text.getText(), player.getPoints()));
        results.sort(Comparator.comparing(Result::getPoints).reversed());
        WriteToTable(table);
        WriteToExcel();
    }
    
    public void WriteToExcel() throws IOException{
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Результаты ТОП 10");
        XSSFRow r = sheet.createRow(0);
        r.createCell(0).setCellValue("№");
        r.createCell(1).setCellValue("Имя");
        r.createCell(2).setCellValue("Количество баллов");
        for (int i=0; i<results.size();i++){
            if (i<10){
                XSSFRow r2 = sheet.createRow(i+1);
                r2.createCell(0).setCellValue(i+1);
                r2.createCell(1).setCellValue(results.get(i).getName());
                r2.createCell(2).setCellValue(results.get(i).getPoints());
            }
        }
        File f = new File("Results.xlsx");
        book.write(new FileOutputStream(f));
        book.close();
    }
    
    public ArrayList<Result> getResults(){
        return this.results;
    }

    public void ReadFromExcel() throws IOException{
      try {
          XSSFWorkbook book = new XSSFWorkbook("Results.xlsx");
          XSSFSheet sh = book.getSheetAt(0);
          for (int i = 1; i <= sh.getLastRowNum(); i++) {
              results.add(new Result(sh.getRow(i).getCell(1).getStringCellValue(), (int) sh.getRow(i).getCell(2).getNumericCellValue()));
          }
      }catch (IOException e){
          e.printStackTrace();
      }
    }
    
    public void WriteToTable(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        for (int i=0; i<results.size();i++){
            if (i<10){
                model.setValueAt(results.get(i).getName(), i, 0);
                model.setValueAt(results.get(i).getPoints(), i, 1);
            }
        }
    }
}
