package Minesweaper;

import java.util.Random;
import java.util.Scanner;

public class Minesweaper {
    int column;
    int row;
    String[][] map;
    String[][] board;
    int size;
    boolean game=true;
    Random rand=new Random();
    Scanner s=new Scanner(System.in);
    Minesweaper(int row,int column){
        this.column=column;
        this.row=row;
        this.map=new String[row][column];
        this.board=new String[row][column];
        this.size=this.row*this.column;
    }
    public void run(){
        int r,c;
        int success=0;
        game();
        print(map);
        System.out.println("============");
        while(game){
            print(board);
            System.out.print("Satır girin:");
            r=s.nextInt();
            System.out.print("Sütun girin:");
            c=s.nextInt();
            if(r<0||r>row){
                System.out.println("Geçersiz Kordinat");
                continue;
            }
            if(!map[r][c].equals("*")){
                checkMine(r,c);
                success++;
                if(success==(size-(size/4))){
                    System.out.println("VİCTORY");
                    break;
                }
            }else{
                game=false;
                System.out.println("Game over");
            }
        }

    }
    public void checkMine(int r,int c){
        int mine=0;
        for(int i=r-1;i<=r+1;i++){
            for(int j=c-1;j<=c+1;j++){
                if(i>4||i<0||j>4||j<0){
                    continue;
                }else{
                if(map[i][j].equals("*")){
                    mine++;
                }else{
                    continue;
                }
            }
            }
        }
        switch(mine){
            case 1:board[r][c]="1";
            break;
            case 2:board[r][c]="2";
            break;
            case 3:board[r][c]="3";
            break;
            case 4:board[r][c]="4";
            break;
            case 5:board[r][c]="5";
            break;
            case 6:board[r][c]="6";
            break;
            case 7:board[r][c]="7";
            break;
            case 8:board[r][c]="8";
            break;
            default:board[r][c]="0";
            break;
        }
    }
    public void game(){
        int minesPlaced=0;
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.column;j++){
                board[i][j]="-";
            }
        }
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.column;j++){
                map[i][j]="-";
            }
        }
        while(minesPlaced!=(this.size/4)){
            int x = rand.nextInt(row);
            int y = rand.nextInt(column);
            if (map[x][y]=="-") {
                map[x][y] = "*";
                minesPlaced++;
            }else{
                continue;
            }
            

        }
    }
    public void print(String[][] arr){
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.column;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
