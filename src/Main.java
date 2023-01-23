import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLConnection;

public class Main extends JFrame{
    private JTextArea Chatarea = new JTextArea();
    private JTextField chatbox = new JTextField();
    private JButton button = new JButton(" > ");
    public Main(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(500,600);
        frame.setTitle("MediBot");
        frame.add(Chatarea);
        frame.add(chatbox);
        frame.add(button);
        JScrollPane scroll = new JScrollPane(Chatarea);
        scroll.setBounds(25,10,435, 480);
        frame.add(scroll);

        //For textarea
        Chatarea.setEditable(false);
        Chatarea.setLineWrap(true);
        Chatarea.setVisible(true);
        Chatarea.setFont(new Font("Serif", Font.PLAIN, 14));
        Chatarea.setText("Hi! I'm Medibot, your personal medical research assistant."+"\n"+"Want to know how to use me? type \"\\help\" in to the textbox and submit"+"\n");


        //for textfield
        chatbox.setSize(400,30);
        chatbox.setLocation(25,500);

        //for button
        button.setSize(30,30);
        button.setLocation(430, 500);
        button.setFont(new Font("Serif", Font.BOLD, 25));
        button.setBackground(Color.white);

       //event listener for button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String uinput = chatbox.getText();
                Chatarea.setText(" ");
                Chatarea.append("You : " + uinput +"\n");
                String fuinput = uinput.toLowerCase();
                chatbox.setText("");

                //generating bot replies
                if(fuinput.contentEquals("\\help")) {
                    bot("Type any statement in the textbox and submit. Please note that I'm still under construction therefore some of my responses might not mot be what you expect."
                            +"\n" + "Tritech is working hard to bring you the best you deserve.");
                } else if(fuinput.contains("hi")||fuinput.contains("hello")||fuinput.contains("hey")){
                    int rand = (int) (Math.random()*3+1);
                    if (rand == 1)
                        bot("Hello! I'm medibot. How are you doing today");
                    else if (rand == 2) {
                        bot("Hi, how are you doing today?");
                    }
                    else if (rand == 3) {
                        bot("Hey, how are you today?");
                    }
                } else if ((fuinput.contains("how")&&fuinput.contains("you"))||fuinput.contains("what about you")) {
                    int rand = (int) (Math.random()*3+1);
                    if (rand == 1)
                        bot("I'm doing well.");
                    else if (rand == 2) {
                        bot("I am good , thanks for asking");
                    }
                    else if (rand == 3) {
                        bot("I am great , thanks for asking");
                    }
                } else if (fuinput.contains("i am good")||fuinput.contains("fine")||fuinput.contains("i'm")||fuinput.contains("good")) {
                    int rand = (int) (Math.random()*3+1);
                    if (rand == 1){
                        bot("That's great.");
                    }else if(rand == 2){
                        bot("We thank God.");
                    } else if (rand == 3) {
                        bot("All praise to God.");
                    }
                } else if (fuinput.contains("bye")||fuinput.contains("goodbye")||fuinput.contains("next time")) {
                    int rand = (int) (Math.random() * 3 + 1);
                    if (rand == 1) {
                        bot("Bye, see you next time.");
                        Chatarea.setText("");
                    }else if (rand == 2) {
                        bot("Bye. It was nice communicating with you.");
                        Chatarea.setText("");
                    } else if (rand == 3) {
                        bot("Thanks for your time.");
                        Chatarea.setText("");
                    }
                } else if ((fuinput.contains("name")&&fuinput.contains("your"))) {
                    int rand = (int) (Math.random() * 3 + 1);
                    if (rand == 1)
                        bot("I'm Medibot.");
                    else if (rand == 2) {
                        bot("My name is Medibot");
                    } else if (rand == 3) {
                        bot("I'm called Medibot");
                    }
                } else if (fuinput.contains("thank")||fuinput.contains("thanks")){
                    int rand = (int) (Math.random() * 3 + 1);
                    if (rand == 1)
                        bot("It's a pleasure.");
                    else if (rand == 2) {
                        bot("It's my work to serve you.");
                    } else if (rand == 3) {
                        bot("You're welcome.");
                    }
                }else
                {
                    try
                    {
                        try
                        {

                            //searchs for statement on google
                            URL url=new URL("https://google.co.in");
                            URLConnection connection=url.openConnection();
                            connection.connect();
                            bot("Check your browser for some interesting results...");
                            java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://www.google.com/search?hl=en&q="+fuinput.replace(" ", "+")+"&btnG=Google+Search"));


                        } //if bot can't connect to the net
                        catch(Exception ee)
                        {
                            bot("Please set-up your internet connection to get better results...");
                        }
                    }
                    catch(Exception eee)
                    {
                        int rand = (int) (Math.random()*3+1);
                        if (rand == 1){
                            bot("I don't understand you");
                        }else if(rand == 2){
                            bot("Didn't get you clearly");
                        } else if (rand == 3) {
                            bot("Please come again");
                        }
                        else {
                            bot("Please reframe your statement");
                        }
                    }
                }
            }
        });

            //event listener for enter key
        chatbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String uinput = chatbox.getText();
                Chatarea.setText("");
                Chatarea.append("You : " + uinput +"\n");
                String fuinput = uinput.toLowerCase();
                chatbox.setText("");

                //generating bot replies
                if(fuinput.contentEquals("\\help")) {
                    bot("Type any statement in the textbox and submit. Please note that I'm still under construction therefore some of my responses might not mot be what you expect."
                            +"\n" + "Tritech is working hard to bring you the best you deserve.");
                } else if(fuinput.contains("hi")||fuinput.contains("hello")||fuinput.contains("hey")){
                    int rand = (int) (Math.random()*3+1);
                    if (rand == 1)
                        bot("Hello! I'm medibot. How are you doing today");
                    else if (rand == 2) {
                        bot("Hi, how are you doing today?");
                    }
                    else if (rand == 3) {
                        bot("Hey, how are you today?");
                    }
                } else if ((fuinput.contains("how")&&fuinput.contains("you"))||fuinput.contains("what about you")) {
                    int rand = (int) (Math.random()*3+1);
                    if (rand == 1)
                        bot("I'm doing well.");
                    else if (rand == 2) {
                        bot("I am good , thanks for asking");
                    }
                    else if (rand == 3) {
                        bot("I am great , thanks for asking");
                    }
                } else if (fuinput.contains("i am good")||fuinput.contains("fine")||fuinput.contains("i'm")||fuinput.contains("good")) {
                    int rand = (int) (Math.random()*3+1);
                    if (rand == 1){
                        bot("That's great.");
                    }else if(rand == 2){
                        bot("We thank God.");
                    } else if (rand == 3) {
                        bot("All praise to God.");
                    }
                } else if (fuinput.contains("bye")||fuinput.contains("goodbye")||fuinput.contains("next time")) {
                    int rand = (int) (Math.random() * 3 + 1);
                    if (rand == 1) {
                        bot("Bye, see you next time.");
                        Chatarea.setText("");
                    }else if (rand == 2) {
                        bot("Bye. It was nice communicating with you.");
                        Chatarea.setText("");
                    } else if (rand == 3) {
                        bot("Thanks for your time.");
                        Chatarea.setText("");
                    }
                } else if ((fuinput.contains("name")&&fuinput.contains("your"))) {
                    int rand = (int) (Math.random() * 3 + 1);
                    if (rand == 1)
                        bot("I'm Medibot.");
                    else if (rand == 2) {
                        bot("My name is Medibot");
                    } else if (rand == 3) {
                        bot("I'm called Medibot");
                    }
                } else if (fuinput.contains("thank")||fuinput.contains("thanks")){
                    int rand = (int) (Math.random() * 3 + 1);
                    if (rand == 1)
                        bot("It's a pleasure.");
                    else if (rand == 2) {
                        bot("It's my work to serve you.");
                    } else if (rand == 3) {
                        bot("You're welcome.");
                    }
                }else
                {
                    try
                    {
                        try
                        {

                            //searchs for statement on google
                            URL url=new URL("https://google.co.in");
                            URLConnection connection=url.openConnection();
                            connection.connect();
                            bot("Check your browser for some interesting results...");
                            java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://www.google.com/search?hl=en&q="+fuinput.replace(" ", "+")+"&btnG=Google+Search"));


                        } //if bot can't connect to the net
                        catch(Exception ee)
                        {
                            bot("Please set-up your internet connection to get better results...");
                        }
                    }
                    catch(Exception eee)
                    {
                        int rand = (int) (Math.random()*3+1);
                     if (rand == 1){
                         bot("I don't understand you");
                     }else if(rand == 2){
                         bot("Didn't get you clearly");
                     } else if (rand == 3) {
                         bot("Please come again");
                     }
                    else {
                        bot("Please reframe your statement");
                     }
                    }
                }
            }
        });
    }
    private void bot(String reply){
        Chatarea.append("Medibot : " +reply+ "\n");
    }

    public static void main(String[] args) {
        new Main();
    }
}