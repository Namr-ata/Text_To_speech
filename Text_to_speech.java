
package text_to_speech;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Locale;
import javax.speech.synthesis.Synthesizer; 
import javax.speech.Engine; 
import javax.speech.Central;  
import javax.speech.synthesis.SynthesizerModeDesc;
/**
 *
 * @author USER
 */
public class Text_to_speech extends JFrame implements ActionListener {
    Container c;
    JLabel l1,heading; 
    JTextArea t1;
    JButton b1;
    JScrollPane sc;
    public Text_to_speech(){
    setSize(800,600);
    setTitle("Text_to_speech");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    c=this.getContentPane();
    c.setLayout(null);
    c.setBackground(Color.cyan);
    
     heading=new JLabel("Text to speech");
     heading.setBounds(300,20 ,200 , 50);
     Font f =new Font("Times new roman",Font.BOLD,22);
     heading.setFont(f);
     c.add(heading);
    
    l1=new JLabel("Enter the text");
    l1.setBounds(20,80 ,200 , 50);
    Font f1 =new Font("Times new roman",Font.BOLD,20);
    l1.setFont(f1);
    c.add(l1);
    
    t1=new JTextArea();
    t1.setBounds(20,140, 700, 200);
     Font f2 =new Font("Times new roman",Font.PLAIN,18);
      t1.setFont(f2);
    c.add(t1);
     
    b1=new JButton("convert to speech");
    b1.setBounds(300,380,200,50);
    b1.addActionListener(this);
    c.add(b1);
    
    
       setVisible(true);
    }
    
    public static void main(String[] args) {
        new Text_to_speech();
  
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==b1){
       String  message=t1.getText();
       if(message.equals("")){
        JOptionPane.showMessageDialog(this,"Please enter text");
       }
       else{
         try   
{  
//setting properties as Kevin Dictionary  
System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");  
//registering speech engine  
Central.registerEngineCentral("com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral");  
//create a Synthesizer that generates voice  
Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));  
//allocates a synthesizer  
synthesizer.allocate();  
//resume a Synthesizer  
synthesizer.resume();  
//speak the specified text until the QUEUE become empty  
synthesizer.speakPlainText(message, null);  
synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);  
//deallocating the Synthesizer  
synthesizer.deallocate();  
}  
catch (Exception e)   
{  
e.printStackTrace();  
} 
       }
    }
    }
}
