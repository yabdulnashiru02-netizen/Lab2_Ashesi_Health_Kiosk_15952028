import java.util.Random;
import java.util.Scanner;
public class HealthKiosk{
    public static void main(String[] args){
        System.out.println("Enter either P/L/T/C:");
        Scanner input = new Scanner(System.in);
        char service = input.next().charAt(0);
        service = Character.toUpperCase(service);

        String summary ="";
        switch (service){
            case 'P':
                System.out.println("Pharmacy Desk");
                break;
            case 'L':
                System.out.println("Lab Desk");
                break;
            case 'T':
                System.out.println("Triage Desk");
                break;
            case 'C':
                System.out.println(" Counselling Desk");
                break;
            default:
                System.out.println("invalid code");
        }
        System.out.println("");
        int decide = input.nextInt();
        double bodyMassRounded =0.0;
        int tabs =0;
        double degree =0.0;
        
        switch(decide){
            case 1:
                System.out.println("Enter weight in kg:");
                double weight = input.nextDouble();
                double height = input.nextDouble();
                double bodyMass = weight / (Math.pow(height,2));
                bodyMassRounded = Math.round(bodyMass*10)/10.0;
                System.out.println("BMI" + bodyMassRounded +" Category");

                if (bodyMassRounded >= 30){
                    System.out.println("Obese");
                } else if ( bodyMassRounded >= 25.0 && bodyMassRounded <29.9 ){
                    System.out.println("Overweight");
                } else if (bodyMassRounded >= 18.5 && bodyMassRounded <24.9){
                    System.out.print("Normal");
                }else{
                    System.out.println("Underweight");
                }
                break;
            
            case 2:
                System.out.println("enter your dosage in mg: ");
                double dosage = input.nextDouble();
                tabs =(int) Math.ceil(dosage/250.0);
                System.out.println("Tablet =" + tabs);
                break;
            
            case 3:
                System.out.println("enter your angle indegrees:");
                degree = input.nextDouble();
                double radian= Math.toRadians(degree);

                double sin = Math.round(Math.sin(radian)*1000)/1000.0;
                double cos = Math.round(Math.cos(radian)*1000)/1000.0;
                //System.out.println("sin is" + sin + "cos is " + cos);
                break;
            
            default:
                System.out.println("Invlaid input");
            }

        Random rand = new Random();
        char[] digits = new char[4];
        for (int i=0; i<4 ; i++){
            digits[i]=(char)('0' + (rand.nextInt(7)+3));
        }
        char letter = (char) ('A' + rand.nextInt(26));
        String studentId = letter + new String(digits);
        System.out.println("student ID:" + studentId);
        
        if (studentId.length()!= 5){
            System.out.println("wrong length");
            return;
        
        } else if (!Character.isLetter(studentId.charAt(0))){
            System.out.println("first letter must bea letter");
            return;
        } else if (!(Character.isDigit(studentId.charAt(1)) &&
             Character.isDigit(studentId.charAt(2)) &&
             Character.isDigit(studentId.charAt(3)) &&
             Character.isDigit(studentId.charAt(4)))) {
             System.out.println("Invalid: last 4 must be digits");
             return;
        }else {
            System.out.println("continue");
        }

        input.nextLine();
        System.out.println("Enter your first name:");
        String name = input.nextLine();
        char base = Character.toUpperCase(name.charAt(0));
        char shift = (char)('A'+(base -'A'+2)%26);
        String last =studentId.substring(studentId.length()-2);
        int metricInt = 0;
        if (decide == 1) {
            metricInt = (int)Math.round(bodyMassRounded);
        } else if (decide == 2) {
            metricInt = tabs;
        } else if (decide == 3) { 
            metricInt = (int)Math.round(Math.sin(Math.toRadians(degree)) * 100);
        }
        String displayCode = "" + shift + last + "-" + metricInt;
        System.out.println("Display Code: " + displayCode);

        
        System.out.println("summary"+ summary);
    
    }
}
