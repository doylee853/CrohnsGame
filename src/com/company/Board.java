package com.company;

/*import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Board extends JPanel implements ActionListener{
    private Image background;

    public Board() {
        initBoard();
    }

    private void initBoard(){

        addKeyListener(new TAdapter());
        //int w = background.getWidth(this);
        //int h = background.getHeight(this);
        //setPreferredSize(new Dimension(w, h));
        //setPreferredSize(new Dimension(800, 500));
    }

    private void startScreen(Graphics g){
        String msg = "Zap the Map!";
        Font small = new Font("Helvitica", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.RED);
        g.setFont(small);
        g.drawString(msg, 500 - metr.stringWidth(msg) / 2, 500 / 2);
    }

}*/

import java.applet.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 700;
    private final int B_HEIGHT = 700;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 7000;
    private final int RAND_POS = 69;
    private final int DELAY = 30;

    private final int[] x = new int[ALL_DOTS];
    private final int[] y = new int[ALL_DOTS];
    private final int[] zapX = new int[ALL_DOTS];
    private final int[] zapY = new int[ALL_DOTS];
    private final int[] zapX2 = new int[ALL_DOTS];
    private final int[] zapY2 = new int[ALL_DOTS];
    private final int[] zapX3 = new int[ALL_DOTS];
    private final int[] zapY3 = new int[ALL_DOTS];

    private boolean crazy = true;


    private boolean start = true;
    private boolean mainStart = true;
    private boolean start0 = false;
    private boolean start1 = false;
    private boolean start2 = false;
    private boolean start3 = false;
    private boolean start4 = false;
    private boolean start5 = false;

    private boolean game2 = false;

    private int dots;
    private int apple_x;
    private int apple_y;
    private int map_x;
    private int map_y;
    private int map_x2;
    private int map_y2;
    private int map_x3;
    private int map_y3;
    private int map_x4;
    private int map_y4;
    private int map_x5;
    private int map_y5;
    private int rbc_x;
    private int rbc_y;
    private int rbc_x2;
    private int rbc_y2;
    private int wbc_x;
    private int wbc_y;
    private int wbc_x2;
    private int wbc_y2;
    private int moveNum = 0;
    private int shoot_x;
    private int shoot_y;
    private int counter = 0;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;
    private boolean ap = false;
    private boolean mp = false;
    private boolean mp2 = false;
    private boolean mp3 = false;
    private boolean mp4 = false;
    private boolean mp5 = false;
    private boolean rb = false;
    private boolean rb2 = false;
    private boolean wb = false;
    private boolean wb2 = false;
    private boolean moveNumCheck = false;
    private boolean shoot = false;
    private boolean shoot2 = false;
    private boolean shoot3 = false;
    private boolean shootFirst = false;
    private boolean shootSecond = false;
    private boolean shootThird = false;

    private boolean redHit = false;
    private boolean whiteHit = false;

    private boolean instructions = false;
    private boolean info0 = false;
    private boolean info1 = false;
    private boolean info2 = false;
    private boolean info3 = false;
    private boolean info4 = false;
    private boolean info5 = false;

    private boolean stage1 = false;
    private boolean stage2 = false;
    private boolean stage3 = false;
    private boolean stage4 = false;
    private boolean stage5 = false;

    private boolean stage1C = false;
    private boolean stage2C = false;
    private boolean stage3C = false;
    private boolean stage4C = false;
    private boolean stage5C = false;
    private boolean finale = false;

    private boolean win = false;
    private boolean lose = false;

    private boolean storyScreen = false;




    private Timer timer;
    private Image ball;
    private Image head;

    private Image apple;
    private Image map;
    private Image map2;
    private Image map3;
    private Image map4;
    private Image map5;
    private Image rbc;
    private Image rbc2;
    private Image wbc;
    private Image wbc2;

    private Image infected;
    private int infected_x;
    private int infected_y;

    private Image bad;
    private int bad_x;
    private int bad_y;
    private Image bad1;
    private int bad_x1;
    private int bad_y1;
    private Image bad2;
    private int bad_x2;
    private int bad_y2;

    private Image heart;
    private Image heart2;
    private Image heart3;

    private boolean heart3B = true;
    private boolean heart2B = true;
    private boolean heartB = true;

    private boolean inUp = true;
    private boolean inDown = false;

    private boolean shootFinale = false;

    private int monsterHealth = 20;

    private Image poisonH;
    private Image emptyH;

    private boolean youWin = false;

    private int counter2 = 0;



    public Board() {

        initBoard();
    }

    private void initBoard() {

        if(!game2){
            addKeyListener(new TAdapter());
            setBackground(Color.GRAY);
            setFocusable(true);

            setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        }
        //addKeyListener(new TAdapter());

        //setBackground(Color.getHSBColor(100, 184, 153));

        //setBackground(Color.GRAY);
        //setFocusable(true);

        //setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {

        //ImageIcon player = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\MainBoyProto.png");

        ImageIcon iid = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\Lightning.png");
        ball = iid.getImage();


        ImageIcon purpleMAP = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\PurpleMAP.png");
/*        URL url = new URL("https://ibb.co/RT16Tf0");
        ImageIcon blueMap2 = ImageIO.read("https://ibb.co/RT16Tf0");*/
        ImageIcon blueMAP = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\BlueMAPC.png");
        ImageIcon redBloodCell = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\RedBloodCellC.png");
        ImageIcon whiteBloodCell = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\WhiteBloodCell.png");
        ImageIcon submarine = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\Submarine.png");

        if(counter == 0){

            apple = blueMAP.getImage();
            map = blueMAP.getImage();
            map2 = blueMAP.getImage();
            stage1 = true;
            stage1C = true;
            mp3 = true;
            mp4 = true;
            mp5 = true;
            shoot = false;
            shoot2 = false;
            shoot3 = false;
            shootFirst = false;
            shootSecond = false;
            shootThird = false;
            //counter++;
        }
        else if(info1 && start1){
            apple = blueMAP.getImage();
            map = blueMAP.getImage();
            map2 = purpleMAP.getImage();
            map3 = purpleMAP.getImage();
            map4 = purpleMAP.getImage();
            stage1C = false;
            stage2 = true;
            stage2C = true;
            ap = false;
            mp = false;
            mp2 = false;
            mp3 = false;
            mp4 = false;
            mp5 = true;
            shoot = false;
            shoot2 = false;
            shoot3 = false;
            shootFirst = false;
            shootSecond = false;
            shootThird = false;
            //counter++;
        }
        else if(info2 && start2){
            heart3B = true;
            heart2B = true;
            heartB = true;
            apple = blueMAP.getImage();
            map = blueMAP.getImage();
            map2 = blueMAP.getImage();
            map3 = purpleMAP.getImage();
            map4 = purpleMAP.getImage();
            map5 = purpleMAP.getImage();
            rbc = redBloodCell.getImage();
            rbc2 = redBloodCell.getImage();
            stage2C = false;
            stage3 = true;
            stage3C = true;
            ap = false;
            mp = false;
            mp2 = false;
            mp3 = false;
            mp4 = false;
            mp5 = false;
            shoot = false;
            shoot2 = false;
            shoot3 = false;
            shootFirst = false;
            shootSecond = false;
            shootThird = false;
            //counter++;
        }
        else if(info3 && start3){
            heart3B = true;
            heart2B = true;
            heartB = true;
            apple = blueMAP.getImage();
            map = blueMAP.getImage();
            map2 = blueMAP.getImage();
            map3 = purpleMAP.getImage();
            map4 = purpleMAP.getImage();
            map5 = purpleMAP.getImage();
            rbc = redBloodCell.getImage();
            rbc2 = redBloodCell.getImage();
            wbc = whiteBloodCell.getImage();
            wbc2 = whiteBloodCell.getImage();
            stage3C = false;
            stage4 = true;
            stage4C = true;
            ap = false;
            mp = false;
            mp2 = false;
            mp3 = false;
            mp4 = false;
            mp5 = false;
            shoot = false;
            shoot2 = false;
            shoot3 = false;
            shootFirst = false;
            shootSecond = false;
            shootThird = false;
            //counter++;
        }
        else if(info4 && start4){
            heart3B = true;
            heart2B = true;
            heartB = true;
            finale = true;
            infected_x = 400;
            infected_y = 250;
            bad_x = -10000;
            bad_y = -10000;
            bad_x1 = -10000;
            bad_y1 = -10000;
            bad_x2 = -10000;
            bad_y2 = -10000;
            apple = redBloodCell.getImage();
            map = redBloodCell.getImage();
            map2 = redBloodCell.getImage();
            stage4C = false;
            stage5 = true;
            stage5C = true;
            ap = false;
            mp = false;
            mp2 = false;
            mp3 = false;
            mp4 = false;
            mp5 = false;
            shoot = false;
            shoot2 = false;
            shoot3 = false;
            shootFirst = false;
            shootSecond = false;
            shootThird = false;
            //counter++;
        }
        else{
            apple = purpleMAP.getImage();
            map = blueMAP.getImage();
            map2 = redBloodCell.getImage();
            stage5C = false;
            shoot = false;
            shoot2 = false;
            shoot3 = false;
            shootFirst = false;
            shootSecond = false;
            shootThird = false;
            //counter++;
        }

        ImageIcon iih = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\head.png");
        //head = iih.getImage();
        //head = player.getImage();
    }

    private void initGame() {

        //dots = 3;

        //for (int z = 0; z < dots; z++) {
            //x[z] = 50 - z * 10;
            //y[z] = 50;
        //}

        locateApple();

        if(!game2){
            timer = new Timer(DELAY, this);
            timer.start();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon backRed = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\kindared.jpg");
        Image backRedC = backRed.getImage();
        ImageIcon mirrorRed = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\kindaredmirror.jpg");
        Image mirrorRedC = mirrorRed.getImage();
        g.drawImage(backRedC, 0, 0, null);
        g.drawImage(mirrorRedC, 0, 535, null);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        if (inGame) {

            if(start && mainStart){
                startScreen(g);
            }
            else if(!mainStart && !instructions && storyScreen){
                storyScreenA(g);
            }
            else if(!mainStart && !instructions){
                startInstructions(g);
            }
            else if(start0 && info0){
                setInfo0(g);
                x[0] = 50;
                y[0] = 50;
                shoot = false;
                shoot2 = false;
                shoot3 = false;
            }
            else if(start1 && info1){
                setInfo1(g);
                //counter++;
                loadImages();
                locateApple();
                x[0] = 50;
                y[0] = 50;
                shoot = false;
                shoot2 = false;
                shoot3 = false;
            }
            else if(start2 && info2){
                setInfo2(g);
                //counter++;
                loadImages();
                locateApple();
                x[0] = 50;
                y[0] = 50;
                shoot = false;
                shoot2 = false;
                shoot3 = false;
            }
            else if(start3 && info3){
                setInfo3(g);
                //counter++;
                loadImages();
                locateApple();
                x[0] = 50;
                y[0] = 50;
                shoot = false;
                shoot2 = false;
                shoot3 = false;
            }
            else if(start4 && info4){
                setInfo4(g);
                //counter++;
                loadImages();
                locateApple();
                x[0] = 50;
                y[0] = 50;
                shoot = false;
                shoot2 = false;
                shoot3 = false;
            }
            else if(start5 && info5){
                setInfo5(g);
                //counter++;
                loadImages();
                locateApple();
                x[0] = 50;
                y[0] = 50;
                shoot = false;
                shoot2 = false;
                shoot3 = false;
            }
            else if(redHit){
                redHitScreen(g);
            }
            else if(whiteHit){
                whiteHitScreen(g);
            }
            else if(win){
                winScreen(g);
            }
            else if(lose){
                loseScreen(g);
            }
            else{
                if(heart3B){
                    ImageIcon h1 = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\FullHeart.png");
                    heart = h1.getImage();
                    heart2 = h1.getImage();
                    heart3 = h1.getImage();
                    g.drawImage(heart, 0, 0, this);
                    g.drawImage(heart2, 25, 0, this);
                    g.drawImage(heart3, 50, 0, this);
                }
                else if(heart2B){
                    ImageIcon h1 = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\FullHeart.png");
                    ImageIcon h2 = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\EmptyHeart.png");
                    heart = h1.getImage();
                    heart2 = h1.getImage();
                    heart3 = h2.getImage();
                    g.drawImage(heart, 0, 0, this);
                    g.drawImage(heart2, 25, 0, this);
                    g.drawImage(heart3, 50, 0, this);
                }
                else if(heartB){
                    ImageIcon h1 = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\FullHeart.png");
                    ImageIcon h2 = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\EmptyHeart.png");
                    heart = h1.getImage();
                    heart2 = h2.getImage();
                    heart3 = h2.getImage();
                    g.drawImage(heart, 0, 0, this);
                    g.drawImage(heart2, 25, 0, this);
                    g.drawImage(heart3, 50, 0, this);
                }
                else{

                    lose = true;
                    //checkCollision();
                }

                g.drawImage(head, x[0], y[0], this);

                if(stage1C == true){
                    g.drawImage(apple, apple_x, apple_y, this);
                    g.drawImage(map, map_x, map_y, this);
                    g.drawImage(map2, map_x2, map_y2, this);
                }
                else if(stage2C == true){
                    g.drawImage(apple, apple_x, apple_y, this);
                    g.drawImage(map, map_x, map_y, this);
                    g.drawImage(map2, map_x2, map_y2, this);
                    g.drawImage(map3, map_x3, map_y3, this);
                    g.drawImage(map4, map_x4, map_y4, this);
                }
                else if(stage3C == true){
                    g.drawImage(apple, apple_x, apple_y, this);
                    g.drawImage(map, map_x, map_y, this);
                    g.drawImage(map2, map_x2, map_y2, this);
                    g.drawImage(map3, map_x3, map_y3, this);
                    g.drawImage(map4, map_x4, map_y4, this);
                    g.drawImage(map5, map_x5, map_y5, this);
                    g.drawImage(rbc, rbc_x, rbc_y, this);
                    g.drawImage(rbc2, rbc_x2, rbc_y2, this);
                }
                else if(stage4C == true){
                    g.drawImage(apple, apple_x, apple_y, this);
                    g.drawImage(map, map_x, map_y, this);
                    g.drawImage(map2, map_x2, map_y2, this);
                    g.drawImage(map3, map_x3, map_y3, this);
                    g.drawImage(map4, map_x4, map_y4, this);
                    g.drawImage(map5, map_x5, map_y5, this);
                    g.drawImage(rbc, rbc_x, rbc_y, this);
                    g.drawImage(rbc2, rbc_x2, rbc_y2, this);
                    g.drawImage(wbc, wbc_x, wbc_y, this);
                    g.drawImage(wbc2, wbc_x2, wbc_y2, this);
                }
                else{
                    finale = true;
                    ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\InfectedB.png");
                    ImageIcon badB = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\BlueMAPCellbigger.png");
                    ImageIcon badB1 = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\PurpleMAPCellbigger.png");
                    infected = title.getImage();
                    bad = badB.getImage();
                    bad1 = badB1.getImage();
                    bad2 = badB1.getImage();
                    g.drawImage(infected, infected_x, infected_y, this);
                    g.drawImage(bad, bad_x, bad_y, this);
                    g.drawImage(bad1, bad_x1, bad_y1, this);
                    g.drawImage(bad2, bad_x2, bad_y2, this);

                    ImageIcon poison = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\PoisonHeart.png");
                    ImageIcon empty = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\EmptyHeart.png");
                    poisonH = poison.getImage();
                    emptyH = empty.getImage();
                    for(int i = 0; i < 20; i++){
                        Image using;
                        if(i < monsterHealth){
                            using = poisonH;
                        }
                        else{
                            using = emptyH;
                        }
                        if(i < 10){
                            g.drawImage(using, 400 + i*25, 0, this);
                        }
                        else{
                            g.drawImage(using, 400 + (i-10)*25, 20, this);
                        }
                    }
                    if(youWin){
                        win = true;
                        //inGame = false;
                        //checkCollision();
                    }
                }

                if(shoot){
                    if(shootFirst){
                        zapX[0] = x[0] + 50;
                        zapY[0] = y[0];
                        g.drawImage(ball, zapX[0] + 10, zapY[0], this);
                        shootFirst = false;
                    }
                    else{
                        g.drawImage(ball, zapX[0], zapY[0], this);
                    }
                }
                if(shoot2){
                    if(shootSecond){
                        zapX2[0] = x[0] + 50;
                        zapY2[0] = y[0];
                        g.drawImage(ball, zapX2[0] + 10, zapY2[0], this);
                        shootSecond = false;
                    }
                    else{
                        g.drawImage(ball, zapX2[0], zapY2[0], this);
                    }
                }
                if(shoot3){
                    if(shootThird){
                        zapX3[0] = x[0] + 50;
                        zapY3[0] = y[0];
                        g.drawImage(ball, zapX3[0] + 10, zapY3[0], this);
                        shootThird = false;
                    }
                    else{
                        g.drawImage(ball, zapX3[0], zapY3[0], this);
                    }
                }

                //for (int z = 0; z < dots; z++) {
                    //if (z == 0) {
                        //g.drawImage(head, x[z], y[z], this);
                    //} else {
                        //g.drawImage(ball, x[z], y[z], this);
                    //}
                //}

                Toolkit.getDefaultToolkit().sync();
            }

        }
        else {

            gameOver(g);
        }
    }

    private void startScreen(Graphics g){
        //String msg = "Zap the Map!";
        //String howto = "Press Enter to Start";
        //Font small = new Font("Helvitica", Font.BOLD, 18);
        //FontMetrics metr = getFontMetrics(small);

        //g.setColor(Color.BLACK);
        //g.setFont(small);
        //g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 - 100);
        //g.drawString(howto, (B_WIDTH - metr.stringWidth(howto)) / 2, (B_HEIGHT / 2) - 50);
        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\Zap Title Screen.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
        storyScreen = true;


        //start = false;
    }

    private void storyScreenA(Graphics g){
        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\StoryScreen.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
    }

    private void startInstructions(Graphics g){
        /*String msg = "INSERT INSTRUCTION SHEET HERE";
        String choice = "Press B to play as a boy                    Press G to play as a girl";

        Font small = new Font("Helvitica", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 - 100);
        g.drawString(choice, (B_WIDTH - metr.stringWidth(choice)) / 2, (B_HEIGHT / 2) - 50);*/
        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\InstructionsCNew.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
        start0 = true;
        info0 = true;
    }

    private void setInfo0(Graphics g){
        /*String msg = "pls";
        String choice = "Press ENTER to continue";

        Font small = new Font("Helvitica", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 - 100);
        g.drawString(choice, (B_WIDTH - metr.stringWidth(choice)) / 2, (B_HEIGHT / 2) - 50);*/
        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\AnimalMAPSlide.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
        shoot = false;
        shoot2 = false;
        shoot3 = false;
        shootFirst = false;
        shootSecond = false;
        shootThird = false;
    }

    private void setInfo1(Graphics g){
        /*String msg = "INSERT INFORMATION ABOUT PURPLE MAP HERE";
        String choice = "Press ENTER to continue";

        Font small = new Font("Helvitica", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 - 100);
        g.drawString(choice, (B_WIDTH - metr.stringWidth(choice)) / 2, (B_HEIGHT / 2) - 50);*/

        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\HumanMAPSlide.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
        counter++;
    }

    private void setInfo2(Graphics g){
        /*String msg = "INSERT INFORMATION ABOUT BLUE MAP HERE";
        String choice = "Press ENTER to continue";

        Font small = new Font("Helvitica", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 - 100);
        g.drawString(choice, (B_WIDTH - metr.stringWidth(choice)) / 2, (B_HEIGHT / 2) - 50);*/
        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\RBCSlide.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
        counter++;
    }

    private void setInfo3(Graphics g){
        /*String msg = "INSERT INFORMATION ABOUT RED BLOOD CELLS HERE";
        String choice = "Press ENTER to continue";

        Font small = new Font("Helvitica", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 - 100);
        g.drawString(choice, (B_WIDTH - metr.stringWidth(choice)) / 2, (B_HEIGHT / 2) - 50);*/
        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\WBCSlide.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
        counter++;
    }

    private void setInfo4(Graphics g){
        /*String msg = "INSERT INFORMATION ABOUT WHITE BLOOD CELLS HERE";
        String choice = "Press ENTER to continue";

        Font small = new Font("Helvitica", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 - 100);
        g.drawString(choice, (B_WIDTH - metr.stringWidth(choice)) / 2, (B_HEIGHT / 2) - 50);*/
        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\InfectedSlide.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
        counter++;
    }

    private void setInfo5(Graphics g){
        String msg = "INSERT INFORMATION ABOUT SOMETHING MAYBE HERE";
        String choice = "Press ENTER to continue";

        Font small = new Font("Helvitica", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 - 100);
        g.drawString(choice, (B_WIDTH - metr.stringWidth(choice)) / 2, (B_HEIGHT / 2) - 50);
        counter++;
    }

    private void winScreen(Graphics g){
        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\WinScreen.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
    }

    private void loseScreen(Graphics g){
        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\LoseScreen.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
    }

    private void redHitScreen(Graphics g){
        /*String msg = "Don't hit the Red Blood Cells";
        String choice = "Press ENTER to continue";

        Font small = new Font("Helvitica", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 - 100);
        g.drawString(choice, (B_WIDTH - metr.stringWidth(choice)) / 2, (B_HEIGHT / 2) - 50);*/
        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\RBCRememberSlide.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
        shoot = false;
        shoot2 = false;
        shoot3 = false;
        shootFirst = false;
        shootSecond = false;
        shootThird = false;
    }

    private void whiteHitScreen(Graphics g){
        /*String msg = "Don't hit the White Blood Cells";
        String choice = "Press ENTER to continue";

        Font small = new Font("Helvitica", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2 - 100);
        g.drawString(choice, (B_WIDTH - metr.stringWidth(choice)) / 2, (B_HEIGHT / 2) - 50);*/
        ImageIcon title = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\WBCRememberSlide.png");
        Image titleC = title.getImage();
        g.drawImage(titleC, 0, 0, this);
        shoot = false;
        shoot2 = false;
        shoot3 = false;
        shootFirst = false;
        shootSecond = false;
        shootThird = false;
    }

    private void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.black);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    private void checkApple() {
        if(shoot || shoot2 || shoot3){
            shooting();
        }

        if(stage1C){
            if(moveNum % 20 == 0){
                moveNumCheck = true;
            }
            else{
                moveNumCheck = false;
            }
        }
        else if(stage2C){
            if(moveNum % 12 == 0){
                moveNumCheck = true;
            }
            else{
                moveNumCheck = false;
            }
        }
        else if(stage3C){
            if(moveNum % 10 == 0){
                moveNumCheck = true;
            }
            else{
                moveNumCheck = false;
            }
        }
        else if(stage4C){
            if(moveNum % 7 == 0){
                moveNumCheck = true;
            }
            else{
                moveNumCheck = false;
            }
        }
        else{
            if(moveNum % 1 == 0){
                moveNumCheck = true;
            }
            else{
                moveNumCheck = false;
            }
        }

        if(!finale){
            if(((zapX[0] == apple_x) || (zapX[0] == apple_x + 10)) && ((zapY[0] == apple_y) || (zapY[0] == apple_y + 10) || (zapY[0] == apple_y - 10))){
                deleteApple(0);
                shoot = false;
            }
            if(((zapX2[0] == apple_x) || (zapX2[0] == apple_x + 10)) && ((zapY2[0] == apple_y) || (zapY2[0] == apple_y + 10) || (zapY2[0] == apple_y - 10))){
                deleteApple(0);
                shoot2 = false;
            }
            if(((zapX3[0] == apple_x) || (zapX3[0] == apple_x + 10)) && ((zapY3[0] == apple_y) || (zapY3[0] == apple_y + 10) || (zapY3[0] == apple_y - 10))){
                deleteApple(0);
                shoot3 = false;
            }

            if(((zapX[0] == map_x) || (zapX[0] == map_x + 10)) && ((zapY[0] == map_y) || (zapY[0] == map_y + 10) || (zapY[0] == map_y - 10))){
                deleteApple(1);
                shoot = false;
            }
            if(((zapX2[0] == map_x) || (zapX2[0] == map_x + 10)) && ((zapY2[0] == map_y) || (zapY2[0] == map_y + 10) || (zapY2[0] == map_y - 10))){
                deleteApple(1);
                shoot2 = false;
            }
            if(((zapX3[0] == map_x) || (zapX3[0] == map_x + 10)) && ((zapY3[0] == map_y) || (zapY3[0] == map_y + 10) || (zapY3[0] == map_y - 10))){
                deleteApple(1);
                shoot3 = false;
            }

            if(((zapX[0] == map_x2) || (zapX[0] == map_x2 + 10)) && ((zapY[0] == map_y2) || (zapY[0] == map_y2 + 10) || (zapY[0] == map_y2 - 10))){
                deleteApple(2);
                shoot = false;
            }
            if(((zapX2[0] == map_x2) || (zapX2[0] == map_x2 + 10)) && ((zapY2[0] == map_y2) || (zapY2[0] == map_y2 + 10) || (zapY2[0] == map_y2 - 10))){
                deleteApple(2);
                shoot2 = false;
            }
            if(((zapX3[0] == map_x2) || (zapX3[0] == map_x2 + 10)) && ((zapY3[0] == map_y2) || (zapY3[0] == map_y2 + 10) || (zapY3[0] == map_y2 - 10))){
                deleteApple(2);
                shoot3 = false;
            }

            if(((zapX[0] == map_x3) || (zapX[0] == map_x3 + 10)) && ((zapY[0] == map_y3) || (zapY[0] == map_y3 + 10) || (zapY[0] == map_y3 - 10))){
                deleteApple(3);
                shoot = false;
            }
            if(((zapX2[0] == map_x3) || (zapX2[0] == map_x3 + 10)) && ((zapY2[0] == map_y3) || (zapY2[0] == map_y3 + 10) || (zapY2[0] == map_y3 - 10))){
                deleteApple(3);
                shoot2 = false;
            }
            if(((zapX3[0] == map_x3) || (zapX3[0] == map_x3 + 10)) && ((zapY3[0] == map_y3) || (zapY3[0] == map_y3 + 10) || (zapY3[0] == map_y3 - 10))){
                deleteApple(3);
                shoot3 = false;
            }

            if(((zapX[0] == map_x4) || (zapX[0] == map_x4 + 10)) && ((zapY[0] == map_y4) || (zapY[0] == map_y4 + 10) || (zapY[0] == map_y4 - 10))){
                deleteApple(4);
                shoot = false;
            }
            if(((zapX2[0] == map_x4) || (zapX2[0] == map_x4 + 10)) && ((zapY2[0] == map_y4) || (zapY2[0] == map_y4 + 10) || (zapY2[0] == map_y4 - 10))){
                deleteApple(4);
                shoot2 = false;
            }
            if(((zapX3[0] == map_x4) || (zapX3[0] == map_x4 + 10)) && ((zapY3[0] == map_y4) || (zapY3[0] == map_y4 + 10) || (zapY3[0] == map_y4 - 10))){
                deleteApple(4);
                shoot3 = false;
            }

            if(((zapX[0] == map_x5) || (zapX[0] == map_x5 + 10)) && ((zapY[0] == map_y5) || (zapY[0] == map_y5 + 10) || (zapY[0] == map_y5 - 10))){
                deleteApple(5);
                shoot = false;
            }
            if(((zapX2[0] == map_x5) || (zapX2[0] == map_x5 + 10)) && ((zapY2[0] == map_y5) || (zapY2[0] == map_y5 + 10) || (zapY2[0] == map_y5 - 10))){
                deleteApple(5);
                shoot2 = false;
            }
            if(((zapX3[0] == map_x5) || (zapX3[0] == map_x5 + 10)) && ((zapY3[0] == map_y5) || (zapY3[0] == map_y5 + 10) || (zapY3[0] == map_y5 - 10))){
                deleteApple(5);
                shoot3 = false;
            }

            if(((zapX[0] == rbc_x) || (zapX[0] == rbc_x + 10)) && ((zapY[0] == rbc_y) || (zapY[0] == rbc_y + 10) || (zapY[0] == rbc_y - 10))){
                deleteApple(6);
                shoot = false;
            }
            if(((zapX2[0] == rbc_x) || (zapX2[0] == rbc_x + 10)) && ((zapY2[0] == rbc_y) || (zapY2[0] == rbc_y + 10) || (zapY2[0] == rbc_y - 10))){
                deleteApple(6);
                shoot2 = false;
            }
            if(((zapX3[0] == rbc_x) || (zapX3[0] == rbc_x + 10)) && ((zapY3[0] == rbc_y) || (zapY3[0] == rbc_y + 10) || (zapY3[0] == rbc_y - 10))){
                deleteApple(6);
                shoot3 = false;
            }

            if(((zapX[0] == rbc_x2) || (zapX[0] == rbc_x2 + 10)) && ((zapY[0] == rbc_y2) || (zapY[0] == rbc_y2 + 10) || (zapY[0] == rbc_y2 - 10))){
                deleteApple(7);
                shoot = false;
            }
            if(((zapX2[0] == rbc_x2) || (zapX2[0] == rbc_x2 + 10)) && ((zapY2[0] == rbc_y2) || (zapY2[0] == rbc_y2 + 10) || (zapY2[0] == rbc_y2 - 10))){
                deleteApple(7);
                shoot2 = false;
            }
            if(((zapX3[0] == rbc_x2) || (zapX3[0] == rbc_x2 + 10)) && ((zapY3[0] == rbc_y2) || (zapY3[0] == rbc_y2 + 10) || (zapY3[0] == rbc_y2 - 10))){
                deleteApple(7);
                shoot3 = false;
            }

            if(((zapX[0] == wbc_x) || (zapX[0] == wbc_x + 10)) && ((zapY[0] == wbc_y) || (zapY[0] == wbc_y + 10) || (zapY[0] == wbc_y - 10))){
                deleteApple(8);
                shoot = false;
            }
            if(((zapX2[0] == wbc_x) || (zapX2[0] == wbc_x + 10)) && ((zapY2[0] == wbc_y) || (zapY2[0] == wbc_y + 10) || (zapY2[0] == wbc_y - 10))){
                deleteApple(8);
                shoot2 = false;
            }
            if(((zapX3[0] == wbc_x) || (zapX3[0] == wbc_x + 10)) && ((zapY3[0] == wbc_y) || (zapY3[0] == wbc_y + 10) || (zapY3[0] == wbc_y - 10))){
                deleteApple(8);
                shoot3 = false;
            }

            if(((zapX[0] == wbc_x2) || (zapX[0] == wbc_x2 + 10)) && ((zapY[0] == wbc_y2) || (zapY[0] == wbc_y2 + 10) || (zapY[0] == wbc_y2 - 10))){
                deleteApple(9);
                shoot = false;
            }
            if(((zapX2[0] == wbc_x2) || (zapX2[0] == wbc_x2 + 10)) && ((zapY2[0] == wbc_y2) || (zapY2[0] == wbc_y2 + 10) || (zapY2[0] == wbc_y2 - 10))){
                deleteApple(9);
                shoot2 = false;
            }
            if(((zapX3[0] == wbc_x2) || (zapX3[0] == wbc_x2 + 10)) && ((zapY3[0] == wbc_y2) || (zapY3[0] == wbc_y2 + 10) || (zapY3[0] == wbc_y2 - 10))){
                deleteApple(9);
                shoot3 = false;
            }

            if(moveNumCheck){
                moveApple(0);
                moveApple(1);
                moveApple(2);
                moveApple(3);
                moveApple(4);
                moveApple(5);
                moveApple(6);
                moveApple(7);
                moveApple(8);
                moveApple(9);
            }
        }
        else{
            if(zapX[0] >= infected_x && zapX[0] <= infected_x + 150){
                if(zapY[0] >= infected_y && zapY[0] <= infected_y + 200){
                    hitMonster(0);
                    shoot = false;
                    zapX[0] = -100000;
                    zapY[0] = -100000;
                }
            }
            if(zapX2[0] >= infected_x && zapX2[0] <= infected_x + 150){
                if(zapY2[0] >= infected_y && zapY2[0] <= infected_y + 200){
                    hitMonster(0);
                    shoot2 = false;
                    zapX2[0] = -100000;
                    zapY2[0] = -100000;
                }
            }
            if(zapX3[0] >= infected_x && zapX3[0] <= infected_x + 150){
                if(zapY3[0] >= infected_y && zapY3[0] <= infected_y + 200){
                    hitMonster(0);
                    shoot3 = false;
                    zapX3[0] = -100000;
                    zapY3[0] = -100000;
                }
            }

            if(((zapX[0] == bad_x) || (zapX[0] == bad_x + 10) || (zapX[0] == bad_x + 20)) && ((zapY[0] == bad_y) || (zapY[0] == bad_y + 10))){
                hitMonster(1);
                shoot = false;
                zapX[0] = -15000;
                zapY[0] = -15000;
            }
            if(((zapX[0] == bad_x1) || (zapX[0] == bad_x1 + 10) || (zapX[0] == bad_x1 + 20)) && ((zapY[0] == bad_y1) || (zapY[0] == bad_y1 + 10))){
                hitMonster(2);
                shoot = false;
                zapX[0] = -15000;
                zapY[0] = -15000;
            }
            if(((zapX[0] == bad_x2) || (zapX[0] == bad_x2 + 10) || (zapX[0] == bad_x2 + 20)) && ((zapY[0] == bad_y2) || (zapY[0] == bad_y2 + 10))){
                hitMonster(3);
                shoot = false;
                zapX[0] = -15000;
                zapY[0] = -15000;
            }

            if(((zapX2[0] == bad_x) || (zapX2[0] == bad_x + 10) || (zapX2[0] == bad_x + 20)) && ((zapY2[0] == bad_y) || (zapY2[0] == bad_y + 10))){
                hitMonster(1);
                shoot2 = false;
                zapX2[0] = -15000;
                zapY2[0] = -15000;
            }
            if(((zapX2[0] == bad_x1) || (zapX2[0] == bad_x1 + 10) || (zapX2[0] == bad_x1 + 20)) && ((zapY2[0] == bad_y1) || (zapY2[0] == bad_y1 + 10))){
                hitMonster(2);
                shoot2 = false;
                zapX2[0] = -15000;
                zapY2[0] = -15000;
            }
            if(((zapX2[0] == bad_x2) || (zapX2[0] == bad_x2 + 10) || (zapX2[0] == bad_x2 + 20)) && ((zapY2[0] == bad_y2) || (zapY2[0] == bad_y2 + 10))){
                hitMonster(3);
                shoot2 = false;
                zapX2[0] = -15000;
                zapY2[0] = -15000;
            }

            if(((zapX3[0] == bad_x) || (zapX3[0] == bad_x + 10) || (zapX3[0] == bad_x + 20)) && ((zapY3[0] == bad_y) || (zapY3[0] == bad_y + 10))){
                hitMonster(1);
                shoot3 = false;
                zapX3[0] = -15000;
                zapY3[0] = -15000;
            }
            if(((zapX3[0] == bad_x1) || (zapX3[0] == bad_x1 + 10) || (zapX3[0] == bad_x1 + 20)) && ((zapY3[0] == bad_y1) || (zapY3[0] == bad_y1 + 10))){
                hitMonster(2);
                shoot3 = false;
                zapX3[0] = -15000;
                zapY3[0] = -15000;
            }
            if(((zapX3[0] == bad_x2) || (zapX3[0] == bad_x2 + 10) || (zapX3[0] == bad_x2 + 20)) && ((zapY3[0] == bad_y2) || (zapY3[0] == bad_y2 + 10))){
                hitMonster(3);
                shoot3 = false;
                zapX3[0] = -15000;
                zapY3[0] = -15000;
            }

            if(bad_x >= x[0] && bad_x <= x[0] + 40){
                if(bad_y >= y[0] && bad_y <= y[0] + 60){
                    bad_x = -20000;
                    bad_y = -20000;
                    if(heart3B){
                        heart3B = false;
                    }
                    else if(heart2B){
                        heart2B = false;
                    }
                    else if(heartB){
                        heartB = false;
                    }
                }
            }
            if(bad_x1 >= x[0] && bad_x1 <= x[0] + 40){
                if(bad_y1 >= y[0] && bad_y1 <= y[0] + 60){
                    bad_x1 = -20000;
                    bad_y1 = -20000;
                    if(heart3B){
                        heart3B = false;
                    }
                    else if(heart2B){
                        heart2B = false;
                    }
                    else if(heartB){
                        heartB = false;
                    }
                }
            }
            if(bad_x2 >= x[0] && bad_x2 <= x[0] + 40){
                if(bad_y2 >= y[0] && bad_y2 <= y[0] + 60){
                    bad_x2 = -20000;
                    bad_y2 = -20000;
                    if(heart3B){
                        heart3B = false;
                    }
                    else if(heart2B){
                        heart2B = false;
                    }
                    else if(heartB){
                        heartB = false;
                    }
                }
            }
            /*if((zapX[0] == infected_x) || (zapX[0] == infected_x + 10) || (zapX[0] == infected_x + 20) || (zapX[0] == infected_x + 30)){
                if((zapY[0] == infected_y) || (zapY[0] == infected_y + 10) || (zapY[0] == infected_y + 20) || (zapY[0] == infected_y + 30) || (zapY[0] == infected_y + 40) || (zapY[0] == infected_y + 50) || (zapY[0] == infected_y + 60) || (zapY[0] == infected_y + 70) || (zapY[0] == infected_y + 80) || (zapY[0] == infected_y + 90) || (zapY[0] == infected_y + 100)){
                    hitMonster();
                    shoot = false;
                    zapX[0] = -100000;
                    zapY[0] = -100000;
                }
            }
            if((zapX2[0] == infected_x) || (zapX2[0] == infected_x + 10) || (zapX2[0] == infected_x + 20) || (zapX2[0] == infected_x + 30)){
                if((zapY2[0] == infected_y) || (zapY2[0] == infected_y + 10) || (zapY2[0] == infected_y + 20) || (zapY2[0] == infected_y + 30) || (zapY2[0] == infected_y + 40) || (zapY2[0] == infected_y + 50) || (zapY2[0] == infected_y + 60) || (zapY2[0] == infected_y + 70) || (zapY2[0] == infected_y + 80) || (zapY2[0] == infected_y + 90) || (zapY2[0] == infected_y + 100)){
                    hitMonster();
                    shoot2 = false;
                    zapX2[0] = -100000;
                    zapY2[0] = -100000;
                }
            }
            if((zapX3[0] == infected_x) || (zapX3[0] == infected_x + 10) || (zapX3[0] == infected_x + 20) || (zapX3[0] == infected_x + 30)){
                if((zapY3[0] == infected_y) || (zapY3[0] == infected_y + 10) || (zapY3[0] == infected_y + 20) || (zapY3[0] == infected_y + 30) || (zapY3[0] == infected_y + 40) || (zapY3[0] == infected_y + 50) || (zapY3[0] == infected_y + 60) || (zapY3[0] == infected_y + 70) || (zapY3[0] == infected_y + 80) || (zapY3[0] == infected_y + 90) || (zapY3[0] == infected_y + 100)){
                    hitMonster();
                    shoot3 = false;
                    zapX3[0] = -100000;
                    zapY3[0] = -100000;
                }
            }*/

            if(moveNumCheck){
                moveMonster(0);
                moveMonster(1);
                moveMonster(2);
                moveMonster(3);
            }
        }

        /*if(moveNumCheck) {
            moveApple(0);
            moveApple(1);
            moveApple(2);
            moveApple(3);
            moveApple(4);
            moveApple(5);
            moveApple(6);
            moveApple(7);
            moveApple(8);
            moveApple(9);
            if(finale){
                moveMonster(0);
                moveMonster(1);
                moveMonster(2);
            }*/


        /*if (((x[0]+40 == apple_x) || (x[0]+30 == apple_x) || (x[0]+20 == apple_x) || (x[0]+10 == apple_x)) && ((y[0] == apple_y) || (y[0] == apple_y - 10) || (y[0] == apple_y - 20) || (y[0] == apple_y - 30) || (y[0] == apple_y - 40))) {
            //dots++;
            //locateApple();
            deleteApple(0);
        }
        else{
            if(moveNumCheck) {
                moveApple(0);
            }
        }

        if (((x[0]+40 == map_x) || (x[0]+30 == map_x) || (x[0]+20 == map_x) || x[0]+10 == map_x) && ((y[0] == map_y) || (y[0] == map_y - 10) || (y[0] == map_y - 20) || (y[0] == map_y - 30) || (y[0] == map_y - 40))) {
            //dots++;
            //locateApple();
            deleteApple(1);
        }
        else{
            if(moveNumCheck) {
                moveApple(1);
            }
        }

        if (((x[0]+40 == map_x2) || (x[0]+30 == map_x2) || (x[0]+20 == map_x2) || x[0]+10 == map_x2) && ((y[0] == map_y2) || (y[0] == map_y2 - 10) || (y[0] == map_y2 - 20) || (y[0] == map_y2 - 30) || (y[0] == map_y2 - 40))) {
            //dots++;
            //locateApple();
            deleteApple(2);
        }
        else{
            if(moveNumCheck) {
                moveApple(2);
            }
        }

        if (((x[0]+40 == map_x3) || (x[0]+30 == map_x3) || (x[0]+20 == map_x3) || x[0]+10 == map_x3) && ((y[0] == map_y3) || (y[0] == map_y3 - 10) || (y[0] == map_y3 - 20) || (y[0] == map_y3 - 30) || (y[0] == map_y3 - 40))) {
            //dots++;
            //locateApple();
            deleteApple(3);
        }
        else{
            if(moveNumCheck) {
                moveApple(3);
            }
        }

        if (((x[0]+40 == map_x4) || (x[0]+30 == map_x4) || (x[0]+20 == map_x4) || x[0]+10 == map_x4) && ((y[0] == map_y4) || (y[0] == map_y4 - 10) || (y[0] == map_y4 - 20) || (y[0] == map_y4 - 30) || (y[0] == map_y4 - 40))) {
            //dots++;
            //locateApple();
            deleteApple(4);
        }
        else{
            if(moveNumCheck) {
                moveApple(4);
            }
        }

        if (((x[0]+40 == map_x5) || (x[0]+30 == map_x5) || (x[0]+20 == map_x5) || x[0]+10 == map_x5) && ((y[0] == map_y5) || (y[0] == map_y5 - 10) || (y[0] == map_y5 - 20) || (y[0] == map_y5 - 30) || (y[0] == map_y5 - 40))) {
            //dots++;
            //locateApple();
            deleteApple(5);
        }
        else{
            if(moveNumCheck) {
                moveApple(5);
            }
        }

        if (((x[0]+40 == rbc_x) || (x[0]+30 == rbc_x) || (x[0]+20 == rbc_x) || x[0]+10 == rbc_x) && ((y[0] == rbc_y) || (y[0] == rbc_y - 10) || (y[0] == rbc_y - 20) || (y[0] == rbc_y - 30) || (y[0] == rbc_y - 40))) {
            //dots++;
            //locateApple();
            deleteApple(6);
        }
        else{
            if(moveNumCheck) {
                moveApple(6);
            }
        }

        if (((x[0]+40 == rbc_x2) || (x[0]+30 == rbc_x2) || (x[0]+20 == rbc_x2) || x[0]+10 == rbc_x2) && ((y[0] == rbc_y2) || (y[0] == rbc_y2 - 10) || (y[0] == rbc_y2 - 20) || (y[0] == rbc_y2 - 30) || (y[0] == rbc_y2 - 40))) {
            //dots++;
            //locateApple();
            deleteApple(7);
        }
        else{
            if(moveNumCheck) {
                moveApple(7);
            }
        }

        if (((x[0]+40 == wbc_x) || (x[0]+30 == wbc_x) || (x[0]+20 == wbc_x) || x[0]+10 == wbc_x) && ((y[0] == wbc_y) || (y[0] == wbc_y - 10) || (y[0] == wbc_y - 20) || (y[0] == wbc_y - 30) || (y[0] == wbc_y - 40))) {
            //dots++;
            //locateApple();
            deleteApple(8);
        }
        else{
            if(moveNumCheck) {
                moveApple(8);
            }
        }

        if (((x[0]+40 == wbc_x2) || (x[0]+30 == wbc_x2) || (x[0]+20 == wbc_x2) || x[0]+10 == wbc_x2) && ((y[0] == wbc_y2) || (y[0] == wbc_y2 - 10) || (y[0] == wbc_y2 - 20) || (y[0] == wbc_y2 - 30) || (y[0] == wbc_y2 - 40))) {
            //dots++;
            //locateApple();
            deleteApple(9);
        }
        else{
            if(moveNumCheck) {
                moveApple(9);
            }
        }*/


        ++moveNum;
    }

    private void move() {

        //for (int z = dots; z > 0; z--) {
            //x[z] = x[(z - 1)];
            //y[z] = y[(z - 1)];
        //}

        if (leftDirection) {
            x[0] -= DOT_SIZE;
            leftDirection = false;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
            rightDirection = false;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
            upDirection = false;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
            downDirection = false;
        }
    }

    private void checkCollision() {

        //for (int z = dots; z > 0; z--) {

            //if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                //inGame = false;
            //}
        //}

        //if (y[0] >= B_HEIGHT) {
            //inGame = false;
        //}

        //if (y[0] < 0) {
            //inGame = false;
        //}

        //if (x[0] >= B_WIDTH) {
            //inGame = false;
        //}

        //if (x[0] < 0) {
            //inGame = false;
        //}

        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {
        if(stage1){
            int position = (int) (Math.random() * RAND_POS);
            apple_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            apple_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y2 = ((position * DOT_SIZE));

            map_x3 = -10000;
            map_y3 = -10000;
            map_x4 = -10000;
            map_y4 = -10000;
            map_x5 = -10000;
            map_y5 = -10000;
            rbc_x = -10000;
            rbc_y = -10000;
            rbc_x2 = -10000;
            rbc_y2 = -10000;
            wbc_x = -10000;
            wbc_y = -10000;
            wbc_x2 = -10000;
            wbc_y2 = -10000;

            stage1 = false;

            if(apple_x < 50){
                apple_x = 50;
            }
            if(apple_y < 50){
                apple_y = 50;
            }
            if(map_x < 50){
                map_x = 50;
            }
            if(map_y < 50){
                map_y = 50;
            }
            if(map_x2 < 50){
                map_x2 = 50;
            }
            if(map_y2 < 50){
                map_y2 = 50;
            }
        }

        else if(stage2){
            int position = (int) (Math.random() * RAND_POS);
            apple_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            apple_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x3 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y3 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x4 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y4 = ((position * DOT_SIZE));

            map_x5 = -10000;
            map_y5 = -10000;
            rbc_x = -10000;
            rbc_y = -10000;
            rbc_x2 = -10000;
            rbc_y2 = -10000;
            wbc_x = -10000;
            wbc_y = -10000;
            wbc_x2 = -10000;
            wbc_y2 = -10000;

            stage2 = false;

            if(apple_x < 50){
                apple_x = 50;
            }
            if(apple_y < 50){
                apple_y = 50;
            }
            if(map_x < 50){
                map_x = 50;
            }
            if(map_y < 50){
                map_y = 50;
            }
            if(map_x2 < 50){
                map_x2 = 50;
            }
            if(map_y2 < 50){
                map_y2 = 50;
            }
            if(map_x3 < 50){
                map_x3 = 50;
            }
            if(map_y3 < 50){
                map_y3 = 50;
            }
            if(map_x4 < 50){
                map_x4 = 50;
            }
            if(map_y4 < 50){
                map_y4 = 50;
            }
        }

        else if(stage3){
            int position = (int) (Math.random() * RAND_POS);
            apple_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            apple_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x3 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y3 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x4 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y4 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x5 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y5 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            rbc_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            rbc_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            rbc_x2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            rbc_y2 = ((position * DOT_SIZE));

            wbc_x = -10000;
            wbc_y = -10000;
            wbc_x2 = -10000;
            wbc_y2 = -10000;

            stage3 = false;

            if(apple_x < 50){
                apple_x = 50;
            }
            if(apple_y < 50){
                apple_y = 50;
            }
            if(map_x < 50){
                map_x = 50;
            }
            if(map_y < 50){
                map_y = 50;
            }
            if(map_x2 < 50){
                map_x2 = 50;
            }
            if(map_y2 < 50){
                map_y2 = 50;
            }
            if(map_x3 < 50){
                map_x3 = 50;
            }
            if(map_y3 < 50){
                map_y3 = 50;
            }
            if(map_x4 < 50){
                map_x4 = 50;
            }
            if(map_y4 < 50){
                map_y4 = 50;
            }
            if(map_x5 < 50){
                map_x5 = 50;
            }
            if(map_y5 < 50){
                map_y5 = 50;
            }
            if(rbc_x < 50){
                rbc_x = 50;
            }
            if(rbc_y < 50){
                rbc_y = 50;
            }
            if(rbc_x2 < 50){
                rbc_x2 = 50;
            }
            if(rbc_y2 < 50){
                rbc_y2 = 50;
            }
        }

        else if(stage4){
            int position = (int) (Math.random() * RAND_POS);
            apple_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            apple_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x3 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y3 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x4 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y4 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x5 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y5 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            rbc_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            rbc_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            rbc_x2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            rbc_y2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            wbc_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            wbc_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            wbc_x2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            wbc_y2 = ((position * DOT_SIZE));

            stage4 = false;

            if(apple_x < 50){
                apple_x = 50;
            }
            if(apple_y < 50){
                apple_y = 50;
            }
            if(map_x < 50){
                map_x = 50;
            }
            if(map_y < 50){
                map_y = 50;
            }
            if(map_x2 < 50){
                map_x2 = 50;
            }
            if(map_y2 < 50){
                map_y2 = 50;
            }
            if(map_x3 < 50){
                map_x3 = 50;
            }
            if(map_y3 < 50){
                map_y3 = 50;
            }
            if(map_x4 < 50){
                map_x4 = 50;
            }
            if(map_y4 < 50){
                map_y4 = 50;
            }
            if(map_x5 < 50){
                map_x5 = 50;
            }
            if(map_y5 < 50){
                map_y5 = 50;
            }
            if(rbc_x < 50){
                rbc_x = 50;
            }
            if(rbc_y < 50){
                rbc_y = 50;
            }
            if(rbc_x2 < 50){
                rbc_x2 = 50;
            }
            if(rbc_y2 < 50){
                rbc_y2 = 50;
            }
            if(wbc_x < 50){
                wbc_x = 50;
            }
            if(wbc_y < 50){
                wbc_y = 50;
            }
            if(wbc_x2 < 50){
                wbc_x2 = 50;
            }
            if(wbc_y2 < 50){
                wbc_y2 = 50;
            }
        }

        else{
            int position = (int) (Math.random() * RAND_POS);
            apple_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            apple_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_x2 = ((position * DOT_SIZE));

            position = (int) (Math.random() * RAND_POS);
            map_y2 = ((position * DOT_SIZE));
        }

    }

    private void deleteApple(int num){
        if(num == 0){
            apple_x = -10000;
            apple_y = -10000;
            ap = true;
        }
        if(num == 1){
            map_x = -10000;
            map_y = -10000;
            mp = true;
        }
        if(num == 2){
            map_x2 = -10000;
            map_y2 = -10000;
            mp2 = true;
        }
        if(num == 3){
            map_x3 = -10000;
            map_y3 = -10000;
            mp3 = true;
        }
        if(num == 4){
            map_x4 = -10000;
            map_y4 = -10000;
            mp4 = true;
        }
        if(num == 5){
            map_x5 = -10000;
            map_y5 = -10000;
            mp5 = true;
        }
        if(num == 6){
            if((stage3C || stage4C || stage5C) && !finale){
                rbc_x = -10000;
                rbc_y = -10000;
                redHit = true;
                if(heart3B){
                    heart3B = false;
                }
                else if(heart2B){
                    heart2B = false;
                }
                else if(heartB){
                    heartB = false;
                }
            }
        }
        if(num == 7){
            if((stage3C || stage4C || stage5C) && !finale){
                rbc_x2 = -10000;
                rbc_y2 = -10000;
                redHit = true;
                if(heart3B){
                    heart3B = false;
                }
                else if(heart2B){
                    heart2B = false;
                }
                else if(heartB){
                    heartB = false;
                }
            }
        }
        if(num == 8){
            if((stage4C || stage5C) && !finale){
                wbc_x = -10000;
                wbc_y = -10000;
                whiteHit = true;
                if(heart3B){
                    heart3B = false;
                }
                else if(heart2B){
                    heart2B = false;
                }
                else if(heartB){
                    heartB = false;
                }
            }
        }
        if(num == 9){
            if((stage4C || stage5C) && !finale){
                wbc_x2 = -10000;
                wbc_y2 = -10000;
                whiteHit = true;
                if(heart3B){
                    heart3B = false;
                }
                else if(heart2B){
                    heart2B = false;
                }
                else if(heartB){
                    heartB = false;
                }
            }
        }
        if(ap && mp && mp2 && mp3 && mp4 && mp5 && !finale){
            ap = false;
            mp = false;
            mp2 = false;
            mp3 = false;
            mp4 = false;
            mp5 = false;
            if(info1){
                if(info2){
                    if(info3){
                        if(info4){
                            if(info5){
                                inGame = false;
                                checkCollision();
                            }
                            else{
                                info5 = true;
                                start5 = true;
                            }
                        }
                        else{
                            info4 = true;
                            start4 = true;
                        }
                    }
                    else{
                        info3 = true;
                        start3 = true;
                    }
                }
                else{
                    info2 = true;
                    start2 = true;
                }
            }
            else{
                info1 = true;
                start1 = true;
            }
            //inGame = false;
            //checkCollision();
        }

    }

    private void hitMonster(int num){
        if(num == 0){
            monsterHealth--;
            if(monsterHealth == 0){
                youWin = true;
            }
        }
        else if(num == 1){
            bad_x = -12000;
            bad_y = -12000;
        }
        else if(num == 2){
            bad_x1 = -12000;
            bad_y1 = -12000;
        }
        else if(num == 3){
            bad_x2 = -12000;
            bad_y2 = -12000;
        }
    }

    private void shooting(){
        if(shoot){
            if(zapX[0] < 690){
                zapX[0] += 10;
            }
            else{
                shoot = false;
                zapX[0] = x[0];
            }
        }
        if(shoot2){
            if(zapX2[0] < 690){
                zapX2[0] += 10;
            }
            else{
                shoot2 = false;
                zapX2[0] = x[0];
            }
        }
        if(shoot3){
            if(zapX3[0] < 690){
                zapX3[0] += 10;
            }
            else{
                shoot3 = false;
                zapX3[0] = x[0];
            }
        }
    }

    private void moveMonster(int num){
        if(num == 0){
            if(inUp){
                infected_y -= 20;
                if(infected_y == 50){
                    inUp = false;
                    inDown = true;
                }
            }
            else if(inDown){
                infected_y += 20;
                if(infected_y == 510){
                    inUp = true;
                    inDown = false;
                }
            }

            int rando = (int)(Math.random() * 10);
            int rando2 = (int)(Math.random() * 4);
            if(rando >= 9){
                if(bad_x < 0){
                    if(rando2 >= 2){
                        bad_x = infected_x;
                        bad_y = infected_y;
                    }
                    else{
                        bad_x = infected_x;
                        bad_y = infected_y + 100;
                    }
                }
                else if(bad_x1 < 0){
                    if(rando2 >= 2){
                        bad_x1 = infected_x;
                        bad_y1 = infected_y;
                    }
                    else{
                        bad_x1 = infected_x;
                        bad_y1 = infected_y + 100;
                    }
                }
                else if(bad_x2 < 0){
                    if(rando2 >= 2){
                        bad_x2 = infected_x;
                        bad_y2 = infected_y;
                    }
                    else{
                        bad_x2 = infected_x;
                        bad_y2 = infected_y + 100;
                    }
                }
            }
        }
        if(num == 1){
            if(bad_x > 10){
                bad_x -= 10;
            }
            else{
                bad_x = -10000;
                bad_y = -10000;
            }
        }
        if(num == 2){
            if(bad_x1 > 10){
                bad_x1 -= 10;
            }
            else{
                bad_x1 = -10000;
                bad_y1 = -10000;
            }
        }
        if(num == 3){
            if(bad_x2 > 10){
                bad_x2 -= 10;
            }
            else{
                bad_x2 = -10000;
                bad_y2 = -10000;
            }
        }
    }

    private void moveApple(int num){
        if(num == 0){
            if(apple_x > 50 && apple_y > 50 && apple_x < 650 && apple_y < 650){
                int chance = (int)(Math.random() * 4);
                if(chance == 0){
                    apple_x -= 10;
                }
                else if(chance == 1){
                    apple_x += 10;
                }
                else if(chance == 2){
                    apple_y -= 10;
                }
                else{
                    apple_y += 10;
                }
            }
            else{
                if(apple_x <= 50){
                    apple_x += 10;
                }
                if(apple_y <= 50){
                    apple_y += 10;
                }
                if(apple_x >= 650){
                    apple_x -= 10;
                }
                if(apple_y >= 650){
                    apple_y -= 10;
                }
            }
        }
        if(num == 1){
            if(map_x > 50 && map_y > 50 && map_x < 650 && map_y < 650){
                int chance = (int)(Math.random() * 4);
                if(chance == 0){
                    map_x -= 10;
                }
                else if(chance == 1){
                    map_x += 10;
                }
                else if(chance == 2){
                    map_y -= 10;
                }
                else{
                    map_y += 10;
                }
            }
            else{
                if(map_x <= 50){
                    map_x += 10;
                }
                if(map_y <= 50){
                    map_y += 10;
                }
                if(map_x >= 650){
                    map_x -= 10;
                }
                if(map_y >= 650){
                    map_y -= 10;
                }
            }
        }
        if(num == 2){
            if(map_x2 > 50 && map_y2 > 50 && map_x2 < 650 && map_y2 < 650){
                int chance = (int)(Math.random() * 4);
                if(chance == 0){
                    map_x2 -= 10;
                }
                else if(chance == 1){
                    map_x2 += 10;
                }
                else if(chance == 2){
                    map_y2 -= 10;
                }
                else{
                    map_y2 += 10;
                }
            }
            else{
                if(map_x2 <= 50){
                    map_x2 += 10;
                }
                if(map_y2 <= 50){
                    map_y2 += 10;
                }
                if(map_x2 >= 650){
                    map_x2 -= 10;
                }
                if(map_y2 >= 650){
                    map_y2 -= 10;
                }
            }
        }
        if(num == 3){
            if(map_x3 > 50 && map_y3 > 50 && map_x3 < 650 && map_y3 < 650){
                int chance = (int)(Math.random() * 4);
                if(chance == 0){
                    map_x3 -= 10;
                }
                else if(chance == 1){
                    map_x3 += 10;
                }
                else if(chance == 2){
                    map_y3 -= 10;
                }
                else{
                    map_y3 += 10;
                }
            }
            else{
                if(map_x3 <= 50){
                    map_x3 += 10;
                }
                if(map_y3 <= 50){
                    map_y3 += 10;
                }
                if(map_x3 >= 650){
                    map_x3 -= 10;
                }
                if(map_y3 >= 650){
                    map_y3 -= 10;
                }
            }
        }
        if(num == 4){
            if(map_x4 > 50 && map_y4 > 50 && map_x4 < 650 && map_y4 < 650){
                int chance = (int)(Math.random() * 4);
                if(chance == 0){
                    map_x4 -= 10;
                }
                else if(chance == 1){
                    map_x4 += 10;
                }
                else if(chance == 2){
                    map_y4 -= 10;
                }
                else{
                    map_y4 += 10;
                }
            }
            else{
                if(map_x4 <= 50){
                    map_x4 += 10;
                }
                if(map_y4 <= 50){
                    map_y4 += 10;
                }
                if(map_x4 >= 650){
                    map_x4 -= 10;
                }
                if(map_y4 >= 650){
                    map_y4 -= 10;
                }
            }
        }
        if(num == 5){
            if(map_x5 > 50 && map_y5 > 50 && map_x5 < 650 && map_y5 < 650){
                int chance = (int)(Math.random() * 4);
                if(chance == 0){
                    map_x5 -= 10;
                }
                else if(chance == 1){
                    map_x5 += 10;
                }
                else if(chance == 2){
                    map_y5 -= 10;
                }
                else{
                    map_y5 += 10;
                }
            }
            else{
                if(map_x5 <= 50){
                    map_x5 += 10;
                }
                if(map_y5 <= 50){
                    map_y5 += 10;
                }
                if(map_x5 >= 650){
                    map_x5 -= 10;
                }
                if(map_y5 >= 650){
                    map_y5 -= 10;
                }
            }
        }
        if(num == 6){
            if(rbc_x > 50 && rbc_y > 50 && rbc_x < 650 && rbc_y < 650){
                int chance = (int)(Math.random() * 4);
                if(chance == 0){
                    rbc_x -= 10;
                }
                else if(chance == 1){
                    rbc_x += 10;
                }
                else if(chance == 2){
                    rbc_y -= 10;
                }
                else{
                    rbc_y += 10;
                }
            }
            else{
                if(rbc_x <= 50){
                    rbc_x += 10;
                }
                if(rbc_y <= 50){
                    rbc_y += 10;
                }
                if(rbc_x >= 650){
                    rbc_x -= 10;
                }
                if(rbc_y >= 650){
                    rbc_y -= 10;
                }
            }
        }
        if(num == 7){
            if(rbc_x2 > 50 && rbc_y2 > 50 && rbc_x2 < 650 && rbc_y2 < 650){
                int chance = (int)(Math.random() * 4);
                if(chance == 0){
                    rbc_x2 -= 10;
                }
                else if(chance == 1){
                    rbc_x2 += 10;
                }
                else if(chance == 2){
                    rbc_y2 -= 10;
                }
                else{
                    rbc_y2 += 10;
                }
            }
            else{
                if(rbc_x2 <= 50){
                    rbc_x2 += 10;
                }
                if(rbc_y2 <= 50){
                    rbc_y2 += 10;
                }
                if(rbc_x2 >= 650){
                    rbc_x2 -= 10;
                }
                if(rbc_y2 >= 650){
                    rbc_y2 -= 10;
                }
            }
        }
        if(num == 8){
            if(wbc_x > 50 && wbc_y > 50 && wbc_x < 650 && wbc_y < 650){
                int chance = (int)(Math.random() * 4);
                if(chance == 0){
                    wbc_x -= 10;
                }
                else if(chance == 1){
                    wbc_x += 10;
                }
                else if(chance == 2){
                    wbc_y -= 10;
                }
                else{
                    wbc_y += 10;
                }
            }
            else{
                if(wbc_x <= 50){
                    wbc_x += 10;
                }
                if(wbc_y <= 50){
                    wbc_y += 10;
                }
                if(wbc_x >= 650){
                    wbc_x -= 10;
                }
                if(wbc_y >= 650){
                    wbc_y -= 10;
                }
            }
        }
        if(num == 9){
            if(wbc_x2 > 50 && wbc_y2 > 50 && wbc_x2 < 650 && wbc_y2 < 650){
                int chance = (int)(Math.random() * 4);
                if(chance == 0){
                    wbc_x2 -= 10;
                }
                else if(chance == 1){
                    wbc_x2 += 10;
                }
                else if(chance == 2){
                    wbc_y2 -= 10;
                }
                else{
                    wbc_y2 += 10;
                }
            }
            else{
                if(wbc_x2 <= 50){
                    wbc_x2 += 10;
                }
                if(wbc_y2 <= 50){
                    wbc_y2 += 10;
                }
                if(wbc_x2 >= 650){
                    wbc_x2 -= 10;
                }
                if(wbc_y2 >= 650){
                    wbc_y2 -= 10;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (((key == KeyEvent.VK_LEFT) || key == KeyEvent.VK_A) && (!rightDirection)) {
                if(x[0] > 10){
                    leftDirection = true;
                    upDirection = false;
                    downDirection = false;
                }
            }

            if (((key == KeyEvent.VK_RIGHT) || key == KeyEvent.VK_D) && (!leftDirection)) {
                if(x[0] < 640){
                    rightDirection = true;
                    upDirection = false;
                    downDirection = false;
                }
            }

            if (((key == KeyEvent.VK_UP) || key == KeyEvent.VK_W) && (!downDirection)) {
                if(y[0] > 30){
                    upDirection = true;
                    rightDirection = false;
                    leftDirection = false;
                }
            }

            if (((key == KeyEvent.VK_DOWN) || key == KeyEvent.VK_S) && (!upDirection)) {
                if(instructions == false && start == false){
                    ImageIcon player = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\Submarine.png");
                    head = player.getImage();
                    instructions = true;
                }
                else{
                    if(y[0] < 640){
                        downDirection = true;
                        rightDirection = false;
                        leftDirection = false;
                    }
                }
            }

            if(key == KeyEvent.VK_ENTER){
                if(counter2 == 0){
                    storyScreen = true;
                }
                else{
                    storyScreen = false;
                }
                start = false;
                //storyScreen = false;
                mainStart = false;
                start0 = false;
                start1 = false;
                start2 = false;
                start3 = false;
                start4 = false;
                start5 = false;
                redHit = false;
                whiteHit = false;
                counter2++;
            }

            if(key == KeyEvent.VK_SPACE){
                if(!shoot && !shootFirst) {
                    shoot = true;
                    shootFirst = true;
                }
                else if(!shoot2 && !shootSecond){
                    shoot2 = true;
                    shootSecond = true;
                }
                else if(!shoot3 && !shootThird){
                    shoot3 = true;
                    shootThird = true;
                }
                else if(finale){
                    shootFinale = true;
                }
            }

            if(key == KeyEvent.VK_B){
                if(instructions == false && start == false){
                    ImageIcon player = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\MainBoyProto.png");
                    head = player.getImage();
                    instructions = true;
                }
            }

            if(key == KeyEvent.VK_G){
                if(instructions == false && start == false){
                    ImageIcon player = new ImageIcon("C:\\Users\\Ethan\\Documents\\Crohn's Project\\MainGirlProtoTinierB.png");
                    head = player.getImage();
                    instructions = true;
                }
            }

            if(key == KeyEvent.VK_P){
                //if(win || lose){
                if(crazy){
                    crazy = true;
                    start = true;
                    mainStart = true;
                    start0 = false;
                    start1 = false;
                    start2 = false;
                    start3 = false;
                    start4 = false;
                    start5 = false;

                    /*private int dots;
                    private int apple_x;
                    private int apple_y;
                    private int map_x;
                    private int map_y;
                    private int map_x2;
                    private int map_y2;
                    private int map_x3;
                    private int map_y3;
                    private int map_x4;
                    private int map_y4;
                    private int map_x5;
                    private int map_y5;
                    private int rbc_x;
                    private int rbc_y;
                    private int rbc_x2;
                    private int rbc_y2;
                    private int wbc_x;
                    private int wbc_y;
                    private int wbc_x2;
                    private int wbc_y2;
                    private int moveNum = 0;
                    private int shoot_x;
                    private int shoot_y;
                    private int counter = 0;*/
                    moveNum = 0;
                    counter = 0;

                    leftDirection = false;
                    rightDirection = true;
                    upDirection = false;
                    downDirection = false;
                    inGame = true;
                    ap = false;
                    mp = false;
                    mp2 = false;
                    mp3 = false;
                    mp4 = false;
                    mp5 = false;
                    rb = false;
                    rb2 = false;
                    wb = false;
                    wb2 = false;
                    moveNumCheck = false;
                    shoot = false;
                    shoot2 = false;
                    shoot3 = false;
                    shootFirst = false;
                    shootSecond = false;
                    shootThird = false;

                    redHit = false;
                    whiteHit = false;

                    instructions = false;
                    info0 = false;
                    info1 = false;
                    info2 = false;
                    info3 = false;
                    info4 = false;
                    info5 = false;

                    stage1 = false;
                    stage2 = false;
                    stage3 = false;
                    stage4 = false;
                    stage5 = false;

                    stage1C = false;
                    stage2C = false;
                    stage3C = false;
                    stage4C = false;
                    stage5C = false;
                    finale = false;

                    win = false;
                    lose = false;

                    storyScreen = false;




                    /*private Timer timer;
                    private Image ball;
                    private Image head;

                    private Image apple;
                    private Image map;
                    private Image map2;
                    private Image map3;
                    private Image map4;
                    private Image map5;
                    private Image rbc;
                    private Image rbc2;
                    private Image wbc;
                    private Image wbc2;

                    private Image infected;
                    private int infected_x;
                    private int infected_y;*/

                    /*private Image bad;
                    private int bad_x;
                    private int bad_y;
                    private Image bad1;
                    private int bad_x1;
                    private int bad_y1;
                    private Image bad2;
                    private int bad_x2;
                    private int bad_y2;

                    private Image heart;
                    private Image heart2;
                    private Image heart3;*/

                    heart3B = true;
                    heart2B = true;
                    heartB = true;

                    inUp = true;
                    inDown = false;

                    shootFinale = false;

                    monsterHealth = 20;

                    /*private Image poisonH;
                    private Image emptyH;*/

                    youWin = false;
                    game2 = true;

                    counter2 = 0;

                    initBoard();
                }

            }
        }
    }
}
