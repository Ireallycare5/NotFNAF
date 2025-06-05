import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int blank;
    public static int tim;
    public static int camera;
    public static int rockman;
    public static int rockagro;
    public static int guy;
    public static int guyagro;
    public static int flips;
    public static int joe;
    public static int joeagro;
    public static int randomthingidk;

    public static void main(String[] args) {
        // Create a JFrame (the main window)

        gameplay();



    }


    public static void gameplay()
    {
        blank=35;
        tim=0;
        flips=150;
        joe=200;
        joeagro=0;
        randomthingidk=1;
        cams();
        rockman=1;
        rockagro=0;
        guy=1;
        guyagro=0;


        JFrame window= new JFrame("Room");
        window.setMinimumSize(new Dimension(500, 700));
        window.setTitle("Room");
        window.getContentPane().setBackground(Color.WHITE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.toFront();
        //time
        JLabel label = new JLabel("1 AM" );
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setVerticalAlignment(SwingConstants.TOP);

        //time equation
        Timer time = new Timer();
        TimerTask tasks = new TimerTask() {
            @Override
            public void run() {
                // Code to be executed every 3 seconds
                tim+=1;
                label.setText(tim+ ( "AM"));
            }
        };
        time.scheduleAtFixedRate(tasks, 0, 60000);

        //rock man
        Random random = new Random();
        Timer rock = new Timer();
        TimerTask man = new TimerTask() {
            @Override
            public void run() {
                // Code to be executed every 3 seconds
                int myRandomNumber = random.nextInt(1,21);
                if (rockagro>=myRandomNumber){
                    rockman+=1;
                }
            }
        };
        rock.scheduleAtFixedRate(man, 0, 3000);




        //ammo
        JLabel ammo = new JLabel("Blanks "+blank);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setVerticalAlignment(SwingConstants.BOTTOM);
        JPanel pan = new JPanel(new BorderLayout());
        pan.add(label, BorderLayout.NORTH);
        pan.add(ammo);

        //camera flips
        JLabel fliping = new JLabel("Flips "+flips);
        fliping.setHorizontalAlignment(SwingConstants.RIGHT);
        fliping.setVerticalAlignment(SwingConstants.BOTTOM);
        pan.add(fliping, BorderLayout.SOUTH);

        //shoot
        JButton button = new JButton("SHOOT!");
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        // Add an ActionListener to handle the button click event
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code runs when the button is clicked
                if(blank>=1) {
                    JOptionPane optionPane = new JOptionPane("BANG!", JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("YOU shot me");
                    dialog.setVisible(true);



                    blank -= 1;
                    ammo.setText("Blanks" + blank+" ");
                    rockman=1;
                    int myRandomNumber = random.nextInt(1,21);
                    if (guyagro>=myRandomNumber){
                        guy+=4;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(window, "oh no");
                }

            }

        });

        //joe ai
        JButton joey = new JButton("Click now");
        joey.setHorizontalAlignment(SwingConstants.CENTER);
        joey.setVerticalAlignment(SwingConstants.CENTER);
        // Add an ActionListener to handle the button click event
        joey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(camera==1) {
                    joe += 4;
                }
            }

        });
        //joe attack
        Timer josh = new Timer();
        TimerTask clicky = new TimerTask() {
            @Override
            public void run() {
                joe-=joeagro;
            }
        };
        josh.scheduleAtFixedRate(clicky, 0, 4000);

        //updating
        Timer eepy = new Timer();
        TimerTask dang = new TimerTask() {
            @Override
            public void run() {
                fliping.setText("Camera flips" + flips);
                if (rockman==8) {
                    if(randomthingidk==1) {
                        window.setVisible(false);

                    }
                }
                if (guy>=8) {
                    if(randomthingidk==1) {
                        window.setVisible(false);

                    }
                }
                if(joe<=0)
                {
                    if(randomthingidk==1) {
                        window.setVisible(false);

                    }
                }
                if(tim>=7)
                {
                    if(randomthingidk==1) {
                        window.setVisible(false);

                    }
                }
            }
        };
        eepy.scheduleAtFixedRate(dang, 0, 100);

        // Set the layout of the frame (using FlowLayout for simplicity)
        window.setLayout(new java.awt.BorderLayout());

        // Add the button to the frame
        window.add(button, BorderLayout.WEST);
        window.add(pan, BorderLayout.EAST);
        window.add(joey, BorderLayout.SOUTH);

        // Set the window size

        window.setSize(300, 300);
        window.setLocation(780, -25); // Sets the window to appear at (100, 100)

        // Set the default close operation
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        window.setVisible(true);



    }
    public static void cams() {
        // Create a JFrame (the main window)

        JFrame cam = new JFrame("CAMS");
        cam.setMinimumSize(new Dimension(780, 700));
        cam.setTitle("cam");
        cam.getContentPane().setBackground(Color.WHITE);
        cam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cam.setLayout(new BorderLayout());

        //cam info
        JLabel cram = new JLabel( "camera "+camera );
        cram.setHorizontalAlignment(SwingConstants.CENTER);
        cram.setVerticalAlignment(SwingConstants.TOP);

        //location
        ImageIcon rockpic = new ImageIcon("src/images.jpg");
        JLabel nice = new JLabel(rockpic);
        nice.setHorizontalAlignment(SwingConstants.RIGHT);
        nice.setVerticalAlignment(SwingConstants.CENTER);

        ImageIcon guypic = new ImageIcon("src/smiler.jpg");
        JLabel dude = new JLabel(guypic);
        dude.setHorizontalAlignment(SwingConstants.RIGHT);
        dude.setVerticalAlignment(SwingConstants.CENTER);

        JLabel josh = new JLabel("Joe see "+ joe +" clicks");
        dude.setHorizontalAlignment(SwingConstants.RIGHT);
        dude.setVerticalAlignment(SwingConstants.CENTER);

        JPanel ahh = new JPanel(new BorderLayout());
        ahh.add(cram, BorderLayout.NORTH);
        ahh.add(dude, BorderLayout.NORTH);
        ahh.add(josh, BorderLayout.SOUTH);
        ahh.add(nice);




        //cam 1
        JButton cam1 = new JButton("cam 1");
        cam1.setHorizontalAlignment(SwingConstants.CENTER);
        cam1.setVerticalAlignment(SwingConstants.CENTER);
        // Add an ActionListener to handle the button click event
        cam1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code runs when the button is clicked

                camera=1;
                cram.setText("camera "+camera);
                if(rockman==camera)
                {
                    nice.setIcon(rockpic);
                }else{
                    nice.setIcon(null);
                }
                if(guy==camera)
                {
                    dude.setIcon(guypic);
                }else{
                    dude.setIcon(null);
                }


            }

        });
        //cam 2
        JButton cam2 = new JButton("cam 2");
        cam2.setHorizontalAlignment(SwingConstants.CENTER);
        cam2.setVerticalAlignment(SwingConstants.CENTER);
        // Add an ActionListener to handle the button click event
        cam2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code runs when the button is clicked
                camera=2;
                cram.setText("camera "+camera);
                if(rockman==camera)
                {
                    nice.setIcon(rockpic);

                }else{
                    nice.setIcon(null);
                }
                if(guy==camera)
                {
                    dude.setIcon(guypic);
                }else{
                    dude.setIcon(null);
                }
                if(guy==camera) {
                    guy-=1;
                }
                flips-=1;
            }

        });

        //cam3
        JButton cam3 = new JButton("cam 3");
        cam3.setHorizontalAlignment(SwingConstants.CENTER);
        cam3.setVerticalAlignment(SwingConstants.CENTER);
        // Add an ActionListener to handle the button click event
        cam3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code runs when the button is clicked
                camera=3;
                cram.setText("camera "+camera);
                if(rockman==camera)
                {
                    nice.setIcon(rockpic);

                }else{
                    nice.setIcon(null);
                }
                if(guy==camera)
                {
                    dude.setIcon(guypic);
                }else{
                    dude.setIcon(null);
                }
                if(guy==camera) {
                    guy-=1;
                }
                flips-=1;
            }

        });

        //cam4
        JButton cam4 = new JButton("cam 4");
        cam4.setHorizontalAlignment(SwingConstants.CENTER);
        cam4.setVerticalAlignment(SwingConstants.CENTER);
        // Add an ActionListener to handle the button click event
        cam4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code runs when the button is clicked
                camera=4;
                cram.setText("camera "+camera);
                if(rockman==camera)
                {
                    nice.setIcon(rockpic);

                }else{
                    nice.setIcon(null);
                }
                if(guy==camera)
                {
                    dude.setIcon(guypic);
                }else{
                    dude.setIcon(null);
                }
                if(guy==camera) {
                    guy-=1;
                }
                flips-=1;

            }

        });

        //cam5
        JButton cam5 = new JButton("cam 5");
        cam5.setHorizontalAlignment(SwingConstants.CENTER);
        cam5.setVerticalAlignment(SwingConstants.CENTER);
        // Add an ActionListener to handle the button click event
        cam5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code runs when the button is clicked
                camera=5;
                cram.setText("camera "+camera);
                if(rockman==camera)
                {
                    nice.setIcon(rockpic);

                }else{
                    nice.setIcon(null);
                }
                if(guy==camera)
                {
                    dude.setIcon(guypic);
                }else{
                    dude.setIcon(null);
                }
                if(guy==camera) {
                    guy-=1;
                }
                flips-=1;

            }

        });

        //cam6
        JButton cam6 = new JButton("cam 6");
        cam6.setHorizontalAlignment(SwingConstants.CENTER);
        cam6.setVerticalAlignment(SwingConstants.CENTER);
        // Add an ActionListener to handle the button click event
        cam6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code runs when the button is clicked
                camera=6;
                cram.setText("camera "+camera);
                if(rockman==camera)
                {
                    nice.setIcon(rockpic);

                }else{
                    nice.setIcon(null);
                }
                if(guy==camera)
                {
                    dude.setIcon(guypic);
                }else{
                    dude.setIcon(null);
                }
                if(guy==camera) {
                    guy-=1;
                }
                flips-=1;

            }

        });

        //cam7
        JButton cam7 = new JButton("cam 7");
        cam7.setHorizontalAlignment(SwingConstants.CENTER);
        cam7.setVerticalAlignment(SwingConstants.CENTER);
        // Add an ActionListener to handle the button click event
        cam7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code runs when the button is clicked
                camera=7;
                cram.setText("camera "+camera);
                if(rockman==camera)
                {
                    nice.setIcon(rockpic);

                }else{
                    nice.setIcon(null);
                }
                if(guy==camera)
                {
                    dude.setIcon(guypic);
                }else{
                    dude.setIcon(null);
                }
                if(guy==camera) {
                    guy-=1;
                }
                flips-=1;

            }

        });


        //update cams
        Random random = new Random();
        Timer rock = new Timer();
        TimerTask man = new TimerTask() {
            @Override
            public void run() {
                // Code to be executed every 3 seconds
                if(rockman==camera)
                {
                    nice.setIcon(rockpic);
                }else{
                    nice.setIcon(null);
                }
                if(guy==camera)
                {
                    dude.setIcon(guypic);
                }else{
                    dude.setIcon(null);
                }
                if (rockman==8) {
                    if(randomthingidk==1) {
                        cam.setVisible(false);
                        lose();

                    }
                }
                if (guy>=8) {
                    if(randomthingidk==1) {
                        cam.setVisible(false);
                        lose();

                    }
                }
                if (tim>=7) {

                    if(randomthingidk==1) {
                        cam.setVisible(false);
                        win();

                    }
                }
                if (flips<=0){
                    cam.setVisible(false);
                }
                if(camera==1){
                    josh.setVisible(true);
                }
                else{
                    josh.setVisible(false);
                }
                josh.setText("Joe see "+ joe+" clicks");
                if(joe<=0)
                {
                    if(randomthingidk==1) {
                        cam.setVisible(false);
                        lose();

                    }
                }
            }
        };
        rock.scheduleAtFixedRate(man, 0, 100);

        JPanel pan = new JPanel();
        pan.setLayout(new BoxLayout(pan, BoxLayout.X_AXIS));

        pan.add(cam1);
        pan.add(cam2);
        pan.add(cam3);
        pan.add(cam4);
        pan.add(cam5);
        pan.add(cam6);
        pan.add(cam7);
        cam.add(cram);

        cam.setLocation(0, -25);
        cam.setSize(300, 300);

        cam.add(pan, BorderLayout.WEST);
        cam.add(ahh, BorderLayout.EAST);
        // Set the default close operation
        cam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        cam.setVisible(true);
    }

    public static void win() {
        // Create a JFrame (the main window)

        JFrame cam = new JFrame("You win");
        cam.setMinimumSize(new Dimension(780, 700));
        cam.setTitle("You win");
        cam.getContentPane().setBackground(Color.WHITE);
        cam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cam.setLayout(new BorderLayout());
        cam.setLocation(0, 0);
        cam.setSize(1500, 1000);

        JLabel yay = new JLabel("You win");
        yay.setHorizontalAlignment(SwingConstants.CENTER);
        yay.setVerticalAlignment(SwingConstants.CENTER);

        cam.add(yay);
        cam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        cam.setVisible(true);
    }
    public static void lose() {
        // Create a JFrame (the main window)
        randomthingidk-=1;
        JFrame cam = new JFrame("You lose");
        cam.setMinimumSize(new Dimension(780, 700));
        cam.setTitle("You lose");
        cam.getContentPane().setBackground(Color.WHITE);
        cam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cam.setLayout(new BorderLayout());
        cam.setLocation(0, -50);
        cam.setSize(1500, 900);

        JLabel yay = new JLabel("You lose");
        yay.setHorizontalAlignment(SwingConstants.CENTER);
        yay.setVerticalAlignment(SwingConstants.CENTER);

        String tips=("nice");
        if(rockman==8){
            tips=("Shoot beats rock. You have a gun.");
        }
        if(guy>=8){
            tips=("Guy like loud noises. He hates looking at you.");
        }
        if(joe<=0){
            tips=("Joe see all besides clicks. Go to cam one so he can see you click");
        }
        JLabel help = new JLabel(tips);
        help.setHorizontalAlignment(SwingConstants.CENTER);
        help.setVerticalAlignment(SwingConstants.CENTER);

        JButton button = new JButton("Run it back");
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        // Add an ActionListener to handle the button click event
        button.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {
                                         // This code runs when the button is clicked
                                         blank=35;
                                         tim=0;
                                         flips=150;
                                         joe=200;
                                         randomthingidk=1;
                                         rockman=1;
                                         guy=1;

                                             gameplay();
                                        cam.setVisible(false);

                                     }
                                 });

        cam.add(yay);
        cam.add(help,BorderLayout.WEST);
        cam.add(button,BorderLayout.SOUTH);
        cam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Make the frame visible
        cam.setVisible(true);


    }
}

